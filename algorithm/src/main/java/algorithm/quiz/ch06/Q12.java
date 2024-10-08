package algorithm.quiz.ch06;

import java.util.Arrays;
import java.util.Scanner;

import algorithm.ch04.IntStack;

// 재귀, 비재귀 quickSort가 요솟수가 더 적은 그룹을 먼저 나누도록 작성
public class Q12 {
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	// 재귀
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
		if (lLen > rLen) {
			if (left < pr) quickSort1(a, left, pr);
			if (pl < right) quickSort1(a, pl, right);
		} else {
			if (pl < right) quickSort1(a, pl, right);
			if (left < pr) quickSort1(a, left, pr);
		}
	}
	
	// 비재귀
	static void quickSort2(int[] a, int left, int right) {
		IntStack lStack = new IntStack(right - left + 1);
		IntStack rStack = new IntStack(right - left + 1);
		lStack.push(left);
		rStack.push(right);
		
		while (!rStack.isEmpty()) {
			int pl = left = lStack.pop();
			int pr = right = rStack.pop();
			int x = a[(left + right) / 2];
			
			do {
				while (a[pl] < x) pl++;
				while (a[pr] > x) pr--;
				if (pl <= pr)
					swap(a, pl++, pr--);
			} while (pl <= pr);
			int lLen = pr - left;
			int rLen = right - pl;
			if (lLen > rLen) {
				if (lLen > 1) {
					lStack.push(left);
					rStack.push(pr);
				}
				if (rLen > 1) {
					lStack.push(pl);
					rStack.push(right);
				}
			} else {
				if (rLen > 1) {
					lStack.push(pl);
					rStack.push(right);
				}
				if (lLen > 1) {
					lStack.push(left);
					rStack.push(pr);
				}
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
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = (int)(Math.random() * max);
		System.out.println(Arrays.toString(a));
		quickSort2(a, 0, n - 1);
		System.out.println(Arrays.toString(a));
	}
}
