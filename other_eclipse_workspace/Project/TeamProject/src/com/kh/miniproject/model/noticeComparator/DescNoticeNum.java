package com.kh.miniproject.model.noticeComparator;

import java.util.Comparator;

import com.kh.miniproject.model.vo.Notice;

public class DescNoticeNum implements Comparator<Notice>{

	@Override
	public int compare(Notice o1, Notice o2) {
		
		return o2.getNoticeNum() - o1.getNoticeNum();
	}
	
	

}
