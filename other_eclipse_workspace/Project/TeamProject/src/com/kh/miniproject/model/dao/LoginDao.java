package com.kh.miniproject.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.kh.miniproject.model.vo.Member;

public class LoginDao {
	
	ArrayList<Member> memList = new ArrayList<Member>();
	
	public LoginDao() {
		// TODO Auto-generated constructor stub
	}
//	
//	public LoginDao() {//인풋 (파일 읽기)
//		try(ObjectInputStream logInOpen = new ObjectInputStream(new FileInputStream("Member.dat"))){			
//
//			memList.addAll((ArrayList<Member>)logInOpen.readObject());
//				
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	public void LoginDaoOpen() {//아웃풋 (파일 저장)
		try(ObjectOutputStream logInSave = new ObjectOutputStream(new FileOutputStream("Member.dat"))) {
				logInSave.writeObject(memList);
				
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void LoginDaoSave() {
		
		try(ObjectInputStream logInOpen = new ObjectInputStream(new FileInputStream("Member.dat"))){			

			memList.addAll((ArrayList<Member>)logInOpen.readObject());
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeMember(Member member) {//회원 추가(가입)
		memList.add(member);	
		LoginDaoOpen();
	}
	
	public int login(String id, String pwd) {//로그인	
		LoginDaoSave();	
		for (int i = 0; i < memList.size(); i++) {
			if (memList.get(i).getId().equals(id) && memList.get(i).getPwd().equals(pwd)) {
				System.out.println(memList.get(i));//로그인한 회원 정보 출력
				return 1;
			}
		}
		return 0;
	}
	
	public void memberInfoEdit(String id, String newPwd) {//회원정보 수정	
		LoginDaoSave();		
		for (int i = 0; i < memList.size(); i++) {
			if (memList.get(i).getId().equals(id)) {
				memList.get(i).setPwd(newPwd);
				LoginDaoOpen();
				System.out.println("비밀번호가 수정이 완료되었습니다.");
			}else {
				System.out.println("조회된 아이디가 없습니다.");
			}
		}
	}
	
	public ArrayList<Member> memberSearch(String id) {//회원정보 전체 출력	
		return memList; 
	}
	
	public void memberWithdraw(String id) {//회원 탈퇴		
		LoginDaoSave();
		for (int i = 0; i < memList.size(); i++) {
			if (memList.get(i).getId().equals(i)) {
					memList.remove(i);
				System.out.println("탈퇴가 완료되었습니다.");
				LoginDaoOpen();
			}
		}
	}
}

	