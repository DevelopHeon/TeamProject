package com.kh.miniproject.view;

import java.util.Scanner;

import com.kh.miniproject.controller.ReviewController;

public class ReviewBoard {
	
	private ReviewController rc = new ReviewController();
	private Scanner sc = new Scanner(System.in);
	
	public ReviewBoard() { //기본생성자
	}

	public void ReviewMenu() {
		
		//==== 리뷰 메뉴 ==== //무한 반복 실행
		//1. 리뷰 게시판 조회
		//2. 리뷰 작성
		//3. 리뷰 내역 조회
		//0. 이전 메뉴로 가기
		//9. 프로그램 종료
		
		while(true) {
			System.out.println("< 리뷰 메뉴 >");
			System.out.println("1. 리뷰 게시판 조회");
			System.out.println("2. 리뷰 내역 조회");
			System.out.println("3. 리뷰 검색");
			System.out.println("4. 리뷰 작성");	
			System.out.println("5. 리뷰 제목 수정");
			System.out.println("6. 리뷰 내용 수정");
			System.out.println("7. 리뷰 삭제");
			System.out.println("0. 이전 메뉴로 가기");
			System.out.println("9. 프로그램 종료");
			System.out.println("번호를 입력하세요 : ");
			int num = sc.nextInt();
			sc.nextLine(); //엔터 빼주기
			
			switch(num) {
			case 1 :
				rc.selectAll(); //전체 조회
				break;
			case 2 :
				rc.myReview(); //나의 리뷰 조회
				break;
			case 3 :
				rc.searchReview(); //리뷰 검색
				break;
			case 4 :
				rc.writeReview(); //리뷰 작성
				break;
			case 5 :
				rc.updateTitle(); //리뷰 제목 수정
				break;
			case 6 :
				rc.updateContent(); //리뷰 내용 수정
				break;
			case 7 :
				rc.deleteReview(); //리뷰 내용 삭제
				break;
			case 0 :
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			case 9 :
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default :
				System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
		}	
	}
}
