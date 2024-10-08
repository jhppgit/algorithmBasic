package algorithm.quiz.ch06;

import java.util.Arrays;

// 단순 삽입정렬에서 배열의 맨 앞 요소인 a[0]를 사용하지 않고 데이터를 a[1]부터 저장하면
// a[0]를 보초로 ㅎ하여 삽입을 마치는 조건을 줄일 수 있습니다.
public class Q8 {
	// a[0]를 비운 배열을 반환. 길이는 + 1
	static int[] createSenti(int[] a) {
		int[] result = new int[a.length + 1];
		for(int i = 0; i < a.length; i++) {
			result[i + 1] = a[i];
		}
		System.out.println("변환 완료" + Arrays.toString(result));
		return result;
	}
	
	static int[] convertToOrigin(int[] a) {
		int[] result = new int[a.length - 1];
		for (int i = 0; i < result.length; i++) {
			result[i] = a[i + 1];
		}
		System.out.println("복원 완료" + Arrays.toString(result));
		return result;
	}
	
	static int[] insertionSort(int[] a) {
		// 종료조건을 줄인다.
		// 기존 종료조건? j == 0(끝까지 가기) or 선택된 요소보다 작은거 찾기
		int[] sent = createSenti(a);
		int n = a.length;
		for (int i = 2; i < n + 1; i++) {
			int j = i;
			sent[0] = sent[i];
			while(sent[j - 1] > sent[0]) { // 뽑은거랑 비교해야한다
				sent[j] = sent[j - 1];
				j--;
				System.out.println(Arrays.toString(sent));
			}
			sent[j]	= sent[0];
		}
		System.out.println(Arrays.toString(sent));
		return convertToOrigin(sent);
	}
	
	public static void main(String[] args) {
		int[] x = {6, 4, 8, 5, 1, 7, 9};
		System.out.println(Arrays.toString(x));
		x = insertionSort(x);
		System.out.println("결과 : " + Arrays.toString(x));
		
	}

}
