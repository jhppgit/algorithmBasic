package algorithm.ch06;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import algorithm.ch04.IntStack;

public class MyMergeSort {
	static int[] buff;
	
	static void mergeSort(int[] a, int n) {
		buff = new int[n];
		mergeSort(a, 0, n - 1);
		buff = null;
	}
	
	static void mergeSort(int[] a, int left, int right) {
		if (left < right) {
			int i;
			int center = (left + right) / 2;
			int j = 0;
			int k = left;
			int p = 0;
			
			mergeSort(a, left, center);
			mergeSort(a, center + 1, right);
			
			for (i = left; i <= center; i++) 
				buff[p++] = a[i];
			
			while (i <= right && j < p)
				a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];
			
			while (j < p)
				a[k++] = buff[j++];
		}
	}
	
	static void merge(int[] a, int left, int right) {
		
	}
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("길이 : ");
		int n = stdIn.nextInt();
		System.out.print("최댓값 : ");
		int max = stdIn.nextInt() + 1;
		int[] x = new int[n];
		for (int i = 0; i < n; i++)
			x[i] = (int)(Math.random() * max);
		System.out.println(Arrays.toString(x));
		mergeSort(x, n);
		System.out.println(Arrays.toString(x));
	}
}
