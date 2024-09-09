package algorithm.ch01;

import java.util.Scanner;

public class PrintStar2 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n, w;
		System.out.println("n개 한줄에 w개");
		do {
			System.out.print("n : ");
			n = stdIn.nextInt();
		} while (n <= 0);
		
		do {
			System.out.print("w : ");
			w = stdIn.nextInt();
		} while (w <= 0 || w > n);
		
		for (int i = 0; i < n / w; i++) {
			System.out.println("*".repeat(w));
		}
		int rest = n % w;
		if (rest != 0) {
			System.out.println("*".repeat(rest));
		}
	}
}
