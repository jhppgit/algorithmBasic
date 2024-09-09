package algorithm.quiz.ch06;

import java.util.Arrays;
import java.util.Scanner;

import algorithm.ch04.IntStack;

// 비재귀 퀵정렬을 수정하여 푸시, 팝, 나누는 과정을 출력
public class Q11 {
	static final String PUSH = "push";
	static final String POP = "pop";
	
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	static int sort3(int[] x, int a, int b, int c) {
		if (x[a] > x[b]) swap(x, a, b);
		if (x[b] > x[c]) swap(x, b, c);
		if (x[a] > x[b]) swap(x, a, b);
		return b;
	}
	
	static void quickSort(int[] a, int left, int right) {
		IntStack lStack = new IntStack(right - left + 1);
		IntStack rStack = new IntStack(right - left + 1);
		
		lStack.push(left);
		rStack.push(right);
		System.out.println("lStack push : " + left + "  " + lStack.toString());
		System.out.println("rStack push : " + right + "  " + rStack.toString());
		System.out.println();
		
		while (!lStack.isEmpty()) {
			int pl = left = lStack.pop();
			int pr = right = rStack.pop();
			System.out.println("lStack pop : " + left + "  " + lStack.toString());
			System.out.println("rStack pop : " + right + "  " + rStack.toString());
			System.out.println();
			int m = sort3(a, pl, (pl + pr) / 2, pr);
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
				System.out.println("lStack push : " + left +  "  "+ lStack.toString());
				System.out.println("rStack push : " + pr + "  " + rStack.toString());
				System.out.println();
			}
			if (pl < right) {
				lStack.push(pl);
				rStack.push(right);
				System.out.println("lStack push : " + pl + "  " + lStack.toString());
				System.out.println("rStack push : " + right + "  " + rStack.toString());
				System.out.println();
			}
		} 
		
	}
	
	static void quickSort2(int[] a, int left, int right) {
		int pl = left;
		int pr = right;
		int m = sort3(a, pl, (pl + pr) / 2, pr);
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
		quickSort(a, 0, n - 1);
		System.out.println(Arrays.toString(a));
	}

}
