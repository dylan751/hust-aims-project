package hust.soict.hedspi.lab02;


import java.util.Scanner;

public class InputFromKeyboard {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// In thong bao vao doc dau vao
		System.out.println("Nhap ten cua ban: ");
		String strName = sc.nextLine();
		
		System.out.println("Nhap tuoi: ");
		int age = sc.nextInt();
		
		System.out.println("Nhap chieu cao (m): ");
		double dHeight = sc.nextDouble();
		
		System.out.println("Thong tin da nhap:");
		System.out.println("Ho va ten: " + strName + "\n"+
						   "Tuoi: " + age + "\n" +
						   "Chieu cao: " + dHeight + " m");
		
		sc.close();
		System.exit(0);
	}

}
