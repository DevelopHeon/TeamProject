package com.kh.miniproject.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.miniproject.controller.BookManagement;
import com.kh.miniproject.model.vo.Book;

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
			System.out.println("3.도서 정보 수정");
			System.out.println("4.도서 삭제");
			System.out.println("9.프로그램 종료");
			System.out.println("메뉴 선택 : ");
			
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1 :
				selectAll();
				break;
			case 2 :
				insertBook();
				break;
			case 3 :
				updateBook();
				break;
			case 4 :
				deleteBook();
				break;
			case 9 :
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default :
				System.out.println("잘못 입력하셨습니다. 메뉴를 다시 선택해주세요.");
				break;
			}
			
		}
	}
	
	private void selectAll() {// 도서 전체 조회
		
		ArrayList<Book> bookList = bm.selectAll();
		

		for(Book b : bookList) {
			System.out.println(b);
			
		}
		while(true) {
			System.out.println("도서 관리 메뉴로 돌아가시겠습니까(y/n) : ");
			String str =sc.nextLine();
			if(str.equalsIgnoreCase("y")) {
				return;
			}else if(str.equalsIgnoreCase("n")){
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				
			}else {
				System.out.println("문자를 잘못입력하셨습니다. 다시 입력해주세요.");
			}
		}
		
		
	}
	

	private void insertBook() {//도서 추가
		
		System.out.println("도서 제목 : ");
		String title = sc.nextLine();
		System.out.println("도서 작가 : ");
		String author = sc.nextLine();
		System.out.println("도서 출판사 : ");
		String publisher = sc.nextLine();
		
		Book book = new Book(title, author, publisher);
		
		bm.insertBook(book);
		
	}
	

	private void updateBook() {//도서 수정
		
		System.out.println("도서 번호 : ");
		int bNum = sc.nextInt();
		sc.nextLine();
		
		
		int result = bm.updateBook(bNum);
		
		if(result == 1) {
			
			System.out.println("성공적으로 수정 완료");
		}else if(result == 0) {
			
			System.out.println("수정할 도서가 존재하지 않습니다.");
			
		}
		

	}
		

	private void deleteBook() {//도서 삭제
		System.out.println("도서 번호 : ");
		int bNum = sc.nextInt();
		sc.nextLine();
		
		int result = bm.deleteBook(bNum);// BookManager의 deleteBook 메소드로 bNum 전달
		
		if(result ==1) { // result가 1일 경우 >> “성공적으로 삭제” 출력

			System.out.println("성공적으로 삭제");
		}else if(result == 0) {
			// result가 0일 경우 >> “삭제할 도서가 존재하지 않습니다.”출력

			System.out.println("삭제할 도서가 존재하지 않습니다.");
		}
		
		
	}


}
