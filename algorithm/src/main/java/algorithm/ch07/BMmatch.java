package algorithm.ch07;

// 보이어 무어법
public class BMmatch {
	static int bmMatch(String txt, String pat) {
		int pt; // txt 커서
		int pp; // pat 커서
		int txtLen = txt.length(); // txt 문자갯수
		int patLen = pat.length(); // pat 문자갯수
		int[] skip = new int[Character.MAX_VALUE + 1]; // 건너뛰기표
		
		// 건너뛰기표 만들기
		for (pt = 0; pt <= Character.MAX_VALUE; pt++)
			skip[pt] = patLen; // 건너뛰기표의 원소를 패턴의 길이로 모두 채우기
		for (pt = 0; pt <= patLen - 1; pt++)
			// 건너뛰기표[패턴의 글자] = 패턴의 길이 - 글자의 위치 - 1 (글자의 위치는 0부터 시작하므로)
			skip[pat.charAt(pt)] = patLen - pt - 1; // pt == patLen - 1
		
		// 검색
		while (pt < txtLen) {
			pp = patLen - 1; // pat의 마지막 문자부터
			
			while (txt.charAt(pt) == pat.charAt(pp)) { // 일치한다면
				if (pp == 0) // 패턴의 첫글자와 일치한다면
					return pt;
				pp--;
				pt--; // 이전 문자도 일치하는지 확인
			}
			
			// 건너뛰기 표 참고해서 pt 옮기기(일치하지 않을 때)
			pt += (skip[txt.charAt(pt)] > patLen - pp) ? skip[txt.charAt(pt)] : patLen - pp;
		}
		
		return -1;
	}
}
