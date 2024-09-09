package algorithm.quiz.ch04;

public class IntQueueMySelf {
	private int[] que;
	private int capacity;
	private int front;
	private int rear;
	private int num;
	
	public IntQueueMySelf(int maxlen) {
		capacity = maxlen;
		num = front = rear = 0;
		try {
			que = new int[maxlen];
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}
	
	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {}
	}
	
	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() {}
	}
	
	public int enque(int x) {
		if (num >= capacity)
			throw new OverflowIntQueueException();
		que[rear++] = x;
		num++;
		if (rear == capacity)
			rear = 0;
		return x;
	}
	
	public int deque() {
		if (num <= 0)
			throw new EmptyIntQueueException();
		int x = que[front++];
		num--;
		if (front == capacity)
			front = 0;
		return x;
	}
	
	public int peek() {
		if (num <= 0)
			throw new EmptyIntQueueException();
		return que[front];
	}
	
	public void clear() {
		num = front = rear = 0;
	}
	
	public int indexOf(int x) {
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % capacity;
			if (que[idx] == x)
				return idx;
		}
		return -1;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public int size() {
		return num;
	}
	
	public boolean isEmpty() {
		return num <= 0;
	}
	
	public boolean isFull() {
		return num >= capacity;
	}
	
	public void dump() {
		if (num <= 0)
			System.out.println("큐가 비었습니다.");
		for (int i = 0; i < num; i++)
			System.out.print(que[(front + i) * capacity] + " ");
		System.out.println();
	}
}
