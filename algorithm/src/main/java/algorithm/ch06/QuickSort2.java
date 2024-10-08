package algorithm.ch06;

import java.util.Arrays;
import java.util.Scanner;

import algorithm.ch04.IntStack;

// 비재귀적으로 퀵정렬 구현
public class QuickSort2 {
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	static void quickSort(int[] a, int left, int right) {
		IntStack lStack = new IntStack(right - left + 1); // 담당하는 배열의 길이만큼
		IntStack rStack = new IntStack(right - left + 1);
		
		lStack.push(left);
		rStack.push(right);
		
		while(lStack.isEmpty() != true) {
			int pl = left = lStack.pop();
			int pr = right = rStack.pop();
			int x = a[(left + right) / 2];
			
			do {
				while (a[pl] < x) pl++;
				while (a[pr] > x) pr--;
				if (pl <= pr)
					swap(a, pl++, pr--);
			} while (pl <= pr);
			
			if (left < pr) {
				lStack.push(left);
				rStack.push(pr);
			}
			if (pl < right) {
				lStack.push(pl);
				rStack.push(right);
			}
		}
	}
	
	// 재귀퀵소트
	static void quickSortRecur(int[] a, int left, int right) {
		int pl = left;
		int pr = right;
		int x = a[(pl + pr) / 2];
		
		do {
			while (a[pl] < x) pl++;
			while (a[pr] > x) pr--;
			if (pl <= pr)
				swap(a, pl++, pr--);
		} while (pl <= pr);
		
		if (left < pr)
			quickSortRecur(a, left, pr);
		if (pl < right)
			quickSortRecur(a, pl, right);
	}
	
	static void quickSortNonrecur(int[] a, int left, int right) {
		IntStack lStack = new IntStack(right - left + 1);
		IntStack rStack = new IntStack(right - left + 1);
		
		lStack.push(left);
		rStack.push(right);
		
		while (!lStack.isEmpty()) {
			int pl = left = lStack.pop();
			int pr = right = rStack.pop();
			int x = a[(pl + pr) / 2];
			do {
				while (a[pl] < x) pl++;
				while (a[pr] > x) pr--;
				if (pl <= pr)
					swap(a, pl++, pr--);
			} while (pl <= pr);
			
			if (left < pr) {
				lStack.push(left);
				rStack.push(pr);
			}
			if (pl < right) {
				lStack.push(pl);
				rStack.push(right);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("길이 : ");
		int n = stdIn.nextInt();
		System.out.print("최댓값 : ");
		int max = stdIn.nextInt() + 1;
		stdIn.close();
		int[] x = new int[n];
		for (int i = 0; i < n; i++) 
			x[i] = (int)(Math.random() * max);
		System.out.println("전 : " + Arrays.toString(x));
		quickSortNonrecur(x, 0, n - 1);
		System.out.println("후 : " + Arrays.toString(x));
	}
}
