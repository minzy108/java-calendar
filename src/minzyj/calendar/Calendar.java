package minzyj.calendar;

public class Calendar {

	private final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	public int getMaxDaysOfMonth(int year, int month) {
		if(isLeapYear(year)) {
			return LEAP_MAX_DAYS[month - 1];
		} else {
			return MAX_DAYS[month - 1];			
		}
	}

	/*
	 * - 1일의 요일을 입력받는다.
	 * - 출력한다.
	 * 
	 * 년도를 입력하세요.
	 * YEAR> 2017
	 * 달을 입력하세요.
	 * MONTH> 3
	 * 첫번째 요일을 입력하세요. (SU, MO, TU, WE, TH, FR, SA)
	 * WEEKDAY> WE
	 */

	public void printCalendar(int year, int month, int weekday) {
		System.out.printf("   <<%4d년 %2d월>> \n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");
		
		// print blank space
		for(int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}

		int maxDay = getMaxDaysOfMonth(year, month);
		int count = 7 - weekday;
		int delim = count < 7 ? count : 0;
		
		// print first line
		for(int i=1; i<= count; i++) {
			System.out.printf("%2d ", i);
		};
		System.out.println();
		
		// print from second line to last line
		count++;
		for (int i = count; i <= maxDay; i++) {
			System.out.printf("%2d ", i);
			if (i % 7 == delim) {
				System.out.println();
			}
		}
		System.out.println();
		

	}

}
