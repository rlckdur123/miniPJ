package com.ezen.springplanetrip.service.board.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.springplanetrip.service.board.BoardService;
import com.ezen.springplanetrip.vo.BoardVO;
import com.ezen.springplanetrip.vo.Criteria;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<BoardVO> viewList(Map<String, String> paramMap, Criteria cri) {

		return boardDAO.viewList(paramMap, cri);
	}
	
	@Override
	public int getBoardTotalCnt(Map<String, String> paramMap) {

		return boardDAO.getBoardTotalCnt(paramMap);
	}
	
	@Override
	public BoardVO getBoard(int boardId) {
		
		return boardDAO.getBoard(boardId);
	}

	@Override
	public void addBoard(BoardVO boardVO) {
		
		boardDAO.addBoard(boardVO);
	}

	@Override
	public void updateBoardCnt(int boardId) {
		
		boardDAO.updateBoardCnt(boardId);
	}

	@Override
	public void updateBoard(BoardVO boardVO) {
		
		boardDAO.updateBoard(boardVO);		
	}

	@Override
	public void deleteBoard(int boardId) {
		
		boardDAO.deleteBoard(boardId);
	}
	
	@Override
	public void insertReply(BoardVO boardVO) {
		boardDAO.insertReply(boardVO);
	}


}