package algorithm.quiz.ch05;

import java.util.Scanner;
import java.util.Stack;

import algorithm.ch04.IntStack;

// recur3 메서드를 비재귀적으로 구현
public class Q6 {
	static void recur3(int n) {
		if (n > 0) {
			recur3(n - 1); // 1번
			recur3(n - 2); // 2번
			System.out.println(n); // 3번
		}
	}

	// 위의 함수를 재귀호출 없이 반복문으로 구현
	static void nonRecur3(int n) {
		IntStack nStack = new IntStack(n * 2); // 메서드에 전달될 인수 스택
		// sStack에서 0: 아무것도 안함, 1: 1번까지 완료, 2: 2번까지 완료.
		IntStack sStack = new IntStack(n * 2);
		int s = 0; // sStack에 들어가는 상태
		while (true) {
			if (n > 0) {
				nStack.push(n);
				sStack.push(s);
				if (s == 0) {
					n = n - 1; // 아무것도 안한 상태(0)라면 n - 1을 스택에 넣는다.
				} else if (s == 1) {
					n = n - 2; // 1번을 마친 상태(1)라면 n - 2를 할 차례
				}
				continue;
			}
			do { // n이 0보다 작을때만 여기까지 온다.
				n = nStack.pop(); // 0보다 작은건 의미 없으므로
				s = sStack.pop() + 1;
				
				if (s == 2) { // 2번까지 마쳤다면 
					System.out.println(n); // 출력
					if (nStack.isEmpty()) // 더이상 스택에 남은게 없다면
						return; // 종료
				}
			} while (s == 2); // s가 0에서 1로 올라갔다면 n과 s를 가지고 다시 메서드의 맨 위로, 1에서 2로 올라갔다면 출력. 다음것도 s가 2가 되면 계속 반복
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int x = sc.nextInt();
		sc.close();
		System.out.println("재귀");
		recur3(x);
		System.out.println("비재귀");
		nonRecur3(x);
	}
}
