package algorithm.quiz.ch05;

import java.util.Scanner;

// 팩토리얼을 재귀호출 없이 작성
public class Q1 {
	static int factorial(int x) {
		int result = 1;
		if (x < 0) {
			for (int i = x; i < 0; i++)
				result *= i;
			return result;
		}
		for (int i = 1; i <= x; i++)
			result *= i;
		return result;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int x = stdIn.nextInt();
		System.out.println(x + "! = " + factorial(x));
	}
}
