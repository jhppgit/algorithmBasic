package algorithm.quiz.ch06;

import java.util.Arrays;
import java.util.Scanner;

// 요솟수의 범위가 min 이상 max 이하, 요솟수가 n개인 배열 a를 정렬하는 메서드 작성
public class Q18 {
	static int findMin(int[] a) {
		int min = a[0];
		for (int i = 0; i < a.length; i++)
			if (min > a[i])
				min = a[i];
		return min;
	}
	
	static int findMax(int[] a) {
		int max = a[0];
		for (int i = 0; i < a.length; i++)
			if (max < a[i])
				max = a[i];
		return max;
	}
	static void countingSort(int[] a) {
		int n = a.length;
		int max = findMax(a);
		int min = findMin(a);
		int len = max - min + 1;
		//System.out.println("min : " + min + ", max : " + max + ", len : " + len);
		int[] f = new int[len + 1]; // min이 0, max가 len
		int[] b = new int[n];
		
		for (int i = 0; i < n; i++) f[a[i] - min]++;
		for (int i = 0; i < len; i++) f[i + 1] += f[i];
		for (int i = n - 1; i >= 0; i--) b[--f[a[i] - min]] = a[i];
		for (int i = 0; i < n; i++) a[i] = b[i];
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("길이 : ");
		int n = stdIn.nextInt();
		System.out.println("최댓값, 최솟값이 배열에 포함되지 않을 수 있습니다.");
		System.out.print("최댓값 : ");
		int max = stdIn.nextInt();
		System.out.print("최솟값 : ");
		int min = stdIn.nextInt();
		stdIn.close();
		int[] x = new int[n];
		for (int i = 0; i < n; i++)
			x[i] = (int)(Math.random() * (max - min) + min);
		System.out.println(Arrays.toString(x));
		countingSort(x);
		System.out.println(Arrays.toString(x));
	}
}
