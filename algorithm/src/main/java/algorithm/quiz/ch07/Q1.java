package algorithm.quiz.ch07;

import java.util.Scanner;

// 브루트포스법의 검색과정을 자세하게 출력
public class Q1 {
	static int count = 0;
	
	static int bfMatch(String txt, String pat) {
		int pp = 0;
		int pt = 0;
		int spacer = 0;
		
		while(pt != txt.length() && pp != pat.length()) { // 끝에 갈때까지 반복
			count++;
			if (txt.charAt(pt) == pat.charAt(pp)) {
				if (pp == 0) {
					System.out.print(" " + pt + " ");
				} else
					System.out.print("   ");
				System.out.println(txt);
				System.out.println("   " + " ".repeat(pt - pp + spacer++) + "+");
				System.out.println("   " + " ".repeat(pt - pp) + pat);
				System.out.println();
				pp++;
				pt++;
			} else {
				System.out.println("   " + txt);
				System.out.println("   " + " ".repeat(pt - pp + spacer) + "|");
				spacer = 0;
				System.out.println("   " + " ".repeat(pt - pp) + pat);
				System.out.println();
				pt = pt - pp + 1;
				pp = 0;
			}
		}
		if (pp == pat.length())
			return pt - pp;
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("텍스트 : ");
		String s1 = stdIn.next();
		System.out.print("패턴 : ");
		String s2 = stdIn.next();
		s1 = "ABABCDEFGHA";
		s2 = "ABC";
		stdIn.close();
		int idx = bfMatch(s1, s2);
		System.out.println(idx + 1 + "번째 문자부터 일치");
		System.out.println("비교를 " + count + "회 했습니다.");
	}

}
