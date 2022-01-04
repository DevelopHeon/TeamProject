package com.kh.miniproject.model.noticeComparator;

import java.util.Comparator;

import com.kh.miniproject.model.vo.Notice;

// 제목 오름차순 정렬
public class AscNoticeTitle implements Comparator<Notice> {

	public AscNoticeTitle() {}

	@Override
	public int compare(Notice n1, Notice n2) {
	
		return n1.getNoticeTitle().compareTo(n2.getNoticeTitle());
	}

	
	
}
