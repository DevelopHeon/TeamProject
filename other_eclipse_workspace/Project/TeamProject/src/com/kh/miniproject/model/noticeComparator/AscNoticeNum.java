package com.kh.miniproject.model.noticeComparator;

import java.util.Comparator;

import com.kh.miniproject.model.vo.Notice;

public class AscNoticeNum implements Comparator<Notice>{

	@Override
	public int compare(Notice o1, Notice o2) {
		
		return o1.getNoticeNum() - o2.getNoticeNum();
	}

}
