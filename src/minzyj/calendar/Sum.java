package minzyj.calendar;

import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
		
		// 입력: 키보드로 두 수의 입력을 받는다.
		// 출력: 두 수의 합을 출력한다.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("두 수를 입력하세요.");
		
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		
		
		System.out.printf("%d와 %d의 합은 %d입니다.",num1, num2, num1+num2 );
		
		scan.close();
	}

}
