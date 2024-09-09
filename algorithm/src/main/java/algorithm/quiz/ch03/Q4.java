package algorithm.quiz.ch03;

import java.util.Scanner;

// 이진탐색 과정 출력 첫요소 <-, 끝요소 ->, 중앙요소 +
public class Q4 {
	static void printArr(int[] a) { // 배열 출력 후 줄바꿈
		int n = a.length;
		for (int i = 0; i < n; i++) {
			System.out.printf("%3d", a[i]);
		}
		System.out.println();
	}
	
	static int bSearch(int[] a, int n, int key) {
		int pl = 0;
		int pr = n - 1;
		
		System.out.print("   |");
		for (int i = 0; i < n; i++) { // 인덱스 입력
			System.out.printf("%3d", i);
		}
		System.out.println();
		
		System.out.println("---+-" + "---".repeat(n));
		
		do {
			
			
			int pc = (pl + pr) / 2; // 목표: 각 3칸씩, p1공간 =  p1 * 3칸 + 2칸, p2공간 = 
			int plS = pl * 3;
			int pcS = pc * 3 - plS - 1; // 화살표 크기
			int prS = pr * 3 - plS - pcS - 2; // 화살표크기 더하기크기
			if (pcS >= 0 && prS >= 0) {
				System.out.println("   | " + " ".repeat(plS) +"<-" + " ".repeat(pcS) + "+" + " ".repeat(prS) + "->");
				System.out.printf("%3d|", pc);
			} else if (pcS < 0 && prS >= 0) {
				System.out.println("   | " + " ".repeat(plS) +"<*" + " ".repeat(prS) + "->");
				System.out.printf("%3d|", pc);
			} else if (pl == pr) {
				System.out.println("   | " + " ".repeat(plS) +" *");
				System.out.printf("%3d|", pc);
			}
			printArr(a);
			
			if (a[pc] > key)
				pr = pc - 1;
			else if (a[pc] < key)
				pl = pc + 1;
			
			
			if (a[pc] == key) 
				
				return pc;
		} while (pr >= pl);
		
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("요솟수 : ");
		int n = sc.nextInt();
		System.out.println("오름차순으로 입력");
		System.out.print("x[0] : ");
		int[] x = new int[n];
		x[0] = sc.nextInt();
		for (int i = 1; i < n; i++) {
			do {
				System.out.print("x[" + i + "] : ");
				x[i] = sc.nextInt();
			} while(x[i] < x[i - 1]);
		}
		System.out.print("키 입력 : ");
		int key = sc.nextInt();
		int idx = bSearch(x, n, key);
		if (idx == -1)
			System.out.println("배열에 키값이 존재하지 않습니다.");
		else
			System.out.println(key + "는 x[" + idx + "] 에 있습니다."); 
		sc.close();
	}
}
