package bera31.Project.domain.page;

import bera31.Project.domain.comment.Comment;
import bera31.Project.domain.dto.requestdto.ContentsRequestDto;
import bera31.Project.domain.dto.requestdto.GroupBuyingRequestDto;
import bera31.Project.domain.dto.responsedto.groupbuying.GroupBuyingListResponseDto;
import bera31.Project.domain.member.Member;
import bera31.Project.domain.page.intersection.*;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
public class Contents {
    @Id
    @GeneratedValue
    @Column(name = "CONTENTS_ID")
    private Long id;

    private String title;
    private String category;
    private String content;
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();
    private LocalDateTime postTime;

    // Sharing field
    private boolean isFinish;
    private String product;
    private LocalDateTime expiry;
    private LocalDateTime deadLine;
    private String image;
    private String gu;
    private String dong;
    @OneToMany(mappedBy = "contents", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<LikedContents> likedMemberList = new ArrayList<>();

    // GroupBuying field
    private String link;
    private int price;
    private int memberLimit;
    @OneToMany(mappedBy = "contents", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ContentsParticipation> memberList = new ArrayList<>();

    // DutchPay field
    private String store;
    private int deliveryCost;
    // String address;
    private String detailAddress;

    // 구분자
    private ContentsType contentsType;

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public Contents(ContentsRequestDto contentsRequestDto, Member member, ContentsType contentsType) {
        this.title = contentsRequestDto.getTitle();
        this.category = contentsRequestDto.getCategory();
        this.content = contentsRequestDto.getContent();
        this.user = member;
        this.postTime = LocalDateTime.now();
        this.isFinish = false;
        this.product = contentsRequestDto.getProduct();
        this.expiry = contentsRequestDto.getExpiry();
        this.deadLine = contentsRequestDto.getDeadLine();
        this.gu = contentsRequestDto.getGu();
        this.dong = contentsRequestDto.getDong();

        this.link = contentsRequestDto.getLink();
        this.price = contentsRequestDto.getDeliveryCost();
        this.memberLimit = contentsRequestDto.getMemberLimit();
        this.store = contentsRequestDto.getStore();
        this.deliveryCost = contentsRequestDto.getDeliveryCost();
        this.detailAddress = contentsRequestDto.getDetailAddress();

        this.contentsType = contentsType;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void addMember(ContentsParticipation contentsParticipation) {
        memberList.add(contentsParticipation);
    }

    public void expirePost() {
        this.isFinish = true;
    }

    public Long update(ContentsRequestDto contentsRequestDto) {
        this.category = contentsRequestDto.getCategory();
        this.expiry = contentsRequestDto.getExpiry();
        this.price = contentsRequestDto.getPrice();
        this.memberLimit = contentsRequestDto.getMemberLimit();
        this.content = contentsRequestDto.getContent();
        this.product = contentsRequestDto.getProduct();
        this.deadLine = contentsRequestDto.getDeadLine();
        this.link = contentsRequestDto.getLink();
        this.title = contentsRequestDto.getTitle();
        this.gu = contentsRequestDto.getGu();
        this.dong = contentsRequestDto.getDong();

        this.store = contentsRequestDto.getStore();
        this.deliveryCost = contentsRequestDto.getDeliveryCost();
        this.detailAddress = contentsRequestDto.getDetailAddress();
        return this.getId();
    }

}
