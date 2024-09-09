package algorithm.ch02;

// PrimeNumber1의 개선. 소수 배열을 만들어 다음 소수를 찾을 때 소수로만 검사
public class PrimeNumber2 {
	public static void main(String[] args) {
		int counter = 0; // 나눈 횟수
		int ptr = 0; // 찾은 소수의 횟수(배열의 길이)
		int[] prime = new int[500]; // 소수를 저장하는 배열
		
		prime[ptr++] = 2; // 2는 자명한 소수의 시작
		
		for (int n = 3; n <= 1000; n += 2) { // 3이상부터 검사 시작; 1000까지 검사; 짝수는 소수가 아니므로 2씩 추가
			int i;
			for (i = 1; i < ptr; i++) { // i를 배열의 인덱스로 사용 -> ptr(현재 배열에 채워진 소수의 수) 만큼만 검사
				counter++; // 나눗셈 횟수 추가
				if (n % prime[i] == 0) // n이 그보다 작은 소수로 나누어 떨어진다면
					break; // 검사 그만. 소수 아님
			}
			if (ptr == i) // 반복문을 빠져나왔다면
				prime[ptr++] = n; // 소수이므로 배열에 추가, 배열의 길이 ++			
		}
		for(int i = 0; i < ptr; i++) {
			System.out.println(prime[i]); // 소수 배열 출력
		}
		System.out.println("ptr : " + ptr);
		System.out.println("나눗셈을 수행한 횟수 : " + counter + ", 이전의 나눗셈 횟수는 78022");
	}
}
