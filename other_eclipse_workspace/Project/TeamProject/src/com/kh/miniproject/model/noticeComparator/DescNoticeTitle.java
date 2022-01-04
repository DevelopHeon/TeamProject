package com.kh.miniproject.model.noticeComparator;

import java.util.Comparator;

import com.kh.miniproject.model.vo.Notice;

public class DescNoticeTitle implements Comparator<Notice> { // 제네릭스로 <Notice>만 받도록 선언

	public DescNoticeTitle() {
	}

	@Override
	public int compare(Notice n1, Notice n2) { // compareTo 이용 숫자로 반환해준다.

		return n2.getNoticeTitle().compareTo(n1.getNoticeTitle());
	}

}
