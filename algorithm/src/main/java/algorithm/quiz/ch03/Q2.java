package algorithm.quiz.ch03;

import java.util.Scanner;

// 선형검색 과정을 시각적으로 표시
public class Q2 {
	static void printArr(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%3d", a[i]);
		}
		System.out.println();
	}
	
	static int lSearchSen(int[] a, int n, int key) {
		a[n] = key;
		int i = 0;
		int count = 0;
		boolean mark = true;
		
		System.out.print("   |");
		for(int j = 0; j <= n; j++)
			System.out.printf("%3d", j);
		System.out.println();
		System.out.print("---+" + "-".repeat(3 * (n + 1)) + "\n");
		
		while(true) {
			
			System.out.print("   |");
			System.out.print(" ".repeat(3 * i + 2));
			System.out.print("*\n");
	
			System.out.printf("%3d|", count);
			
			mark = !mark;
			printArr(a);
			if (a[i] == key)
				break;
			System.out.println("   |");
			i++;
			count++;
		}
		return i == n ? -1 : i;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("요솟수 : "); // num 받고
		int num = stdIn.nextInt();
		int[] x = new int[num + 1];
		
		for (int i = 0; i < num; i++) { // x 배열 받고
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}
			
		System.out.print("key : "); // 키 받고
		int key = stdIn.nextInt();
		
		stdIn.close(); // 스트림 닫고
		
		int idx =lSearchSen(x, num, key);
		
		if (idx == -1)
			System.out.println("값없음");
		else
			System.out.println("x[" + idx + "]에 있음.");
	}
}
