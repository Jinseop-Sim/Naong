package bera31.Project.domain.dto.responsedto.groupbuying;

import bera31.Project.domain.Address;
import bera31.Project.domain.dto.responsedto.contents.ContentsListResponseDto;
import bera31.Project.domain.member.Member;
import bera31.Project.domain.page.Contents;
import bera31.Project.domain.page.groupbuying.GroupBuying;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GroupBuyingListResponseDto {
    private Long id;
    private String image;
    private String nickname;
    private String title;
    private String category;
    private String dong;
    private LocalDateTime postTime;
    private LocalDateTime deadLine;
    private int limit;
    private int currParticipant;
    private boolean isFinish;

    private GroupBuyingListResponseDto(ContentsListResponseDto contentsListResponseDto) {
        this.id = contentsListResponseDto.getId();
        this.image = contentsListResponseDto.getImage();
        this.nickname = contentsListResponseDto.getNickname();
        this.title = contentsListResponseDto.getTitle();
        this.category = contentsListResponseDto.getCategory();
        this.dong = contentsListResponseDto.getDong();
        this.postTime = contentsListResponseDto.getPostTime();
        this.deadLine = contentsListResponseDto.getDeadLine();
        this.limit = contentsListResponseDto.getLimit();
        this.currParticipant = contentsListResponseDto.getCurrParticipant();
        this.isFinish = contentsListResponseDto.isFinish();
    }

    public static GroupBuyingListResponseDto fromContentsListResponse(ContentsListResponseDto contentsListResponseDto){
        return new GroupBuyingListResponseDto(contentsListResponseDto);
    }
}
