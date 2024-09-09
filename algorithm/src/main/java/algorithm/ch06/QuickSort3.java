package algorithm.ch06;

import java.util.Arrays;
import java.util.Scanner;

import algorithm.ch04.IntStack;

// 퀵 정렬 개선
// 피벗값을 처음 중간 마지막 요소를 정렬 후 중간값으로.
// 가운뎃값과 마지막에서 하나 전 요소를 교환.
// a[left], a[right - 1], a[right]는 이미 정렬돼있으므로
// a[left + 1] ~ a[right - 2] 에 대해 정렬 수행.(pl++, pr -= 2)
public class QuickSort3 {
	// 스왑
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	// 처음 중간 마지막 요소를 정렬 후 중간 인덱스 반환
	static int sort3elem(int[] x, int a, int b, int c) {
		if (x[a] > x[b]) swap(x, a, b);
		if (x[b] > x[c]) swap(x, b, c);
		if (x[a] > x[b]) swap(x, a, b);
		return b;
	}
	
	// 퀵정렬(비재귀)
	static void quickSort(int[] a, int left, int right) {
		IntStack lStack = new IntStack(right - left + 1);
		IntStack rStack = new IntStack(right - left + 1);
		lStack.push(left);
		rStack.push(right);
		
		while(!lStack.isEmpty()) {
			int pl = left = lStack.pop();
			int pr = right = rStack.pop();
			int m = sort3elem(a, pl, (pl + pr) / 2, pr);
			int x = a[m];
			swap(a, m, right - 1);
			pl++;
			pr -= 2;
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
	
	// 재귀 퀵정렬
	static void quickSort2(int[] a, int left, int right) {
		int pl = left;
		int pr = right;
		int m = sort3elem(a, pl, (pl + pr) / 2, pr);
		int x = a[m];
		swap(a, m, right - 1);
		pl++;
		pr -= 2;
		
		do {
			while (a[pl] < x) pl++;
			while (a[pr] > x) pr--;
			if (pl <= pr)
				swap(a, pl++, pr--);
		} while (pl <= pr);
		
		if (left < pr)
			quickSort2(a, left, pr);
		if (pl < right)
			quickSort2(a, pl, right);
	}
	
	public static void main(String[] args) {
		System.out.print("길이 : ");
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		System.out.print("최댓값 : ");
		int max = stdIn.nextInt() + 1;
		int[] x = new int[n];
		for (int i = 0; i < n; i++) 
			x[i] = (int)(Math.random() * max);
		System.out.println(Arrays.toString(x));
		quickSort(x, 0, n - 1);
		System.out.println(Arrays.toString(x));
	}
	
}
