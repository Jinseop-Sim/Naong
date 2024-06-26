package bera31.Project.domain.comment;

import bera31.Project.domain.dto.requestdto.CommentRequestDto;
import bera31.Project.domain.member.Member;
import bera31.Project.domain.page.Contents;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Comment {
    @Id
    @GeneratedValue
    Long id;
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    Member user;
    LocalDateTime timeStamp;
    String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    Comment parent;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent", cascade = CascadeType.ALL)
    List<Comment> children = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "CONTENTS_ID")
    Contents post;

    public Comment(CommentRequestDto commentRequestDto, Member member, Contents post, Comment parent) {
        this.user = member;
        this.timeStamp = LocalDateTime.now();
        this.content = commentRequestDto.getContent();
        this.post = post;
    }

    public static Comment commentWithoutParent(CommentRequestDto commentRequestDto, Member member, Contents post){
        return new Comment(commentRequestDto, member, post, null);
    }

    public static Comment commentWithParent(CommentRequestDto commentRequestDto, Member member, Comment parent){
        return new Comment(commentRequestDto, member, parent.getPost(), parent);
    }

    public void addChildComment(Comment comment) {
        this.children.add(comment);
    }
}

