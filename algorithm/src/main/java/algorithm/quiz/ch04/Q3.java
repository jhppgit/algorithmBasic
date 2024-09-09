package algorithm.quiz.ch04;

// 하나의 배열을 공유하는 두개의 스택 (int)
public class Q3 {
	private int capacity; // 전체 배열 크기
	private int capacity1; // 왼쪽배열 크기
	private int capacity2; // 오른쪽 배열 크기
	private int ptr1; // 왼쪽포인터
	private int ptr2; // 오른쪽 포인터
	private int[] stk; // 공유하는 배열
	
	public Q3 (int maxlen, int lenLeft, int lenRight) throws StackCollisionException {
		if (lenLeft > maxlen || lenRight > maxlen - lenLeft)
			throw new StackCollisionException();
		else {
			capacity1 = lenLeft;
			capacity2 = lenRight;
		}
		ptr1 = 0;
		ptr2 = maxlen - 1; // 배열의 마지막인덱스
		
		try {
			stk = new int[maxlen];
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}
	
	public class StackCollisionException extends RuntimeException {
		public StackCollisionException() { }
	}
	
	public class FullIntStackException extends RuntimeException {
		public FullIntStackException() {}
	}
	
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {}
	}
	
	public int pushLeft(int x) throws FullIntStackException {
		if (ptr1 >= capacity1)
			throw new FullIntStackException();
		return stk[ptr1++];
	}
	
	public int pushRight(int x) throws FullIntStackException {
		if (ptr2 >= capacity1)
			throw new FullIntStackException();
		return stk[ptr2--];
	}
	
	public int popLeft() throws EmptyIntStackException {
		if (ptr1 <= 0) 
			throw new EmptyIntStackException();
		return stk[--ptr1];
	}
	
	public int popRight() throws EmptyIntStackException {
		if (ptr2 >= capacity) 
			throw new EmptyIntStackException();
		return stk[++ptr2];
	}
	
	public int peekLeft() throws EmptyIntStackException {
		if (ptr1 <= 0)
			throw new EmptyIntStackException();
		return stk[ptr1 - 1];
	}
	
	public int peekRight() throws EmptyIntStackException {
		if (ptr2 >= capacity)
			throw new EmptyIntStackException();
		return stk[ptr2 + 1];
	}
	
	public void clear() {
		ptr1 = 0;
		ptr2 = capacity - 1;
	}
	
	public void clearLeft() {
		ptr1 = 0;
	}
	
	public void clearRight() {
		ptr2 = capacity - 1;
	}
	
	public int indexOfLeft(int x) {
		for (int i = ptr1 - 1; i >= 0; i--)
			if (stk[i] == x)
				return i;
		return -1;
	}
	
	public int indexOfRight(int x) {
		for (int i = ptr2 + 1; i < capacity; i++)
			if (stk[i] == x)
				return capacity - i;
		return -1;
	}
	
	public int sizeLeft() {
		return ptr1;
	}
	
	public int sizeRight() {
		return capacity - ptr2;
	}
	
}
