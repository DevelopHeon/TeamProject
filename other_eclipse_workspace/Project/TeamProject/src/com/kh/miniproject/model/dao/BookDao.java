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


	ArrayList<Book> bookList = new ArrayList<Book>();
	// vo클래스 자료형을 임시로 저장할 컬렉션(ArrayList)
	
	public BookDao() {
		try (ObjectInputStream bookOpen = new ObjectInputStream(new FileInputStream("booklist.dat"))) {
			
			bookList.addAll((ArrayList<Book>)bookOpen.readObject());

		} catch (ClassNotFoundException e) {
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
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Book bNum(int no) {
		Book book = null;
		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getbNum() == no) {
				
				book = bookList.get(i);
				break;
			}
			
		}
		return book;
	}
	
	public ArrayList<Book> selectAll() {// 도서 조회
		return bookList;
	}

	public void insertBook(Book book) {// 도서 추가
		bookList.add(book);
		BookDaoOpen();
	}
	
	public void updateTitle(int no, String title) {// 도서 제목 수정
		
		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getbNum() == no) {
				bookList.get(i).setTitle(title);
				BookDaoOpen();
				break;
				}
		}
	}
	
	public void updateAuthor(int no, String author) { // 도서 작가 수정

		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getbNum() == no) {
				bookList.get(i).setAuthor(author);
				BookDaoOpen();
				break;
			}
		}
	}

	public void updatePublisher(int no, String publisher) { //도서 출판사 수정

		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getbNum() == no) {
				bookList.get(i).setPublisher(publisher);
				BookDaoOpen();
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
	public int getLastBoardNo() {

		return bookList.get(bookList.size() - 1).getbNum();
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
