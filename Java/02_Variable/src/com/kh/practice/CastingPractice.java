package com.kh.practice;

import java.util.Scanner;

public class CastingPractice {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		CastingPractice c = new CastingPractice();
		c.method1();
	}

	public void method1() {

		System.out.print("문자 : ");
		String input = sc.nextLine();

		char c1 = input.charAt(0);
		int i = c1;
		char c2 = (char) (i + 1);

		System.out.println(c1 + " unicode : " + i);
		System.out.println(c2 + " unicode : " + (i + 1));
	}

	public void method2() {

		System.out.print("국어 : ");
		int ko = sc.nextInt();
		System.out.print("영어 : ");
		int en = sc.nextInt();
		System.out.print("수학 : ");
		int mat = sc.nextInt();

		int sum = ko + en + mat;
		System.out.println("총점 : " + sum);

		double avg = ((double) sum / 3);
		System.out.printf("평균 : %.2f", avg);
	}
}
