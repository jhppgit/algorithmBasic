package algorithm.ch05;

public class QueenBB {
	static boolean[] flag = new boolean[8];	// 각 행에 퀸을 이미 배치했는지 체크 (true: 배치됨)
	static int[] pos = new int[8];			// 각 열에 있는 퀸의 위치
	static int count = 0;
	
	static void print() {
		for (int i = 0; i < 8; i++) 
			System.out.printf("%2d", pos[i]);
		System.out.println();		
		count++;
	}
	
	static void set(int i) {
		for (int j = 0; j < 8; j++) {
			if(flag[j] == false) { // j행에 아직 퀸을 배치하지 않았다면
				pos[i] = j; // 퀸을 j행에 배치
				if (i == 7) // 모든 열에 배치했다면
					print(); // 출력
				else { // 아직 배치중이면
					flag[j] = true; // j행에 퀸을 배치했음 표시
					set(i + 1); // 다음 열에 배치
					flag[j] = false; // 다음 조합을 위해 false(재귀호출이므로)
				}
			}
		}
	}
	
	public static void main(String[] args) {
		set(0);
		System.out.println("조합의 수 : " + count);
	}
}
