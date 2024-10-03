package algorithm.quiz.ch07;

import java.util.Scanner;

// 브루트포스로 앞쪽이 아니라 뒷쪽부터 검색
public class Q2 {
	static int bfMatchLast(String txt, String pat) {
		int pt = txt.length() - 1;
		int pp = pat.length() - 1;
		
		while(pt != 0 && pp != 0) {
			if (txt.charAt(pt) == pat.charAt(pp)) {
				pp--;
				pt--;
			} else {
				pt = pt + pp - 1;
				pp = pat.length() - 1;
			}
		}
		if (pp == 0)
			return pt - pp;
		
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		stdIn.close();
		String s1 = "ABCABABABABABCABABABC";
		String s2 = "ABC";
		int idx = bfMatchLast(s1, s2);
		System.out.println(idx + 1 + "번째 검색 완료");
	}
}
