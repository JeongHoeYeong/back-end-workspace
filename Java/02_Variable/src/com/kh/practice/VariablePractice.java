// 클래스 이름 : com.kh.practice.VariablePractice
// FQCN(Fully Qualified Class Name)
package com.kh.practice;

import java.util.Scanner;

public class VariablePractice {

	public static void main(String[] args) {
		VariablePractice v = new VariablePractice();
		v.method1();
	}

	public void method1() {
		int ad = 10000;
		int ch = 7000;

		System.out.println("성인 2명 :" + 2 * ad + "원");
		System.out.println("청소년 3명 :" + 3 * ch + "원\n");
		System.out.println("총 금액 : " + (2 * ad + 3 * ch) + "원");
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
		String input = sc.nextLine();
		char c1 = input.charAt(0);
		char c2 = input.charAt(input.length() - 1);
		System.out.println("첫번째 문자 : " + c1);
		System.out.println("마지막 문자 : " + c2);
	}
}
