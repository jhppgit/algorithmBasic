package algorithm.ch02;

// 1000 이하의 소수를 나열하는 프로그램
public class PrimeNumber1 {
	public static void main(String[] args) {
		int counter = 0;
		
		for (int n = 2; n <= 1000; n++) { // n은 소수 후보
			int i;
			for (i = 2; i < n; i++) { // n을 i로 나눠본다
				counter++;
				if (n % i == 0) // 나누어 떨어지면 소수가 아님
					break;  // 반복 더이상 불필요
			}
			if (n == i) { // 마지막 까지 나누어지지 않음. i++ 후 조건식 통과 실패.
				System.out.println(n);
			}
		}
		System.out.println("나눗셈을 시행한 횟수 : " + counter);
	}
}
