package bera31.Project.repository;

import bera31.Project.domain.comment.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {

    private final EntityManager em;

    public Long save(Comment comment) {
        em.persist(comment);
        return comment.getId();
    }

    public Long delete(Comment comment) {
        em.remove(comment);
        return comment.getId();
    }

    public List<Comment> findAll() {
        return em.createQuery("select c from Comment c", Comment.class)
                .getResultList();
    }


    public Comment findCommentById(Long id) {
        return em.createQuery("select c from Comment c where c.id =:id", Comment.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
