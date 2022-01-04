package com.kh.miniproject.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.miniproject.model.dao.LoginDao;
<<<<<<< HEAD
import com.kh.miniproject.model.dao.MemberDao;
=======
import com.kh.miniproject.model.vo.Book;
>>>>>>> refs/heads/master
import com.kh.miniproject.model.vo.Member;
import com.kh.miniproject.view.MemberPage;

public class MemberController {
<<<<<<< HEAD
=======

	public static final int SIZE = 100;
	private int memberCount;
	private Member[] mem = new Member[SIZE];
	
//	{
//		mem[0] = new Member("skyblue1", "bcbc", "홍길동", 10, 'M', "서울시 마포구", "010-1234-4567", 0);
//		mem[1] = new Member("skyblue2", "cdcd", "도라지", 11, 'M', "서울시 용산구", "010-5656-5656", 0);
//		mem[2] = new Member("skyblue3", "efef", "미역국", 12, 'M', "서울시 강남구", "010-8989-8989", 0);
//		memberCount = 3;
//
//	}
>>>>>>> refs/heads/master
	
	MemberDao md = new MemberDao();
	Scanner sc = new Scanner (System.in);
	MemberPage mp = new MemberPage();
	LoginDao ld = new LoginDao();
	public ArrayList <Member> memList = new ArrayList<Member>();
	
	//기본생성자
	public MemberController() {	}

	
	

	//로그인
	public void login() {

		System.out.println("id :");
		String id = sc.nextLine();

		System.out.println("pwd :");
		String pwd = sc.nextLine();

		int result = ld.login(id, pwd);
		
		if (result == 1) {
			mp.memberMainMenu();
		} else {
			System.out.println("로그인에 실패하였습니다.");
		}

	}
	//회원등록
	public void join() {
		System.out.println("Id : ");
		String id = sc.nextLine();
		
		System.out.println("Pwd :");
		String pwd = sc.nextLine();
		
		System.out.println("이름: ");
		String name = sc.nextLine();
		
		System.out.println("나이: ");
		int age = sc.nextInt();
		
		System.out.println("성별: ");
		char gender = sc.next().charAt(0);
		
		System.out.println("주소: ");
		String address = sc.nextLine();
		
		System.out.println("휴대폰 번호: ");
		String phoneNum = sc.nextLine();
		
		Member join = new Member(id, pwd, name, age, gender, address, phoneNum);
		
	}


	//회원정보수정
	public void memberInfoEdit() {
		System.out.println("회원정보를 수정하시겠습니까? (y/n) ");
		String info = sc.nextLine();
		
		md.memberInfoEdit(info);
	}

<<<<<<< HEAD

	//회원정보출력
	public void memberPrint() {
	System.out.println("회원의 아이디를 입력해주세요");
	String id = sc.nextLine();
	
	Member member = md.memberPrint(id);
	if(member == null) {
		System.out.println("조회된 아이디가 없습니다.");
		
	}else {
		System.out.println(id);
	}
	
		
	}


	//회원탈퇴
	/*public void memberWithdraw() {
		System.out.println("탈퇴할 아이디를 입력하세요");
		String id = sc.nextLine();
		
		
		md.memberWithdraw(withdraw);
		
	}*/



	

}
=======
	public int getCount() {
		
		return memberCount;  
	}

	
	


	}


>>>>>>> refs/heads/master
