package hust.soict.hedspi.test.utils;

import hust.soict.hedspi.aims.utils.DateUtils;
import hust.soict.hedspi.aims.utils.MyDate;

public class DataTest {
	public static void main(String[] args) {
		// test các structors
		MyDate date1 = new MyDate("February 31th 2019");
		date1.print();
		MyDate date2 = new MyDate();
		date2.print();
		MyDate date3 = new MyDate(3, 8 ,2001);
		date3.print();
		
		// test các phương thức get/set
		System.out.println(date3.getDay());
		System.out.println(date3.getMonth());
		System.out.println(date3.getYear());
		
		date2.setDay(-12);
		date2.setDay(30);
		date2.setMonth(4);
		date2.setYear(2022);
		date2.print();
		
		// test accept()
		MyDate date4 = new MyDate();
		date4.accept();
		date4.print();
		
		//lab04 test
		// test method  MyDate(String day, String month,String year)
		MyDate date = new MyDate("third", "August", "2001");
		date.print(); // 3/8/2001
		
		// test method in DataUtils
		System.out.println("Compare this date with 3/8/2001");
		if(DateUtils.compareTwoDates(date4, date) == 0) {
			System.out.println("same date!");
		} else System.out.println("not same!");
		
	}
}
