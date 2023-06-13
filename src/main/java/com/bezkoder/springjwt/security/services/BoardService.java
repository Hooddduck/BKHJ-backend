package com.bezkoder.springjwt.security.services;

import com.bezkoder.springjwt.models.Board;

import java.util.List;

public interface BoardService {
	
		public Board saveBoard(Board board);

		public List<Board> getAllBoard();
		
		public Board getBoardById(Long id);
		
		public String deleteBoard(Long id);
		
		public Board editBoard(Board board,Long id);
	
}
