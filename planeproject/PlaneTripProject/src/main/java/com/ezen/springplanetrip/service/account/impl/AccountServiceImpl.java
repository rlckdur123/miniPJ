package com.ezen.springplanetrip.service.account.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.springplanetrip.service.account.AccountService;
import com.ezen.springplanetrip.vo.PassengerVO;
import com.ezen.springplanetrip.vo.UserVO;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountDAO accountDAO;
	
	@Override
	public int join(UserVO userVO) {
		return accountDAO.join(userVO);
	}
	@Override
	public UserVO login(UserVO userVO) {
		return accountDAO.login(userVO); 
	}
	
	@Override
	public List<UserVO> viewMypage(){
		return accountDAO.viewMypage(); 
	}
	
	@Override
	public void quit(int userId){
		accountDAO.quit(userId);
	}
	
	@Override
	public int updateInfo(UserVO userVO){
		 return accountDAO.updateInfo(userVO);
	}
	
	@Override
	public int idCheck(String email) {
		return accountDAO.idCheck(email);
	}
	
	@Override
	public UserVO findId(UserVO userVO) {
		return accountDAO.findId(userVO);
	}

	@Override
	public UserVO findPassword(UserVO userVO) {
		return accountDAO.findPassword(userVO);
	}
	
	@Override
	public UserVO getUserInfo(int userId) {
		return accountDAO.getUserInfo(userId);
	}
	
	@Override
	public int currentPwdCheck(UserVO userVO) {
		return accountDAO.currentPwdCheck(userVO);
	}
	
	@Override
	public Map<String, Object> getMyReservation(int loginUser) {
		return accountDAO.getMyReservation(loginUser);
	}
}
