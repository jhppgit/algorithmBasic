package algorithm.ch05;

import java.util.Scanner;

// no개의 원반을 x번 기둥에서 y번 기둥으로 옮김
// 기둥 번호를 1, 2, 3
public class Hanoi {
	static int count = 0;
	static void move(int no, int x, int y) {
		count++;
		int another = 6 - x - y;
		if (no > 1)
			move(no - 1, x, another); // 6 - x - y : 중간기둥 (x와 y 가 아닌 기둥, 기둥 번호의 합이 6이므로)
		
		System.out.printf("원반[%d]을(를) %d번 기둥에서 %d번 기둥으로 옮김\n", no, x, y);
		
		if (no > 1)
			move(no - 1, another, y);
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("하노이의 탑");
		System.out.print("원반의 갯수 : ");
		int x = stdIn.nextInt();
		
		move(x, 1, 3); // x개를 1번에서 3번까지 다 옮겨라
		System.out.println("횟수 : " + count);
	}
}
