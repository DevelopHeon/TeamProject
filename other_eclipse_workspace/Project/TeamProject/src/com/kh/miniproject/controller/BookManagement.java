package com.kh.miniproject.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.miniproject.model.vo.Book;

public class BookManagement {

	
	private ArrayList<Book> bookList = new ArrayList<Book>();
	

	Scanner sc = new Scanner(System.in);
	
	
	public ArrayList<Book> selectAll() {
	
		
		return bookList;
		

	}

	public void insertBook(Book book) {//도서 추가
		
		int lastNum = 0; //변수 생성 및 초기화
		
		try {
			lastNum = bookList.get(bookList.size() -1).getbNum() + 1;// 마지막 도서 번호 + 1
			//0 부터 시작이라 크기에 -1을 해준다
		}catch(IndexOutOfBoundsException e) {//예외처리
			//북리스트보다 크기가 크거나 음수 인덱스 예외 처리해줌
			lastNum =1;
		}
		
		//매개변수로 받은 book 객체에 번호 초기화
		book.setbNum(lastNum);
		
		bookList.add(book);
		
		
	}

	public int updateBook(int bNum) {//도서 수정

       
        
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getbNum() == bNum) {//bookList.get(i).getbNum : 해당 인덱스의 book을 가져와서 넘버를 얻음 
                
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

		
	
	public int deleteBook(int bNum) {//도서 삭제
		//반환은 int형으로
		
		for(int i = 0; i < bookList.size(); i++) {
			
			if(bookList.get(i).getbNum() == bNum) {
				
				bookList.remove(bookList.get(i)); // 삭제
				return 1; //1로 반환
			}
			
		}
		
		return 0;
	}




}


