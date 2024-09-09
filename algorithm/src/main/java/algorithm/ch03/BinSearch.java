package algorithm.ch03;

import java.util.Scanner;

// 요솟수가 n개인 배열 a에서 key와 같은 요소를 이진 검색
public class BinSearch {
	static int binSearch(int[] a, int n, int key) {
		int pl = 0; // pointer left
		int pr = n - 1; // pointer right
		int count = 0;
		do {
			int pc = (pl + pr) / 2;
			
			if (a[pc] == key) { // pc로 한방에 찾았다면
				count ++;
				System.out.println("count = " + count);
				return pc;
			} else if(a[pc] < key) { // pc가 key값보다 작다면 목표가 뒷쪽 배열에 있으므로
				pl = pc + 1; // pl을 pc 오른쪽으로 옮긴다.
			} else { // pc가 key값보다 크다면 key가 배열 앞쪽에 있다
				pr = pc - 1;
			}
			count += 3;
		} while (!(pl > pr)); // 좌우 포인터가 교차한다면. (종료조건이므로 부정)
		
		return -1; // 반복문을 빠져나온다면 배열에 key값이 존재하지 않는다.
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int num = stdIn.nextInt();
		int[] x = new int[num];
		
		System.out.println("오름차순으로 입력하세요");
		
		System.out.print("x[0] : "); // 첫 요소 입력
		x[0] = stdIn.nextInt();
		
		for (int i = 1; i < num; i++) {
			do { // 오름차순인지 검사
				System.out.print("x[" + i + "] : ");
				x[i] = stdIn.nextInt();
			} while(!(x[i] >= x[i - 1])); // 앞의 요소보다 작거나 같으면 다시입력
		}
		
		System.out.print("검색할 값 : ");
		int key = stdIn.nextInt();
		
		int idx = binSearch(x, num, key);
		
		if (idx == -1)
			System.out.println(" 그 값의 요소가 없습니다.");
		else 
			System.out.println("그 값은 x[" + idx + "]에 있습니다.");
	}
}
