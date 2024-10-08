package algorithm.ch06;

import java.util.Arrays;

// 버블정렬 (버전3)
public class BubbleSort3 {
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	static void bubbleSort(int[] a, int n) {
		int k = 0; // a[k]보다 앞쪽은 정렬을 마친상태
		while(k < n - 1) { // 마지막 요소는 정렬할 필요가 없으므로
			int last = n - 1; // 마지막으로 요소를 교환한 위치
			for (int j = n - 1; j > k; j--) { // j가 작아진다
				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
					last = j; // 마지막으로 교환한 인덱스 대입
				}
			}
			k = last; // 다음 반복문은 마지막으로 교환한 인덱스 다음까지 진행
		}
	}
	
	public static void main(String[] args) {
		int[] x = {1, 3, 9, 4, 7, 8, 6};
		bubbleSort(x, x.length);
		System.out.println(Arrays.toString(x));
	}
}
