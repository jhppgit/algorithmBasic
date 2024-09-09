package algorithm.ch06;

// 단순 선택정렬
// 최솟값을 찾아서 아직 정렬이 안된 요소 중 가장 앞의 요소와 교환
public class SelectionSort {
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	static void selectionSort(int[] a, int n) {
		for (int i = 0; i < n - 1; i++) { // 패스, i는 이번 패스에 정렬해야 할 값, i 이전 요소들은 정렬됨
			int min = i; // 비교를 시작할 값
			for (int j = i + 1; j < n; j++) {
				if (a[j] > a[min])
					min = j; // 최솟값의 인덱스 저장
			}
			swap(a, i, min);
		}
	}

}
