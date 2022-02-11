package minzyj.calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT = "cal> ";

	public void runPrompt() {
		Scanner scan = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month = 0;
		int year = 2017;
		
		while (true) {
			System.out.println("년도를 입력하세요.");
			System.out.print("YEAR> ");
			year = scan.nextInt();
			System.out.println("달을 입력하세요.");
			System.out.print("MONTH> ");
			
			month = scan.nextInt();
			if (month == -1) {
				break;
			}
			if (month > 12) {
				continue;
			}
			cal.printCalendar(year, month);
		}

		System.out.println("BYE");

		scan.close();

	}

	public static void main(String[] args) {

		// 쉘 실행

		Prompt p = new Prompt();
		p.runPrompt();

	}

}
