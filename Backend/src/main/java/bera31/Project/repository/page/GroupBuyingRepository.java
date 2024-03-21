package bera31.Project.repository.page;

import bera31.Project.domain.page.Contents;
import bera31.Project.domain.page.groupbuying.GroupBuying;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class GroupBuyingRepository implements PostRepository<GroupBuying> {
    private final EntityManager em;
    @Override
    public Long save(Contents contents) {
        em.persist(contents);
        return contents.getId();
    }
    @Override
    public Long delete(Contents contents) {
        em.persist(contents);
        return contents.getId();
    }

    @Override
    public List<GroupBuying> findAll() {
        return em.createQuery("select g from GroupBuying g", GroupBuying.class)
                .getResultList();
    }

    @Override
    public GroupBuying findById(Long id) {
        return em.createQuery("select g from GroupBuying g where g.id =:id", GroupBuying.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<GroupBuying> findAllWithPaging(int page) {
        return em.createQuery("select g from GroupBuying g", GroupBuying.class)
                .setFirstResult((page - 1) * 6)
                .setMaxResults(6)
                .getResultList();
    }

/*    public List<GroupBuying> findAllWithCursor(int lastPage){
        return em.createQuery("select g from GroupBuying g where g.id <:lastPage", GroupBuying.class)
                .setParameter("lastPage", lastPage)
                .setMaxResults(5)
                .getResultList();
    }*/
}
