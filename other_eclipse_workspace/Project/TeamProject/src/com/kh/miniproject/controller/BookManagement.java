package com.kh.miniproject.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import com.kh.miniproject.model.dao.BookDao;
import com.kh.miniproject.model.vo.Book;

public class BookManagement{
	public ArrayList<Book> bookList = new ArrayList<Book>();
	Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	BookDao bd = new BookDao();
	//수정
	private ArrayList<Book> rentBook = new ArrayList<Book>();//렌트한 책 담을 리스트
	//
	public BookManagement() {}

	
	
	
	public void selectAll() {// 도서 전체 조회
		
		Iterator it = bd.selectAll().iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
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
	

	public void insertBook() {//도서 추가
		
		
		System.out.println("도서 제목 : ");
		String title = sc.nextLine();
		System.out.println("도서 작가 : ");
		String author = sc.nextLine();
		System.out.println("도서 출판사 : ");
		String publisher = sc.nextLine();
		
		try { //1) 기존의 게시글이 있을 경우(파일이 존재할 경우)
			bd.insertBook(new Book(bd.getLastBoardNo() + 1, title, author, publisher, true));
		}catch(IndexOutOfBoundsException e ) {//2) 기존의 게시글이 없을 경우(파일이 존재하지 않을 경우)
			bd.insertBook(new Book(1, title, author, publisher,true));
		}
		
		
	
	}

	
	
	
	
	public void updateTitle() {// 도서 제목 수정
	
		System.out.print("수정할 도서 번호 : ");
		int no = sc.nextInt();
		sc.nextLine();
		
		Book book = bd.bNum(no);
		if (bookList == null) {
			System.out.println("조회된 도서가 없습니다.");
		} else {
			System.out.println(book);
			
			System.out.print("변경할 도서 제목 : ");
			String title = sc.nextLine();
			bd.updateTitle(no,title);
		}
	}
	
	public void updateAuthor() {
		
		System.out.print("수정할 도서 번호 : ");
		int no = sc.nextInt();
		sc.nextLine();
		
		Book book = bd.bNum(no);
		if (bookList == null) {
			System.out.println("조회된 도서가 없습니다.");
		} else {
			System.out.println(book);
			
			System.out.print("변경할 작가 : ");
			String author = sc.nextLine();
			bd.updateAuthor(no,author);
		}
	}
	


	public void updatePublisher() { //도서 출판사 수정
		

		System.out.print("수정할 도서 번호 : ");
		int no = sc.nextInt();
		sc.nextLine();
		
		Book book = bd.bNum(no);
		if (bookList == null) {
			System.out.println("조회된 도서가 없습니다.");
		} else {
			System.out.println(book);
			
			System.out.print("변경할 출판사 : ");
			String publisher = sc.nextLine();
			bd.updatePublisher(no,publisher);
		}
	}
		

	
	public void deleteBook() { // 도서 삭제 
		System.out.print("삭제할 도서 번호 : ");
		int no = sc.nextInt();
		sc.nextLine();


		if (bookList == null) {
			System.out.println("조회된 도서가 없습니다.");
		} else {
			
			System.out.print("정말로 삭제하시겠습니까? (y/n) : ");
			char ch = sc.nextLine().toUpperCase().charAt(0);
			if (ch == 'Y') {
				bd.deleteBook(no);
				System.out.println(no + "번 도서가 삭제되었습니다.");
			}
		}
	}





public ArrayList<Book> searchBook(String keyWord) { // 도서 검색

		ArrayList<Book> searchList = new ArrayList<Book>();

		for (Book b : bookList) {
			if (b.getTitle().contains(keyWord)) {
				searchList.add(b);
			}
			if (b.getAuthor().contains(keyWord)) {
				searchList.add(b);
			}
		}
		return searchList;
	}

	public void rentBook(int num) {
		for (Book b : bookList) {
			if (b.getbNum() == num) { // num과 책의 bNo이 일치하는 경우
				if (b.isRent()) { // isRent가 true(대여가능)인 경우
					System.out.println("<" + b.getTitle() + ">을(를) 대여하시겠습니까? (y/n)");
					String result = sc.nextLine();

					if (result.equalsIgnoreCase("Y")) {
						b.setRent(false);// 해당 도서를 false(대여불가능)으로 수정
						System.out.println("<" + b.getTitle() + ">의 대여가 완료되었습니다.");
						
						rentBook.add(b);// +회원 정보에 대여 기록 추가하기


					} else { // 대여 취소
						System.out.println("<" + b.getTitle() + ">의 대여가 취소되었습니다.");
					}

					for (Book a : bookList) {
						if (a.getbNum() != b.getbNum()) {// 같은 책은 제외하고
							if (a.getAuthor().equals(b.getAuthor())) {// 같은 작가의 책중에
								System.out.println("====이런 책은 어떠세요?====");
								System.out.println(a);// 도서 추천
							}
						}
					}

				} else {
					System.out.println("<" + b.getTitle() + ">은(는) 현재 대여가 불가능한 책입니다.");
				}
			}
		}
	}
	
	public void rentList() {
		//rentBook으로 수정
		for (Book b : rentBook) {// 대여중 도서 목록 출력 (각 회원의 대여 정보랑 연동이 되어야 함)
			if (!b.isRent()) {// 수정 전 임시로 대여중인 책 전권 출력
				System.out.println(b);
			}
		}
	}

	public void bookReturn(int num) {
		for (Book b : bookList) {
			if (b.getbNum() == num) {// num과 같은 번호의 책
				b.setRent(true);// true (대여 가능)
				System.out.println("<" + b.getTitle() + ">을(를) 반납하셨습니다.");
			}
		}
	} 

}
