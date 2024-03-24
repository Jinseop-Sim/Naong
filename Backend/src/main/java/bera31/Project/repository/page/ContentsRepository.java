package bera31.Project.repository.page;

import bera31.Project.domain.page.Contents;
import bera31.Project.domain.page.ContentsType;
import bera31.Project.domain.page.groupbuying.GroupBuying;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ContentsRepository {
    private final EntityManager em;

    public Long save(Contents contents) {
        em.persist(contents);
        return contents.getId();
    }
    public Long delete(Contents contents) {
        em.persist(contents);
        return contents.getId();
    }

    public List<Contents> findAll(ContentsType contentsType) {
        return em.createQuery("select c from Contents c where c.contentsType=:contentsType", Contents.class)
                .setParameter("contentsType", contentsType)
                .getResultList();
    }

    public Contents findById(Long id) {
        return em.createQuery("select c from Contents c where c.id =:id", Contents.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public List<Contents> findAllWithPaging(int page) {
        return em.createQuery("select c from Contents c", Contents.class)
                .setFirstResult((page - 1) * 6)
                .setMaxResults(6)
                .getResultList();
    }

/*    public List<Contents> findAllWithCursor(int lastPage){
        return em.createQuery("select c from Contents c where c.id <:lastPage", Contents.class)
                .setParameter("lastPage", lastPage)
                .setMaxResults(5)
                .getResultList();
    }*/
}
