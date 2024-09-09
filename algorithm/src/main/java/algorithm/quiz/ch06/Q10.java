package algorithm.quiz.ch06;

import java.util.Arrays;
import java.util.Scanner;

// 셸정렬 버전1과 버전2의 이동횟수 출력 후 비교
public class Q10 {
	static int shellSort1(int[] a, int n) {
		int count = 0;
		for (int h = n / 2; h > 0; h /= 2) {
			for (int i = h; i < n; i++) {
				int j;
				int temp = a[i];
				for (j = i - h; j >= 0 && a[j] > temp; j -= h) {
					a[j + h] = a[j]; // 밀기
					count++;
				}
				a[j + h] = temp;
			}
		}
		return count;
	}
	
	static int shellSort2(int[] a, int n) {
		int count = 0;
		int h;
		for (h = 1; h * 3 + 1 < n; h = h * 3 + 1);
		
		for ( ; h > 0; h /= 3) {
			for (int i = h; i < n; i++) {
				int j;
				int temp = a[i];
				for (j = i - h; j >= 0 && a[j] > temp; j -= h) {
					a[j + h] = a[j];
					count++;
				}
				a[j + h] = temp;
			}
		}
		return count;
	}
	
	static int[] createArray(int[] a, int n) {
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = a[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.print("길이 : ");
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int[] x1 = new int[n];
		System.out.print("최댓값 : ");
		int max = stdIn.nextInt() + 1;
		
		for (int i = 0; i < n; i++) {
			x1[i] = (int)(Math.random() * max);
		}
		int[] x2 = createArray(x1, n);
		
		System.out.println("버전1 : " + Arrays.toString(x1));
		System.out.println("버전2 : " + Arrays.toString(x2));
		int count1 = shellSort1(x1, n);
		int count2 = shellSort2(x2, n);
		System.out.println("버전1 : " + Arrays.toString(x1));
		System.out.println("버전2 : " + Arrays.toString(x2));
		System.out.println("버전1 횟수 : " + count1);
		System.out.println("버전2 횟수 : " + count2);
	}
}
