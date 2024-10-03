package algorithm.ch07;

import java.util.Scanner;

// 브루트 포스법으로 문자열 검색
public class BFmatch {
	static int bfMatch(String txt, String pat) {
		int pt = 0; // pointer text
		int pp = 0; // pointer pattern
		
		while (pt != txt.length() && pp != pat.length()) {
			if (txt.charAt(pt) == pat.charAt(pp)) { // 글자가 일치한다면
				pt++; // 다음것도
				pp++; // 검사
			} else { // 일치하지 않는다면
				pt = pt - pp + 1; // 지금까지 검사하면서 이동한 포인터 다시 뒤로 밀기
				pp = 0; // 패턴포인터도 초기화
			}
		}
		
		if (pp == pat.length()) // 검색 성공
			return pt - pp; // 첫글자의 자리 반환
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("텍스트 : ");
		String s1 = stdIn.next(); // 텍스트용 문자열
		
		System.out.print("패턴 : ");
		String s2 = stdIn.next();
		
		stdIn.close();
		
		int idx = bfMatch(s1, s2);
		
		if (idx == -1)
			System.out.println("텍스트에 패턴이 없습니다.");
		else {
			// 일치하는 문자 바로 앞까지 문자 개수를 반각문자로 환산하여 구함
			int len = 0;
			for (int i = 0; i < idx; i++) 
				len += s1.substring(i, i + 1).getBytes().length;
			len += s2.length();
			
			System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
			System.out.println("텍스트 : " + s1);
			System.out.printf(String.format("패턴 : %%%ds\n", len), s2);
		}
	}
}
