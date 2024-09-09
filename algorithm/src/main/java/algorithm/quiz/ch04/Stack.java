package algorithm.quiz.ch04;

// 임의의 객체형 데이터를 쌓을 수 있는 제네릭 클래스 Stack<E> 작성

public class Stack<E> {
	private Object[] stk; // 제네릭 타입으로 배열 초기화 불가
	private int ptr;
	private int capacity;
	
	public Stack (int maxlen){
		int ptr = 0;
		int capacity = maxlen;
		try {
			stk = new Object[maxlen]; // 오브젝트로
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}
	
	static public class FullGenericStackException extends RuntimeException {
		public FullGenericStackException() {};
	}
	
	static public class EmptyGenericStackException extends RuntimeException {
		public EmptyGenericStackException() {};
	}
	
	public E push(E e) throws FullGenericStackException {
		if (ptr >= capacity)
			throw new FullGenericStackException();
		return (E) (stk[ptr++] = (Object)e);
	}
	
	public E pop() throws EmptyGenericStackException {
		if (ptr <= 0)
			throw new EmptyGenericStackException();
		return (E) stk[--ptr];
	}
	
	public E peek() throws EmptyGenericStackException {
		if (ptr <= 0)
			throw new EmptyGenericStackException();
		return (E) stk[ptr - 1];
	}
	
	public void clear() {
		ptr = 0;
	}
	
	public int indexOf(E e) {
		for (int i = ptr; i > ptr; i--)
			if ((E) stk[i] == e)
				return i;
		return -1;
	}
	
	public boolean isFull() {
		return ptr >= capacity;
	}
	
	public boolean isEmpty() {
		return ptr <= 0;
	}
	
	public int size() {
		return ptr;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void dump() {
		if (ptr <= 0)
			System.out.println("스택이 비었습니다.");
		else {
			for (int i = 0; i < ptr; i++)
				System.out.print(stk[i].toString());
			System.out.println();
		}
	}
	
	
}

