package bera31.Project.domain.member;

import bera31.Project.domain.page.Contents;
import bera31.Project.domain.page.intersection.*;
import bera31.Project.domain.schedule.Schedule;
import bera31.Project.domain.page.dutchpay.DutchPay;
import bera31.Project.domain.page.groupbuying.GroupBuying;
import bera31.Project.domain.page.sharing.Sharing;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String email;
    private String nickname;
    private String password;
    private String profileImage;
    @Enumerated(EnumType.STRING)
    private Authority authority;
    private String dong;
    private String gu;
    private double manner;
    @Enumerated(EnumType.STRING)
    private Provider provider;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Contents> contentsList = new ArrayList<>();

    @OneToMany(mappedBy = "participant", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ContentsParticipation> participantingContents = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<LikedContents> likedContents = new ArrayList<>();

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Schedule> memoList = new ArrayList<>();

    public Member(String email, String password, String nickname, String dong, String gu) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.dong = dong;
        this.gu = gu;
        this.authority = Authority.ROLE_USER;
        this.provider = Provider.NAONG;
    }

    public void postContents(Contents contents) {this.contentsList.add(contents); }

    public void participantContent(ContentsParticipation contentsParticipation) {
        this.participantingContents.add(contentsParticipation);
    }
    public void pushLikeContent(LikedContents likedContents) {
        this.likedContents.add(likedContents);
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public void changeAddress(String dong, String gu) {
        this.dong = dong;
        this.gu = gu;
    }

    public void setKakaoMemberInfo(String image) {
        this.profileImage = image;
        this.provider = Provider.KAKAO;
    }

    public void setKakaoMemberNickname(String nickname) {
        this.nickname = nickname;
    }

    public void addMemo(Schedule schedule) {
        this.memoList.add(schedule);
    }
}