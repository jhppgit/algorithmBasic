package algorithm.ch01;

import java.util.Scanner;

public class TwoDigits {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int no;
		
		System.out.println("2자리의 양수를 입력하세요.");
		
		do {
			System.out.println("no : ");
			no = stdIn.nextInt();
		} while (no > 99 || no < 10);
		
		System.out.println("변수 no값은 " + no + "가 되었습니다.");
	}
}
