package algorithm.ch06;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 힙정렬
 *  - 힙을 사용한다
 *    - 힙 : 완전이진트리
 *      - 부모노드가 항상 자식보다 크다. -> 루트가 최댓값
 *      - 왼쪽부터 채운다.
 *  - 선택정렬인데 배열의 정렬되지 않은 부분중 최댓값을 힙을 통해 찾는다
 *  - 최댓값을 찾을 부분을 힙으로 만들고 루트를 가져와 배열의 맨 끝에 둔다.
 *  - 다시 남은 부분을 힙으로 만들고 위 최댓값을 찾는 행동을 반복한다.
 * 부모노드 : a[(i - 1) / 2]
 * 왼쪽자식 : a[i * 2 + 1]
 * 오른쪽자식 : a[i * 2 + 1]
 */
public class HeapSort {
	// 배열요소 a[idx1]과 a[idx2]의 값을 교환
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
	}
	
	/*
	 *  루트를 없애고 힙 상태를 유지하기
	 *  힙 상태에서 힙정렬을 위해 루트를 꺼내고 가장 마지막 요소와 교환된 상태(downHeap 메서드가 호출된 상태)
	 *  1. 루트부터 시작해서 큰 자식과 교환. (반복)
	 *  2. 부모의 값이 양쪽 자식 모두보다 크거나, 트리의 끝에 다다르면 종료
	 */
	// a[left] ~ a[right]를 힙으로 만듦
	// a[left]를 제외하고 나머지는 힙 상태를 유지한다고 가정.
	static void downHeap(int[] a, int left, int right) {
		int temp = a[left]; // 루트
		int child; // 큰 값을 갖는 자식
		int parent; // 부모
		
		// (트리의 시작부터; 자식이 있는 부모까지(잎에 다다랐다면); 반복문을 돌고 큰 자식을 부모에 대입)
		for (parent = left; parent < (right + 1) / 2; parent = child) {
			int cl = parent * 2 + 1; // 왼쪽자식
			int cr = cl + 1; // 오른쪽 자식
			//       오른쪽 자식이 있고, 오른쪽이 더 크다면
			child = (cr <= right && a[cr] > a[cl]) ? cr : cl; // 큰쪽을 자식에 대입
			
			// 자식중에서 루트 이상의 값을 찾았다면 반복문 탈출
			if (temp >= a[child])
				break;
			a[parent] = a[child];
		}
		a[parent] = temp;
	}
	
	// 힙정렬
	static void heapSort(int[] a, int n) {
		// 힙정렬을 위한 사전작업
		for (int i = (n - 1) / 2; i >= 0; i--) // a[i] ~ a[n - 1]을 힙으로 만듦 (힙이 아닌 배열을 힙으로 만든다)
			downHeap(a, i, n - 1); 
		
		for (int i = n - 1; i > 0; i--) { // i -> 정렬할 부분의 인덱스. 반복문을 돌고나면 정렬된 부분의 첫 인덱스.
			swap(a, 0, i); // 가장 큰 요소와 아직 정렬되지 않은 부분의 마지막 요소를 교환(루트가져오기)
			downHeap(a, 0, i - 1); // a[0] ~ a[i - 1]을 힙으로 만듦
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("힙 정렬");
		System.out.print("길이 : ");
		int n = stdIn.nextInt();
		System.out.print("최댓값 : ");
		int max = stdIn.nextInt() + 1;
		int[] x = new int[n];
		for (int i = 0; i < n; i++)
			x[i] = (int)(Math.random() * max);
		System.out.println(Arrays.toString(x));
		heapSort(x, n);
		System.out.println(Arrays.toString(x));
		stdIn.close();
	}
}
