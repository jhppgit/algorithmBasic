package algorithm.quiz.ch05;

import java.util.Arrays;

// 8퀸문제를 비재귀적으로 구현
public class Q10 {
	static int[] pos = new int[8];
	static boolean[] flagA = new boolean[8]; // 행 검사
	static boolean[] flagB = new boolean[15]; // /
	static boolean[] flagC = new boolean[15]; // \
	static int count = 0;
	
	static void print() {
		count++;
		System.out.println(Arrays.toString(pos));
	}
	
	static void printBoard() {
		print();
		for (int j = 0; j < 8; j++) { // 행
			for (int i = 0; i < 8; i++) { // 열
				if (pos[i] == j)
					System.out.print("■ ");
				else
					System.out.print("□ ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void Origin(int i) {
		for (int j = 0; j < 8; j++) {
			if(flagA[j] == false && flagB[i + j] == false && flagC[i - j + 7] == false) {
				pos[i] = j;
				if (i == 7)
					printBoard();
				else {
					flagA[j] = flagB[i + j] = flagC[i - j + 7] = true;
					Origin(i + 1);
					flagA[j] = flagB[i + j] = flagC[i - j + 7] = false;
				}
			}
		}
	}
	
	static void set() {
		
	}
	
	public static void main(String[] args) {
		System.out.println("시작");
		Origin(0);
		System.out.println("count : " + count);
	}
}
