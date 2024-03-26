package bera31.Project.domain.dto.responsedto.groupbuying;

import bera31.Project.domain.dto.responsedto.CommentResponseDto;
import bera31.Project.domain.dto.responsedto.contents.ContentsResponseDto;
import bera31.Project.domain.page.Contents;
import bera31.Project.domain.page.groupbuying.GroupBuying;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class GroupBuyingResponseDto {
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
    private LocalDateTime deadLine;
    private LocalDateTime postTime;
    private boolean checkMine;
    private int price;
    private int limitMember;
    private int currentMember;
    private List<CommentResponseDto> commentList;

    private GroupBuyingResponseDto(ContentsResponseDto contentsResponseDto){
        this.id = contentsResponseDto.getId();
        this.profileImage = contentsResponseDto.getProfileImage();
        this.title = contentsResponseDto.getTitle();
        this.userId = contentsResponseDto.getUserId();
        this.nickName = contentsResponseDto.getNickName();
        this.category = contentsResponseDto.getCategory();
        this.postImage = contentsResponseDto.getPostImage();
        this.product = contentsResponseDto.getProduct();
        this.price = contentsResponseDto.getPrice();
        this.deadLine = contentsResponseDto.getDeadLine();
        this.content = contentsResponseDto.getContent();
        this.link = contentsResponseDto.getLink();
        this.gu = contentsResponseDto.getGu();
        this.dong = contentsResponseDto.getDong();
        this.currentMember = contentsResponseDto.getCurrentMember();
        this.limitMember = contentsResponseDto.getLimitMember();
        this.commentList = contentsResponseDto.getCommentList();
        this.postTime = contentsResponseDto.getPostTime();
        this.checkMine = contentsResponseDto.isCheckMine();
    }
    public static GroupBuyingResponseDto fromContentsResponse(ContentsResponseDto contentsResponseDto) {
        return new GroupBuyingResponseDto(contentsResponseDto);
    }
}
