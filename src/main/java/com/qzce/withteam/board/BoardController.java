package com.qzce.withteam.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("")
    public String board(Model model,
                        @PageableDefault(page = 0, size = 10, sort = "bid", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<Board> list = boardService.boardList(pageable);

        final int pageRange = 10;

        int nowPage = list.getPageable().getPageNumber()+1; // 현재 페이지
        int fitPage = (nowPage-1)/pageRange;                // 페이지 맞춤

        int startPage = fitPage * pageRange + 1;            // 시작 페이지
        int endPage = fitPage * pageRange + pageRange;      // 끝 페이지

        int totalPage = list.getTotalPages();               // 총 페이지

        int lastStartPage = totalPage / pageRange * pageRange + 1;

        if(endPage > totalPage) {
            endPage = totalPage;
        }

        model.addAttribute("boardList", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("lastStartPage", lastStartPage);
        model.addAttribute("pageRange", pageRange);

        return "board/board";
    }

    @GetMapping("/{bid}")
    public String boardRead(Model model,
                            @PathVariable("bid") Long bid) {

        model.addAttribute("board", boardService.boardView(bid));

        return "board/boardRead";

    }

    @GetMapping("/write")
    public String boardWrite() {
        return "board/boardWrite";
    }
}