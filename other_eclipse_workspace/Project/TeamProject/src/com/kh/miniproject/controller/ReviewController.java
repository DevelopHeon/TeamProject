package com.kh.miniproject.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.kh.miniproject.model.vo.Review;

public class ReviewController {
	
	Scanner sc = new Scanner(System.in);
	
	public ReviewController() {
		// TODO Auto-generated constructor stub
	}
	
	//ArrayList 객체를 생성함 -> Review자료형만 들어올 수 있음
	ArrayList<Review> rList = new ArrayList<Review>();
	
	{ //초기화블록
	//임시로 리뷰 데이터 넣어보기 (제목, 리뷰)
	rList.add(new Review("abc***", "개미", "정말 재미있어요! 추천합니다."));
	rList.add(new Review("def***","불편한 편의점", "감동적이에요."));
	rList.add(new Review("ghi***", "과학 이야기", "내용이 어려워요."));
	rList.add(new Review("jkl***", "옷소매 붉은 끝동", "엄청 몰입해서 읽었어요."));
		//for문 돌려서 배열의 리뷰 번호 1증가 시킴
		int i = 0;
		for(Review r : rList) {
			r.setRNo(++i); 
		}
	}
	//리뷰 전체 조회
	public ArrayList<Review> selectAll() {
		
		return rList;
	}
	
	//도서 제목 검색 -> 맞는 리뷰 출력
	public ArrayList<Review> searchBook(String title) {
		ArrayList<Review> searchList = new ArrayList<Review>(); //검색 결과를 넣을 리스트 객체 생성
		
		for(Review r : rList) {
			if(r.getTitle().contains(title)) {
				searchList.add(r); //리스트에 title을 포함하고 있는 배열 객체 추가
			}
		}
		
		return searchList;
	}
	//리뷰 작성
	public void writeReview(Review review) {
		// 전달 받은 review는 현재 리뷰 번호가 0인 채로 들어오는데
		// 새로운 리뷰가 추가될 때마다 추가되는 리뷰의 리뷰번호는
		// 리스트 마지막 리뷰 번호의 다음 번호로 부여해야 됨
		int lastNo = 0; // 우선 변수 생성 및 초기화
		
		try {
			lastNo = rList.get(rList.size() - 1).getRNo() + 1; //rList 크기의 -1 -> 마지막 리뷰 번호 +1부터 리뷰가 등록되어야한다.
			//리스트에 리뷰가 없는 경우
		} catch(IndexOutOfBoundsException e) {
			lastNo = 1;
		}
		review.setRNo(lastNo); //lastNo를 review의 리뷰 번호에 집어넣음
		rList.add(review); //rList의 마지막 번호에 리뷰를 집어넣음
	}

	public ArrayList<Review> checkId(String userId) {
		ArrayList<Review> checkList = new ArrayList<Review>(); //결과값을 보관
		
		for(Review review : rList) {
			if(review.getUserId().equals(userId)) {
				checkList.add(review);
			}
		}
		return checkList;
	}

	public void updateTitle(ArrayList<Review> checkList, String title) {
		
		for(Review titleList : checkList) {
			titleList.setTitle(title);
		}
		
	}

	public void updateReview(ArrayList<Review> checkList, String review) {
		
		for(Review reviewList : checkList) {
			reviewList.setReview(review);
		}
		
	}
	//리뷰 삭제
	public int deleteReview(int rNo) {
		
		int index = 0; //삭제하고 index 끌어올 변수
		
		for(Review delete : rList) {
			if(delete.getRNo() == rNo) {
				rList.remove(delete);
			}
			//remove한 객체부터 땡겨서 정렬하기 위해 index 후증가
			for(Review r : rList) {
				r.setRNo(index++);
			}
			
			rList.sort((Comparator<? super Review>) rList);
			return 1;
		}
		
		return 0;
	}



	
}