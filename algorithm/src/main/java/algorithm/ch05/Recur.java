package algorithm.ch05;

import java.util.Scanner;

import algorithm.ch04.IntStack;

// 재귀함수 이해
public class Recur {
	// 재귀함수
	static void recur(int n) {
		if (n > 0) {
			recur(n - 1);
			System.out.print(n + " ");
			recur(n - 2);
		}
	}
	
	// 재귀 꼬리를 제거 - 꼬리에 있는 재귀는 변수를 바꿔서 메서드의 상단으로 올라가면 된다. (반복문)
	static void recur2(int n) {
		while (n > 0) {
			recur2(n - 1);
			System.out.print(n + " ");
			n -= 2;
		}
	}
	
	// 스택을 이용해 남은 하나의 재귀호출도 제거. 재귀호출, 메서드 내부에서 사용되는 변수를 스택에 잠시 저장
	static void recur3(int n) {
		IntStack s = new IntStack(n);
		
		while (true) {
			if (n > 0) { // sysout 못만나는 애들 스택에 우르르 집어넣기
				s.push(n); // n 값을 스택에 잠시 저장
				n--; // recur(n - 1); 이였으므로
				continue; // 재귀호출 하나를 했으므로 변경된 변수를 가지고 while문의 처음으로 돌아간다.
			}
			if (s.isEmpty() != true) { // 스택이 비어있지 않다면
				n = s.pop(); // 저장해뒀던 값 꺼내서
				System.out.println(n); // n 출력 (원래 메서드 두번째 동작)
				n -= 2; // n - 2
				continue; // recur()
			}
			break; // if문을 두개 다 통과하면 반복 종료
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		recur(stdIn.nextInt());
	}
}
