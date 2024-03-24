package bera31.Project.domain.dto.responsedto.groupbuying;

import bera31.Project.domain.page.Contents;
import bera31.Project.domain.page.ContentsType;
import bera31.Project.domain.page.dutchpay.DutchPay;
import bera31.Project.domain.page.groupbuying.GroupBuying;
import bera31.Project.domain.page.sharing.Sharing;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SimpleContentsResponseDto {
    Long id;
    String title;
    LocalDateTime postTime;
    ContentsType contentsType;

    public SimpleContentsResponseDto(Contents contents){
        this.id = contents.getId();
        this.title = contents.getTitle();
        this.postTime = contents.getPostTime();
        this.contentsType = contents.getContentsType();
    }
}
