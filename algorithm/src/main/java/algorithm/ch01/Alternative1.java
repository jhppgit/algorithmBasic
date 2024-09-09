package algorithm.ch01;

import java.util.Scanner;

public class Alternative1 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("+ 와 - 를 번갈아 n개를 출력합니다.");
		int n;
		do {
			System.out.print("n값 : ");
			n = stdIn.nextInt();
		} while(n <= 0);
		
		for(int i = 0; i < n; i++) {
			if (i % 2 == 0)
				System.out.print("+");
			else
				System.out.print("-");
		}
	}
}
