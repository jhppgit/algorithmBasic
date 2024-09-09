package algorithm.quiz.ch05;

// 배열 a의 모든 요소의 최대공약수를 구하는 메서드 작성
public class Q3 {
	static int gcdArray(int[] a) {
		// a b c의 최대공약수는 gcd(gcd(a, b), c)
		int i = 2;
		int result = gcd(a[0], a[1]);
		if (a.length == 2)
			return result;
		while(i < a.length) {
			result = gcd(result, a[i++]);
		}
		return result;
	}
	
	static int gcd(int x, int y) {
		if (y == 0)
			return x;
		else
			return gcd(y, x % y);
	}
}
