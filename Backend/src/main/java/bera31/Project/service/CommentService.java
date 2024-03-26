package bera31.Project.service;

import bera31.Project.domain.comment.Comment;
import bera31.Project.domain.dto.requestdto.CommentRequestDto;
import bera31.Project.domain.member.Member;
import bera31.Project.domain.page.Contents;
import bera31.Project.repository.CommentRepository;
import bera31.Project.repository.MemberRepository;
import bera31.Project.repository.page.ContentsRepository;
import bera31.Project.utility.SecurityUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final ContentsRepository contentsRepository;

    public Long saveComment(CommentRequestDto commentRequestDto, Long contentsId) {
        Member currentMember = loadCurrentMember();
        Contents currentContent = contentsRepository.findById(contentsId);
        Comment comment = Comment.commentWithoutParent(commentRequestDto, currentMember, currentContent);
        currentContent.addComment(comment);
        return commentRepository.save(comment);
    }

    public Long saveChildComment(CommentRequestDto commentRequestDto, Long commentId) {
        Member currentMember = loadCurrentMember();
        Comment parent = commentRepository.findCommentById(commentId);
        Comment comment = Comment.commentWithParent(commentRequestDto, currentMember, parent);
        parent.addChildComment(comment);
        return commentRepository.save(comment);
    }

    public Long deleteComment(Long commentId) {
        commentRepository.delete(commentRepository.findCommentById(commentId));
        return commentId;
    }


    private Member loadCurrentMember() {
        String currentMemberEmail = SecurityUtility.getCurrentMemberEmail();
        return memberRepository.findByEmail(currentMemberEmail).get();
    }


}
