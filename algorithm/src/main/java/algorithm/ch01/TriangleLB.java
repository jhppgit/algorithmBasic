package algorithm.ch01;

import java.util.Scanner;

// 직각이등변삼각형 출력하기 (왼쪽 아래가 직각)
public class TriangleLB {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n;
		System.out.println("왼쪽 아래가 직각인 이등변삼각형을 출력합니다.");
		
		do {
			System.out.print("몇단 삼각형입니까?");
			n = stdIn.nextInt();
		} while (!(n > 0)); // 종료조건의 부정
		
		for (int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++) { // i와 같은거까진 찍는다.
				System.out.print('*');
			}
			System.out.println();
		}
	}
}
