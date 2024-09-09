package algorithm.quiz.ch05;

import java.util.Arrays;

import algorithm.ch04.IntStack;

// hanoi를 비재귀적으로 구현
public class Q8 {
	static void move(int n, int x, int y) {
		if (n > 1)
			move(n - 1, x, 6 - x - y);
		System.out.printf("[%d]번 원판을 %d기둥에서 %d기둥으로 옮김\n", n, x, y);
		if (n > 1)
			move(n - 1, 6 - x - y, y);
	}

	static void hanoi(int n, int x, int y) {
		IntStack xStack = new IntStack(n * 2);
		IntStack yStack = new IntStack(n * 2);
		IntStack sStack = new IntStack(n * 2);
		int s = 0; // 상태를 나타낸다. 0: 아무것도 안함 2: 다함

		while (true) {
			if (n > 1 && s == 0) {
				xStack.push(x);
				yStack.push(y);
				sStack.push(s);
				n--;
				y = 6 - x - y;
				continue;
			}
			System.out.printf("[%d]번 원판을 %d기둥에서 %d기둥으로 옮김\n", n, x, y);
			if (n > 1 && s == 1) {
				xStack.push(x);
				yStack.push(y);
				sStack.push(s);
				
				x = 6 - x - y;
			}
		}
	}

	

	public static void main(String[] args) {
		//test4(3, 1, 3);
	}

}
