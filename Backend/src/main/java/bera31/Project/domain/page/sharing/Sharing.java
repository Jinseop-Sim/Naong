package bera31.Project.domain.page.sharing;

import bera31.Project.domain.Address;
import bera31.Project.domain.dto.requestdto.SharingRequestDto;
import bera31.Project.domain.member.Member;
import bera31.Project.domain.page.Contents;
import bera31.Project.domain.page.intersection.LikedGroupBuying;
import bera31.Project.domain.page.intersection.LikedSharing;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("S")
public class Sharing extends Contents {
    String product;
    LocalDateTime expiry;
    LocalDateTime deadLine;
    boolean isFinish;
    String image;
    String gu;
    String dong;

    @OneToMany(mappedBy = "sharing", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<LikedSharing> likedMemberList = new ArrayList<>();

    public Sharing(SharingRequestDto sharingRequestDto, Member member) {
        super(member, sharingRequestDto.getTitle(), sharingRequestDto.getCategory(), sharingRequestDto.getContent());
        this.product = sharingRequestDto.getProduct();
        this.expiry = sharingRequestDto.getExpiry();
        this.deadLine = sharingRequestDto.getDeadLine();
        this.gu = sharingRequestDto.getGu();
        this.dong = sharingRequestDto.getDong();
        this.isFinish = false;
    }

    public void updateSharing(SharingRequestDto sharingRequestDto) {
        this.title = sharingRequestDto.getTitle();
        this.content = sharingRequestDto.getContent();
        this.category = sharingRequestDto.getCategory();
        this.product = sharingRequestDto.getProduct();
        this.expiry = sharingRequestDto.getExpiry();
        this.gu = sharingRequestDto.getGu();
        this.dong = sharingRequestDto.getDong();
        this.deadLine = sharingRequestDto.getDeadLine();
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void expirePost() {
        this.isFinish = true;
    }
}