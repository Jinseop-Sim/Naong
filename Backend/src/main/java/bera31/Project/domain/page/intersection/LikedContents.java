package bera31.Project.domain.page.intersection;

import bera31.Project.domain.member.Member;
import bera31.Project.domain.page.Contents;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class LikedContents {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member user;

    @ManyToOne
    @JoinColumn(name = "CONTENTS_ID")
    private Contents contents;

    public LikedContents(Member member, Contents contents){
        this.user = member;
        this.contents = contents;
    }
}
