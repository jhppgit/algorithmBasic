package algorithm.quiz.ch06;

import java.util.Arrays;
import java.util.Scanner;

// 버블정렬 비교, 교환과정 출력. 교환수행 +, 비교만 -
// 비교횟수와 교환횟수 출력
public class Q2 {
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	static void bubbleSort(int[] a) {
		int n = a.length;
		int pointer;
		boolean flag = false; // true: 교환함
		for (int i = 0; i < n - 1; i++) {
			System.out.println("패스" + i);
			for (int j = n - 1; j > i; j--) {
				if (a[j - 1] > a[j]) {
					flag = true;
				}
				for (int k = 0; k < n; k++) {
					if (k == j) {
						if (flag)
							System.out.printf(" +%2d", a[k]);
						else
							System.out.printf(" -%2d", a[k]);
					} else {
						System.out.printf("%4d", a[k]);
					}
				}
				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
				}
				
				flag = false;
				System.out.println();
			}
			for (int k = 0; k < n; k++) {
				System.out.printf("%4d", a[k]);
			}
			System.out.println();
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		System.out.print("길이 입력 : ");
//		int n = stdIn.nextInt();
//		int[] x= new int[n];
//		for (int i = 0; i < n; i++) {
//			System.out.print("x[" + i + "] : ");
//			x[i] = stdIn.nextInt();
//		}
		int[] x = {6, 4, 3, 7, 1, 9, 8,};
		bubbleSort(x);
		System.out.println(Arrays.toString(x));
	}
}
