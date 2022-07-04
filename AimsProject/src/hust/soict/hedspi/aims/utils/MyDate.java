package hust.soict.hedspi.aims.utils;

import java.util.Scanner;

public class MyDate {
	// Khai báo thuộc tính
		private int day;
		private int month;
		private int year;
		
		String[] MONTH = {"January", "February",  "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		String[] DAY = {"first", "second",  "third", "fouth", "fifth", "sixth", "seventh", "eight", "ninth", "tenth", "eleventh", "twelfth", "thirteen", "fourteenth", "fifteenth", "sixteenth", "seventeenth", "eighteenth", "ninteenth", 
						"twentieth", "twenty-first", "twenty-second", "Twenty-third", "twenty-fourth", "twenty-fifth", "twenty-sixth", "twenty-seventh", "twenty-eighth", "twenty-ninth", "thirtieth", "thirty-first"};
		public int getMonthFromString(String month) {
			int i;
			for (i = 0; i < MONTH.length; i++) {
				if(MONTH[i].equals(month)){
	                break;
	            }
			}
			return i+1;
		}
		
		public int getDayFromStringNotNumber(String day) {
			int i;
			for (i = 0; i < DAY.length; i++) {
				if(DAY[i].equals(day)){
	                break;
	            }
			}
			return i+1;
		}
		
		public static String removeCharAt(String s, int pos) {
		      return s.substring(0, pos) + s.substring(pos + 1);
		   }
		// 18th -> 18 ; 1st -> 1; 2sd -> 2; 3td -> 3
		public int getDayFromString(String day) {
			
			String tmp = removeCharAt(day, day.length()-1);
			return Integer.parseInt(removeCharAt(tmp, tmp.length()-1));
		}
		// Constructors 
		public MyDate() {
			super();
			this.day = 0;
			this.month = 0;
			this.year = 0;
		}
		
		public MyDate(int day, int month, int year) {
			super();
			this.day = day;
			this.month = month;
			this.year = year;
		}
		
		// ví dụ data: "February 18th 2019"
		public MyDate(String data) {
			super();
			String str[] = data.split(" ");
			this.year = Integer.parseInt(str[2]);
			this.month = getMonthFromString(str[0]);
			this.day = getDayFromString(str[1]);
		}
		
		// their names instead of their values in number, such as “second”, “September”, “twenty nineteen”
		public MyDate(String day, String month, String year) {
			super();
			this.day = getDayFromStringNotNumber(day);
			this.month = getMonthFromString(month);
			this.year = Integer.parseInt(year);
		}
		
		// Phương thức set/get
		public int getDay() {
			return day;
		}
		public void setDay(int day) {
			if(day > 0 && day < 32)
				this.day = day;
			else {
				System.out.println("Invalid day!");
				this.day = 0;
			}
				
		}
		public int getMonth() {
			return month;
		}
		public void setMonth(int month) {
			if(month > 0 && month < 13)
				this.month = month;
			else {
				System.out.println("Invalid day!");
				this.month = 0;
			}
				
		}
		public int getYear() {
			return year;
		}
		public void setYear(int year) {
			if(year > 0)
				this.year = year;
			else {
				System.out.println("Invalid day!");
				this.year = 0;
			}
		}
		
		// các phương thức khác
		// print format d/m/yyyy
		 public void print() {
			 System.out.println(this.day + "/" + this.month + "/" + this.year);
		 }
		
		public void accept() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your date (format: August 3th 2001):\n");
			String strDate = sc.nextLine();
			MyDate tmp = new MyDate(strDate);
			this.day = tmp.day;
			this.month = tmp.month;
			this.year = tmp.year;
			
			sc.close();
		}
}
