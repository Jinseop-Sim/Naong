package bera31.Project.repository.page;

import bera31.Project.domain.member.Member;
import bera31.Project.domain.page.groupbuying.GroupBuying;
import bera31.Project.domain.page.intersection.ContentsParticipation;
import bera31.Project.domain.page.intersection.DutchPayIntersection;
import bera31.Project.domain.page.intersection.GroupBuyingIntersection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class IntersectionRepository {
    private final EntityManager em;

    public Long save(ContentsParticipation contentsParticipation) {
        em.persist(contentsParticipation);
        return contentsParticipation.getId();
    }


    public List<ContentsParticipation> findByUserId(Member participant) {
        return em.createQuery("select cp from ContentsParticipation cp join fetch cp.contents " +
                        "where cp.participant =: participant", ContentsParticipation.class)
                .setParameter("participant", participant)
                .getResultList();
    }
}
