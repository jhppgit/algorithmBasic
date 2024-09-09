package algorithm.quiz.ch02;

// 배열의 모든 요소의 합계를 구하는 메서드
public class Q3 {
	static int sumOf(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5}; // 합은 15
		System.out.println("합은 : " + sumOf(arr));
	}
}
