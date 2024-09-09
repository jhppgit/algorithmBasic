package algorithm.quiz.ch01;

import java.util.Scanner;

public class Q13 {
	// 입력한 수를 한 변으로 하는 정사각형 * 로 그리기
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("정사각형을 출력합니다.");
		int sideLength;
		do {
			System.out.print("변의 길이");
			sideLength = stdIn.nextInt();
		} while (!(sideLength > 0)); // 종료조건
		
		for (int i = 0; i < sideLength; i++) {
			for(int j = 0; j < sideLength; j++) {
				System.out.printf("%3s","*");
			}
			System.out.println();
		}
		System.out.println();
		// repeat()써보기
		for (int i = 0; i < sideLength; i++) {
			System.out.println(" * ".repeat(sideLength));
		}
	}
}
