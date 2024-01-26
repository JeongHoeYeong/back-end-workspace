package com.kh.example.practice1;

import java.util.Set;
import java.util.TreeSet;

public class Application {

	public static void main(String[] args) {
		Application a = new Application();
		a.method1();
	}
	
	public void method1() {
		
		int count = 0;
		
		int random = (int)(Math.random()*45)+1;
		
		Set<Integer> mynum =  new TreeSet<>();
		Set<Integer> lonum =  new TreeSet<>();
		while(lonum.size()<=5) {
			lonum.add((int)(Math.random()*45)+1);
		}
		
		while(true) {
			count++;
			mynum.clear();
			while(mynum.size()<=5) {
				mynum.add((int)(Math.random()*45)+1);
			}
			System.out.println("내 번호 : " + mynum);
			System.out.println("로또 번호 : " + lonum);
			
			if(mynum.equals(lonum)) {
				break;
			}		
		}
		System.out.println("횟수 : " + count);
	}
}
