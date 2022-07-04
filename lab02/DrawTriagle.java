import java.util.Scanner;

public class DrawTriagle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhap chieu cao cua tam giac:");
		int h = sc.nextInt();
		
		for(int i = 1; i <= h; i++) {
			for(int j = 1; j <= h - i; j++) {
				System.out.print(" ");
			}
			for(int j = 1; j <= 2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		sc.close();
		System.exit(0);
	}

}
