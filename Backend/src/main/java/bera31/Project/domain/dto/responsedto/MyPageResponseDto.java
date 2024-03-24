package bera31.Project.domain.dto.responsedto;

import bera31.Project.domain.dto.responsedto.groupbuying.SimpleContentsResponseDto;
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
    List<SimpleContentsResponseDto> simpleContentsList;
    List<SimpleContentsResponseDto> simpleLikedContentsList;
    List<SimpleContentsResponseDto> simpleParticipantingContentsList;
    List<TodayScheduleResponseDto> todayScheduleList;
}