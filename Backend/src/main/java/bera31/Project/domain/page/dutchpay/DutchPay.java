package bera31.Project.domain.page.dutchpay;

import bera31.Project.domain.dto.requestdto.DutchPayRequestDto;
import bera31.Project.domain.member.Member;
import bera31.Project.domain.page.Contents;
import bera31.Project.domain.page.intersection.DutchPayIntersection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
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
    @OneToMany(mappedBy = "dutchPay", cascade = CascadeType.ALL, orphanRemoval = true)
    List<DutchPayIntersection> memberList = new ArrayList<>();

    public DutchPay(DutchPayRequestDto dutchPayRequestDto, Member member) {
        super(member, null, dutchPayRequestDto.getCategory(), dutchPayRequestDto.getContent());
        this.store = dutchPayRequestDto.getStore();
        this.deliveryCost = dutchPayRequestDto.getDeliveryCost();
        this.limitMember = dutchPayRequestDto.getLimitMember();
        this.address = dutchPayRequestDto.getAddress();
        this.detailAddress = dutchPayRequestDto.getDetailAddress();
        this.deadLine = dutchPayRequestDto.getDeadLine();
    }

    public void addParticipantMember(DutchPayIntersection dutchPayIntersection) {
        memberList.add(dutchPayIntersection);
    }
}
