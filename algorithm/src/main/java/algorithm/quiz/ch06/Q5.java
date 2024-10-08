package algorithm.quiz.ch06;

import java.util.Arrays;

/*
 * 9 1 3 4 6 7 8 은 두번째 요소부터 정렬되어있다.
 * 버전 3의 알고리즘으로는 빠른시간안에 정렬할 수 없다.
 * 	홀수번째 패스는 가장 작은요소를 맨 앞으로 옮기고
 * 	짝수번째 패스는 가장 큰 요소를 맨 뒤로 옮기는 방식을 사용(패스의 스캔 방향을 교대로 바꾸기)
 * 버블정렬 버전3를 수정하기
 * -> 양방향 버블정렬, 칵테일정렬, 셰이커정렬
 */
public class Q5 {
	static int[] exchange = {0, 0}; // 0번이 기존, 1번이 칵테일
	static int[] compare = {0, 0}; // "
	static int[] pass = {0, 0};
	
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	static void bubbleSort(int[] a) {
		int k = 0; // k 이전까진 정렬 완료
		int n = a.length;
		while(k < n - 1) { // 정렬 완료된 요소의 인덱스가 배열의 끝 - 1 일때까지 반복(정렬 완료시까지)
			pass[0]++;
			int last = n - 1; // 마지막으로 비교된 인덱스
			for (int j = n - 1; j > k; j--) {
				compare[0]++;
				if (a[j - 1] > a[j]) {
					exchange[0]++;
					swap(a, j - 1, j);
					last = j;
				}
			}
			k = last;
		}
	}
	
	static void cocktailSort(int[] a) { // 패스에따라 두 경우로 나눠서 진행
		int n = a.length;
		int kf = 0; // kf 이전까지 정렬 완료
		int kr = n - 1; // kr 이후로 정렬 완료
		while(kf <= kr) {
			pass[1]++;
			if (pass[1] % 2 == 1) { // 홀수번째 패스일 때
				int last = n - 1;
				for (int j = n - 1; j > kf; j--) {
					compare[1]++;
					if (a[j - 1] > a[j]) {
						exchange[1]++;
						swap(a, j - 1, j);
						last = j;
					}
				}
				kf = last;
				
			} else { // 짝수번째 패스일 때
				int first = 0;
				for (int j = 1; j < kr; j++) {
					compare[1]++;
					if (a[j - 1] > a[j]) {
						exchange[1]++;
						swap(a, j - 1, j);
						first = j;
					}
				}
				kr = first;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] x1 = {9, 1, 3, 4, 6, 7, 8};
		int[] x2 = Arrays.copyOf(x1, x1.length);
		System.out.println("기존 x1 : " + Arrays.toString(x1));
		bubbleSort(x1);
		System.out.println("정렬 x1 : " + Arrays.toString(x1));
		System.out.println("패스 : " + pass[0] + "  비교 : " + compare[0] + "  교환 : " + exchange[0]);
		
		System.out.println();
		
		System.out.println("기존 x2 : " + Arrays.toString(x2));
		cocktailSort(x2);
		System.out.println("정렬 x2 : " + Arrays.toString(x2));
		System.out.println("패스 : " + pass[1] + "  비교 : " + compare[1] + "  교환 : " + exchange[1]);
	}
}
