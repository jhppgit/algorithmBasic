package algorithm.ch06;

import java.util.Arrays;
import java.util.Scanner;

public class ShellSort2 {
	static void shellSort(int[] a, int n) {
		int h;
		for (h = 1; h * 3 + 1 < n; h = h * 3 + 1); // h의 초깃값 구하기 n을 넘지 않는 가장 큰 값을 h에 대입
		// 조건식에 통과하지 못하게도면 이미 n 보다 h가 큰 상태이므로 다음 항이 n보다 크다면 반복문을 빠져나오도록 하기.
		System.out.println(h);
		
		for ( ; h > 0; h /= 3)
			for (int i = h; i < n; i++) {
				int j;
				int temp = a[i];
				for (j = i - h; j >= 0 && a[j] > temp; j -= h)
					a[j + h] = a[j];
				a[j + h] = temp;
			}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("요솟수 : ");
		int n = stdIn.nextInt();
		int[] x = new int[n];
		System.out.print("최댓값 : ");
		int max = stdIn.nextInt() + 1; 
		
		for (int i = 0; i < n; i++) {
			x[i] = (int)(Math.random() * max);
		}
		System.out.println(Arrays.toString(x));
		shellSort(x, n);
		System.out.println(Arrays.toString(x));
	}
}
