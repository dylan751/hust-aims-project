public class JavaFundamentals {

	public static void main(String[] args) {
		//1. Chu y khi tinh toan voi kieu so thuc
		System.out.println(2.0 - 1.1);
		System.out.println(5.0 - 4.9);
		
		//2. lenh printf
		System.out.printf("%.2f\n", 2.0 - 1.1);
		
		//3. khai bao hang trong Java
		final double PI = 3.14159;
		final long MICROS = 24*60*60*1000*1000;
		final long MILLIS = 24*60*60*1000;
		System.out.println(PI);
		System.out.println(MICROS / MILLIS); // 5 ????
		
		//4. luu y font chu
		System.out.println(12345 + 5432l); // l dung sau ep kieu long
		
		//5. luu y chuyen doi kieu
		System.out.println((int) (char) (byte) - 1); //65535 ??
		
		//6. char va string trong phep cong 
		System.out.println("H" + "a"); // Ha
		System.out.println('H' + 'a'); // 169
		
		System.out.println(1 + 2 + "3"); // 33
		System.out.println("1" + 2 + 3); // 123 -> String
		
		//7. ki tu kieu char trong java la unicode
		
		char a = '\u0061';
		System.out.println(a);
		ch\u0061r b = 'b';
		System.out.println(b);
	}

}
