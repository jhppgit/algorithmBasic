package algorithm.ch05;

// 8퀸 문제풀이
public class EightQueen {
	static boolean[] flagA = new boolean[8]; // 각 행에 퀸을 배치했는지 체크 (행)
	static boolean[] flagB = new boolean[15]; // /대각선 방향으로 퀸을 배치했는지 체크(양수대각선)
	static boolean[] flagC = new boolean[15]; // \대각선 방향으로 퀸을 배치했는지 체크(음수대각선)
	static int[] pos = new int[8];
	static int count = 0;
	
	// 각 열에 있는 퀸의 위치를 출력 
	static void print() {
		for (int i = 0; i < 8; i++) 
			System.out.printf("%2d", pos[i]);
		System.out.println();
		count++;
	}
	
	// i열에 알맞은 위치에 퀸을 배치
	static void set(int i) { // 파라미터는 i열에 관련
		for (int j = 0; j < 8; j++) { // 반복문은 j행에 관련
			if (flagA[j] == false &&			// 가로(j행)에 아직 배치되지 않음
				flagB[i + j] == false &&		// /대각선에 아직 배치되지 않음 (i + j가 같은 위치들의 모임: /대각선)
				flagC[i - j + 7] == false) {	// \대각선에 아직 배치되지 않음 (제일 작은 대각선 번호가 0이 되야 하므로 i - j + 7)
				pos[i] = j; // j행에 배치
				if (i == 7)
					print();
				else {
					// 각 flag배열에 해당하는 인덱스 확인하기
					flagA[j] = flagB[i + j] = flagC[i - j + 7] = true; // 배치했으니까 true
					set(i + 1); // 다음열 호출
					flagA[j] = flagB[i + j] = flagC[i - j + 7] = false; // 이번 메서드에선 다 썼으므로 다음 경우의 수 계산을 위해 false
				}
			}
		}
	}
	
	public static void main(String[] args) {
		set(0);
		System.out.println("조합의 수 : " + count);
	}
}
