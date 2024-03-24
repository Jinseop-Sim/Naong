package bera31.Project.domain.page.intersection;

import bera31.Project.domain.member.Member;
import bera31.Project.domain.page.Contents;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class ContentsParticipation {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member participant;

    @ManyToOne
    @JoinColumn(name = "CONTENTS_ID")
    private Contents contents;

    public ContentsParticipation(Member member, Contents contents){
        this.participant = member;
        this.contents = contents;
    }
}
