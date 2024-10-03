package algorithm.ch06;

import java.util.Arrays;
import java.util.Scanner;

// 정렬을 마친 배열의 병합
public class MergeArray {
	static void merge(int[] a, int na, int[] b, int nb, int[] c) {
		int pa = 0;
		int pb = 0;
		int pc = 0;
		
		while (pa < na && pb < nb) // 작은쪽의 값을 c에 복사
			c[pc++] = (a[pa] <= b[pb]) ? a[pa++] : b[pb++];
		
		while (pa < na) // a에 남아있는 요소들을 c에 복사
			c[pc++] = a[pa++];
		while (pb < na) // b에 남아있는 요소들을 c에 복사
			c[pc++] = a[pb++];
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int[] a = {2, 4, 6, 8, 11, 13};
		int[] b = {1, 2, 3, 4, 9, 16, 21};
		int[] c = new int[13];
		
		System.out.println("두 배열을 병합");
		
		merge(a, a.length, b, b.length, c); // 배열 a와 b를 병합하여 c에 저장
		
		System.out.println("배열 a와 b를 병합하여 배열 c에 저장했습니다.");
		System.out.println("배열 a : " + Arrays.toString(a));
		System.out.println("배열 a : " + Arrays.toString(b));
		System.out.println("배열 a : " + Arrays.toString(c));
		
	}
}
