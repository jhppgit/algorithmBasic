package algorithm.quiz.ch06;

import java.util.Arrays;

// 요소 삽입과정을 출력
// 주목요소 '아래' 에는 '+'
// 삽입요소 아래에는 '^'
// 그 사이에 ----
// 삽입하지 않는 경우에는 주목요소 아래에 +만
// 삽입정렬: 카드정렬
public class Q7 {
	// 배열 출력
	static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%3d", a[i]);
		}
		System.out.println();
	}
	
	static void printMark(final int i, final int j) {
		if (i == j)
			System.out.println(" ".repeat(3 * i + 2) + "+");
		else {
			String sel = " ".repeat(3 * j + 2) + "^";
			String loc = "-".repeat(3 * i + 1 - (3 * j + 2)) + "+";
			System.out.println(sel + loc);
		}
	}
	
	// 삽입정렬
	static void insertionSort(int[] a) {
		int n = a.length;
		for (int i = 1; i < n; i++) {
			int temp = a[i]; // 선택된 요소
			int j; // int j 를 for문 바깥으로 빼는 이유 : else문
			print(a);
			for (j = i; j > 0; j--) {
				if (a[j - 1] > temp) {
					a[j] = a[j - 1];
				} else { // 여기 넣으면 j > 0 조건에 의해 끝날 경우 else문을 만나지 않아 배열에 다시 대입되지 않는다
					// a[j] = temp;
					break;
				}
			}
			a[j] = temp;
			printMark(i, j);
		}
		print(a);
	}
	
	public static void main(String[] args) {
		int[] x = {6, 4, 8, 5, 1, 7, 9};
		insertionSort(x);
	}
	
}
