package algorithm.ch02;

// 제곱근보다 작은 수 까지만 나눠서 소수 검사
public class PrimeNumber3 {
	public static void main(String[] args) {
		int count = 0;
		int ptr = 0;
		int prime[] = new int[500];
		
		prime[ptr++] = 2;
		prime[ptr++] = 3;
		
		for (int n = 5; n <= 1000; n += 2) {
			boolean flag = false; // if문으로 반복이 끝났다면 true;
			
			for(int i = 1; prime[i] * prime[i] <= n; i++) {
				count += 2; // prime[i] 제곱과 아래의 n % prime[i] 두개의 연산을 하므로
				
				if(n % prime[i] == 0) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				prime[ptr++] = n;
				count++; // 반복문의 조건식에서 걸러질경우 조건검사에 곱하기 연산한 횟수를 여기서 반영
			}
		}
		
		for (int i = 0; i < ptr; i++) {
			System.out.println(prime[i]);
		}
		System.out.println("ptr : " + ptr + ", count : " + count);
	}
}
