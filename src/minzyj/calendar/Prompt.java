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

	public void runPrompt() throws ParseException {
		printMenu();

		Scanner scan = new Scanner(System.in);
		Calendar cal = new Calendar();

		while (true) {
			System.out.println("명령 (1, 2, 3, h, q)");
			String cmd = scan.next();
			if (cmd.equals("1")) {
				cmdRegister(scan, cal);
			} else if (cmd.equals("2")) {
				cmdSearch(scan, cal);
			} else if (cmd.equals("3")) {
				cmdCal(scan, cal);
			} else if (cmd.equals("h")) {
				printMenu();
			} else if (cmd.equals("q")) {
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
		scan.nextLine();
		System.out.println("일정을 입력해 주세요.");
		text = scan.nextLine();
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
		String plan = "";
		try {
			plan = cal.searchPlan(date);
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.println("일정 검색 중 오류가 발생했습니다.");
		}
		System.out.println(plan);

	}

	public static void main(String[] args) throws ParseException {

		// 쉘 실행

		Prompt p = new Prompt();
		p.runPrompt();

	}

}
