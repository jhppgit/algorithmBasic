package algorithm.quiz.ch05;

import java.util.Scanner;

// 하노이 탑 메서드를 숫자가 아닌 기둥이름 문자열로 출력하도록 수정
public class Q7 {
	static void hanoiInt(int n, int x, int y) {
		int another = 6 - x - y; // x, y 가 아닌 다른 기둥(기둥 세개의 합은 1 + 2 + 3 == 6)
		
		// 그룹을 중간으로 옮기고
		if (n > 1) 
			hanoiInt(n - 1, x, another);
		
		// n == 1일때는 재귀가 필요 없으므로 문자열만 출력
		System.out.printf("[%d]번 원판을 [%d]번 기둥에서 [%d]번 기둥으로 옮겼습니다.\n", n, x, y);
		
		// 중간에
		if (n > 1)
		hanoiInt(n - 1, another, y);	
	}
	
	static void Q7(int n, int x, int y) {
		int another = 6 - x - y;
		String[] names = {"A", "B", "C"};
		if (n > 1)
			Q7(n - 1, x, another);
		System.out.printf("[%d]번 원판을 %s기둥에서 %s기둥으로 옮김.\n", n, names[x - 1], names[y - 1]);
		if (n > 1)
			Q7(n - 1, another, y);
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int n = stdIn.nextInt();
		hanoiInt(n, 1, 3);
		System.out.println("Q7");
		Q7(n, 1, 3);
	}

}
