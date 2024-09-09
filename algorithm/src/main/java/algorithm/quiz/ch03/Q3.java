package algorithm.quiz.ch03;

import java.util.Arrays;
import java.util.Scanner;

// 배열 idx에 key값과 일치하는 인덱스를 저장하고 갯수 반환
// static int searchIdx(int[] a, int n, int key, int[] idx)
public class Q3 {
	static int searchIdx(int[] a, int n, int key, int[] idx) {
		int j = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if(a[i] == key) {
				idx[j++] = i;
				count++;
			}
		}
		return count;
	} // 보초법 아님
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("요솟수: ");
		int n = stdIn.nextInt();
		int[] x = new int[n];
		int[] idx = new int[n];
		
		for (int i = 0; i < n; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}
		System.out.print("키값 : ");
		int key = stdIn.nextInt();
		int num = searchIdx(x, n, key, idx);
		stdIn.close();
		
		System.out.println("일치하는 요소의 수 : " + num);
		System.out.println("키값을 포함한 요소의 인덱스 배열 : " + Arrays.toString(idx));
	}
}
