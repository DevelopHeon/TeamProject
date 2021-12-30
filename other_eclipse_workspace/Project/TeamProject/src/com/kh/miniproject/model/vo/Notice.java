package com.kh.miniproject.model.vo;

public class Notice {
	
	private int noticeNum;
	
	private String noticeTitle;
	
	private String noticeContent;
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public Notice(int noticeNum, String noticeTitle, String noticeContent) {
		super();
		this.noticeNum = noticeNum;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
	}

	public int getNoticeNum() {
		return noticeNum;
	}

	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	
	@Override
	public String toString() {
		return "Notice [noticeNum=" + noticeNum + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ "]";
	}
	
}
