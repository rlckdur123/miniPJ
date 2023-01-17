package com.ezen.springplanetrip.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.springplanetrip.service.board.BoardService;
import com.ezen.springplanetrip.vo.BoardVO;
import com.ezen.springplanetrip.vo.Criteria;
import com.ezen.springplanetrip.vo.PageVO;
import com.ezen.springplanetrip.vo.UserVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;

	//게시글 목록 화면
	@RequestMapping("/getBoardList.do")
	public String viewList(Model model, @RequestParam Map<String, String> paramMap, Criteria cri) {
		List<BoardVO> boardList = boardService.viewList(paramMap, cri);
		model.addAttribute("boardList", boardList);

		//검색기능 추가
		if(paramMap.get("searchKeyword") != null && !paramMap.get("searchKeyword").equals(""))
		model.addAttribute("searchKeyword", paramMap.get("searchKeyword"));
			
		//페이징 
		int total = boardService.getBoardTotalCnt(paramMap);
		System.out.println(total);
		
		model.addAttribute("pageVO", new PageVO(cri, total));
		
		return "board/getBoardList";
	}

	//게시글 등록화면으로 이동 
	@GetMapping("/insertBoard.do")
	public String addBoardView(HttpSession session) {
		// 로그인한 유저의 정보가 세션에 없을 때 로그인 화면으로 이동
		UserVO loginUser = (UserVO)session.getAttribute("loginUser");

		if(loginUser==null) {
			return "redirect:/Account/login.do";
		}

		return "board/insertBoard";
	}
	
	// 게시글 등록을 가져오는 포스트매핑
	@PostMapping("/insertBoard.do")
	public String addBoard(BoardVO boardVO) {
		//int boardId = 
		boardService.addBoard(boardVO);
		
		return "redirect:/board/getBoardList.do";
	}
	
	// 게시글 상세보기
	@RequestMapping("/getBoard.do")
	public String getBoard(@RequestParam("boardId") int boardId, Model model) {
		BoardVO board = boardService.getBoard(boardId);
		model.addAttribute("board",board);
		
		return "board/getBoard";
	}
	
	// 조회수 증가 // getBoard 상세보기 창 
	@RequestMapping("updateBoardCnt.do")
	public String udpateBoardCnt(@RequestParam("boardId") int boardId) {
		boardService.updateBoardCnt(boardId);
		
		return "redirect:/board/getBoard.do?boardId="+ boardId;
	}
	
	// 게시글 수정 
	@PostMapping("/updateBoard.do")
	public String updateBoard(BoardVO boardVO) {
		boardService.updateBoard(boardVO);
		System.out.println("board"+ boardVO);
		return "redirect:/board/getBoard.do?boardId="+boardVO.getBoardId();
		//return "/board/updateBoard";
		/* return "redirect:/board/updateBoard.do?boardId="+boardVO.getBoardId(); */
	}
	
	// 게시글 삭제 
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(@RequestParam("boardId") int boardId) {
		boardService.deleteBoard(boardId);
		
		return "redirect:/board/getBoardList.do";
	}
	
	@GetMapping("/updateBoard.do")
								// 리퀘스트 파람 안되는 이유는 ? PostMapping updateBoard 때문인가? 
	public String updateBoardView(BoardVO boardVO, Model model) {
		model.addAttribute("board", boardService.getBoard(boardVO.getBoardId()));
		
		return "board/updateBoard";
	}
	
	@PostMapping("/insertReply.do")
	public String insertReply(BoardVO boardVO) {
		System.out.println(boardVO.getBoardReply());
		boardService.insertReply(boardVO);
		
		return "redirect:/board/getBoard.do?boardId="+boardVO.getBoardId();
	}
}
