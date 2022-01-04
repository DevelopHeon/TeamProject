package com.kh.miniproject.view;

import java.util.Scanner;

import com.kh.miniproject.controller.BookManagement;

public class BookMenu {
	//도서 관리 창
	
	private Scanner sc = new Scanner(System.in);
	private BookManagement bm = new BookManagement(); //BookManagent 클래스에 접근하기 위한 변수 bm
	
	public BookMenu() {}
	
	
	
	public void bookManagement() {//도서관리
		
		while(true) {
			System.out.println(" <도서 관리> ");
			System.out.println("1.도서 전체 조회");
			System.out.println("2.신규 도서 등록");
			System.out.println("3.도서 제목 수정");
			System.out.println("4.도서 작가 수정");
			System.out.println("5.도서 출판사 수정");
			System.out.println("6.도서 삭제");
			System.out.println("0. 이전 메뉴로 가기");
			System.out.println("메뉴 선택 : ");
			
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1 :
				bm.selectAll(); // 도서 전체 조회
				break;
			case 2 :
				bm.insertBook(); // 신규 도서 등록
				break;
			case 3 :
				bm.updateTitle(); // 도서 제목 수정
				break;
			case 4 :
				bm.updateAuthor(); // 도서 작가 수정
				break;
			case 5 :
				bm.updatePublisher(); // 도서 출판사 수정
				break;
			case 6 :
				bm.deleteBook(); // 도서 삭제
				break;
			case 0 :
				return;
			default :
				System.out.println("잘못 입력하셨습니다. 메뉴를 다시 선택해주세요.");
				break;
			}
			
		}
	}
}

	
	

