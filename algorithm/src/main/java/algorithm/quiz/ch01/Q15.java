package algorithm.quiz.ch01;

// 피라미드 출력
public class Q15 {
	public static void main(String[] args) {
		spira(5);
	}
	
	static void spira(int n) {
		for(int i = 1; i <= n; i++) { // i : [1, n]
			for (int j = 0; j < n - i; j++) { // 공백 n - i개
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * i - 1; j++) { // 별 2i - 1개
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
