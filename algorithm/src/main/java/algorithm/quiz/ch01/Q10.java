package algorithm.quiz.ch01;

import java.util.Scanner;

public class Q10 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("양수 입력");
		int input = stdIn.nextInt();
		int count = 0;
		do {
			input /= 10;
			count++;
//			System.out.println(input);
		} while(input != 0);
		System.out.println("그 수는 " + count + "자릿수 입니다.");
		stdIn.close();
	}
}
