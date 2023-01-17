package com.ezen.springplanetrip.service.board.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.springplanetrip.vo.BoardVO;
import com.ezen.springplanetrip.vo.Criteria;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public List<BoardVO> viewList(Map<String, String> paramMap, Criteria cri) {
		// paramMap에서 value값 2개 못꺼냄
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("boardSearch", paramMap);
		//페이징
		cri.setStartNum((cri.getPageNum()-1)*cri.getAmount());
		pMap.put("cri", cri);
									// 파라미터 없어 스테이트먼트만 작성
		
		return mybatis.selectList("BoardDAO.viewList", pMap);
	}

	public int getBoardTotalCnt(Map<String, String> paramMap) {
		return mybatis.selectOne("BoardDAO.getBoardTotalCnt", paramMap);
	}

	public BoardVO getBoard(int boardId) {
		
		return mybatis.selectOne("BoardDAO.getBoard", boardId);
	}

	public void addBoard(BoardVO boardVO) {
		mybatis.insert("BoardDAO.addBoard", boardVO);
		
	}

	public void updateBoardCnt(int boardId) {
		mybatis.update("BoardDAO.updateBoardCnt", boardId);
	}

	public void updateBoard(BoardVO boardVO) {
		mybatis.update("BoardDAO.updateBoard", boardVO);
	}

	public void deleteBoard(int boardId) {
		mybatis.delete("BoardDAO.deleteBoard", boardId);
	}
	
	public void insertReply(BoardVO boardVO) {
		mybatis.update("BoardDAO.insertReply", boardVO);
	}
}
