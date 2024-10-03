package algorithm.ch07;

import java.util.Scanner;

// String.indexOf, String.lastIndexOf 메서드로 문자열 검색
public class IndexOfTester {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("텍스트 : ");
		String s1 = stdIn.next();
		
		System.out.print("패턴 : ");
		String s2 = stdIn.next();
		
		stdIn.close();
		
		int idx1 = s1.indexOf(s2); // 문자열 s1에서 s2를 검색(앞쪽부터)
		int idx2 = s2.indexOf(s2); // 문자열 s1에서 s2를 검색(뒷쪽부터)
		
		if (idx1 == -1)
			System.out.println("텍스트 안에 패턴이 없습니다.");
		else {
			// 찾아낸 문자열 바로 앞까지의 문자 개수를 구함
			int len1 = 0;
			for (int i = 0; i < idx1; i++)
				len1 += s1.substring(i, i + 1).getBytes().length;
			len1 += s2.length();
			
			int len2 = 0;
			for (int i = 0; i < idx2; i++)
				len2 += s1.substring(i, i + 1).getBytes().length;
			len2 += s2.length();
			
			System.out.println("텍스트 : " + s1);
			System.out.printf(String.format("패턴 : %%%ds\n", len1), s2);
			System.out.println("텍스트 : " + s1);
			System.out.printf(String.format("패턴 : %%%ds\n", len2), s2);
		}
	}
}
