package com.kh.miniproject.model.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;


import com.kh.miniproject.model.vo.Review;

public class ReviewDao {
	
	ArrayList<Review> rList = new ArrayList<Review>();
	
	//vo클래스 자료형을 임시로 저장할 컬렉션(ArrayList)
	{ //초기화블록
		//임시로 리뷰 데이터 넣어보기 (제목, 리뷰)
		rList.add(new Review("abc", "개미", "정말 재미있어요! 추천합니다."));
		rList.add(new Review("def","불편한 편의점", "감동적이에요."));
		rList.add(new Review("ghi", "과학 이야기", "내용이 어려워요."));
		rList.add(new Review("jkl", "옷소매 붉은 끝동", "엄청 몰입해서 읽었어요."));
		
		//for문 돌려서 배열의 리뷰 번호 1증가 시킴
		int i = 0;
		for(Review r : rList) {
			r.setRNo(++i); 
		}
	}
	
	public ReviewDao() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("review_list.dat"))){
			
		for(int i = 0; i < rList.size(); i++) {
			oos.writeObject(rList.get(i));
		}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//리뷰 전체 조회
	public ArrayList<Review> selectAll() {
		
		return rList;
	}
	
	public Review myReview(int no) {
		
		Review review = null;
		for(int i = 0; i < rList.size(); i++) {
			if(rList.get(i).getRNo() == no) {
				// 반복문을 돌리면서 list에 있는 Board객체들의 게시글 번호를 확인하고
				// 사용자가 입력했던 번호랑 일치하는게 있다면
				review = rList.get(i);
				// 그 Board객체를 저장
				break;
			}
		}		
		return review;
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
	
	//도서 제목 검색 -> 맞는 리뷰 출력
	public ArrayList<Review> searchReview(String title) {
		
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
	
	
	
	public void updateTitle(int no, String title) {
		
		for(int i = 0; i < rList.size(); i++) {
			if(rList.get(i).getRNo() == no) {
				rList.get(i).setTitle(title);
				break;
			}
		}			
	}

	public void updateContent(int no, String content) {
		
		for(int i = 0; i < rList.size(); i++) {
			if(rList.get(i).getRNo() == no) {
				rList.get(i).setReview(content);
				break;
			}
		}	
	}
	
	//리뷰 삭제
	public void deleteReview(int no) {
		
		for(int i = 0; i < rList.size(); i++) {
			if(rList.get(i).getRNo() == no) {
				rList.remove(i);
			}
		}
		int index = 1; //1부터 시작하는 인덱스 -> 리뷰 번호가 1부터 시작
		for(Review re : rList) { //for문으로 rList를 다시 돌려서 리뷰 번호를 다시 넣어줌
			re.setRNo(index++); //넣어주고 후증가
		}
		Collections.sort(rList);//오름차순 정렬
	} 
}
