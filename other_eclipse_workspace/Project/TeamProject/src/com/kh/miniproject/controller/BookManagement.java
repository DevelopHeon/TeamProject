package com.kh.miniproject.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.kh.miniproject.model.dao.BookDao;
import com.kh.miniproject.model.dao.DeliveryDao;
import com.kh.miniproject.model.vo.Book;
import com.kh.miniproject.model.vo.Delivery;

public class BookManagement{
	public ArrayList<Book> bookList = new ArrayList<Book>();
	Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	BookDao bd = new BookDao();
	//수정
	private DeliveryDao dd = new DeliveryDao();
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
			}else if (b.getAuthor().contains(keyWord)) {
				searchList.add(b);
			}
		}
		return searchList;
	}

	public void rentBook(int num) {//1. 도서 대여
		for (Book b : bookList) {
			if (b.getbNum() == num) { // num과 책의 bNo이 일치하는 경우
				if (b.isRent()) { // isRent가 true(대여가능)인 경우
					
					System.out.println("<" + b.getTitle() + ">을(를) 대여하시겠습니까? (Y/N)");
					String result = sc.nextLine();
					
					if (result.equalsIgnoreCase("Y")) { //Y선택한 경우
						b.setRent(false);// 해당 도서를 false(대여불가능)으로 수정
						System.out.println("<" + b.getTitle() + ">의 대여가 완료되었습니다.");
						
						infoInput(b);//배송 정보 입력
						
					} else { //Y가 아닌 경우대여 취소
						System.out.println("<" + b.getTitle() + ">의 대여가 취소되었습니다.");
					}

					//도서 추천
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
	
	public void infoInput(Book book) {//1-1.베송 정보 입력

			System.out.println("배송받을 사람의 이름을 입력하세요.");
			String name = sc.nextLine();
			System.out.println("배송받을 주소를 입력해 주세요.");
			String address = sc.nextLine();
			
			Delivery info = new Delivery(name, address, book);//입력 정보들로 객체 생성
			
			ArrayList<Delivery> check =dd.displayAll();//저장된 정보를 check에 담아서
			
			if(check.size()==0) {
				dd.addInfo(info);
			}else {
				for(int i = 0; i<check.size();i++) {//check과 info를 비교해서
					if(!check.get(i).equals(info)) {//중복이 아니라면
						dd.addInfo(info);//dao에 정보 추가
						return;
					}else{
					book.setRent(true);//대출가능으로 다시 바꾸기
						System.out.println("주문 기록이 이미 있습니다.");
						return;
					}
				
				}
			}
			
				
			
			
			
		
	}

	public void infoCheck(String name) {//2.배송 조회
	
		try {
			Delivery check = dd.searchInfo(name);
			if(check.getName().equals(name)) {
				System.out.println(check.toString());//검색 결과 출력
				
				//배송 수정, 취소
				System.out.println("1. 배송 정보 수정");
				System.out.println("2. 배송 취소");
				System.out.println("0. 이전 메뉴로 가기");
				int num = sc.nextInt();sc.nextLine();
				switch(num) {
				case 1: modifyInfo(name);
				break;
				case 2: deleteInfo(name);
				break;
				case 0 :
					return;
				default : System.out.println("잘못 입력하셨습니다. 메뉴를 다시 선택해주세요.");
				break;
				}
			}
		}catch(NullPointerException e) {
			System.out.println("수취인 정보가 없습니다.");
		}finally {
			
		}
	}

	public void modifyInfo(String name) {//2-1 배송 정보 수정
		System.out.println("새로운 주소를 입력해 주세요.");
		String address = sc.nextLine();
		dd.modifyAddress(name, address);
	}

	public void deleteInfo(String name) {//2-2. 배송 취소
		System.out.println("주문을 취소하시겠습니까? (Y/N)");
		String result = sc.nextLine();
		if (result.equalsIgnoreCase("Y")) {
			
			//책을 대여가능으로 전환
			int booknum= dd.searchInfo(name).getBook().getbNum();
			for (Book b : bookList) {
				if(b.getbNum()==booknum) {
					b.setRent(true);
				}
			}
			
			dd.deleteInfo(name);//정보 삭제
			
		}else {
			System.out.println("이전 메뉴로 돌아갑니다.");
		}
	}
}
