package algorithm.quiz.ch01;

import java.util.Scanner;

public class Q09 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("a값 : ");
		int a = stdIn.nextInt();
		int b;
		do {
			System.out.print("b값 : ");
			b = stdIn.nextInt();
			if(b < a) {
				System.out.println("a보다 큰 값을 입력하세요!");
			}
		} while(b < a);
		
		System.out.println("b - a 는 " + (b - a) + "입니다.");
	}
}
