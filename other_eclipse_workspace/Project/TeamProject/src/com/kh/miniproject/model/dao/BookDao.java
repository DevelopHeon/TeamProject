package com.kh.miniproject.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.miniproject.model.vo.Book;

public class BookDao {

	Scanner sc = new Scanner(System.in);

	ArrayList<Book> bookList = new ArrayList<Book>();
	// vo클래스 자료형을 임시로 저장할 컬렉션(ArrayList)
	
	{//초기화
		bookList.add(new Book(1,"나비", "상우", "다람쥐", true));
		bookList.add(new Book(2,"벌레", "지우", "사슴", true));
		
		int i = 0;
		for(Book b : bookList) {
			b.setbNum(++i);
		}
	}

	
	public BookDao() {
		try (ObjectOutputStream bookSave = new ObjectOutputStream(new FileOutputStream("booklist.dat",true))) {

			for (int i = 0; i < bookList.size(); i++) {
				bookSave.writeObject(bookList.get(i));
			}
			System.out.println("Book.list.dat에 성공적으로 저장되었습니다.");

		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	public void BookDaoOpen() {
		try (ObjectInputStream bookOpen = new ObjectInputStream(new FileInputStream("booklist.dat"))) {
			int value = 0;
			while ((value = bookOpen.read()) != -1) {
				bookList.add((Book) (bookOpen.readObject()));

			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
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
		
	}
	
	public void updateTitle(int no, String title) {// 도서 제목 수정
		
		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getbNum() == no) {
				bookList.get(i).setTitle(title);
				break;
				}
		}
			
	
	}
	
	public void updateAuthor(int no, String author) { // 도서 작가 수정
		

		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getbNum() == no) {
				bookList.get(i).setAuthor(author);
				break;
				}
		}
			
	}
	


	public void updatePublisher(int no, String publisher) { //도서 출판사 수정

		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getbNum() == no) {
				bookList.get(i).setTitle(publisher);
				break;
				}
		}
	}
		

	// 도서의 마지막 번호 얻어오기
	public int getLastBoardNo() {

		return bookList.get(bookList.size() - 1).getbNum();
	}

	

	public void deleteBook(int no) {// 도서 삭제

		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getbNum() == no) {
				bookList.remove(i);

			}
		}

	}



}
