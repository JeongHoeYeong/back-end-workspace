package com.kh.practice;

import java.util.Scanner;

class LoopPractice {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
			
		LoopPractice p = new LoopPractice();
		p.method6();

	}

    /*
        1. 사용자로부터 숫자(1~100) 1개가 입력되었을 때 카운트다운 출력하시오.
        사용자 입력 : 5
        5
        4
        3
        2
        1
     */
    public void method1() {
    	System.out.print("사용자 입력 : ");
    	int num = sc.nextInt();
    	if(num <= 100) {
    		for(int i = num; i>=1; i--) {
    			System.out.println(i);
    		}
    	}
    }

    // 2. 1+(-2)+3+(-4)+...과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100 이상 되는지 출력하시오.
    public void method2() {
    	int sum = 0;
    	int i = 0;
    	while(true) {
    		i++;
    		if(i % 2 == 0) {
    			sum -=i;
    		} else if (i % 2 != 0){
    			sum += i;
    		}
    		if(sum >= 100) {
    			System.out.println(i);
    			break;
    		}
    	}
    }

    /*
        3. 사용자로부터 문자열을 입력 받고 문자열에서 검색될 문자를 입력 받아 해당 문자열에 그 문자가 몇 개 있는지 개수를 출력하세요. 

        문자열 : banana
        문자 : a
        banana 안에 포함된 a 개수 : 3

    */
    public void method3() {
    	
    	int count = 0;
    	System.out.print("문자열 : ");
    	String str = sc.nextLine();
    	
    	System.out.print("문자 : ");
    	char ch = sc.nextLine().charAt(0); 	
    	
    	char [] arr = str.toCharArray();
    	
    	for(int i=0; i<=str.length()-1; i++) {
    		if(ch == arr[i]) {
    			count++;
    		}
    	}
		System.out.printf("%s 안에 포함된 %s 개수 : %d", str, ch, count);
    }

    /*
        4. 0이 나올 때까지 숫자를 출력하시오. (random 사용! 0 ~ 10)
        7
        3
        4
        2
        3
        4
        0
     */
    public void method4() {
    	while(true) {
    		int random = (int) (Math.random()*11);
    		System.out.println(random);
    		if(random == 0) {
    			break;
    		}
    	}
    }

    /*
        5. 주사위를 10번 굴렸을 때 각 눈의 수가 몇 번 나왔는지 출력하세요. (random 사용!)

        1 : 3
        2 : 2
        3 : 1
        4 : 0
        5 : 4
        6 : 0

     */
    public void method5() {
    	int one = 0;
    	int two = 0;
    	int three = 0;
    	int four = 0;
    	int five = 0;
    	int six = 0;
    	
    	for(int i=1; i<=10; i++) {
        	int random = (int) (Math.random()*6) + 1;
        	switch (random) {
        	case 1: ++one; break;
        	case 2: ++two; break;
        	case 3: ++three; break;
        	case 4: ++four; break;
        	case 5: ++five; break;
        	case 6: ++six; break;
        	}
    	}
    	System.out.println("1 : " + one);
    	System.out.println("2 : " + two);
    	System.out.println("3 : " + three);
    	System.out.println("4 : " + four);
    	System.out.println("5 : " + five);
    	System.out.println("6 : " + six);
    }

    /*
        6. 사용자의 이름을 입력하고 컴퓨터와 가위바위보를 하세요. 
        컴퓨터가 가위인지 보인지 주먹인지는 랜덤한 수를 통해서 결정하도록 하고, 사용자에게는 직접 가위바위보를 받으세요.
        사용자가 이겼을 때 반복을 멈추고 몇 번 이기고 몇 번 비기고 몇 번 졌는지 출력하세요.


        당신의 이름을 입력해주세요 : 김미경
        가위바위보 : 가위
        컴퓨터 : 가위
        김미경 : 가위
        비겼습니다.

        가위바위보 : 가위 
        컴퓨터 : 바위
        김미경 : 가위
        졌습니다 ㅠㅠ

        가위바위보 : 보
        컴퓨터 : 바위
        김미경 : 보
        이겼습니다 !
    */
    public void method6() {
    	boolean b = true;
    	System.out.print("당신의 이름을 입력해주세요 : ");
    	String name = sc.nextLine();
    	int win = 0;
    	int draw = 0;
    	int lose = 0;
    	
    	while(b) {
        	
        	System.out.print("가위바위보 : ");
        	String str = sc.nextLine();
        	
        	int random = (int) (Math.random()*3);
        		
        	switch(random) {
        	case 0:
        		System.out.println("컴퓨터 : 가위");
        		if(str.equals("가위")) {
        			System.out.printf("%s : %s\n", name, str);
        			System.out.println("비겼습니다.\n");
        			draw++;
        			break;
        		} else if(str.equals("바위")) {
        			System.out.printf("%s : %s\n", name, str);
        			System.out.println("이겼습니다 !\n");
        			b = false;
        			break;
        		} else if(str.equals("보")) {
        			System.out.printf("%s : %s\n", name, str);
        			System.out.println("졌습니다 ㅠㅠ\n");
        			lose++;
        			break;
        		}
        	case 1:
        		System.out.println("컴퓨터 : 바위");
        		if(str.equals("가위")) {
        			System.out.printf("%s : %s\n", name,str);
        			System.out.println("졌습니다 ㅠㅠ\n");
        			lose++;
        			break;
        		} else if(str.equals("바위")) {
        			System.out.printf("%s : %s\n", name, str);
        			System.out.println("비겼습니다.\n");
        			draw++;
        			break;
        		} else if(str.equals("보")) {
        			System.out.printf("%s : %s\n", name, str);
        			System.out.println("이겼습니다 !\n");
        			win++;
        			b = false;
        			break;
        		}
        	case 2:
        		System.out.println("컴퓨터 : 보");
        		if(str.equals("가위")) {
        			System.out.printf("%s : %s\n", name, str);
        			System.out.println("이겼습니다 !\n");
        			win++;
        			b = false;
        			break;
        		} else if(str.equals("바위")) {
        			System.out.printf("%s : %s\n", name, str);
        			System.out.println("졌습니다 ㅠㅠ\n");
        			lose++;
        			break;
        		} else if(str.equals("보")) {
        			System.out.printf("%s : %s\n", name, str);
        			System.out.println("비겼습니다.\n");
        			draw++;
        			break;
        		}
        	}
    	}
    	System.out.printf("이긴 횟수 : %s 비긴 횟수 : %s 진 횟수 : %s", win, draw, lose);
    }

}