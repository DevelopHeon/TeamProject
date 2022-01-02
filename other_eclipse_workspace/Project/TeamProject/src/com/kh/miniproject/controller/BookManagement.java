package com.kh.miniproject.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.kh.miniproject.model.vo.Book;

public class BookManagement {
	private ArrayList<Book> bookList = new ArrayList<Book>();
	Scanner sc = new Scanner(System.in);
	
	public BookManagement() {}
	
	{
		bookList.add(new Book("감자","작가1","출판사1",true));
		bookList.add(new Book("고구마","작가2","출판사2",true));
		bookList.add(new Book("옥수수","작가3","출판사3",true));
		bookList.add(new Book("감자와 고구마","작가4","출판사4",false));
		bookList.add(new Book("마","작가1","출판사1",true));
		bookList.add(new Book("호박","작가4","출판사4",false));
		int i =0;
		for(Book b : bookList) {//이미 등록된 도서 번호 set
			b.setbNum(++i);
		}
		
	}

	//전재은
	public ArrayList<Book> searchBook(String keyWord){ //도서 검색
		
		ArrayList<Book> searchList = new ArrayList<>();
		
		for(Book b : bookList) {
			if(b.getTitle().contains(keyWord)) {
				searchList.add(b);
			}
			if(b.getAuthor().contains(keyWord)) {
				searchList.add(b);
			}
		}
		return searchList;
	}
	
	
	public void rentBook(int num) {
		for(Book b : bookList) {
			if(b.getbNum()==num) { //num과 책의 bNo이 일치하는 경우
				if(b.isRent()) { //isRent가 true(대여가능)인 경우
					System.out.println("<"+b.getTitle()+">을(를) 대여하시겠습니까? (y/n)");
					String result = sc.nextLine();
					
					if(result.equalsIgnoreCase("Y")) {
						b.setRent(false);//해당 도서를 false(대여불가능)으로 수정
						System.out.println("<"+b.getTitle()+">의 대여가 완료되었습니다.");
						
						//+회원 정보에 대여 기록 추가하기
						
						Date today = new Date();
						int year =today.getYear();
						int month = today.getMonth();
						int date = today.getDate();
						Date dueDay =new Date(year, month, date+7);//대여일 +7일
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
						
						System.out.println("[반납일] "+sdf.format(dueDay));
						
						System.out.println("[배달 주소] ");
						
						
					}else { //대여 취소
						System.out.println("<"+b.getTitle()+">의 대여가 취소되었습니다.");
					}

					for(Book a : bookList) {
						if(a.getbNum()!=b.getbNum()){//같은 책은 제외하고
							if(a.getAuthor().equals(b.getAuthor())) {//같은 작가의 책중에
								System.out.println("====이런 책은 어떠세요?====");
								System.out.println(a);//도서 추천
							}
						}
					}

				}else {
					System.out.println("<"+b.getTitle()+">은(는) 현재 대여가 불가능한 책입니다.");
				}
			}
		}
	}

	
	public void rentList() {
		for(Book b : bookList) {//대여중 도서 목록 출력 (각 회원의 대여 정보랑 연동이 되어야 함)
			if(!b.isRent()) {//수정 전 임시로 대여중인 책 전권 출력
				System.out.println(b);
			}
		}
	}
	
	
	public void bookReturn(int num) {
		for(Book b : bookList) {
			if(b.getbNum()==num) {//num과 같은 번호의 책
			b.setRent(true);// true (대여 가능)
			System.out.println("<"+b.getTitle()+">을(를) 반납하셨습니다.");
			}
		}
	}
	//전재은
	
}
