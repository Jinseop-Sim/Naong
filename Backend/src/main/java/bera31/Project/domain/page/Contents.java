package bera31.Project.domain.page;


import bera31.Project.domain.comment.Comment;
import bera31.Project.domain.member.Member;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@DiscriminatorColumn(name = "DTYPE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Contents {
    @Id
    @GeneratedValue
    @Column(name = "CONTENTS_ID")
    protected Long id;

    protected String title;
    protected String category;
    protected String content;
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    protected Member user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    protected List<Comment> comments = new ArrayList<>();

    protected LocalDateTime postTime;

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public Contents(Member user, String title, String category, String content){
        this.user = user;
        this.title = title;
        this.category = category;
        this.content = content;
        this.postTime = LocalDateTime.now();
    }
}
