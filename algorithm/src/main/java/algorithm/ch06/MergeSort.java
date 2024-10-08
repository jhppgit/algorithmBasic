package algorithm.ch06;

import java.util.Arrays;
import java.util.Scanner;

// 병합정렬
public class MergeSort {
	static int[] buff; // 작업용 배열
	
	static int[] mergeArray(int[] a, int na, int[] b, int nb) {
		int nc = na + nb;
		int[] c = new int[nc];
		int pa = 0;
		int pb = 0;
		int pc = 0;
		
		while(pa < na && pb < nb)
			c[pc++] = (a[pa] > b[pb]) ? b[pb++] : a[pa++];
		while (pa < na)
			c[pc++] = a[pa++];
		while (pb < nb)
			c[pc++] = b[pb++];
		
		return c;
	}
	
	// a[left] ~ a[right]를 재귀적으로 병합정렬
	static void __mergeSort(int[] a, int left, int right) {
		if (left < right) { // 배열의 길이가 1보다 크면
			int i; // 배열의 앞부분을 작업용 배열에 대입하는 반복문에 사용할 변수. 뒷부분에서 i를 받아서 바로 사용할 수 있으므로 반복문 밖에 선언
			int center = (left + right) / 2; // 앞부분과 뒷부분을 나누는 중앙값
			int p = 0; // 앞쪽 0배열의 길이
			int j = 0;
			int k = left;
			
			__mergeSort(a, left, center); // 배열의 앞부분을 병합정렬
			__mergeSort(a, center + 1, right); // 배열의 뒷부분을 병합정렬
			
			// 정렬된 두 부분 배열들을 병합정렬
			
			// 왼쪽 끝부터 중앙까지 -> 배열의 앞부분에 해당
			for (i = left; i <= center; i++) // i가 center + 1 까지 간다
				buff[p++] = a[i]; // 작업용 배열에 기존 배열의 앞부분을 대입
			
			while (i <= right && j < p) // i가 오른쪽 끝보다 작고, 
				a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];
			
			while (j < p)
				a[k++] = buff[j++];
		}
	}
	
	// 병합정렬
	static void mergeSort(int[] a, int n) {
		buff = new int[n]; // 작업용 배열을 생성
		
		__mergeSort(a, 0, n - 1); // 배열 전체를 병합정렬
		
		buff = null; // 작업용 배열을 해제
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("병합정렬");
		System.out.print("길이 : ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		System.out.print("최댓값 : ");
		int max = stdIn.nextInt() + 1;
		for (int i = 0; i < nx; i++)
			x[i] = (int)(Math.random() * max);
		System.out.println(Arrays.toString(x));
		mergeSort(x, nx);
		System.out.println(Arrays.toString(x));
	}
	
	
}
