package algorithm.quiz.ch01;

public class Q12 {
	public static void main(String[] args) {
		System.out.printf("%2s%3s", " ", "|");
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		
		System.out.print("----+-");
		for (int i = 0; i < 9; i++) {
			System.out.print("---");
		}
		System.out.println();
		
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%2d%3s", i, "|");
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%3d", i + j);
			}
			System.out.println();
		}
	}
}
