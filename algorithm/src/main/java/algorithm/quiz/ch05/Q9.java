package algorithm.quiz.ch05;

// 8퀸문제에서 print()를 수정해서 시각적으로 표현
public class Q9 {
	static boolean[] flagA = new boolean[8]; // 행
	static boolean[] flagB = new boolean[15]; // /
	static boolean[] flagC = new boolean[15]; // \
	static int[] pos = new int[8]; // 위치
	
	static void print() {
		for (int i = 0; i < 8; i++) {
			String str = "□ ".repeat(pos[i]) + "■ " + "□ ".repeat(7 - pos[i]);
			System.out.println(str);
		}
		System.out.println();
	}
	
	static void set(int i) {
		for (int j = 0; j < 8; j++) {
			if (flagA[j] == false && flagB[i + j] == false && flagC[i - j + 7] == false) {
				pos[i] = j;
				if (i == 7)
					print();
				else {
					flagA[j] = flagB[i + j] = flagC[i - j + 7] = true;
					set(i + 1);
					flagA[j] = flagB[i + j] = flagC[i - j + 7] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		set(0);
	}
}
