package bera31.Project.domain.member;

import bera31.Project.domain.dto.requestdto.SignUpDto;
import bera31.Project.domain.page.Contents;
import bera31.Project.domain.page.intersection.*;
import bera31.Project.domain.schedule.Schedule;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
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
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9._]+@[A-Za-z]+.[A-za-z]$")
    private String email;
    @NotNull
    private String nickname;
    @NotNull
    @Size(min = 8, max = 12, message = "8글자 이상, 12글자 이하가 되어야 합니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\\\W)(?=\\\\S+$)",
            message = "숫자, 영문 대소문자, 특수문자가 반드시 조합되어야 합니다.")
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

    private Member(SignUpDto signUpDto){
        this.email = signUpDto.getEmail();
        this.password = signUpDto.getPassword();
        this.nickname = signUpDto.getNickname();
        this.gu = signUpDto.getGu();
        this.dong = signUpDto.getDong();
        this.authority = Authority.ROLE_USER;
        this.provider = Provider.NAONG;
    }

    public static Member toMember(SignUpDto signUpDto){
        return new Member(signUpDto);
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