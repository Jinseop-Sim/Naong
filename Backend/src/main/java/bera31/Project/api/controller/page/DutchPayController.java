package bera31.Project.api.controller.page;

import bera31.Project.domain.dto.requestdto.CommentRequestDto;
import bera31.Project.domain.dto.requestdto.ContentsRequestDto;
import bera31.Project.domain.dto.requestdto.DutchPayRequestDto;
import bera31.Project.domain.dto.responsedto.ContentsListResponseDto;
import bera31.Project.domain.dto.responsedto.ContentsResponseDto;
import bera31.Project.domain.dto.responsedto.dutchpay.DutchPayListResponseDto;
import bera31.Project.domain.dto.responsedto.dutchpay.DutchPayResponseDto;
import bera31.Project.domain.page.ContentsType;
import bera31.Project.service.CommentService;
import bera31.Project.service.page.ContentsService;
import bera31.Project.service.page.DutchPayService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dutchPay")
public class DutchPayController {
    private final DutchPayService dutchPayService;
    private final ContentsService contentsService;

    @Operation(summary = "N빵 글 목록 조회", description = "N빵 글 목록 조회 시 요청하는 Api 입니다.")
    @GetMapping
    public ResponseEntity<List<ContentsListResponseDto>> findAll(@RequestParam ContentsType contentsType) {
        return new ResponseEntity<>(contentsService.findAll(contentsType), HttpStatus.OK);
    }

    @Operation(summary = "N빵 글 작성", description = "N빵 글 작성 시 요청하는 Api 입니다.\n" +
            "주소와 상세주소를 각각 Address, DetailAddress로 따로 받습니다.")
    @PostMapping
    public ResponseEntity<Long> postDutchPay(@RequestBody ContentsRequestDto contentsRequestDto, ContentsType contentsType) throws IOException {
        return new ResponseEntity<>(contentsService.postContents(contentsRequestDto, contentsType), HttpStatus.OK);
    }

    @Operation(summary = "N빵 글 삭제", description = "N빵 글 삭제 요청 시 요청하는 Api 입니다.")
    @DeleteMapping("/{dutchPayId}")
    public ResponseEntity<Long> deleteDutchPay(@PathVariable Long dutchPayId) {
        return new ResponseEntity<>(contentsService.deleteContents(dutchPayId), HttpStatus.OK);
    }

    @Operation(summary = "N빵 글 상세 조회",
            description = "N빵 글 상세 페이지 조회시 요청하는 Api 입니다.\n\n" +
                    "글에는 작성자의 고유 id가 같이 넘어갑니다.\n\n" +
                    "checkMine 변수로 본인 글인지 확인 가능하게 해두었습니다\n\n" +
                    "쪽지 보내기 기능이 사용될 경우, 해당 작성자의 id로 보내면 됩니다.")
    @GetMapping("/{dutchPayId}")
    public ResponseEntity<ContentsResponseDto> findDutchPay(@PathVariable Long dutchPayId) {
        return new ResponseEntity<>(contentsService.findById(dutchPayId), HttpStatus.OK);
    }

    @Operation(summary = "N빵 글 참여 API입니다.",
            description = "Request Parameter 형식으로 URL에 넘겨주시면 됩니다.")
    @PostMapping("/{dutchPayId}")
    public ResponseEntity<Long> participantDutchPay(@PathVariable Long dutchPayId) {
        return new ResponseEntity<>(contentsService.participantContents(dutchPayId), HttpStatus.OK);
    }
}
