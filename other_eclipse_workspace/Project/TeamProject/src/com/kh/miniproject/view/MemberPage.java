package com.kh.miniproject.view;

import java.util.ArrayList;
import java.util.Scanner;
import com.kh.miniproject.controller.MemberController;
import com.kh.miniproject.model.vo.Member;
import com.kh.miniproject.controller.BookManagement;
import com.kh.miniproject.model.vo.Book;

public class MemberPage {
	MemberController mc = new MemberController();
	ReviewBoard rb = new ReviewBoard();

	BookManagement bm = new BookManagement();

	Scanner sc = new Scanner(System.in);

	public MemberPage() {
	}

	public void memberMainMenu() {
		while (true) {
			System.out.println("==== 회원 메뉴 페이지 ====");
			System.out.println("1. 도서 검색");
			System.out.println("2. 도서 반납");
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
				bookReturn();// 메소드 이름 수정함
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
				memberInfoEdit();
				break;

			case 2:
				memberprint();
				break;

			case 3:
				memberWithdraw();
				return;

			case 0:
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;

			default:
				System.out.println("잘못 입력하였습니다. 다시 입력하세요");
				continue;
			}
		}

	}

	public void memberInfoEdit() {
		while (true) {
			System.out.println("===== 회원 정보 수정 =====");
			System.out.println("1. 비밀번호 수정");
			System.out.println("2. 이름 수정");
			System.out.println("3. 주소 수정");
			System.out.println("4. 휴대폰 번호 수정");

			System.out.println("0. 이전 페이지");

			System.out.println("메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			if (menu == 0) {
				System.out.println("이전 페이지로 돌아갑니다.");
				return;
			}

			System.out.print("\n변경할 회원 아이디 : ");
			String id = sc.nextLine();

			// 아이디로 회원 조회 요청 (Controller에 요청함)
			Member m = mc.checkId(id);
			// m : 일치하는 회원 찾은 경우 해당 회원 객체, 못찾은 경우 null

			if (m == null) {
				System.out.println("변경할 회원에 대한 정보가 존재하지 않습니다.");

			} else {

				System.out.println("기존 정보 : " + m.information()); // 우선 현재 회원의 기존 정보 출력

				System.out.print("\n변경 내용 : ");
				String edit = sc.nextLine(); // 수정할 값 입력받기

				System.out.println("회원의 정보가 변경되었습니다.");

				mc.memberInfoEdit(m, menu, edit);
			}

			System.out.println("회원 정보 수정이 완료되었습니다.");
		}

	}

	private void memberprint() {
		int i = 0;
		Member[] mem = mc.getMem();
		System.out.println(mem[i].information());
		if (mem[i] == null) {
			System.out.println("이미 탈퇴한 회원입니다.");
		}
	}

	public void memberWithdraw() {
		System.out.println("탈퇴할 회원 아이디 :");
		String id = sc.nextLine();

		Member m = mc.checkId(id);
		if (m == null) {
			System.out.println("탈퇴할 회원이 존재하지 않습니다.");

		} else {
			System.out.println("기존 정보 출력 : " + memberInfo.toString());

			System.out.println("정말 탈퇴하시겠습니까? (y/n) ");
			char ch = sc.nextLine().toUpperCase().charAt(0);

			if (ch == 'Y') {
				mc.memberWithdraw(id);

			}

		}
		System.out.println("회원의 정보가 삭제되었습니다.");
	}

	public void booksearch() {

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
				}

				// BookManager의 rentBook 호출
				bm.rentBook(num);
			}
		}

	}

	private void bookReturn() {// 도서 반납 (회원 정보랑 연결)
		System.out.println("====도서 반납====");
		bm.rentList();// 대여중인 책 목록 출력

		System.out.println("0. 이전 메뉴로 가기");
		System.out.println("반납할 책 번호를 선택해주세요.");
		int num = sc.nextInt();
		if (num == 0) {// 0 입력 -> while문 처음으로
			return;
		}

		bm.bookReturn(num);
	}

}
