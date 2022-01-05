package com.kh.miniproject.view;

import java.util.Scanner;

import com.kh.miniproject.controller.MemberController;
import com.kh.miniproject.controller.ReviewController;

public class ManagerLogin {

	public static final String MID = "manager"; // 관리자 아이디와 비밀번호는 상수로 생성
	public static final String MPWD = "12345";

	Scanner sc = new Scanner(System.in);

	ReviewController rc = new ReviewController();
	NoticeMenu nc = new NoticeMenu();
	BookMenu bm = new BookMenu();
	MemberController mc = new MemberController();

	public ManagerLogin() {
	}

	public void managerMainMenu() {

		while (true) {

			System.out.println("아이디 : ");
			String id = sc.nextLine();
			System.out.println("비밀번호 : ");
			String pwd = sc.nextLine();

			if (MID.equals(id) && pwd.equals(MPWD)) {
				System.out.println("로그인 성공");
				break;
			} else {
				System.out.println("로그인 실패했습니다");
			}
			System.out.println("다시 시도하시겠습니까? (Y/N)");
			String num = sc.nextLine();
			if (num.equalsIgnoreCase("n")) {
				return;
			}
		}

		while (true) {
			System.out.println("==== 관리자 메뉴 ====");
			System.out.println("1. 공지사항 관리");
			System.out.println("2. 도서 관리");
			System.out.println("3. 리뷰 게시판 조회");
			System.out.println("0. 이전 메뉴로");
			System.out.println("메뉴 선택 : ");

			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				nc.noticeManagement();
				break;
			case 2:
				bm.bookManagement();
				break;
			case 3:
				rc.selectAll();
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
}