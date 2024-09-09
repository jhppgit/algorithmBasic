package algorithm.ch05;

public class QueenB {
	static int[] pos = new int[8]; // 각 열에 있는 퀸의 위치
	
	// 각 열에 있는 퀸의 위치를 출력 
	static void print() {
		for (int i = 0; i < 8; i++) 
			System.out.printf("%2d", pos[i]);
		System.out.println();
	}
	
	// i열에 퀸을 배치
	static void set(int i) {
		for (int j = 0; j < 8; j++) {
			pos[i] = j;
			if (i == 7) // 열의 끝이면
				print(); // 출력
			else // 중간이면
				set(i + 1); // i + 1로 재귀호출. 이 안에도 반복문이 있으니까 처음 대입
		}
	}
	
	public static void main(String[] args) {
		set(0); // 0열에 퀸을 배치
	}
}
