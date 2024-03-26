package bera31.Project.domain.dto.responsedto.dutchpay;

import bera31.Project.domain.dto.responsedto.contents.ContentsResponseDto;
import bera31.Project.domain.page.dutchpay.DutchPay;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DutchPayResponseDto {
    Long id;
    Long userId;
    String nickname;
    String profileImage;
    String store;
    String category;
    int deliveryCost;
    int limitMember;
    String address;
    String detailAddress;
    LocalDateTime deadLine;
    LocalDateTime postTime;
    String content;
    int currentMember;
    boolean checkMine;

    public DutchPayResponseDto(ContentsResponseDto contentsResponseDto) {
        this.id = contentsResponseDto.getId();
        this.userId = contentsResponseDto.getUserId();
        this.nickname = contentsResponseDto.getNickName();
        this.profileImage = contentsResponseDto.getProfileImage();
        this.store = contentsResponseDto.getStore();
        this.category = contentsResponseDto.getCategory();
        this.deliveryCost = contentsResponseDto.getDeliveryCost();
        this.limitMember = contentsResponseDto.getLimitMember();
        this.currentMember = contentsResponseDto.getCurrentMember();
        this.deadLine = contentsResponseDto.getDeadLine();
        this.address = contentsResponseDto.getGu() + " " + contentsResponseDto.getDong();
        this.detailAddress = contentsResponseDto.getDetailAddress();
        this.content = contentsResponseDto.getContent();
        this.postTime = contentsResponseDto.getPostTime();
        this.checkMine = contentsResponseDto.isCheckMine();
    }
}
