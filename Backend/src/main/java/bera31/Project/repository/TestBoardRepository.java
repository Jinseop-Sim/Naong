package bera31.Project.repository;

import bera31.Project.domain.TestBoard;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.awt.print.Pageable;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TestBoardRepository{
    private final EntityManager em;

    public List<TestBoard> findByCursorPaging(int cursor){
        return em.createQuery("select t from TestBoard t where t.id<:id order by t.id desc", TestBoard.class)
                .setParameter("id", cursor)
                .setMaxResults(10)
                .getResultList();
    }
}
