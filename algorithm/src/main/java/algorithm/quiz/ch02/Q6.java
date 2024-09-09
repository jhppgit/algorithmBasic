package algorithm.quiz.ch02;

import java.util.Scanner;

public class Q6 {
	static int cardConv(int input, int radix, char[] chArr) {
		String dChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int digits = 0;
		int tempInput = input;
		
		do {
			System.out.printf("%2d|%8d", radix, input);
			if (digits != 0) {
				System.out.println(" ... " + (tempInput) % radix);
				tempInput /= radix;
			} else
				System.out.println();
			
			chArr[digits++] = dChar.charAt(input % radix);
			input /= radix;
			
			System.out.printf("%3s--------%n", "+");
		} while(input != 0);
		if (tempInput != 0) {
			System.out.printf("%11d", radix, input);
			System.out.println(" ... " + (tempInput) % radix);
		}
		
		for(int i = 0; i < digits / 2; i++) {
			char t = chArr[i];
			chArr[i] = chArr[digits - i - 1];
			chArr[digits - i - 1] = t;
		}
		
		//System.out.printf("%2d|%8d", radix, tempInput);
		do {
		} while(false);
		
		return digits;
	}
	
	public static void main(String[] args) {
		System.out.println("10진수를 기수 변환합니다.");
		Scanner stdIn = new Scanner(System.in);
		int input, radix, digits;
		char[] chArr = new char[32];
		do {
			System.out.print("변환하는 음이 아닌 정수 : ");
			input = stdIn.nextInt();
		} while (input < 0);
		
		do {
			System.out.print("어떤 진수로 변환할까요? (2 ~ 36) : ");
			radix = stdIn.nextInt();
		} while(radix < 2 || radix > 36);
		
		digits = cardConv(input, radix, chArr);
		System.out.print(radix + "진수로 ");
		for(int i = 0; i < digits; i++) {
			System.out.print(chArr[i]);
		}
		System.out.println("입니다.");
		
	}
}
