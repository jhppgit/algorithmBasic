package algorithm.ch02;

import java.util.Arrays;
import java.util.Scanner;

// 배열의 순서 뒤집기
public class ReverseArray {
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	static void reverse(int[] a) {
		for (int i = 0; i < a.length / 2; i++) { // a.length로 하면 한 쌍에 대해 두번 스왑하므로 제자리
			swap(a, i, a.length - 1 - i);
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int num = stdIn.nextInt();
		
		int[] x = new int[num];
		
		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i +"] : ");
			x[i] = stdIn.nextInt();
		}
		
		reverse(x);
		
		System.out.println("요소를 역순으로 정렬했습니다.");
		System.out.println("x = " + Arrays.toString(x));
	}
}
