package algorithm.quiz.ch06;

// 단순선택정렬 과정을 자세하게 출력
// 맨 앞의 요소 위에 *, 정렬하지 않은 요소중 가장 작은 값의 요소 위에 +
// 단순선택정렬 : 아직 정렬이 안된 부분에서 최솟값을 찾아 정렬이 된 배열 맨 뒤에 추가
public class Q6 {
	// 교환
	static void swap(int[] a, int idx1, int idx2) { 
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	// 배열을 출력하는 메서드
	static void print(int[] a) { 
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%3d", a[i]);
		}
		System.out.println();
	}
	
	// 별은 안이뻐서 -로 대체. 교환하는 인덱스 위에 마크를 찍는 메서드
	static void printMark(int minMax, int min) { 
		String star = " ".repeat(3 * minMax + 2) + "-";
		String plus = " ".repeat(3 * min + 2 - (3 * minMax + 2 + 1)) + "+";
		System.out.println(star + plus);
	}
	
	// 선택정렬
	static void selectionSort(int[] a) {
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for(int j = i; j < n; j++) {
				if (a[min] > a[j])
					min = j;
			}
			printMark(i, min);
			print(a);
			System.out.println();
			swap(a, min, i);
		}
		System.out.println("정렬 완료");
		print(a);
	}
	
	public static void main(String[] args) {
		int[] x = {6, 4, 8, 3, 1, 9, 7};
		selectionSort(x);
	}
}
