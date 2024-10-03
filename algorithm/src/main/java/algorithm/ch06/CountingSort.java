package algorithm.ch06;

import java.util.Arrays;
import java.util.Scanner;

// 도수 정렬
public class CountingSort {
	static void countingSort(int[] a, int n, int max) {
		int[] f = new int[max + 1]; // 누적도수
		int[] b = new int[n]; // 작업용 목표배열
		
		for (int i = 0; i < n; i++) f[a[i]]++; // f를 도수분포배열로 만들기
		for (int i = 0; i < max; i++) f[i + 1] += f[i]; // f를 누적도수분포배열로 만들기
		for (int i = n - 1; i >= 0; i--) b[--f[a[i]]] = a[i]; // f로 원본 배열의 값에 해당하는 인덱스를 찾아 작업용 배열에 복사
		for (int i = 0; i < n; i++) a[i] = b[i]; // 원본 배열에 복사
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("길이 : ");
		int n = stdIn.nextInt();
		int[] x = new int[n];
		
		for (int i = 0; i < n; i++)
			x[i] = (int)(Math.random() * 200);
		
		int max = x[0];
		for (int i = 1; i < n; i++)
			if (max < x[i]) max = x[i];
		
		System.out.println(Arrays.toString(x));
		
		countingSort(x, n, max);
		
		System.out.println(Arrays.toString(x));
		
	}
}
