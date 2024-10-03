package algorithm.ch06;

import java.util.Arrays;
import java.util.Scanner;

// Arrays.sort 메서드를 사용하여 정렬(퀵정렬)
public class ArraySortTester {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("길이 : ");
		int n = stdIn.nextInt();
		System.out.print("최댓값 ; ");
		int max = stdIn.nextInt() + 1;
		int[] x = new int[n];
		for (int i = 0; i < n; i++)
			x[i] = (int)(Math.random() * max);
		System.out.println(Arrays.toString(x));
		Arrays.sort(x);
		System.out.println(Arrays.toString(x));
	}
}
