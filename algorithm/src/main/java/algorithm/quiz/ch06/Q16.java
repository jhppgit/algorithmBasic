package algorithm.quiz.ch06;

import java.util.Arrays;
import java.util.Scanner;

// downHeap 메서드 과정 트리형식으로 시각화하기  (아직 안함, 숙제)
public class Q16 {
	static void swap(int[] a, int x, int y) {
		
	}
	
	static void printTree(int[] a) {
		int n = a.length;
		int totFloor = 0;
		for (totFloor = 0; n < Math.pow(2, totFloor); totFloor++);
		totFloor--;
		if(n > 0) {
			System.out.print(0); // 공백을 입력
			/*      01 - 3
			 *     /  \ - 2
			      03   04 - 1
			     /  \    /  \
			    01  01  01  01
			 */
			System.out.println();
		}
		for (int i = 1; i <= totFloor; i++) { // i : 현재층, 1층부터 시작
			for (int j = (int)Math.pow(2, i - 1); j < Math.pow(2, i); j++) {
				
			}
		}
	}
	
	static void downHeap(int[] a, int left, int right) {
		
	}
	
	static void heapSort(int[] a, int n) {
		
	}
	
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("길이 : ");
		int n = stdIn.nextInt();
		System.out.print("최댓값 : ");
		int max = stdIn.nextInt() + 1;
		stdIn.close();
		int[] x = new int[n];
		for (int i = 0; i < n; i++)
			x[i] = (int)(Math.random() * max);
		System.out.println(Arrays.toString(x));
		heapSort(x, n);
		System.out.println(Arrays.toString(x));
	}
}
