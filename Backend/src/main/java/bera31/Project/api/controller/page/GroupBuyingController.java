package bera31.Project.api.controller.page;

import bera31.Project.domain.dto.requestdto.CommentRequestDto;
import bera31.Project.domain.dto.requestdto.ContentsRequestDto;
import bera31.Project.domain.dto.responsedto.contents.ContentsListResponseDto;
import bera31.Project.domain.dto.responsedto.contents.ContentsResponseDto;
import bera31.Project.domain.dto.responsedto.groupbuying.GroupBuyingListResponseDto;
import bera31.Project.domain.dto.responsedto.groupbuying.GroupBuyingResponseDto;
import bera31.Project.domain.page.ContentsType;
import bera31.Project.service.CommentService;
import bera31.Project.service.page.ContentsService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/groupBuying")
public class GroupBuyingController {
    private final ContentsService contentsService;
    private final CommentService commentService;

    @Operation(summary = "공동구매 글 작성 API입니다.",
            description = "사진은 필수 값입니다.\n\n" +
                    "form-data/multipart 형식으로 보내주시면 됩니다.")
    @PostMapping
    public ResponseEntity<Long> postGroupBuying(@RequestBody ContentsRequestDto contentsRequestDto,
                                                @RequestParam ContentsType contentsType) throws IOException {
        return new ResponseEntity<>(contentsService.postContents(contentsRequestDto, contentsType), HttpStatus.OK);
    }

    @Operation(summary = "공동 구매 전체 글 조회 API입니다.",
            description = "공동구매 창 처음 접속 시 보여지는 글 목록 요청 Api 입니다. \n\n" +
                    "전체 조회에도 각 게시글 마다 고유 id를 같이 보내놨습니다.\n\n" +
                    "해당 값은 글 내용 조회 시, 수정 시, 삭제 시, 참여 기능, 찜 기능에 사용됩니다.")
    @GetMapping
    public ResponseEntity<List<GroupBuyingListResponseDto>> findAllGroupBuying(@RequestParam ContentsType contentsType) {
        return new ResponseEntity<>(contentsService.findAll(contentsType).stream()
                .map(GroupBuyingListResponseDto::fromContentsListResponse).collect(Collectors.toList()), HttpStatus.OK);
    }

    @Operation(summary = "변경된 공동 구매 전체 글 조회 API입니다.",
            description = "공동구매 창 처음 접속 시 보여지는 글 목록 요청 Api 입니다. \n\n" +
                    "전체 조회에도 각 게시글 마다 고유 id를 같이 보내놨습니다.\n\n" +
                    "페이지네이션까지 된 목록 조회입니다.\n\n" +
                    "해당 값은 글 내용 조회 시, 수정 시, 삭제 시, 참여 기능, 찜 기능에 사용됩니다.")
    @GetMapping("/page/{pageNumber}")
    public ResponseEntity<List<GroupBuyingListResponseDto>> findAllGroupBuyingWithPaging(@PathVariable int pageNumber) {
        return new ResponseEntity<>(contentsService.findAllWithPaging(pageNumber).stream()
                                .map(GroupBuyingListResponseDto::fromContentsListResponse).collect(Collectors.toList()), HttpStatus.OK);
    }

    @Operation(summary = "공동구매 글 상세 조회 API 입니다.",
            description = "글의 고유 id를 Request Parameter 형식으로 URL에 보내주시면 됩니다.\n\n" +
                    "글에는 작성자의 고유 id가 같이 넘어갑니다.\n\n" +
                    "checkMine 변수로 본인 글인지 확인 가능하게 해두었습니다\n\n" +
                    "쪽지 보내기 기능이 사용될 경우, 해당 작성자의 id로 보내면 됩니다.")
    @GetMapping("/{postId}")
    public ResponseEntity<GroupBuyingResponseDto> findGroupBuying(@PathVariable Long postId) {
        return new ResponseEntity<>(GroupBuyingResponseDto.fromContentsResponse(contentsService.findById(postId)), HttpStatus.OK);
    }

    @Operation(summary = "공동구매 글 수정 API 입니다.",
            description = "글의 고유 id를 Request Parameter 형식으로 URL에 보내주시면 됩니다.")
    @PutMapping("/{postId}")
    public ResponseEntity<Long> updateGroupBuying(@RequestPart ContentsRequestDto contentsRequestDto,
                                                  @PathVariable Long postId) throws IOException {
        return new ResponseEntity<>(contentsService.updateContents(contentsRequestDto, postId), HttpStatus.OK);
    }

    @Operation(summary = "공동구매 신청 api",
            description = "글의 고유 id를 Request Parameter 형식으로 URL에 보내주시면 됩니다.")
    @PostMapping("/{postId}")
    public ResponseEntity<Long> participantGroupBuying(@PathVariable Long postId) {
        return new ResponseEntity<>(contentsService.participantContents(postId), HttpStatus.OK);
    }

    @Operation(summary = "거래 완료(조기 마감) API",
            description = "글 작성자가 버튼을 눌러 거래를 조기 마감시키는 API입니다.")
    @PostMapping("/{postId}/finish")
    public ResponseEntity<String> closeGroupBuying(@PathVariable Long postId) {
        return new ResponseEntity<>(contentsService.closeContent(postId), HttpStatus.OK);
    }

    @Operation(summary = "공동구매 찜 api",
            description = "글의 고유 id를 Request Parameter 형식으로 URL에 보내주시면 됩니다.")
    @PostMapping("/{postId}/like")
    public ResponseEntity<String> pushLikeGroupBuying(@PathVariable Long postId) {
        return new ResponseEntity<>(contentsService.pushLikeContents(postId), HttpStatus.OK);
    }

/*    @Operation(summary = "공동구매 글 찾기", description = "공동구매 글 검색 시 요청 경로입니다")
    @GetMapping("/search")
    public ResponseEntity<List<GroupBuyingListResponseDto>> searchGroupBuying(@RequestParam String keyword) {
        return new ResponseEntity<>(groupBuyingService.searchGroupBuying(keyword), HttpStatus.OK);
    }*/

    @Operation(summary = "공동구매 글 삭제",
            description = "글의 고유 id를 Request Parameter 형식으로 URL에 보내주시면 됩니다.")
    @DeleteMapping("/{postId}") // 단순 글 삭제
    public ResponseEntity<Long> deleteGroupBuying(@PathVariable Long postId) {
        return new ResponseEntity<>(contentsService.deleteContents(postId), HttpStatus.OK);
    }

    @Operation(summary = "공동 구매 댓글 작성 API",
            description = "글의 고유 id를 Request Parameter 형식으로 URL에 보내주시고,\n\n" +
                    " 댓글 내용은 Dto 형식으로 보내주시면 됩니다.")
    @PostMapping("/{postId}/comment")
    public ResponseEntity<Long> postComment(@RequestBody CommentRequestDto commentRequestDto, @PathVariable Long postId) {
        return new ResponseEntity<>(commentService.saveComment(commentRequestDto, postId), HttpStatus.OK);
    }

    @Operation(summary = "공동 구매 답글 작성 API",
            description = "글의 고유 id 뒤에 댓글 id를 붙여서 Request Parameter 형식으로 URL에 보내주시고,\n\n" +
                    " 댓글 내용은 Dto 형식으로 보내주시면 됩니다.")
    @PostMapping("/{postId}/{commentId}/childComment")
    public ResponseEntity<Long> postChildComment(@PathVariable Long commentId, @RequestBody CommentRequestDto commentRequestDto) {
        return new ResponseEntity<>(commentService.saveChildComment(commentRequestDto, commentId), HttpStatus.OK);
    }

    @Operation(summary = "재료 나눔 답글 작성 API",
            description = "글의 고유 id 뒤에 댓글 id를 붙여서 Request Parameter 형식으로 URL에 보내주시고,\n\n" +
                    " 댓글 내용은 Dto 형식으로 보내주시면 됩니다.")
    @DeleteMapping("/{postId}/{commentId}")
    public ResponseEntity<Long> deleteComment(@PathVariable Long commentId) {
        return new ResponseEntity<>(commentService.deleteComment(commentId), HttpStatus.OK);
    }

}
