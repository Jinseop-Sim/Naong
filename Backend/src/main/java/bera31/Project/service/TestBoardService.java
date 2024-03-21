package bera31.Project.service;

import bera31.Project.domain.dto.responsedto.TestBoardDto;
import bera31.Project.repository.TestBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestBoardService {
    private final TestBoardRepository testBoardRepository;

    @Transactional(readOnly = true)
    public List<TestBoardDto> findByCursorPaging(Pageable pageable){
        return testBoardRepository.findAllByOrderByIdDesc(pageable).stream()
                .map(TestBoardDto::new).collect(Collectors.toList());
    }
}
