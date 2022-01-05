package com.kh.miniproject.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.kh.miniproject.model.vo.Book;

public class BookDao {


	ArrayList<Book> bookList = new ArrayList<Book>(); //Book 타입 객체들을 모아놓음 
	// vo클래스 자료형을 임시로 저장할 컬렉션(ArrayList)
	
	public BookDao() { //파일 읽기
		try (ObjectInputStream bookOpen = new ObjectInputStream(new FileInputStream("booklist.dat"))) {//1. 경로지정을 하지않으면 현재 project 폴더에 생성된다.
			//FileInputStream : 파일로부터 데이터를 읽어들이기 위해 사용되는 바이트 스트림 클래스
			//ObjectInputStream : 스트림으로 부터 객체 단위로 읽어들이기 위해 사용되는 보조 바이트 스트림 클래스
			
			
			// addAll메소드를 통해  bookList를 한번에 추가	
			bookList.addAll((ArrayList<Book>)bookOpen.readObject());
			// 처음에 파일이 있으면 파일에 있는 객체들을 다 bookList에 담는 역할
			
		} catch (ClassNotFoundException e) {//예외 처리 
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void BookDaoOpen() {
		try (ObjectOutputStream bookSave = new ObjectOutputStream(new FileOutputStream("booklist.dat"))) {
				bookSave.writeObject(bookList);
				//FileOutputStream : 파일출력에 사용되는 기반 바이트 스트림 클래스
				//ObjectOutputStream : 객체 단위로 출력시 사용되는 보조 바이트 스트림 클래스
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Book bNum(int no) { //BookManagement에서 쓰일 번호
		Book book = null;
		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getbNum() == no) {//bookList에 i번째 인덱스랑 입력받은 번호랑 같으면 
				
				book = bookList.get(i); //bookList에 i번째 인덱스 
				break;
			}
			
		}
		return book; // 결과값 book 반환
	}
	
	public ArrayList<Book> selectAll() {// 도서 조회
		return bookList; // bookList 반환
	}

	public void insertBook(Book book) {// 도서 추가
		bookList.add(book);
		BookDaoOpen();
	}
	
	public void updateTitle(int no, String title) {// 도서 제목 수정
		
		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getbNum() == no) { //bookList에 i번째 인덱스랑 입력받은 번호랑 같으면 
				bookList.get(i).setTitle(title); //bookList에 i번째 도서 제목 수정
				BookDaoOpen(); //세이브
				break;
				}
		}
	}
	
	public void updateAuthor(int no, String author) { // 도서 작가 수정

		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getbNum() == no) { //bookList에 i번째 인덱스랑 입력받은 번호랑 같으면 
				bookList.get(i).setAuthor(author); //bookList에 i번째 도서 작가 수정
				BookDaoOpen(); //세이브
				break;
			}
		}
	}

	public void updatePublisher(int no, String publisher) { //도서 출판사 수정

		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getbNum() == no) { //bookList에 i번째 인덱스랑 입력받은 번호랑 같으면
				bookList.get(i).setPublisher(publisher); //bookList에 i번째 도서 출판사 수정
				BookDaoOpen();//세이브
				break; 
			}
		}
	}
	
	public void updateRent(int no, boolean rent) { //도서 상태 변경
		
		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getbNum() == no) {
				bookList.get(i).setRent(rent);
				BookDaoOpen();
				break;
			}
		}
	}

	// 도서의 마지막 번호 얻어오기
	public int getLastBoardNo() { // BookManagement에 inserBook()에서 사용

		return bookList.get(bookList.size() - 1).getbNum(); //0부터라 -1 해줌
	}

	//도서 검색
	public ArrayList<Book> searchBook(String keyWord) {
		
		ArrayList<Book> searchList = new ArrayList<Book>();

		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getTitle().contains(keyWord)
					||bookList.get(i).getAuthor().contains(keyWord)) {
				searchList.add(bookList.get(i));
				
			}
		}
		return searchList;
	}
	public Book oneBook(Book one) {//책 하나만 출력
		Book result = null;
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).equals(one)) {
				result= bookList.get(i);
				
			}
		}
		return result;
	}
	public void deleteBook(int no) {// 도서 삭제
		
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getbNum() == no) {
				bookList.remove(i);
				BookDaoOpen();
			}
		}
		
	}
	
}