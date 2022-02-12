package minzyj.calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

	public void printMenu() {
		System.out.println("+------------------+");
		System.out.println("| 1. 일정 등록 ");
		System.out.println("| 2. 일정 검색 ");
		System.out.println("| 3. 달력 보기 ");
		System.out.println("| h. 도움말 q. 종료 ");
		System.out.println("+-------------------+ ");
	}

	/**
	 * 1. switch case - String 2. Plan class - refactoring
	 */

	public int parseDay(String week) {
		switch (week) {
		case "SU":
			return 0;
		case "MO":
			return 1;
		case "TU":
			return 2;
		case "WE":
			return 3;
		case "TH":
			return 4;
		case "FR":
			return 5;
		case "SA":
			return 6;
		default:
			return 0;
		}
	}

	public void runPrompt() throws ParseException {
		printMenu();

		Scanner scan = new Scanner(System.in);
		Calendar cal = new Calendar();

		boolean isLoop = true;
		while (isLoop) {
			System.out.println("명령 (1, 2, 3, h, q)");
			String cmd = scan.next();
			switch (cmd) {
			case "1":
				cmdRegister(scan, cal);
				break;
			case "2":
				cmdSearch(scan, cal);
				break;
			case "3":
				cmdCal(scan, cal);
				break;
			case "h":
				printMenu();
				break;
			case "q":
				isLoop = false;
				break;
			}

		}

		System.out.println("GoodBye");
		scan.close();

	}

	private void cmdRegister(Scanner scan, Calendar cal) throws ParseException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd)");
		String date = scan.next();
		String text = "";
		System.out.println("일정을 입력해 주세요. (마지막에 ; 입력)");
		String word;
		while(!(word = scan.next()).endsWith(";")) {
			text += word + " ";
		}
		word = word.replace(";", "");
		text += word;
		cal.registerPlan(date, text);
	}

	private void cmdCal(Scanner scan, Calendar cal) {
		int month = 1;
		int year = 2017;

		System.out.println("년도를 입력하세요. (exit: -1)");
		System.out.print("YEAR> ");
		year = scan.nextInt();

		System.out.println("달을 입력하세요.");
		System.out.print("MONTH> ");
		month = scan.nextInt();
		if (month > 12 || month < 1) {
			System.out.println("잘못된 입력입니다.");
			return;
		}

		cal.printCalendar(year, month);

	}

	private void cmdSearch(Scanner scan, Calendar cal) {
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd)");
		String date = scan.next();
		PlanItem plan;
		plan = cal.searchPlan(date);
		if (plan != null) {
			System.out.println(plan.detail);
		} else {
			System.out.println("일정이 없습니다.");			
		}
		
	}

	public static void main(String[] args) throws ParseException {

		// 쉘 실행

		Prompt p = new Prompt();
		p.runPrompt();

	}

}
