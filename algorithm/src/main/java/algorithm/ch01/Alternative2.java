package algorithm.ch01;

import java.util.Scanner;

public class Alternative2 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("+ 와 - 를 번갈아 n개 출력합니다.");
		int n;
		do {
			System.out.print("n값: ");
			n = stdIn.nextInt();
		} while(n <= 0);
		int nHalf = n / 2;
		for (int i = 0; i < nHalf; i++) {
			System.out.print("+-");
		}
		if (n % 2 == 1)
			System.out.println("+");
	}
}
