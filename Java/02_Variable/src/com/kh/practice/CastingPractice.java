package com.kh.practice;

import java.util.Scanner;

public class CastingPractice {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		CastingPractice c = new CastingPractice();
		c.method2();
	}

	public void method1() {

		System.out.print("문자 : ");
		char ch = sc.nextLine().charAt(0);
		
		int num = ch;
		char ch2 = (char) (num + 1);

		System.out.println(ch + " unicode : " + num);
		System.out.println(ch2 + " unicode : " + (int)ch2);
	}

	public void method2() {

		System.out.print("국어 : ");
		int kScore = sc.nextInt();
		System.out.print("영어 : ");
		int eScore = sc.nextInt();
		System.out.print("수학 : ");
		int mScore = sc.nextInt();

		int sum = kScore + eScore + mScore;
		System.out.println("총점 : " + sum);

		double avg = ((double) sum / 3);
		System.out.printf("평균 : %.2f", avg);
	}
}
