package com.ezen.springplanetrip.service.board;

import java.util.List;
import java.util.Map;

import com.ezen.springplanetrip.vo.BoardVO;
import com.ezen.springplanetrip.vo.Criteria;

public interface BoardService {

	List<BoardVO> viewList(Map<String, String> paramMap, Criteria cri);

	int getBoardTotalCnt(Map<String, String> paramMap);

	void addBoard(BoardVO boardVO);

	BoardVO getBoard(int boardId);

	void updateBoardCnt(int boardId);

	void updateBoard(BoardVO boardVO);

	void deleteBoard(int boardId);
	
	void insertReply(BoardVO boardVO);

}
