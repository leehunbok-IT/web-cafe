package com.web.cafe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.cafe.domain.Board;

@Mapper
public interface BoardMapper {
	
	public List<Board> boardList();
	
	//Board 객체로 받아서 DB에 추가하는 메서드
	public void insertBoard(Board board);
	
	public Board getBoard(int no);
	
	public String isPassCheck(int no);
	
	public void updateBoard(Board board);
}
