package com.web.cafe.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	private static final int PAGE_SIZE = 10;
	private static final int PAGE_GROUP = 10;
	
	public Map<String, Object> boardList(int pageNum){
		log.info("BoardService:boardList(int pageNum)");
		

		int currentPage = pageNum;
		//1페이지는 (1 - 1) * 10 = 0 → 0번째부터 데이터 가져옴.
		//2페이지는 (2 - 1) * 10 = 10 → 10번째부터 가져옴.
		//3페이지는 (3 - 1) * 10 = 20 → 20번째부터 가져옴.
		int startRow = (currentPage - 1) * PAGE_SIZE;
		int listCount = boardMapper.getBoardCount();
		
		List<Board> boardList = boardMapper.boardList(startRow, PAGE_SIZE);
		
		// 45 / 10 = 4 → 나머지가 5이므로 1을 더해 총 5페이지
		int pageCount = 
				listCount / PAGE_SIZE + (listCount % PAGE_SIZE == 0 ? 0 : 1);
		
		// 만약 currentPage % PAGE_GROUP == 0이라면 - PAGE_GROUP 처리.
		// 현재 페이지가 13, 그룹 크기가 10일 때: (13 / 10) * 10 + 1 = 11 → 시작 페이지는 11
		int startPage = (currentPage / PAGE_GROUP) * PAGE_GROUP + 1
				-(currentPage % PAGE_GROUP == 0 ? PAGE_GROUP : 0);
		
		// endPage가 총 페이지 수(pageCount)보다 크면 pageCount로 조정.
		// 시작 페이지가 11이고 그룹 크기가 10일 때: 11 + 10 - 1 = 20 → 마지막 페이지는 20.
		// 만약 총 페이지 수가 18이면 endPage = 18
		int endPage = startPage + PAGE_GROUP - 1;
		
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		modelMap.put("bList", boardList);
		modelMap.put("pageCount", pageCount);
		modelMap.put("startPage", startPage);
		modelMap.put("endPage", endPage);
		modelMap.put("listCount", listCount);
		modelMap.put("pageGroup", PAGE_GROUP);
		
		return modelMap;
	}
	
	public Board getBoard(int no) {
		log.info("BoardService: getBoard(int no)");
		return boardMapper.getBoard(no);
	}
	
	public void addBoard(Board board) {
		log.info("boardServie: addBoard(Board board)");
		boardMapper.insertBoard(board);
	}
	
	public boolean isPassCheck(int no, String pass) {
		log.info("BoardService: isPassCheck(int no, String pass)");
		boolean result = false;
		
		String dbPass = boardMapper.isPassCheck(no);
		
		if(dbPass.equals(pass)) {
			result = true;
		}
		return result;
	}
	
	public void updateBoard(Board board) {
		log.info("BoardService: updateBoard(Board board)");
		boardMapper.updateBoard(board);
	}
	
	public void deleteBoard(int no) {
		log.info("BoardService: deleteBoard(int no)");
		boardMapper.deleteBoard(no);
	}
	
	public Board getBoard(int no, boolean isCount) {
		log.info("BoardService: getBoard(int no, boolean isCount)");
		
		if(isCount) {
			boardMapper.incrementReadCount(no);
		}
		return boardMapper.getBoard(no);
	}
}








