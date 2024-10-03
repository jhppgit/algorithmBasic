package algorithm.ch06;

import java.util.Arrays;
import java.util.Scanner;

// 도수정렬 구현해보기
// a: 원본배열, f: 누적도수분포, b: 작업용 배열
public class CountingSort1 {
	static void countingSort(int[] a, int n, int max) {
		int[] f = new int[max + 1];
		int[] b = new int[n]; // 작업용 배열
		
		for (int i = 0; i < n; i++) f[a[i]]++; // 도수분포배열
		for (int i = 0; i < max; i++) f[i + 1] += f[i]; // 누적도수분포배열
		for (int i = n - 1; i >= 0; i--) b[--f[a[i]]] = a[i];
		for (int i = 0; i < n; i++) a[i] = b[i];
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("길이 : ");
		int n = stdIn.nextInt();
		int[] x = new int[n];
		for (int i = 0; i < n; i++)
			x[i] = (int)(Math.random() * 100);
		int max = x[0];
		stdIn.close();
		for (int i = 0; i < n; i++)
			if (max < x[i])
				max = x[i];
		System.out.println(Arrays.toString(x));
		countingSort(x, n, max);
		System.out.println(Arrays.toString(x));
	}
}
