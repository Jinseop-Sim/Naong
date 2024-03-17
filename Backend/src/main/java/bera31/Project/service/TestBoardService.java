package bera31.Project.service;

import bera31.Project.domain.TestBoard;
import bera31.Project.domain.dto.responsedto.TestBoardDto;
import bera31.Project.repository.TestBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestBoardService {
    private final TestBoardRepository testBoardRepository;

    public List<TestBoardDto> findByCursorPaging(int cursor){
        return testBoardRepository.findByCursorPaging(cursor)
                .stream().map(TestBoardDto::new)
                .collect(Collectors.toList());
    }
}
