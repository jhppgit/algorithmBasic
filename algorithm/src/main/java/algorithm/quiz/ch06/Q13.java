package algorithm.quiz.ch06;

import java.util.Arrays;
import java.util.Scanner;

import algorithm.ch04.IntStack;

// 퀵정렬은 요솟수가 적을때는 그다지 빠르지 않습니다. 나눈 그룹의 요솟수가 9 이하라면 단순삽입정렬
// 단순삽입정렬 : 카드정력
public class Q13 {
	static void swap(int[] a, int x, int y) {
		int t = a[x];
		a[x] = a[y];
		a[y] = t;
	}
	
	static void insertionSort(int[] a, int first, int last) {
		for (int i = first + 1; i < last + 1; i++) {
			int x = a[i];
			int j;
			for (j = i - 1; j >= 0 && a[j] > x; j--)
				a[j + 1] = a[j];
			a[j + 1] = x;
		}
	}
	
	static void quickSort1(int[] a, int left, int right) {
		int pl = left;
		int pr = right;
		int x = a[(pl + pr) / 2];
		do {
			while (a[pl] < x) pl++;
			while (a[pr] > x) pr--;
			if (pl <= pr) swap(a, pl++, pr--);
		} while (pl <= pr);
		int lLen = pr - left;
		int rLen = right - pl;
		if (lLen < 10)
			insertionSort(a, left, pr);
		else 
			if (left < pr) quickSort1(a, left, pr);
		if (rLen < 10)
			insertionSort(a, pl, right);
		else
			if (pr < right) quickSort1(a, pr, right);
	}
	
	static void quickSort2(int[] a, int left, int right) {
		IntStack lStack = new IntStack(right - left + 1);
		IntStack rStack = new IntStack(right - left + 1);
		lStack.push(left);
		rStack.push(right);
		while (!rStack.isEmpty()) {
			int pl = left = lStack.pop();
			int pr = right = rStack.pop();
			int x = a[(pl + pr) / 2];
			do {
				while (a[pl] < x) pl++;
				while (a[pr] > x) pr--;
				if (pl <= pr) swap(a, pl++, pr--);
			} while(pl <= pr);
			int lLen = pr - left;
			int rLen = right - pl;
			if (lLen < 10) {
				insertionSort(a, left, pr);
			} else if (lLen > 0) {
				lStack.push(left);
				rStack.push(pr);
			}
			if (rLen < 10) {
				insertionSort(a, pl, right);
			} else if (rLen > 0) {
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
		System.out.println(Arrays.toString(x));
		quickSort2(x, 0, n - 1);
		System.out.println(Arrays.toString(x));
	}
}
