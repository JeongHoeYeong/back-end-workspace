package com.kh.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		ArrayPractice a = new ArrayPractice();
		a.method3();
	}
	/*
	 * 길이가 5인 배열을 선언하고 과일 5개로 초기화 한 후 본인이 좋아하는 과일 하나를 출력하세요. (과일 5개는 뭐든지~)
	 * 
	 * */
	public void method1() {
		
		String[] fruit = new String[5];
		fruit[0] = "사과";
		fruit[1] = "배";
		fruit[2] = "귤";
		fruit[3] = "오렌지";
		fruit[4] = "파인애플";
				
		
		System.out.println(fruit[1]);
	}
	
	/*
	 * 사용자에게 배열의 길이와 배열의 크기 만큼 사용자한테 입력 받은 값으로 초기화 한 후
	 * 각 입력 받은 값이 잘 들어갔는지 출력 후 저장된 값들의 합을 출력하세요.
	 * 
	 * 정수 : 5
	 * 배열 0번째 인덱스에 넣을 값 : 4
	 * 배열 1번째 인덱스에 넣을 값 : -4
	 * 배열 2번째 인덱스에 넣을 값 : 3
	 * 배열 3번째 인덱스에 넣을 값 : -3
	 * 배열 4번째 인덱스에 넣을 값 : 2
	 * [4, -4, 3, -3, 2]
	 * 2
	 * */
	public void method2() {
		
		int sum = 0;
		System.out.print("정수 : ");
		int[] arr = new int[sc.nextInt()];
		
		for(int i=0; i<=arr.length-1; i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(sum);
	}
	
	
	/*
	 * 음식 메뉴는 자유롭게! 개수도 자유롭게! 배열 사용해서
	 * 사용자가 입력한 값이 배열에 있으면 "배달 가능", 없으면 "배달 불가능"을 출력하세요.
	 * 
	 * */
	public void method3() {
		String[] arr = {"치킨", "떡볶이", "피자"};
		
		System.out.print("배달 메뉴 : ");
		String food = sc.nextLine();
		
		for(int i=0; i<arr.length; i++) {
			if(food.equals(arr[i])) {
				System.out.println("배달 가능");
				break;
			} else if(i == arr.length-1) {
				System.out.println("배달 불가능");
			}
		}
	}
	
	/*
	 * 
	 * 사용자에게 주민등록번호를 입력받아 성별자리 이후부터 *로 가리고 출력하세요.
	 * 단, 원본 배열은 건드리지 않고! 
	 * 
	 * 주민등록번호 : 123456-1234567
	 * 123456-1******
	 * 
	 * */
	public void method4() {
		
		char[] arr = new char[14];
		
		System.out.print("주민등록번호 : ");
		arr = sc.nextLine().toCharArray();
		char[] copy = arr.clone();
		
		if(arr.length==14 && arr[6] == '-') {
			for(int i=8; i<arr.length; i++) {
				copy[i] = '*';
			}
			System.out.println(copy);
		} else {
			System.out.println("잘못된 값");
		}
	}
	
	/*
	 * 사용자가 입력한 단어를 거꾸로 뒤집어서 출력하세요. 
	 * 
	 * 단어 입력 : programming
	 * gnimmargorp
	 * 
	 * */
	public void method5() {
		System.out.print("단어 입력 : ");
		char[] arr = sc.nextLine().toCharArray();
		char[] copy = new char[arr.length];
		
		for(int i = 0; i<arr.length; i++) {
			copy[(arr.length-1)-i] = arr[i];
		}
		System.out.println(copy);
	}
}
