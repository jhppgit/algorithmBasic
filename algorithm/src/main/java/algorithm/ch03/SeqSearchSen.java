package algorithm.ch03;

import java.util.Scanner;

// 보초법 적용(선형검색)
public class SeqSearchSen {
	static int seqSearchSen(int[] a, int n, int key) {
		int i = 0;
		
		a[n] = key; // 보초 넣기
		
		while(true) {
			if(a[i] == key) // 종료조건은 하나만
				break;
			i++; // break가 위에 있으므로. a[i++] 사용 안함
		}
		return i == n ? -1 : i; // 끝까지 갔다면(보초를 만났다면) -1 아니면 i
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int num = stdIn.nextInt();
		
		int[] x = new int[num + 1]; // 보초자리
		
		for (int i = 0; i < num; i++) { // 값 입력받기
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		int key = stdIn.nextInt();
		
		int idx = seqSearchSen(x, num, key);
		
		if (idx == -1) // 
			System.out.println("그 값의 요소가 없습니다.");
		else 
			System.out.println("그 값은 x[" + idx + "]에 있습니다.");
	}
}
