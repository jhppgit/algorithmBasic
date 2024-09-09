package algorithm.quiz.ch03;

import java.util.Arrays;
import java.util.Scanner;

// Arrays.binarySearch() 를 사용해서 삽입포인트의 값을 출력하는 프로그램 작성
public class Q6 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("요솟수 : ");
		int n = stdIn.nextInt();
		int[] x = new int[n];
		System.out.println("오름차순으로 입력하세요.");
		System.out.print("x[0] : ");
		x[0] = stdIn.nextInt();
		for (int i = 1; i < n; i++) {
			do {
				System.out.print("x[" + i + "] : ");
				x[i] = stdIn.nextInt();
			} while(x[i] < x[i - 1]);
		}
		System.out.print("검색할 값 : ");
		int key = stdIn.nextInt();
		int idx = Arrays.binarySearch(x, key);
		if (idx < 0)
			System.out.println("삽입 포인트 : " + (-(idx + 1)));
		else
			System.out.println("인덱스 : " + idx);
	}
}
