package bera31.Project.service.page;

import bera31.Project.domain.dto.responsedto.*;
import bera31.Project.domain.dto.responsedto.contents.ContentsListResponseDto;
import bera31.Project.domain.member.Member;
import bera31.Project.domain.page.intersection.*;
import bera31.Project.repository.MemberRepository;
import bera31.Project.utility.SecurityUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MyPageService {
    private final MemberRepository memberRepository;

    public MyPageResponseDto showMyPage() {
        Member findedMember = loadCurrentMember();

        return new MyPageResponseDto(findedMember.getProfileImage(), findedMember.getNickname(),
                    loadMyContents(findedMember), loadParticipantingGroupBuying(findedMember),
                loadFavoriteGroupBuying(findedMember), loadTodaySchedules(findedMember));
    }

    public List<TodayScheduleResponseDto> loadTodaySchedules(Member findedMember){
        return findedMember.getMemoList().stream()
                .limit(4).filter(sch -> sch.getTargetDate().equals(LocalDate.now()))
                .map(TodayScheduleResponseDto::new).collect(Collectors.toList());
    }

    public List<ContentsListResponseDto.SimpleContentsResponseDto> loadMyContents(Member findedMember) {
        return findedMember.getContentsList().stream()
                .map(ContentsListResponseDto.SimpleContentsResponseDto::new)
                .collect(Collectors.toList());
    }


    public List<ContentsListResponseDto.SimpleContentsResponseDto> loadParticipantingGroupBuying(Member findedMember) {
        return findedMember.getParticipantingContents().stream()
                .map(ContentsParticipation::getContents)
                .map(ContentsListResponseDto.SimpleContentsResponseDto::new)
                .collect(Collectors.toList());
    }

    public List<ContentsListResponseDto.SimpleContentsResponseDto> loadFavoriteGroupBuying(Member findedMember) {
        return findedMember.getLikedContents().stream()
                .map(LikedContents::getContents)
                .map(ContentsListResponseDto.SimpleContentsResponseDto::new)
                .collect(Collectors.toList());
    }

    private Member loadCurrentMember() {
        String currentMemberEmail = SecurityUtility.getCurrentMemberEmail();
        return memberRepository.findByEmail(currentMemberEmail).get();
    }
}
