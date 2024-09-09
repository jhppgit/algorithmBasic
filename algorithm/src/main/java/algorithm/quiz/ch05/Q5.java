package algorithm.quiz.ch05;

import java.util.Scanner;

// recur 메서드와 메모를 이용한 recurM 메서드에 호출횟수 카운트 추가
public class Q5 {
	static String[] memo;
	static int count;
	static int countM;
	
	static void reset() {
		memo = null;
		count = countM = 0;
	}
	
	static void printCount() {
		System.out.println("기존 재귀함수의 count : " + count);
		System.out.println("메모화 재귀함수의 count : " + countM);
	}
	
	static void recur(int n) {
		count++;
		if (n > 0) {
			recur(n - 1);
			System.out.println(n);
			recur(n - 2);
		}
	}
	
	static void recurM(int n) {
		countM++;
		if (memo[n + 1] != null) {
			System.out.print(memo[n + 1]);
		} else {
			if (n > 0) {
				recurM(n - 1);
				System.out.println(n);
				recurM(n - 2);
				memo[n + 1] = memo[n] + n + "\n" + memo[n - 1];
			} else {
				memo[n + 1] = "";
			}
		}	
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int x = stdIn.nextInt();
		memo = new String[x + 2];
		recur(x);
		System.out.println();
		recurM(x);
		printCount();
		stdIn.close();
		
	}

}
