package algorithm.quiz.ch06;

import java.util.Arrays;
import java.util.Scanner;

import algorithm.ch04.IntStack;

// 퀵정렬의 인수를 두개 사용. 배열과 길이
// 오버라이딩?
public class Q14 {
	static void swap(int[] a, int x, int y) {
		int t = a[x];
		a[x] = a[y];
		a[y] = t;
	}
	
	// 오버라이딩?
	static void qSort(int[] a, int n, boolean recur) {
		if (recur)
			qSort1(a, 0, n - 1);
		else
			qSort2(a, 0, n - 1);
	}
	
	static void qSort1(int[] a, int left, int right) {
		int pl = left;
		int pr = right;
		int x = a[(pl + pr) / 2];
		do {
			while (a[pl] < x) pl++;
			while (a[pr] > x) pr--;
			if (pl <= pr) swap(a, pl++, pr--);
		} while (pl <= pr);
		if (left < pr) qSort1(a, left, pr);
		if (pl < right) qSort1(a, pl, right);
	}
	
	static void qSort2(int[] a, int left, int right) {
		IntStack lStack = new IntStack(right - left + 1);
		IntStack rStack = new IntStack(right - left + 1);
		
		lStack.push(left);
		rStack.push(right);
		while (!lStack.isEmpty()) {
			int pl = left = lStack.pop();
			int pr = right = rStack.pop();
			int x = a[(pl + pr) / 2];
			do {
				while(a[pl] < x) pl++;
				while(a[pr] > x) pr--;
				if (pl <= pr) swap(a, pl, pr);
			} while (pl <= pr);
			if (left < pr) {
				lStack.push(left);
				rStack.push(pr);
			}
			if (pl < right) {
				lStack.push(pl);
				rStack.push(pl);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("길이 : ");
		int n = stdIn.nextInt();
		System.out.print("최댓값 : ");
		int max = stdIn.nextInt() + 1;
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = (int)(Math.random() * max);
		System.out.println(Arrays.toString(a));
		qSort(a, n, false);
		System.out.println(Arrays.toString(a));
	}
}
