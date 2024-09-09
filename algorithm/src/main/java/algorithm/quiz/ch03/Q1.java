package algorithm.quiz.ch03;

import java.util.Scanner;

// 선형검색 보초법 for문으로 작성
public class Q1 {
	static int seqSearchSen(int[] a, int n, int key) {
		a[n] = key;
		int i = 0;
		for(;;i++) {
			if (a[i] == key)
				break;
		}
		return i == n ? -1 : i;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("요솟수 : ");
		int num = stdIn.nextInt();
		int[] x = new int[num + 1];
		for(int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		int key = stdIn.nextInt();
		
		int idx = seqSearchSen(x, num, key);
		if (idx == -1)
			System.out.println("값없다.");
		else 
			System.out.println("x[" + idx + "]에 있다.");
	}
}
