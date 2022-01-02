package com.kh.miniproject.view;

import java.util.Scanner;

public class MemberPage {

	ReviewBoard rb = new ReviewBoard();
	MemberInfo mem = new MemberInfo();
	
	Scanner sc = new Scanner(System.in);

	public MemberPage() {
		
	}

	public void memberMainMenu() {

		while (true) {
			System.out.println("==== 회원 페이지 ====");
			System.out.println("1. 도서 검색");
			System.out.println("2. 대여, 반납내역 조회");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 리뷰 게시판");
			System.out.println("0. 이전 메뉴로 가기");
			System.out.println("메뉴 선택 : ");

			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				booksearch();
				break;
			case 2:
				bookRentAndReturn();
				break;
			case 3:
				mem.memberMainMenu();
				break;
			case 4:
				rb.reviewBoard();
				break;
			case 0:
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 메뉴를 다시 선택해주세요.");
				break;
			}
		}
	}

	public void booksearch() {
	
	}

	public void bookRentAndReturn() {

	}

}
