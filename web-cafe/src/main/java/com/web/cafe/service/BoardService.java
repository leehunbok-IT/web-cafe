package com.web.cafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.cafe.domain.Board;
import com.web.cafe.mapper.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	public List<Board> boardList(){
		log.info("BoardService:boardList()");
		return boardMapper.boardList();
	}
	
	public Board getBoard(int no) {
		log.info("BoardService: getBoard(int no)");
		return boardMapper.getBoard(no);
	}
	
	public void addBoard(Board board) {
		log.info("boardServie: addBoard(Board board)");
		boardMapper.insertBoard(board);
	}
}