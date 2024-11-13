package com.web.cafe.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor //기본생성자 자동으로 만들어줌
@AllArgsConstructor// 모든 필드를 매개변수로 받는 생성자를 만들어줌(필드를 초기화, 객체 생성에 유용)
public class Board {
	private int no;
	private String title;	
	private String writer;
	private String content;
	private Timestamp regDate;
	private int readCount;
	private String pass;
	private String file1;
	private int recommend;
	private int thank;
}
