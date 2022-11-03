package bera31.Project.domain.dto.responsedto;

import bera31.Project.domain.page.dutchpay.Category;
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
    Category category;
    int deliveryCost;
    int currentMember;
    int limitMember;
    LocalDateTime deadLine;

    public DutchPayListResponseDto(DutchPay dutchPay) {
        this.id = dutchPay.getId();
        this.store = dutchPay.getStore();
        this.category = dutchPay.getCategory();
        this.deliveryCost = dutchPay.getDeliveryCost();
        this.limitMember = dutchPay.getLimitMember();
        this.currentMember = dutchPay.getMemberList().size();
        this.deadLine = dutchPay.getDeadLine();
    }
}
