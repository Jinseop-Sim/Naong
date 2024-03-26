package bera31.Project.service.page;

import bera31.Project.domain.comment.Comment;
import bera31.Project.domain.dto.requestdto.ContentsRequestDto;
import bera31.Project.domain.dto.responsedto.CommentResponseDto;
import bera31.Project.domain.dto.responsedto.contents.ContentsListResponseDto;
import bera31.Project.domain.dto.responsedto.contents.ContentsResponseDto;
import bera31.Project.domain.member.Member;
import bera31.Project.domain.page.Contents;
import bera31.Project.domain.page.ContentsType;
import bera31.Project.domain.page.intersection.ContentsParticipation;
import bera31.Project.domain.page.intersection.LikedContents;
import bera31.Project.exception.ErrorResponse;
import bera31.Project.exception.exceptions.AlreadyFullException;
import bera31.Project.repository.LikeRepository;
import bera31.Project.repository.MemberRepository;
import bera31.Project.repository.page.ContentsRepository;
import bera31.Project.repository.page.IntersectionRepository;
import bera31.Project.utility.SecurityUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ContentsService {
    private final ContentsRepository contentsRepository;
    private final MemberRepository memberRepository;
    private final IntersectionRepository intersectionRepository;
    private final LikeRepository likeRepository;

    public Long postContents(ContentsRequestDto contentsRequestDto, ContentsType contentsType) throws IOException {
        Member currentMember = loadCurrentMember();

        Contents newContents = new Contents(contentsRequestDto, currentMember, contentsType);
        //newGroupBuying.setImage(s3Uploader.upload(postImage, "groupBuying"));
        currentMember.postContents(newContents);

        return contentsRepository.save(newContents);
    }

    @Transactional(readOnly = true)
    public List<ContentsListResponseDto> findAll(ContentsType contentsType) {
        List<Contents> findedContents = contentsRepository.findAll(contentsType);

        if(!findedContents.isEmpty()) {
            checkExpiredPost(findedContents);
        }

        return findedContents.stream().map(ContentsListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ContentsListResponseDto> findAllWithPaging(int page) {
        List<Contents> findedContents = contentsRepository.findAllWithPaging(page);

        if(!findedContents.isEmpty()) {
            checkExpiredPost(findedContents);
        }

        return findedContents.stream().map(ContentsListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ContentsResponseDto findById(Long postId) {
        boolean checkMine = false;
        Member currentMember = loadCurrentMember();
        Contents currentContents = contentsRepository.findById(postId);

        if(currentMember.getId().equals(currentContents.getUser().getId())){
            checkMine = true;
        }

        List<CommentResponseDto> commentResponseDtoList =
                makeCommentList(contentsRepository.findById(postId).getComments());
        return new ContentsResponseDto(contentsRepository.findById(postId), commentResponseDtoList, checkMine);
    }

    public Long updateContents(ContentsRequestDto contentsRequestDto, Long postId) throws IOException {
        Contents findedContents = contentsRepository.findById(postId);
        //s3Uploader.deleteRemoteFile(findedPost.getImage().substring(52));

        return findedContents.update(contentsRequestDto);
    }

    public Long deleteContents(Long postId) {
        contentsRepository.delete(contentsRepository.findById(postId));
        return postId;
    }

    public Long participantContents(Long postId) {
        Member currentMember = loadCurrentMember();
        Contents currentContents = contentsRepository.findById(postId);

        if (currentContents.getMemberLimit() <= currentContents.getMemberList().size())
            throw new AlreadyFullException(ErrorResponse.ALREADY_FULL);

        ContentsParticipation newContnentsParticipation = new ContentsParticipation(currentMember, currentContents);
        currentMember.participantContent(newContnentsParticipation);
        currentContents.addMember(newContnentsParticipation);

        return intersectionRepository.save(newContnentsParticipation);
    }

    public String pushLikeContents(Long postId) {
        Member currentMember = loadCurrentMember();
        Contents currentContents = contentsRepository.findById(postId);
        Optional<LikedContents> existsLike = likeRepository.findByPostIdAndUserId(currentContents, currentMember);

        if(existsLike.isPresent()){
            currentMember.getLikedContents().remove(existsLike.get());
            return likeRepository.delete(existsLike.get());
        }

        LikedContents newLikedContents = new LikedContents(currentMember, currentContents);
        currentMember.pushLikeContent(newLikedContents);
        return likeRepository.save(newLikedContents);
    }

    public String closeContent(Long postId) {
        contentsRepository.findById(postId).expirePost();
        return "거래가 마감되었습니다.";
    }

    private Member loadCurrentMember() {
        String currentMemberEmail = SecurityUtility.getCurrentMemberEmail();
        return memberRepository.findByEmail(currentMemberEmail).get();
    }

    private void checkExpiredPost(List<Contents> findedContents) {
        findedContents.stream()
                .filter(g -> g.getDeadLine().isBefore(LocalDateTime.now()))
                .forEach(Contents::expirePost);
    }

    public List<CommentResponseDto> makeCommentList(List<Comment> commentList) {
        List<CommentResponseDto> commentResponseDtoList = new ArrayList<>();
        for (Comment comment : commentList) {
            CommentResponseDto commentResponseDto = new CommentResponseDto(comment);
            if (comment.getChildren().size() != 0) {
                for (Comment child : comment.getChildren()) {
                    commentResponseDto.addChild(new CommentResponseDto(child));
                }
                commentResponseDtoList.add(commentResponseDto);
            }
            else if(comment.getParent() == null){
                commentResponseDtoList.add(commentResponseDto);
            }
        }
        return commentResponseDtoList;
    }
}
