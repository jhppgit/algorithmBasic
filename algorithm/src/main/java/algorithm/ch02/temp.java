package algorithm.ch02;

import java.util.Scanner;

public class temp {
	static int cardConv(int input, int radix, char[] chArr) {
		int digits = 0; // 자릿수
		String dChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		do {
			chArr[digits++] = dChar.charAt(input % radix);
			input /= radix;
		} while(input != 0);
		
		for (int i = 0; i < digits / 2; i++) {
			char t = chArr[i];
			chArr[i] = chArr[digits - i - 1];
			chArr[digits - i - 1] = t;
		}
		
		return digits;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int input;
		int radix;
		int digits;
		int retry;
		char[] chArr = new char[32];
		
		System.out.println("10진수를 기수변환합니다");
		do {
			do {
				System.out.print("변환하는 음이 아닌 정수 : ");
				input = stdIn.nextInt();
			} while (input < 0);
			
			do {
				System.out.print("어떤 진수로 변환할까요? (2 ~ 32) : ");
				radix = stdIn.nextInt();
			} while(!(2 <= radix) && (radix <= 32));
			
			digits = cardConv(input, radix, chArr);
			System.out.print(radix + "진수로 ");
			
			for(int i = 0; i < digits; i++) {
				System.out.print(chArr[i]);
			}
			System.out.println("입니다.");
			
			System.out.print("한번 더 할까요? 1 : 네, 0 : 아니오");
			retry = stdIn.nextInt();
		} while (retry == 1);
	}
}
