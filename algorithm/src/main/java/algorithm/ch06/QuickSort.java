package algorithm.ch06;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1]; a[idx1] = a[idx2]; a[idx2] = temp;
	}
	
	// 퀵정렬
	static void quickSort(int[] a, int left, int right) {
		int pl = left; // 왼쪽 커서, left는 왼쪽 끝
		int pr = right;
		int x = a[(pl + pr) / 2];
		
		do {
			while(a[pl] < x) pl++; // 피봇값 보다 작은 값이라면 pl 그냥 진행, 같거나 큰값이면 대기
			while(a[pr] > x) pr--; // 피봇값보다 큰 값이라면 pr 그냥 진행, 작거나 같다면 거기서 대기
			if (pl <= pr) // 교차되지 않았다면
				swap(a, pl++, pr--); // 스왑하고 한칸 더 진행
		} while (pl <= pr);
		
		if (left < pr) quickSort(a, left, pr); // left == pr 이면 요소가 하나
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
		for (int i = 0; i < n; i++) {
			x[i] = (int)(Math.random() * max);
		}
		System.out.println(Arrays.toString(x));
		quickSort(x, 0, n - 1);
		System.out.println(Arrays.toString(x));
	}
}
