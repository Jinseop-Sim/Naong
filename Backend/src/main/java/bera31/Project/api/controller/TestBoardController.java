package bera31.Project.api.controller;

import bera31.Project.domain.dto.responsedto.TestBoardDto;
import bera31.Project.service.TestBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestBoardController {
    private final TestBoardService testBoardService;

    @GetMapping("/{cursor}")
    public ResponseEntity<List<TestBoardDto>> findBoardsWithCursorPaging(@PathVariable int cursor){
        return new ResponseEntity<>(testBoardService.findByCursorPaging(cursor), HttpStatus.OK);
    }
}
