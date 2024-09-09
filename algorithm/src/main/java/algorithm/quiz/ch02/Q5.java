package algorithm.quiz.ch02;

import java.util.Arrays;

// 모든 요소를 역순으로 복사
public class Q5 {
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	static void reverse(int[] a) {
		for (int i = 0; i < a.length / 2; i++) {
			swap(a, i, a.length - i - 1);
		}
	}
	
	static void copy(int[] target, int[] source) {
		for (int i = 0; i < source.length; i++) {
			target[i] = source[i];
		}
	}
	
	static void rcopy(int[] target, int[] source) { // 복사 후 반전.
		copy(target, source);
		reverse(target);
		System.out.println("source : " + Arrays.toString(source));
		System.out.println("target : " + Arrays.toString(target));
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 7, 9};
		int[] arr2 = new int[arr.length];
		rcopy(arr2, arr);
	}
}
