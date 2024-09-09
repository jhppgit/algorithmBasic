package algorithm.quiz.ch04;

// 양방향 큐 구현
// 기존의 인큐와 디큐는 요소에 접근, 저장 후 인덱스를 옮기지만
// deque에서 추가된 메서드들은 인덱스를 옮기고 나서 작업을 수행해야 한다.
public class IntDeque {
	private int[] que;
	private int num;
	private int capacity;
	private int front;
	private int rear;
	
	public class OverflowIntDequeException extends RuntimeException {
		public OverflowIntDequeException() {}
	}
	public class EmptyIntDequeException extends RuntimeException {
		public EmptyIntDequeException() {}
	}
	
	public IntDeque(int maxlen) {
		num = rear = front = 0;
		capacity = maxlen;
		try {
			que = new int[maxlen];
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}
	
	// 인덱스 먼저 수정 후
	public int enqueFront(int x) throws OverflowIntDequeException {
		if (num >= capacity)
			throw new OverflowIntDequeException();
		if (front == 0)
			front = capacity - 1; // 프론트가 0이라면 제일 뒤로
		else
			front--;
		que[front] = x;
		num++;
		return x;
	}
	
	// 기존 인큐와 같다
	public int enqueRear(int x) throws OverflowIntDequeException {
		if (num >= capacity)
			throw new OverflowIntDequeException();
		que[rear++] = x;
		num++;
		if (rear == capacity)
			rear = 0;
		return x;
	}
	
	// 기존 디큐와 같다
	public int dequeFront() throws EmptyIntDequeException {
		if (num <= 0)
			throw new EmptyIntDequeException();
		int result = que[front++];
		num--;
		if (front == capacity)
			front = 0;
		return result;
	}
	
	public int dequeRear() throws EmptyIntDequeException {
		if (num <= 0)
			throw new EmptyIntDequeException();
		int result = que[rear];
		num--;
		if (rear == 0)
			rear = capacity - 1;
		else 
			rear--;
		return result;
	}
	
	public int peekFront() throws EmptyIntDequeException {
		if (num <= 0)
			throw new EmptyIntDequeException();
		return que[front];
	}
	
	public int peekRear() throws EmptyIntDequeException {
		if (num <= 0)
			throw new EmptyIntDequeException();
		return que[rear];
	}
	
	// 나머지는 큐와 같다
}
