package com.ezen.springplanetrip.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.springplanetrip.service.account.AccountService;
import com.ezen.springplanetrip.service.flight.FlightService;
import com.ezen.springplanetrip.service.passenger.PassengerService;
import com.ezen.springplanetrip.service.reservation.ReservationService;
import com.ezen.springplanetrip.vo.AirportVO;
import com.ezen.springplanetrip.vo.ReservationVO;
import com.ezen.springplanetrip.vo.UserVO;

@Controller
@RequestMapping("/Account")
public class AccountController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private FlightService flightService;

	
	public String reserve(UserVO userVO) {
		return null;
	}

	// -----------------------------------------------------------------------------------------------

	// 마이페이지로 이동
	@GetMapping("/userInfo.do")
	public String userInfoView(Model model,HttpSession session) {
		if(session.getAttribute("loginUser") == null) {
			return "Account/login";
		}
		UserVO user = (UserVO)session.getAttribute("loginUser");
		Map<String, Object> myReservation = accountService.getMyReservation(user.getUserId());
		
		model.addAttribute("myReservation", myReservation);
		
		
		System.out.println("예약리스트 : " + myReservation);
		return "/mypage/userInfo";
	}

	// 회원정보 수정 페이지로 이동
	@GetMapping("/updateInfo.do")
	public String userUpdateView() {
		return "/mypage/userUpdate";
	}

	// 회원정보 수정 처리
	@PostMapping(value = "/updateInfo.do", produces = "application/text; charset=UTF-8")
	public String updateInfo(UserVO userVO, Model model, HttpSession session, HttpServletRequest request) {
		int updateResult = accountService.updateInfo(userVO);

		if (updateResult == 0) {
			model.addAttribute("updateMsg", "회원정보 수정에 실패하였습니다.");
			return "/mypage/userUpdate";
		}

		session.invalidate();

		// 변경된 유저 정보 세션에 담기
		session = request.getSession();
		UserVO loginUser = accountService.getUserInfo(userVO.getUserId());
		session.setAttribute("loginUser", loginUser);

		model.addAttribute("updateMsg", "회원정보 수정에 성공하였습니다.");
		return "/mypage/userInfo";

	}

	// 현재 비밀번호 일치여부 확인
	@PostMapping("/currentPwdCheck.do")
	@ResponseBody
	public String currentPwdCheck(UserVO userVO) {

		String returnStr = "";

		int pwdCnt = accountService.currentPwdCheck(userVO);

		if (pwdCnt > 0) {
			returnStr = "pwdOk";
		} else {
			returnStr = "invalidPwd";
		}

		return returnStr;
	}

	// 회원탈퇴
	@RequestMapping(value = "/quit.do")
	public String quit(HttpSession session) {

		UserVO loginUser = (UserVO) session.getAttribute("loginUser");

		accountService.quit(loginUser.getUserId());
		session.invalidate();

		return "redirect:/mainPage.jsp";
	}

	// ------------------------------------------------------------------------------------------------

	@GetMapping("/join.do")
	public String joinView() {
		return "Account/join";
	}

	@PostMapping(value = "/join.do", produces = "application/text; charset=UTF-8")
	public String join(UserVO userVO, Model model) {
		int joinResult = accountService.join(userVO);

		if (joinResult == 0) {
			model.addAttribute("joinMsg", "회원가입에 실패하셨습니다. 관리자에게 문의해주세요.");
			return "Account/join";
		}

		model.addAttribute("joinMsg", "회원가입에 성공했습니다. 로그인해주세요.");
		return "Account/login";
	}

	@PostMapping("/idCheck.do")
	@ResponseBody
	public String idCheck(UserVO userVO) {

		String returnStr = "";

		int idCnt = accountService.idCheck(userVO.getEmail());

		if (idCnt > 0) {
			returnStr = "duplicatedId";
		} else {
			returnStr = "idOk";
		}

		return returnStr;
	}

	@GetMapping("/login.do")
	public String loginView() {
		return "Account/login";
	}

	@PostMapping("/login.do")
	@ResponseBody
	public String login(UserVO userVO, HttpSession session) {

		int idCheck = accountService.idCheck(userVO.getEmail());
		System.out.println(idCheck);
		if (idCheck < 1) {
			return "idFail";
		} else {
			UserVO loginUser = accountService.login(userVO);

			if (loginUser == null) {
				return "pwFail";
			} else {
				System.out.println("로그인 시도한 계정 : " + loginUser.getEmail());
			}

			session.setAttribute("loginUser", loginUser);
			return "loginSuccess";
		}
	}

	@GetMapping("/logout.do")
	public String logout(HttpSession session, Model model) {
		session.invalidate();

		List<AirportVO> airportList = flightService.viewAirport(null);

		model.addAttribute("airportList", airportList);

		return "../../mainPage";
	}

	// -----------------------------------------------------------------------------------
	// 아이디 찾기 페이지 이동
	@GetMapping(value = "findId.do")
	public String findIdView() {
		return "Account/findId";
	}

	// 아이디 찾기 실행
	@PostMapping(value = "findId.do")
	@ResponseBody
	public String findIdAction(UserVO userVO) {
		System.out.println(userVO.toString());
		UserVO user = accountService.findId(userVO);
		String idCheck = "";
		if (user == null) {
			idCheck = "noexist";
		} else {
			idCheck = user.getEmail();
		}

		return idCheck;
	}

	// 비밀번호 찾기 페이지로 이동
	@GetMapping(value = "findPassword.do")
	public String findPasswordView() {
		return "Account/findPassword";
	}

	// 비밀번호 찾기 실행
	@PostMapping(value = "findPassword.do")
	@ResponseBody
	public String findPasswordAction(UserVO userVO) {
		UserVO user = accountService.findPassword(userVO);

		String passwordCheck = "";
		if (user == null) {
			passwordCheck = "noexist";
		} else {
			passwordCheck = user.getPassword();
		}

		return passwordCheck;
	}
}
