package algorithm.quiz.ch01;

// n단 숫자피라미드
public class Q16 {
	public static void main(String[] args) {
		npira(5);
	}
	
	static void npira(int n) {
		for (int i = 1; i <= n; i++) { // i: [1, n], i를 출력
			for(int j = 0; j < n - i; j++) { // 공백 n - i개
				System.out.print(" ");
			}
			for(int j = 0; j < 2 * i - 1; j++) { // 숫자 2i - 1개
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
