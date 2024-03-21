package bera31.Project.repository;

import bera31.Project.domain.TestBoard;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestBoardRepository extends JpaRepository<TestBoard, Long> {
    Page<TestBoard> findAllByOrderByIdDesc(Pageable pageable);
}