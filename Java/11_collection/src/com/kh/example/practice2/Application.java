package com.kh.example.practice2;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.example.practice2.controller.SongController;
import com.kh.example.practice2.model.Song;

public class Application {

	Scanner sc = new Scanner(System.in);
	SongController con = new SongController();
	
	public static void main(String[] args) {
		Application a = new Application();
		a.mainMenu();
	}
	
	public void mainMenu() {
		
		boolean b = true;
		while (b) {
			System.out.println("===== 메인 메뉴 =====");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 수정");
			System.out.println("7. 곡 명 오름차순 정렬");
			System.out.println("8. 가수 명 내림차순 정렬");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 입력:");
			try {
				int num = Integer.parseInt(sc.nextLine());
				switch (num) {
				case 1:
					behind();
					break;
				case 2:
					front();
					break;
				case 3:
					printAll();
					break;
				case 4:
					print();
					break;
				case 5:
					remove();
					break;
				case 6:
					set();
					break;
				case 7:
					songAsc();
					break;
				case 8:
					break;
				case 9:
					b=false;
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("잘못 입력하셨습니다:" + e.getMessage());
			}
		}
	}
	
	public void behind() {
		System.out.println("****** 마지막 위치에 곡 추가 ******");
		System.out.print("곡 명:");
		String song = sc.nextLine();
		System.out.print("가수 명:");
		String singer = sc.nextLine();
		if(con.behind(song, singer)) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}
		
	}
	
	public void front() {
		System.out.println("****** 첫 위치에 곡 추가 ******");
		System.out.print("곡 명:");
		String song = sc.nextLine();
		System.out.print("가수 명:");
		String singer = sc.nextLine();
		if(con.front(song, singer)) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}
	}
	
	public void printAll() {
		System.out.println("****** 전체 곡 목록 출력 ******");
		ArrayList<Song> list = con.printAll();
		for(Song li : list) {
			System.out.println(li);
		}
	}
	
	public void print() {
		System.out.println("****** 특정 곡 검색 ******");
		System.out.print("검색할 곡 명:");
		String song = sc.nextLine();
		Song title = con.print(song);
		if(title == null) {
			System.out.println("곡 정보가 없습니다.");
		} else {
			System.out.println(title +" 을 검색 했습니다.");
		}
	}
	
	public void remove() {
		System.out.println("****** 특정 곡 삭제 ******");
		System.out.print("삭제할 곡 명:");
		String song = sc.nextLine();
		Song title = con.remove(song);
		if(title == null) {
			System.out.println("삭제할 곡이 없습니다.");
		} else {
			System.out.println(title + "을 삭제 했습니다.");
		}
	}
	
	public void set() {
		System.out.println("****** 특정 곡 수정 ******");
		System.out.print("검색할 곡 명:");
		String song = sc.nextLine();
		System.out.print("수정할 곡 명:");
		String setSong = sc.nextLine();
		System.out.print("수정할 가수 명:");
		String setSinger = sc.nextLine();
		Song title = con.set(song, setSong, setSinger); 
			if(title == null) {
				System.out.println("수정할 곡이 없습니다");
			} else {
				System.out.println(title + "의 값이 변경 되었습니다.");
			}
		
	}
	
	public void songAsc() {
		System.out.println("****** 곡 명 오름차순 정렬 ******");
		ArrayList<Song> list = con.songAsc();
		for(Song li : list) {
			System.out.println(li);
		}
		
	}
	
	public void singerDesc() {
		System.out.println("****** 가수 명 내림차순 정렬 ******");
	}
}
