package com.ezen.springplanetrip.vo;

import java.sql.Date;

public class BoardVO {
	private int boardId; //boardNumber
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private int boardCount;	
	private Date regdate;
	private boolean secret;
	private int userId;
	private String fullName;
	private String userRole;	
	private String boardReply;
//	private boolean secret;
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public int getBoardCount() {
		return boardCount;
	}
	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public boolean isSecret() {
		return secret;
	}
	public void setSecret(boolean secret) {
		this.secret = secret;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getBoardReply() {
		return boardReply;
	}
	public void setBoardReply(String boardReply) {
		this.boardReply = boardReply;
	}
	
	@Override
	public String toString() {
		return "BoardVO [boardId=" + boardId + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardWriter=" + boardWriter + ", boardCount=" + boardCount + ", regdate=" + regdate + ", secret="
				+ secret + ", userId=" + userId + ", fullName=" + fullName + ", userRole=" + userRole + ", boardReply="
				+ boardReply + "]";
	}
	


}
