package bera31.Project.repository.page;

import bera31.Project.domain.page.Contents;
import bera31.Project.domain.page.groupbuying.GroupBuying;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class GroupBuyingRepository {
    private final EntityManager em;
    public Long save(GroupBuying groupBuying) {
        em.persist(groupBuying);
        return groupBuying.getId();
    }
    public Long delete(GroupBuying groupBuying) {
        em.persist(groupBuying);
        return groupBuying.getId();
    }

    public List<GroupBuying> findAll() {
        return em.createQuery("select g from GroupBuying g", GroupBuying.class)
                .getResultList();
    }

    public GroupBuying findById(Long id) {
        return em.createQuery("select g from GroupBuying g where g.id =:id", GroupBuying.class)
                .setParameter("id", id)
                .getSingleResult();
    }
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
