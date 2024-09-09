package algorithm.ch04;

// int형 고정길이 스택
// 직접작성 목록 : 예외2(빔, 참), 생성자, 푸시, 팝, 피크, 클리어, 검색, 용량, 사이즈, 참, 빔, 바닥부터출력
public class IntStack {
	private int ptr;
	private int capacity;
	private int[] stk;
	
	// 빌때 에러
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {}
	}
	
	// 꽉찰때 에러
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {}
	}
	
	// 생성자
	public IntStack(int maxlen) {
		ptr = 0;
		capacity = maxlen;
		try {
			stk = new int[maxlen];
		} catch (OutOfMemoryError e) {
			capacity = 0; // 에러나면 아예 참조 못하게
		}
	}
	
	public int push(int x) {
		if (ptr >= capacity)
			throw new OverflowIntStackException();
		else 
			return stk[ptr++] = x; // 요소를 추가하면서 ptr도 늘려준다.
	}
	
	public int pop() {
		if (ptr <= 0)
			throw new EmptyIntStackException();
		else
			return stk[--ptr]; // ptr은 빈 요소를 가리키고있다.
	}
	
	public int peek() {
		if (ptr <= 0)
			throw new EmptyIntStackException();
		else
			return stk[ptr - 1];
	}
	
	public void clear() {
		ptr = 0;
	}
	
	public int indexOf(int x) {
		for (int i = ptr - 1; i >= 0; i--) 
			if (stk[i] == x)
				return i;
		return -1;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public int size() {
		return ptr;
	}
	
	public boolean isEmpty() {
		return ptr <= 0;
	}
	
	public boolean isFull() {
		return ptr >= capacity;
	}
	
	public void dump() {
		if (ptr <= 0)
			System.out.println("스택이 비었습니다");
		for (int i = 0; i < ptr; i++)
			System.out.print(stk[i] + " ");
		System.out.println();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < ptr; i++) {
			sb.append(stk[i]);
			if (i < ptr - 1)
				sb.append(", ");
			else
				sb.append("]");
		}
		return sb.toString();
	}
}
