package bera31.Project.domain.page.dutchpay;

import bera31.Project.domain.dto.requestdto.DutchPayRequestDto;
import bera31.Project.domain.member.Member;
import bera31.Project.domain.page.Contents;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

//@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("D")
public class DutchPay extends Contents {
    String store;
    int deliveryCost;
    int limitMember;
    LocalDateTime deadLine;
    String address;
    String detailAddress;
    /*@OneToMany(mappedBy = "dutchPay", cascade = CascadeType.ALL, orphanRemoval = true)
    List<DutchPayIntersection> memberList = new ArrayList<>();*/

    public DutchPay(DutchPayRequestDto dutchPayRequestDto, Member member) {
        this.store = dutchPayRequestDto.getStore();
        this.deliveryCost = dutchPayRequestDto.getDeliveryCost();
        this.limitMember = dutchPayRequestDto.getLimitMember();
        this.address = dutchPayRequestDto.getAddress();
        this.detailAddress = dutchPayRequestDto.getDetailAddress();
        this.deadLine = dutchPayRequestDto.getDeadLine();
    }
}
