package algorithm.ch06;

import java.util.Arrays;
import java.util.Scanner;

// 퀵정렬 과정을 출력
public class QuickSortV {
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	static void quickSort(int[] a, int left, int right) {
		int pl = left;
		int pr = right;
		int x = a[(pl + pr) / 2];
		
		System.out.printf("a[%d]~a[%d]: {", left, right);
		for (int i = left; i < right; i++)
			System.out.printf("%d ,", a[i]);
		System.out.printf("%d}\n", a[right]); // right는 배열의 길이가 아니라 마지막 인덱스다.
		
		do {
			while(a[pl] < x) pl++;
			while(a[pr] > x) pr--;
			if(pl <= pr)
				swap(a, pl++, pr--);
		} while (pl <= pr);
		
		if (left < pr) quickSort(a, left, pr); // 안만났다면 거기서 구간잡고 정렬해라
		if (pl < right) quickSort(a, pl, right);
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("길이 : ");
		int n = stdIn.nextInt();
		int[] x = new int[n];
		System.out.print("최댓값 : ");
		int max = stdIn.nextInt() + 1;
		stdIn.close();
		for (int i = 0; i < n; i++) 
			x[i] = (int)(Math.random() * max);
		System.out.println(Arrays.toString(x));
		quickSort(x, 0, n - 1);
		System.out.println(Arrays.toString(x));
	}
}
