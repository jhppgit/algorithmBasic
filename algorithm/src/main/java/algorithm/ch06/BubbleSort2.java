package algorithm.ch06;

// 버블정렬(버전2)
public class BubbleSort2 {
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	static void bubbleSort(int[] a, int n) {
		for (int i = 0; i < n - 1; i++) {
			int exchg = 0; // 이번 패스에서 교환하는 횟수를 저장
			
			for (int j = n - 1; j > i; j--) { // 패스 하나
				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
					exchg++;
				}
			}
			if (exchg == 0) break; // 교환이 이루어지지 않으므로 멈춤
			
		}
	}
}
