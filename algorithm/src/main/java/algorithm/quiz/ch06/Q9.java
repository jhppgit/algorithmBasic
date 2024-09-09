package algorithm.quiz.ch06;

import java.util.Arrays;

// 삽입정렬에 이진검색 도입 (이미 정렬된 부분에 사용)
public class Q9 {
	// pl이 추정위치다.
	static int binarySearch(int[] a, int from, int to, int key) {
		int pl = from;
		int pr = to;
		while(pr >= pl) {
			int pc = (pl + pr) / 2;
			if(a[pc] > key)
				pr = pc - 1;
			else
				pl = pc + 1;
		}
		
		return pl;
		
		
	}
	
	static int binarySearch(int[] a, int n, int key) {
		return binarySearch(a, 0, n, key);
	}
	
	static void insertionSort(int[] a) { // 쉽게 생각하자
		int n = a.length;
			
		for (int i = 1; i < n; i++) { // 비교할 대상
			int temp = a[i];
			int idx = binarySearch(a, i - 1, temp);
			for (int j = i; j > idx; j--)
				a[j] = a[j - 1];
			
			a[idx] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] x = {6, 4, 8, 5, 2, 9, 7};
		System.out.println(Arrays.toString(x));
		insertionSort(x);
		System.out.println(Arrays.toString(x));
	}
}
