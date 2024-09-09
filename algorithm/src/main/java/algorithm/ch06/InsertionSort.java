package algorithm.ch06;

import java.util.Arrays;

// 단순 삽입정렬
public class InsertionSort {
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	// 아이디어로 구현해보기
	static void insertionSort1(int[]a) {
		// 카드를 정렬하는것과 같다
		// 자신의 왼쪽과 비교하고 자신보다 크다면 그 요소를 오른쪽으로 옮기고 다음 요소와 비교.
		// 작다면 그 자리에 대입
		int n = a.length;
		for (int i = 1; i < n; i++) {
			int temp = a[i];
			int j;
			for (j = i; j > 0; j--) { // a[j - 1]과 temp(선택된 값)를 비교하므로 i부터 시작 1까지, 왼쪽으로 가므로 --
				if(a[j - 1] > temp) { // 왼쪽이 크다면 (바꿔야 한다면)
					a[j] = a[j - 1]; // 오른쪽으로 밀기
				} else { // 자기 자리라면
					a[j] = temp;
					break;
				}
			}
			System.out.println(Arrays.toString(a) + " a[" + i + "] :" + temp);
		}
	}
	
	// 교재 내용
	static void insertionSort(int[] a, int n) {
		for (int i = 1; i < n; i++) {
			int j;
			int temp = a[i]; // 선택
			for (j = i; j > 0 && a[j - 1] > temp; j--) { // break 대신 자리를 옮기는 조건을 반복문 조건에 추가
				a[j] = a[j - 1]; // 뒤로 밀기
			}
			a[j] = temp; // 자기자리를 찾으면 (반복문 조건 통과 실패) a[j]에 선택된 값 대입
		}
	}
	
	public static void main(String[] args) {
		int[] x = {1, 4, 6, 7, 3, 9, 8};
		System.out.println("정렬 전 : " + Arrays.toString(x));
		insertionSort1(x);
		System.out.println("정렬 후 : " + Arrays.toString(x));
		
	}
}
