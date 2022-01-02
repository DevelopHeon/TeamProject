package com.kh.miniproject.model.vo;

public class Notice implements Comparable<Notice>{
	// 공지사항 게시물 번호
	private int noticeNum;
	// 공지사항 제목
	private String noticeTitle;
	// 공지사항 내용
	private String noticeContent;
	

	public Notice() {	}
	
	public Notice(int noticeNum, String noticeTitle, String noticeContent) {
		this.noticeNum = noticeNum;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
	}
	
	// 공지사항 추가시 사용할 생성자, 번호는 매개변수로 받지 않는다.
	public Notice(String noticeTitle, String noticeContent) {
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
	}

	public int getNoticeNum() {
		return noticeNum;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	
	@Override
	public String toString() {
		return noticeNum + ". " + noticeTitle + ": " + noticeContent;
	}
	
	public int compareTo(Notice n) {
		
		return this.noticeNum - n.noticeNum;
	}
	
}
