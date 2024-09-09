package algorithm.quiz.ch05;

import java.util.Scanner;

// 유클리드 호제법을 재귀메서드 없이
public class Q2 {
	static int gcd(int x, int y) {
		int a = x; 
		int b = y;
		int temp1, temp2;
		while (true) {
			if (b == 0)
				return a;
			else {
				temp1 = a;
				a = b;
				b = temp1 % b;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("정수1 입력 : "); int x = stdIn.nextInt();
		System.out.print("정수2 입력 : "); int y = stdIn.nextInt();
		System.out.println("gcd(" + x + ", " + y + ") = " + gcd(x, y));
	}
}
