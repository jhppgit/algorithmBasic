package algorithm.quiz.ch04;

// 배열로 큐 만들기
public class IntArrayQueue {
	private int[] que;
	private int capacity;
	private int num;
	
	public class FullException extends RuntimeException {
		public FullException() {};
	}
	
	public class EmptyException extends RuntimeException {
		public EmptyException() {};
	}
	
	public IntArrayQueue(int size) {
		capacity = size;
		num = 0;
		try {
			que = new int[size];
		} catch(OutOfMemoryError e) {
			capacity = 0;
		}
	}
	
	public int enqueue(int x) {
		if (num >= capacity)
			throw new FullException();
		return que[num++] = x;
	}
	
	public int dequeue() {
		if (num <= 0)
			throw new EmptyException();
		int result = que[0];
		for (int i = 0; i < num; i++) {
			que[i] = que[i + 1];
		}
		return result;
	}
	
	public int peek() {
		if (num <= 0)
			throw new EmptyException();
		return que[0];
	}
}
