package algorithm.ch07;

// KMP법을 문자열 검색
public class KMPmatch {
	static int kmpMatch(String txt, String pat) {
		int pt = 1; // txt커서
		int pp = 0; // pat 커서
		int[] skip = new int[pat.length() + 1]; // 건너뛰기표
		
		// 건너뛰기 표 만들기
		skip[pt] = 0;
		while (pt != pat.length()) {
			if (pat.charAt(pt) == pat.charAt(pp))
				skip[++pt] = ++pp;
			else if (pp == 0)
				skip[++pt] = pp;
			else
				pp = skip[pp];
		}
		
		// 검색
		pp = pt = 0;
		while (pt != txt.length() && pp != pat.length()) {
			if (txt.charAt(pt) == pat.charAt(pp)) {
				pt++;
				pp++;
			} else if (pp == 0)
				pt++;
			else
				pp = skip[pp];
		}
		
		if (pp == pat.length())
			return pt - pp;
		return -1;
	}
}
