package algorithm.ch05;

import java.util.Scanner;

// 팩토리얼을 재귀적으로 구함
public class Factorial {
	static double factorial(double n) {
		if (n > 0)
			return n * factorial(n - 1);
		else
			return 1;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		double n = stdIn.nextDouble();
		
		System.out.println(n + "의 팩토리얼은 " + factorial(n) + "입니다.");
	}
}
