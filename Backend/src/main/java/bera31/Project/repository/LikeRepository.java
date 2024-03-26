package bera31.Project.repository;

import bera31.Project.domain.member.Member;
import bera31.Project.domain.page.Contents;
import bera31.Project.domain.page.intersection.LikedContents;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class LikeRepository {
    private final EntityManager em;

    public String save(LikedContents likedContents) {
        em.persist(likedContents);
        return likedContents.getId().toString();
    }

    public Optional<LikedContents> findByPostIdAndUserId(Contents contents, Member member) {
        List<LikedContents> resultList = em.createQuery("select lc from LikedContents lc " +
                        "where lc.contents =: contents and lc.user =: member", LikedContents.class)
                .setParameter("contents", contents)
                .setParameter("member", member)
                .getResultList();

        return resultList.stream().findAny();
    }

    public String delete(LikedContents likedContents){
        em.remove(likedContents);
        return "찜 취소";
    }
}
