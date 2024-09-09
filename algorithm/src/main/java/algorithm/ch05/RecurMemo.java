package algorithm.ch05;

import java.util.Scanner;

// 재귀함수를 메모화로 구현
// 어떤 문제에 대한 답을 구할 경우 그것을 메모해두고 같은 값으로 호출된 경우 메모에서 결과를 가져온다.
public class RecurMemo {
	static String[] memo;
	// 메모에 모든 경우의 수를 담아야 한다 -> n > 0 일 때 n - 2까지 가므로 -1 부터 시작
	// recur(-1) 의 결과를 memo[0]
	// -> memo의 인덱스가 n보다 1 크다.
	
	// 기존 재귀함수
	static void recurOrigin(int n) { 
		if (n > 0) {
			recurOrigin(n - 1);
			System.out.println(n);
			recurOrigin(n - 2);
		}
	}
	
	// 메모화를 도입한 recur 메서드
	static void recur(int n) { 
		if(memo[n + 1] != null) { // n의 해당하는 결과가 메모 배열에 있다면
			System.out.print(memo[n + 1]); // 메모를 출력 (다시 연산 안한다.)
		} else { // 메모에 없는 n이라면
			if (n > 0) {
				// 일단 원래 메서드를 실행은 한다.
				recur(n - 1);
				System.out.println(n);
				recur(n - 1);
				
				// n에 해당하는 메모는  n-1의 메모 + n의 값 + n-2의 메모
				memo[n + 1] = memo[n] + "n\n" + memo[n - 1]; // 메모에 저장
			} else {
				memo[n + 1] = ""; // n이 0보다 작다면(원래 메서드에서 출력하지 않는 값이라면(결과가 없다면)) 메모에 빈 문자열 저장
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int x = stdIn.nextInt();
		
		memo = new String[x + 2];
		recur(x);
	}
}
