package algorithm.quiz.ch06;

import java.util.Arrays;

// 버블정렬 버전3의 과정 출력
public class Q4 {
	static int exchange = 0;
	static int compare = 0;
	static void swap(int[] a, int idx1, int idx2) {
		exchange++;
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	static void bubbleSort(int[] a, int n) {
		int k = 0; // 정렬 완료된 요소 이전 요소의 인덱스 (a[k - 1]까지 정렬 완료)
		int pass = 0;
		while(k < n - 1) {
			System.out.println("패스 " + ++pass + ":");
			int last = n - 1; // 마지막으로 정렬된 요소의 인덱스
			for (int j = n - 1; j > k; j--) {
				boolean flag = false; // 비교면 false, 교환이면 true
				compare++;
				
				if (a[j - 1] > a[j]) { // 출력을 위해 비교
					flag = true;
				}
				
				for (int l = 0; l < n; l++) { // 한줄 출력
					if (l == j) {
						if (flag) { // 교환했다면
							System.out.printf(" +%2d", a[l]);
						} else { // 비교만 했다면
							System.out.printf(" -%2d", a[l]);
						}
					} else { // 비교하지 않은 요소들은
						System.out.printf("%4d", a[l]);
					}
				}
				System.out.println();
				
				if (a[j - 1] > a[j]) { // 실제 교환을 위해 비교
					swap(a, j - 1, j);
					last = j;
				}
				
			}
			for (int l = 0; l < n; l++) {
				System.out.printf("%4d", a[l]);
			}
			System.out.println();
			k = last;
		}
	}
	
	public static void main(String[] args) {
		int[] x = {1, 3, 9, 4, 7, 8, 6};
		System.out.println("정렬 전 : " + Arrays.toString(x));
		bubbleSort(x, x.length);
		System.out.println("정렬 후 : " + Arrays.toString(x));
		System.out.println("비교를 " + compare + "회 했습니다.");
		System.out.println("교환을 " + exchange + "회 했습니다.");
	}
}
