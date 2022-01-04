package com.kh.miniproject.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.miniproject.controller.BookManagement;
import com.kh.miniproject.controller.MemberController;
import com.kh.miniproject.model.dao.DeliveryDao;
import com.kh.miniproject.model.vo.Book;
import com.kh.miniproject.model.vo.Member;

public class MemberPage {
	

	MemberController mc = new MemberController();
	ReviewBoard rb = new ReviewBoard();
	BookManagement bm = new BookManagement();
	DeliveryDao dd= new DeliveryDao();

	Scanner sc = new Scanner(System.in);

	public MemberPage() { }
	


	public void memberMainMenu() {
		while (true) {
			System.out.println("==== 회원 메뉴 페이지 ====");
			System.out.println("1. 도서 검색");
			System.out.println("2. 배송 정보 조회");
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
				infoCheck();
				break;
			case 3:
				memberInfo();
				break;
			case 4:
				rb.ReviewBoard();
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

	public void memberInfo() {

		// 회원 관리 메뉴에서 번호선택!
		while (true) {
			System.out.println("===== 회원 정보 페이지 =====");
			System.out.println("1. 회원 정보 수정");
			System.out.println("2. 나의 회원 정보 출력");
			System.out.println("3. 회원 탈퇴");
			System.out.println("0. 이전 페이지");

			System.out.println("메뉴 선택 :");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {

			case 1:
				mc.memberInfoEdit();
				break;

			case 2:
				mc.memberPrint();
				break;

//			case 3:
//				mc.memberWithdraw();
//				return;

			case 0:
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;

			default:
				System.out.println("잘못 입력하였습니다. 다시 입력하세요");
				continue;
			}



		}
	}

	public void booksearch() {//도서 검색, 대여

		while (true) {// 반복문
			System.out.println("====도서 검색===");
			System.out.println("검색어를 입력하세요.");
			System.out.println("0. 이전 메뉴로 가기");
			String keyWord = sc.nextLine();

			if (keyWord.equals("0")) {// 0 입력 -> while문 처음으로
				break;
			}

			ArrayList<Book> searchList = bm.searchBook(keyWord);// BookManager의 searchBook호출, 출력

			if (searchList.isEmpty()) {// 검색 결과가 없을 경우
				System.out.println("검색 결과가 없습니다."); // 출력 후 반복문 처음으로 돌아감
			} else {// 검색 결과가 있으면 출력
				System.out.println("====검색 결과===");
				for (Book b : searchList) { // 하나씩 출력하기 위한 for문
					System.out.println(b);
				}

				// 검색한 책 출력 후 대여 번호 입력
				System.out.println("0. 이전 메뉴로 가기");
				System.out.println("대여할 책 번호를 선택해주세요.");
				int num = sc.nextInt();
				sc.nextLine();

				if (num == 0) {// 0 입력 -> while문 처음으로
					break;
				}else {
					// BookManager의 rentBook 호출
					bm.rentBook(num);
					
				}
			}
		}
	}

	public void infoCheck() {//배송 조회, 수정, 취소
		while(true) {
			System.out.println("====배송 정보 조회====");
			System.out.println("수취인 이름을 입력해주세요.");
			System.out.println("0. 이전 메뉴로 가기");
			String name = sc.nextLine();
			if (name.equals("0")) {// 0 입력 -> while문 처음으로
				break;
			}else {
				bm.infoCheck(name);
			}
		}
	}
}


