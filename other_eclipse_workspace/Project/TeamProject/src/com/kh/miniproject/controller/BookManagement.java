package com.kh.miniproject.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.miniproject.model.dao.DeliveryDao;
import com.kh.miniproject.model.dao.LoginDao;
import com.kh.miniproject.model.vo.Book;
import com.kh.miniproject.model.vo.Delivery;

public class BookManagement{
	private ArrayList<Book> bookList = new ArrayList<Book>();
	Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	private LoginDao ld = new LoginDao();
	//수정
	private DeliveryDao dd = new DeliveryDao();
	//
	public BookManagement() {}

	{
		bookList.add(new Book("감자", "작가1", "출판사1", true));
		bookList.add(new Book("고구마", "작가2", "출판사2", true));
		bookList.add(new Book("옥수수", "작가3", "출판사3", true));
		bookList.add(new Book("감자와 고구마", "작가4", "출판사4", false));
		bookList.add(new Book("마", "작가1", "출판사1", true));
		bookList.add(new Book("호박", "작가4", "출판사4", false));
		int i = 0;
		for (Book b : bookList) {// 이미 등록된 도서 번호 set
			b.setbNum(++i);
		}

	}

	public ArrayList<Book> selectAll() {

		return bookList;

	}

	public void insertBook(Book book) {// 도서 추가

		int lastNum = 0; // 변수 생성 및 초기화

		try {
			lastNum = bookList.get(bookList.size() - 1).getbNum() + 1;// 마지막 도서 번호 + 1
			// 0 부터 시작이라 크기에 -1을 해준다
		} catch (IndexOutOfBoundsException e) {// 예외처리
			// 북리스트보다 크기가 크거나 음수 인덱스 예외 처리해줌
			lastNum = 1;
		}

		// 매개변수로 받은 book 객체에 번호 초기화
		book.setbNum(lastNum);

		bookList.add(book);

	}

	public int updateBook(int bNum) {// 도서 수정

		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getbNum() == bNum) {// bookList.get(i).getbNum : 해당 인덱스의 book을 가져와서 넘버를 얻음

				System.out.println("제목 수정 : ");
				bookList.get(i).setTitle(sc.nextLine());
				System.out.println("작가 수정 : ");
				bookList.get(i).setAuthor(sc.nextLine());
				System.out.println("출판사 수정 : ");
				bookList.get(i).setPublisher(sc.nextLine());

				return 1;
			}
		}
		return 0;
	}

	public int deleteBook(int bNum) {// 도서 삭제
		// 반환은 int형으로

		for (int i = 0; i < bookList.size(); i++) {

			if (bookList.get(i).getbNum() == bNum) {

				bookList.remove(bookList.get(i)); // 삭제
				return 1; // 1로 반환
			}

		}

		return 0;
	}

	// 전재은
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
