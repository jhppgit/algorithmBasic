package algorithm.quiz.ch02;

import java.util.Arrays;

// 배열의 모든 요소를 다른 배열로 복사
public class Q4 {
	static void copy(int[] arr1, int[] arr2) { // b를 a로 복사
		for(int i = 0; i < arr2.length; i++) {
			arr1[i] = arr2[i];
		}
	}
	
	public static void main(String[] args) {
		int[] source = {1, 2, 3, 4, 5};
		int[] target = new int[source.length];
		System.out.println(Arrays.toString(source));
		copy(target, source);
		System.out.println(Arrays.toString(target));
	}
}
