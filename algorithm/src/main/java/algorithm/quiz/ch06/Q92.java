package algorithm.quiz.ch06;

import java.util.Arrays;

// 이진 삽입정렬 다시 해보기
public class Q92 {
	static int bSearch(int[] a, int from, int to, int key) {
		int pl = from;
		int pr = to;
		while(pl <= pr) {
			int pc = (pl + pr) / 2;
			if (a[pc] > key)
				pr = pc - 1;
			else 
				pl = pc + 1;
		}
		return pl;
	}
	
	static void insertionSort(int[] a) {
		int n = a.length;
		for (int i = 1; i < n; i++) {
			int temp = a[i];
			int idx = bSearch(a, 0, i - 1, temp);
			for (int j = i; j > idx; j--) { // [추정인덱스, 정렬 완료위치 + 1(시작위치)]
				a[j] = a[j - 1]; // 밀기
			}
			a[idx] = temp; // 밀고나서 집어넣기
		}
	}
	
	public static void main(String[] args) {
		int[] x = new int[16];
		for (int i = 0; i < x.length; i++) {
			x[i] = (int)(100 * Math.random());
		}
		System.out.println(Arrays.toString(x));
		insertionSort(x);
		System.out.println(Arrays.toString(x));
	}
}
