package bera31.Project.domain.dto.responsedto;

import bera31.Project.domain.member.Member;
import bera31.Project.domain.page.Contents;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ContentsResponseDto {
    private Long id;
    private String title;
    private String profileImage;
    private Long userId;
    private String nickName;
    private String postImage;
    private String category;
    private String product;
    private String content;
    private String link;
    private String gu;
    private String dong;
    private String detailAddress;
    private LocalDateTime deadLine;
    private LocalDateTime postTime;
    private boolean checkMine;
    private int price;
    private int deliveryCost;
    private int limitMember;
    private int currentMember;
    private List<CommentResponseDto> commentList;

    public ContentsResponseDto(Contents contents, List<CommentResponseDto> commentList, boolean checkMine){
        Member author = contents.getUser();
        this.profileImage = author.getProfileImage();
        this.userId = author.getId();
        this.nickName = author.getNickname();

        this.id = contents.getId();
        this.title = contents.getTitle();
        this.postImage = contents.getImage();
        this.category = contents.getCategory();
        this.product = contents.getProduct();
        this.content = contents.getContent();
        this.link = contents.getLink();
        this.gu = contents.getGu();
        this.dong = contents.getDong();
        this.detailAddress = contents.getDetailAddress();
        this.deadLine = contents.getDeadLine();
        this.postTime = contents.getPostTime();
        this.checkMine = checkMine;
        this.price = contents.getPrice();
        this.deliveryCost = contents.getDeliveryCost();
        this.limitMember = contents.getMemberLimit();;
        this.currentMember = contents.getMemberList().size();
        this.commentList = commentList;
    }
}
