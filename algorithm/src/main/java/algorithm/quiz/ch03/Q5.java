package algorithm.quiz.ch03;

import java.util.Scanner;

// 이진검색은 중복된 값이 있는 경우 가장 앞의 인덱스를 찾지 못한다.
// 찾도록 만들어라
public class Q5 {
	static int bSearchX(int[] a, int n, int key) {
		int pl = 0;
		int pr = n - 1;
		
		do {
			int pc = (pl + pr) / 2;
			
			if (a[pc] == key) {
				int idx = pc;
				while (idx - 1 >= 0 && a[idx - 1] == key)
					idx--;
				return idx;
			} else if (a[pc] < key) {
				pl = pc + 1;
			} else {
				pr = pc - 1;
			}
		} while (pr >= pl);
		
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("요솟수 : ");
		int n = stdIn.nextInt();
		System.out.print("x[0] : ");
		int[] x = new int[n];
		x[0] = stdIn.nextInt();
		for (int i = 1; i < n; i++) {
			do {
				System.out.print("x[" + i + "] : ");
				x[i] = stdIn.nextInt();
			} while (x[i] < x[i - 1]);
		}
		System.out.print("키값 : ");
		int key = stdIn.nextInt();
		int idx = bSearchX(x, n, key);
		if (idx == -1)
			System.out.println("요소가 없음.");
		else
			System.out.println("x[" + idx + "]에 키값이 존재");
	}
}
