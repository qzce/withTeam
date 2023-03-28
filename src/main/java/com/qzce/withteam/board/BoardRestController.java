package com.qzce.withteam.board;

import com.qzce.withteam.board.dto.BoardWriteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api/board")
public class BoardRestController {

    private final BoardService boardService;

    @GetMapping("")
    public ResponseEntity boardAll(@PageableDefault(size=5, sort = "bid") Pageable pageable) {

        Page<Board> list = boardService.boardList(pageable);

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{bid}")
    public ResponseEntity boardDetail(@PathVariable("bid") Long bid) {

        Board board = boardService.boardView(bid);

        return ResponseEntity.ok().body(board);
    }

    @PostMapping("")
    public ResponseEntity<BoardWriteDto> boardWrite(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String content
    ) {

//        HttpHeaders headers = new HttpHeaders();
//        headers.set("test", "header");

        BoardWriteDto boardWriteDto = BoardWriteDto.builder()
                .title(title)
                .content(content)
                .build();

        boardService.boardSave(boardWriteDto);

        return ResponseEntity.ok()
//                .headers(headers)
                .body(boardWriteDto);

    }

    @PutMapping("")
    public ResponseEntity boardUpdate(@RequestBody BoardWriteDto boardWriteDto) {

        Board board = boardService.boardSave(boardWriteDto);

        return new ResponseEntity(board, HttpStatus.OK);
    }

    @DeleteMapping("/{bid}")
    public ResponseEntity boardDelete(@PathVariable("bid") Long bid) {

        boardService.boardDelete(bid);

        return new ResponseEntity("Delete post" ,HttpStatus.OK);
    }

}