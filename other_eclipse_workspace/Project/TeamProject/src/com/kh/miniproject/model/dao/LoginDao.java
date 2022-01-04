package com.kh.miniproject.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import java.util.Scanner;

import com.kh.miniproject.model.vo.Member;
import com.kh.miniproject.view.ManagerLogin;
import com.kh.miniproject.view.MemberPage;
import com.kh.miniproject.view.NoticeMenu;

public class LoginDao {

	public ArrayList<Member> memList = new ArrayList<Member>();

	public LoginDao() {
	}

	public void LoginDaoOpen() {

		try (ObjectOutputStream logInSave = new ObjectOutputStream(new FileOutputStream("Member.dat", true))) {

			for (int i = 0; i < memList.size(); i++) {
				logInSave.writeObject(memList.get(i));
				  
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void LoginDaoSave() {
		
		try (ObjectInputStream logInOpen = new ObjectInputStream(new FileInputStream("Member.dat"))) {
			int i = 0;
			while (true) {
				
				memList.add((Member) logInOpen.readObject());
				i++;
			}
		} catch (EOFException e) {
			return;
		} catch (FileNotFoundException e) {
			System.out.println("정보를 확인할 수 없습니다.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void addMember(Member newMember) {
		memList.add(newMember);
		LoginDaoOpen();
	}

	public int login(String id, String pwd) {
		LoginDaoOpen();
		for (int i = 0; i < memList.size(); i++) {
			if (memList.get(i).getId().equals(id) && memList.get(i).getPwd().equals(pwd)) {
				System.out.println(memList.get(i));// 로그인한 회원 정보 출력
				return 1;
			}
		}
		return 0;
	}


	} 
	

	
	

