package com.kh.miniproject.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.kh.miniproject.model.dao.ReviewDao;
import com.kh.miniproject.model.vo.Review;

public class ReviewController {
	
	ReviewDao rd = new ReviewDao();
	Scanner sc = new Scanner(System.in);
	
	ArrayList<Review> rList = new ArrayList<Review>();
	
	public ReviewController() {
		//기본 생성자
	}
	
	//리뷰 전체 조회
	public void selectAll() {
		System.out.println("< 리뷰 게시판 조회 >");
		Iterator it = rd.selectAll().iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	
		//ReviewController의 slectAll() 메소드 호출하여 결과 값을 Review에 담기
		/*ArrayList<Review> rList = rd.selectAll();
		
		for(Review r : rList) {
			System.out.println(r);
		}*/
	}
	
	//나의 리뷰내역 조회
	public void myReview() {
	
		System.out.println("< 나의 리뷰내역 조회 >");
		
		System.out.println("회원 아이디를 입력하세요 : ");
		String userId = sc.nextLine();
		
		ArrayList<Review> checkList = rd.checkId(userId);
		
			for(Review r : checkList) {
				System.out.println(r);
			}

		if(checkList.isEmpty() == true) {
			System.out.println("작성한 리뷰가 존재 하지 않습니다.");
			return;
			
		}else {
			System.out.println("조회할 글 번호 : ");
			int no = sc.nextInt();
			
			Review review = rd.myReview(no);
			if(review == null) { // myReview() 실행 결과 일치하는 게시글이 없으면
				System.out.println("조회된 게시글이 없습니다.");
			}else {
				System.out.println(review);
			}
		}

	}
	
	public void searchReview() {
		//검색 -> 키워드로
		
		selectAll();
		
		while(true) {
			System.out.println(); //한줄 띄기
			System.out.println("1. 검색하기");
			System.out.println("0. 이전 메뉴로 돌아가기");
			System.out.println("번호를 입력하세요 : ");
			int num = sc.nextInt();
			sc.nextLine();
			
			if(num == 1) {
				System.out.println("검색할 제목을 입력하세요 : ");
				String title = sc.nextLine();
				ArrayList<Review> searchList = rd.searchReview(title);
				
				// searchList가 비어 있을 경우 >> “검색 결과가 존재하지 않습니다.”출력
				// searchList가 비어있지 않을 경우 >> for문을 이용하여 searchList 출력
				if(searchList.isEmpty() == true) { //isEmpty()가 true면 비어있다는 것 = 검색결과 없음
					System.out.println("검색 결과가 존재하지 않습니다.");
				} else {
					for(Review review : searchList) {
						System.out.println(review);
					}
				}
				
			}else if(num == 0) {
				System.out.println("이전 메뉴로 돌아갑니다.");
				break;
			}else {
				System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}			
		}	
	}
	
	//리뷰 적기
	public void writeReview() { //리뷰에 추가
		
		System.out.println("< 리뷰 작성 >");
		
		System.out.println("회원 아이디를 입력하세요 : ");
		String userId = sc.nextLine();
		
		System.out.println("책 제목 : ");
		String title = sc.nextLine();
		
		System.out.println("리뷰 내용(exit 입력 시 종료) : ");
		String content = sc.nextLine();
		String str = "";
		
		while(true) {
			str = sc.nextLine();
			
			if(str.equals("exit")) {
				break;
			}
			
			content += str + "\n";
		}
		
		Review review = new Review(userId, title, content);
		rd.writeReview(review);

	}
	
	public void updateTitle() { 
		
		System.out.println("회원 아이디를 입력하세요 : ");
		String userId = sc.nextLine();
		
		ArrayList<Review> checkList = rd.checkId(userId);
		
		
		for(int i = 0; i < checkList.size(); i++) {
			
			System.out.println(checkList.get(i));
		}
		
			System.out.println("수정할 글 번호 : ");
			int no = sc.nextInt();
			sc.nextLine();
			
			Review review = rd.myReview(no);
			
			if(review == null) {
				System.out.println("조회된 글이 없습니다.");
			}else {
				
			for(int i = 0; i < checkList.size(); i++) {
				
				if(checkList.get(i).getRNo() == no) {
					
					System.out.println(checkList.get(i)); 
				}
			}	
				System.out.println("변경할 제목 : ");
				String title = sc.nextLine();
				rd.updateTitle(no, title);
			}
		}

	public void updateContent() {
		
		System.out.println("회원 아이디를 입력하세요 : ");
		String userId = sc.nextLine();
		
		ArrayList<Review> checkList = rd.checkId(userId);
		
		for(int i = 0; i < checkList.size(); i++) {
			System.out.println(checkList.get(i));
		}
		
		System.out.println("수정할 글 번호 : ");
		int no = sc.nextInt();
		sc.nextLine();
		
		Review review = rd.myReview(no);
		
		if(review == null) {
			System.out.println("조회된 글이 없습니다.");
		}else {	
			
		for(int i = 0; i < checkList.size(); i++) {
				
			if(checkList.get(i).getRNo() == no) {
			
				System.out.println(checkList.get(i)); 
			}
		}
			System.out.println("변경할 내용 : ");
			String content = sc.nextLine();
			rd.updateContent(no, content);
		}
		
	}
	
	public void deleteReview() {
		
		System.out.println("회원 아이디를 입력하세요 : ");
		String userId = sc.nextLine();
		
		ArrayList<Review> checkList = rd.checkId(userId);
		
		for(int i = 0; i < checkList.size(); i++) {
			System.out.println(checkList.get(i));
		}
		
		System.out.println("삭제할 리뷰 번호를 입력해주세요 : ");
		int no = sc.nextInt();
		sc.nextLine();
		
		Review review = rd.myReview(no);

		if(review == null) {
			System.out.println("조회된 글이 없습니다.");
			
		}else {
			System.out.println("정말 삭제하시겠습니까?(y/n) : ");
			char ch = sc.nextLine().toUpperCase().charAt(0);		
			if(ch == 'Y') {
				rd.deleteReview(no);
				System.out.println("리뷰가 삭제 되었습니다.");
			}	
		}

	}

}	

	
