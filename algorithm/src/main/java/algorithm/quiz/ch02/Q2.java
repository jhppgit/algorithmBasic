package algorithm.quiz.ch02;

import java.util.Arrays;

// 역순 정렬 과정을 출력
public class Q2 {
	static void swap(int[] arr, int idx1, int idx2) {
		int t = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = t;
	}
	
	static void reverse(int[] arr) {
		for(int i = 0; i < arr.length / 2; i++) {
			System.out.println(Arrays.toString(arr));
			System.out.println("arr[" + i + "]과 arr[" + (arr.length - i - 1) + "]을 교환합니다.");
			swap(arr, i, arr.length - i - 1);
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("역순 정렬을 마쳤습니다.");
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 5, 1, 3, 9, 7, 6};
		reverse(arr);
	}
}
