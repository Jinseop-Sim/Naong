package bera31.Project.domain.dto.responsedto.dutchpay;

import bera31.Project.domain.dto.responsedto.contents.ContentsListResponseDto;
import bera31.Project.domain.page.dutchpay.DutchPay;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DutchPayListResponseDto {
    Long id;
    String store;
    String category;
    String address;
    int deliveryCost;
    int currentMember;
    int limitMember;
    LocalDateTime deadLine;
    LocalDateTime postTime;

    public DutchPayListResponseDto(ContentsListResponseDto contentsListResponseDto) {
        this.id = contentsListResponseDto.getId();
        this.store = contentsListResponseDto.getStore();
        this.category = contentsListResponseDto.getCategory();
        this.address = contentsListResponseDto.getAddress();
        this.deliveryCost = contentsListResponseDto.getDeliveryCost();
        this.limitMember = contentsListResponseDto.getLimit();
        this.currentMember = contentsListResponseDto.getCurrentMember();
        this.deadLine = contentsListResponseDto.getDeadLine();
        this.postTime = contentsListResponseDto.getPostTime();
    }
}
