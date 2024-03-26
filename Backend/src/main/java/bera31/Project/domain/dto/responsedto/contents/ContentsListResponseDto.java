package bera31.Project.domain.dto.responsedto.contents;

import bera31.Project.domain.member.Member;
import bera31.Project.domain.page.Contents;
import bera31.Project.domain.page.ContentsType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ContentsListResponseDto {
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

    String store;
    String address;
    int deliveryCost;
    int currentMember;

    public ContentsListResponseDto(Contents contents){
        Member user = contents.getUser();
        this.id = contents.getId();
        this.image = contents.getImage();
        this.nickname = user.getNickname();
        this.title = contents.getTitle();
        this.category = contents.getCategory();
        this.dong = contents.getDong();
        this.postTime = contents.getPostTime();
        this.deadLine = contents.getDeadLine();
        this.limit = contents.getMemberLimit();
        this.currParticipant = contents.getMemberList().size();
        this.isFinish = contents.isFinish();
        this.store = contents.getStore();
        this.address = contents.getGu() + " " + contents.getDong();
        this.deliveryCost = contents.getDeliveryCost();
    }

    @Getter
    public static class SimpleContentsResponseDto {
        Long id;
        String title;
        LocalDateTime postTime;
        ContentsType contentsType;

        public SimpleContentsResponseDto(Contents contents){
            this.id = contents.getId();
            this.title = contents.getTitle();
            this.postTime = contents.getPostTime();
            this.contentsType = contents.getContentsType();
        }
    }
}

