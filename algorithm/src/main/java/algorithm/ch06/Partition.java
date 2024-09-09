package algorithm.ch06;

import java.util.Arrays;
import java.util.Scanner;

// 퀵정렬을 위해 배열을 나눔
public class Partition {
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	static void partition(int[] a, int n) {
		int pl = 0; // 왼쪽커서
		int pr = n - 1; // 오른쪽 커서
		int x = a[n / 2]; // 피벗
		
		do {
			while(a[pl] < x) pl++;
			while(a[pr] > x) pr--;
			if (pl <= pr)
				swap(a, pl++, pr--); // 스왑하고 나서도 한번 더 진행
		} while (pl <= pr);
		
		System.out.println("피벗값은 " + x + "입니다.");
		
		System.out.println("피벗 이하의 그룹");
		for (int i = 0; i <= pl - 1; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
		if (pl > pr + 1) {
			System.out.println("피벗과 같은 그룹");
			for (int i = pr + 1; i <= pl - 1; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
		}
		
		System.out.println("피벗 이상의 그룹");
		for (int i = pr + 1; i < n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	// 한번 해봄
	static int p(int[] a, int n) {
		int pl = 0;
		int pr = n - 1;
		int x = a[n / 2];
		do {
			while(a[pl] < x) pl++;
			while(a[pr] > x) pr--;
			if (pl <= pr)
				swap(a, pl++, pr--);
		} while (pl <= pr);
		return pl;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("배열을 나눕니다.");
		System.out.print("길이 : ");
		int n = stdIn.nextInt();
		int[]x = new int[n];
		System.out.print("최댓값 : ");
		int max = stdIn.nextInt() + 1;
		
		for (int i = 0; i < n; i++) {
			x[i] = (int)(max * Math.random());
		}
		System.out.println(Arrays.toString(x));
		partition(x, n);
		stdIn.close();
	}
}
