package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class TestPassingParameter {

	public static void main(String[] args) {

		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}
	
	public static void  swap(DigitalVideoDisc o1, DigitalVideoDisc o2) {
		DigitalVideoDisc tmp = new DigitalVideoDisc(o1.getTitle());
		o1.setTitle(o2.getTitle());
		o2.setTitle(tmp.getTitle());
	}
//	-> truyền giá trị thì chỉ có bản sao của giá trị o1 o2 đc swap-> khi hết hàm thì 2 obj ban đầu không thay đổi
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
//		System.out.println(oldTitle);
		dvd.setTitle(title);
//		System.out.println(oldTitle);
		dvd = new DigitalVideoDisc(oldTitle);
	}
//  -> dvd là biến ảo chứa địa chỉ nhưng khi dùng setTitle thì thay đổi title đc thực thi, nhưng sau khi kết thúc hàm thì giải phóng dvd.
	
}
