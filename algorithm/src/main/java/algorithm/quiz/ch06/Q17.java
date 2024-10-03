package algorithm.quiz.ch06;

import java.util.Arrays;
import java.util.Scanner;

// 도수정렬의 각 단계를 출력
public class Q17 {
	static int[] aa;
	static int[] ff;
	static int[] bb;
	
	static int findMax(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++) 
			if (max < a[i]) max = a[i];
		return max;
	}
	
	static void print(int[] a, int[] f, int[] b) {
		System.out.println("a : " + Arrays.toString(a));
		System.out.println("f : " + Arrays.toString(f));
		System.out.println("b : " + Arrays.toString(b));
		System.out.println();
	}
	
	static void print() {
		print(aa, ff, bb);
	}
	
	static void setArrays(int[] a, int[] f, int[] b) {
		aa = a; ff = f; bb = b;
	}
	
	static void countingSort(int[] a) {
		int max = findMax(a);
		int n = a.length;
		int[] f = new int[max + 1];
		int[] b = new int[n];
		setArrays(a, f, b);
		
		for (int i = 0; i < n; i++) f[a[i]]++;
		System.out.println("도수분포");
		print();
		for (int i = 0; i < max; i++) f[i + 1] += f[i];
		System.out.println("누적도수분포");
		print();
		for (int i = n - 1; i >= 0; i--) b[--f[a[i]]] = a[i];
		System.out.println("b에 값 입력");
		print();
		for (int i = 0; i < n; i++) a[i] = b[i];
		System.out.println("복사");
		print();
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("길이 : ");
		int n = stdIn.nextInt();
		int[] x = new int[n];
		for (int i = 0; i < n; i++) x[i] = (int)(Math.random() * 20);
		System.out.println(Arrays.toString(x));
		countingSort(x);
		System.out.println(Arrays.toString(x));
	}
	
	

}
