package bera31.Project.domain.dto.responsedto;

import bera31.Project.domain.dto.responsedto.contents.ContentsListResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MyPageResponseDto {
    String profileImage;
    String nickname;
    List<ContentsListResponseDto.SimpleContentsResponseDto> simpleContentsList;
    List<ContentsListResponseDto.SimpleContentsResponseDto> simpleLikedContentsList;
    List<ContentsListResponseDto.SimpleContentsResponseDto> simpleParticipantingContentsList;
    List<TodayScheduleResponseDto> todayScheduleList;
}