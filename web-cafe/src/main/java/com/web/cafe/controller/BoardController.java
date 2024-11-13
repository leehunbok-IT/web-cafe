package com.web.cafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.cafe.domain.Board;
import com.web.cafe.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping({"/","/boardList"})
	public String boardList(Model model) {
		model.addAttribute("bList", boardService.boardList());
		return "views/boardList";
	}
	
	@GetMapping({"/boardDetail"})
	public String getBoard(Model model, @RequestParam("no") int no) {
		model.addAttribute("board", boardService.getBoard(no));
		return "views/boardDetail";
	}
	
	@GetMapping("/addBoard")
	public String addBoard() {
		return "views/writeform";
	}
	
	@PostMapping("/addBoard")
	public String addBoard(Board board) {
		log.info("title : ", board.getTitle());
		boardService.addBoard(board);
	}
	
}
