package bera31.Project.repository.page;

import bera31.Project.domain.page.Contents;
import bera31.Project.domain.page.dutchpay.DutchPay;
import bera31.Project.domain.page.groupbuying.GroupBuying;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DutchPayRepository{
    private final EntityManager em;

    public Long save(DutchPay dutchPay) {
        em.persist(dutchPay);
        return dutchPay.getId();
    }

    public Long delete(DutchPay dutchPay) {
        em.remove(dutchPay);
        return dutchPay.getId();
    }

    public List<DutchPay> findAll() {
        return em.createQuery("select d from DutchPay d", DutchPay.class)
                .getResultList();
    }

    public DutchPay findById(Long id) {
        return em.createQuery("select d from DutchPay d where d.id =:id", DutchPay.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public List<DutchPay> findAllWithPaging(int page){
        return em.createQuery("select d from DutchPay d", DutchPay.class)
                .setFirstResult((page - 1) * 6)
                .setMaxResults(6)
                .getResultList();
    }

    public List<DutchPay> findByKeword(String keyword) {
        return em.createQuery("select d from DutchPay d where d.title LIKE :keyword", DutchPay.class)
                .setParameter("keyword", "%" + keyword + "%")
                .getResultList();
    }
}
