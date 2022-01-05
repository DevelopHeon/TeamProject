package com.kh.miniproject.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.kh.miniproject.model.vo.Delivery;

public class DeliveryDao {
	
	ArrayList<Delivery> info = new ArrayList<Delivery>();
	
	public DeliveryDao() {//파일 읽기
		try(ObjectInputStream dlvOpen = new ObjectInputStream(new FileInputStream("deliveryInfo.dat"))){
			
			info.addAll((ArrayList<Delivery>)dlvOpen.readObject());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void DeliverySave() {//파일 저장
		try(ObjectOutputStream dlv = new ObjectOutputStream(new FileOutputStream("deliveryInfo.dat"))){
			dlv.writeObject(info);
			System.out.println("성공적으로 저장되었습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void addInfo(Delivery delivery) {//정보 입력
		info.add(delivery);
		DeliverySave();
	}
	
	public ArrayList<Delivery> displayAll() {//전체 출력
		return info;
	}
	
	public Delivery searchInfo(String name) {//수취인 이름으로 정보 찾기
		Delivery search = new Delivery();
		
		for(int i =0; i<info.size();i++) {
			if(info.get(i).getName().equals(name)) {
				search=info.get(i);
			}
		}
		return search;
	}
	
	public void modifyAddress(String name, String address) {//주소 수정
		for(int i =0; i<info.size();i++) {
			if(info.get(i).getName().equals(name)) {
				info.get(i).setAddress(address);
				System.out.println(info.get(i));
				DeliverySave();
				System.out.println("수정이 완료되었습니다.");
				break;
			}
		}
	}
	
	public void deleteInfo(String name) {//배송 정보 삭제
		for(int i =0; i<info.size();i++) {
			if(info.get(i).getName().equals(name)) {
				info.remove(i);
				DeliverySave();
			}
		}
	}
}
