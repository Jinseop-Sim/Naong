package bera31.Project.domain.dto.requestdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContentsRequestDto {
    // D & G & S Request Dto
    LocalDateTime deadLine;
    String content;
    String category;
    // GroupBuying & Sharing Request Dto
    String title;
    String product;
    String gu;
    String dong;

    // GroupBuying
    String link;
    int price;
    int memberLimit;

    // Sharing
    LocalDateTime expiry;

    // DutchPay
    String store;
    String address;
    String detailAddress;
    int deliveryCost;
}
