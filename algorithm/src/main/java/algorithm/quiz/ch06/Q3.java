package algorithm.quiz.ch06;

// Q2처럼 버블정렬(버전2)의 과정을 자세히 출력
public class Q3 {
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	static void bubbleSort(int[] a) {
		int n = a.length;
		int chTot = 0;
		int compTot = 0;
		for (int i = 0; i < n - 1; i++) {
			System.out.println("패스" + i + ":");
			int ch = 0; // 패스에서 교환횟수
			for (int j = n - 1; j > i; j--) {
				boolean flag = false;
				compTot++;
				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
					ch++;
					chTot++;
					flag = true;
				}
				for (int k = 0; k < n; k++) {
					if (k == j) {
						if (flag)
							System.out.printf(" +%2d", a[k]);
						else
							System.out.printf(" -%2d", a[k]);
					} else
						System.out.printf("%4d", a[k]);
				}
				
				
				flag = false;
				System.out.println();
			}
			for (int k = 0; k < n; k++) {
				System.out.printf("%4d", a[k]);
			}
			System.out.println();
			System.out.println();
			if (ch == 0) break;
		}
		System.out.println("비교를 " + compTot + "회 했습니다.");
		System.out.println("교환을 " + chTot + "회 했습니다");
	}

	public static void main(String[] args) {
		int[] x = {1, 3, 9, 4, 7, 8, 6};
		bubbleSort(x);
	}
}
