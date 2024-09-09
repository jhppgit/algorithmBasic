package algorithm.ch06;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 셸정렬
 * 셸은 사람이름이다.
 * 단순삽입정렬의 단점을 보완한 정렬.
 * 1 2 3 4 5 0 6 의 앞부분처럼 이미 정렬된 또는 정렬에 가까운 부분은 속도가 빠르고
 * 요소 0처럼 멀리 이동해야 하는 경우는 속도가 느리다.
 * h-정렬 : 전체 배열을 h개로 나눈다. h번째마다의 요소를 한 그룹으로
 * h-정렬을 반복해서 수행 후 거의 정렬된 상태로 마지막에 단순삽입정렬을 수행
 */
public class ShellSort {
	static void shellSort(int[] a) {
		int n = a.length;
		for (int h = n / 2; h > 0; h /= 2) { // h-정렬에서 h를 선택할 때 전체 길이의 절반으로 시작해서 1로 끝나게 반복문 설정
			for (int i = h; i < n; i++) { // h부터 n까지인 이유 : 삽입정렬이 그렇게함.
				int j;
				int temp = a[i];
				for (j = i - h; j >= 0 && a[j] > temp; j -= h) {
					a[j + h] = a[j];
				}
				a[j + h] = temp; // a[j + h]인 이유는 조건문을 통과하지 못해도 증감식은 적용되기 때문
			}
		}
	}
	
	static void shellSort2(int[] a) {
		int n = a.length;
		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = n - gap - 1; i < n; i++) {
				int temp = a[i];
				int j;
				for (j = i - gap; j >= 0 && a[j] > temp; j -= gap)
					a[j + gap] = a[j];
				a[j + gap] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.print("배열 길이 입력 :");
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int[] x = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = (int)(200 * Math.random());
		}
		System.out.println(Arrays.toString(x));
		shellSort2(x);
		System.out.println(Arrays.toString(x));
	}
}
