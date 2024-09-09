package algorithm.quiz.ch06;

import java.util.Arrays;
import java.util.Scanner;

// 버블정렬을 앞쪽부터 진행(뒷쪽부터 가장 큰 수가 쌓이도록)
public class Q1 {
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	static void bubbleSort(int[] a) {
		int n = a.length;
		for(int i = n - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				if (a[j] > a[j + 1]) swap(a, j, j + 1);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("길이 입력");
		int n = stdIn.nextInt();
		int[] x = new int[n];
		for(int i = 0; i < n; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}
		bubbleSort(x);
		System.out.println(Arrays.toString(x));
	}
}
