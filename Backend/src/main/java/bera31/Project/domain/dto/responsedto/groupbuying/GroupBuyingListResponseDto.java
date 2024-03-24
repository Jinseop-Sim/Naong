package bera31.Project.domain.dto.responsedto.groupbuying;

import bera31.Project.domain.Address;
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
    Long id;
    String image;
    String nickname;
    String title;
    String category;
    String dong;
    LocalDateTime postTime;
    LocalDateTime deadLine;
    int limit;
    int currParticipant;
    boolean isFinish;

    public GroupBuyingListResponseDto(Contents contents) {
        Member author = contents.getUser();
        this.id = contents.getId();
        this.image = contents.getImage();
        this.nickname = author.getNickname();
        this.title = contents.getTitle();
        this.category = contents.getCategory();
        this.dong = contents.getDong();
        this.postTime = contents.getPostTime();
        this.deadLine = contents.getDeadLine();
        this.limit = contents.getMemberLimit();
        this.currParticipant = contents.getMemberList().size();
        this.isFinish = contents.isFinish();
    }
}
