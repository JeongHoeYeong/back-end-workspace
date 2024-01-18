package com.kh.example.practice3;

import java.util.Scanner;

import com.kh.example.practice3.controller.EmployeeController;
import com.kh.example.practice3.model.Employee;

public class Application {

	Scanner sc = new Scanner(System.in);

	Employee viewEmployee = new Employee();

	EmployeeController employeeController = new EmployeeController();

	public static void main(String[] args) {
		boolean b = true;
		Application a = new Application();
		
		while (b) {
			switch (a.employeeMenu()) {
			case 1:
				a.insertEmp();
				break;
			case 2:
				a.updateEmp();
				break;
			case 3:
				a.printEmp();
				break;
			case 9:
				System.out.println("프로램을 종료합니다.");
				b = false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요~");
			}
		}

	}

	// 메인 메뉴를 출력
	public int employeeMenu() {
		System.out.println("1. 사원 정보 추가");
		System.out.println("2. 사원 정보 수정");
		System.out.println("3. 사원 정보 출력");
		System.out.println("9. 프로그램 종료");
		System.out.print("메뉴 번호를 누르세요 : ");
		int main = sc.nextInt();
		return main;
	}

	// 저장할 데이터를 사용자에게 받는 메서드
	public void insertEmp() {
		System.out.print("사원 번호 : ");
		int empNo = sc.nextInt();
		sc.nextLine();
		System.out.print("사원 이름 : ");
		String name = sc.nextLine();
		
		System.out.print("사원 성별 : ");
		char gender = sc.nextLine().charAt(0);
		
		System.out.print("전화 번호 : ");
		String phone = sc.nextLine();
		
		System.out.print("추가 정보를 더 입력하시겠습니까?(y/n) : ");
		char yn = sc.nextLine().charAt(0);
		if (yn == 'n') {
			employeeController.add(empNo, name, gender, phone);
		} else if (yn == 'y') {
			System.out.print("사원 부서 : ");
			String dept = sc.nextLine();
			System.out.print("사원 연봉 : ");
			int salary = sc.nextInt();
			System.out.print("사원 보너스 율 : ");
			double bonus = sc.nextDouble();
			employeeController.add(empNo, name, gender, phone, dept, salary, bonus);

		}
	}

	// 수정할 데이터를 사용자에게 바든 메서드
	public void updateEmp() {

		while (true) {
			System.out.println("사원의 어떤 정보를 수정하시겠습니까?");
			System.out.println("1. 전화 번호");
			System.out.println("2. 사원 연봉");
			System.out.println("3. 보너스 율");
			System.out.println("9. 돌아가기");
			System.out.print("메뉴 버튼을 누르세요 : ");
			int num = sc.nextInt();
			sc.nextLine();
			if (num == 1) {
				System.out.print("전화 번호 입력 : ");
				String phone = sc.nextLine();
				employeeController.modify(phone);
			} else if (num == 2) {
				System.out.print("사원 연봉 입력 : ");
				int salary = sc.nextInt();
				employeeController.modify(salary);
			} else if (num == 3) {
				System.out.print("보너스 율 입력 : ");
				int bonus = sc.nextInt();
				employeeController.modify(bonus);
			} else if (num == 9) {
				break;
			}
		}
	}
	//데이터를 출력하는 메서드
	public void printEmp() {
		System.out.println(employeeController.info());
	};
}
