package bera31.Project.domain.dto.responsedto.groupbuying;

import bera31.Project.domain.dto.responsedto.CommentResponseDto;
import bera31.Project.domain.page.Contents;
import bera31.Project.domain.page.groupbuying.GroupBuying;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class GroupBuyingResponseDto {
    Long id;
    String title;
    String profileImage;
    Long userId;
    String nickName;
    String postImage;
    String category;
    String product;
    String content;
    String link;
    String gu;
    String dong;
    LocalDateTime deadLine;
    LocalDateTime postTime;
    boolean checkMine;
    int price;
    int limitMember;
    int currentMember;
    List<CommentResponseDto> commentList;

    public GroupBuyingResponseDto(Contents contents, List<CommentResponseDto> commentList, boolean checkMine) {
        this.id = contents.getId();
        this.profileImage = contents.getUser().getProfileImage();
        this.title = contents.getTitle();
        this.userId = contents.getUser().getId();
        this.nickName = contents.getUser().getNickname();
        this.category = contents.getCategory();
        this.postImage = contents.getImage();
        this.product = contents.getProduct();
        this.price = contents.getPrice();
        this.deadLine = contents.getDeadLine();
        this.content = contents.getContent();
        this.link = contents.getLink();
        this.gu = contents.getGu();
        this.dong = contents.getDong();
        this.currentMember = contents.getMemberList().size();
        this.limitMember = contents.getMemberLimit();
        this.commentList = commentList;
        this.postTime = contents.getPostTime();
        this.checkMine = checkMine;
    }
}
