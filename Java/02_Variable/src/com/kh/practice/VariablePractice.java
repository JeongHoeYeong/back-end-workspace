// 클래스 이름 : com.kh.practice.VariablePractice
// FQCN(Fully Qualified Class Name)
package com.kh.practice;

import java.util.Scanner;

public class VariablePractice {

	public static void main(String[] args) {
		VariablePractice v = new VariablePractice();
		v.method3();
	}

	public void method1() {
		int adultPrice = 10000;
		int teenPrice = 7000;
		int adultCount = 2;
		int teenCount = 3; 
		
		int adultTotal = adultPrice * adultCount;
		int teenTotal = teenPrice * teenCount;

		System.out.printf("성인 %d명 : %d원\n", adultCount, adultTotal);
		System.out.printf("성인 %d명 : %d원\n", teenCount, teenTotal);
		System.out.printf("총 금액 : %d원", adultTotal + teenTotal);
	}

	public void method2() {
		int x = 5;
		int y = 7;
		int z = 9;

		int tmp = x;
		x = y;
		y = z;
		z = tmp;

		System.out.println("x=" + x);
		System.out.println("y=" + y);
		System.out.println("z=" + z);
	}

	public void method3() {
		Scanner sc = new Scanner(System.in);

		System.out.print("문자열을 입력하세요 : ");
		String str = sc.nextLine();
		System.out.println("첫번째 문자 : " + str.charAt(0));
		System.out.println("마지막 문자 : " + str.charAt(str.length() - 1));
	}
}
