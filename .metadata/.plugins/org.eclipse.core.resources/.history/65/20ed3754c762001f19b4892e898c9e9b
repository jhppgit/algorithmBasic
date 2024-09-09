package algorithm.ch01;

import java.util.Scanner;

public class GaussSum {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("1부터 n까지의 합을 구합니다");
		System.out.print("n의 값 : ");
		int n = stdIn.nextInt();
		
		int sum = sumof(n, 1);
		System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다.");
	}
	
	static int sumof(int a, int b) {
		int small = (a > b) ? b : a;
		int big = (a > b) ? a : b;
		int sum = 0;
		for (int i = small; i <= big; i++) {
			sum += i;
		}
		return sum;
	}
}
