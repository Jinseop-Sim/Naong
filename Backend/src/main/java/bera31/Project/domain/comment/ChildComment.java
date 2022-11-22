package bera31.Project.domain.comment;

import bera31.Project.domain.member.Member;
import bera31.Project.domain.page.Contents;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ChildComment {
    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    Member user;

    LocalDateTime timeStamp;
    String content;

    @ManyToOne
    @JoinColumn(name = "COMMENT_ID")
    Comment parent;

    @ManyToOne
    @JoinColumn(name = "CONTENTS_ID")
    Contents contents;
}
