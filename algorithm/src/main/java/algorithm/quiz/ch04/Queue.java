package algorithm.quiz.ch04;

public class Queue<E> {
	private E[] que;
	private int capacity;
	private int front;
	private int rear;
	private int num;
	
	public Queue(int maxlen) {
		capacity = maxlen;
		front = rear = num = 0;
		Object[] temp = new Object[maxlen];
		que = (E[]) temp;
	}
	
	public E inque(E x) throws RuntimeException {
		if (num >= capacity) {
			System.out.println("큐가 가득 찼습니다.");
			throw new RuntimeException();
		}
		que[rear++] = x;
		num++;
		if (rear == capacity)
			rear = 0;
		return x;
	}
	
	public E deque() throws RuntimeException {
		if (num <= 0) {
			System.out.println("큐가 비었습니다.");
			throw new RuntimeException();
		}
		E result = que[front++];
		num--;
		if (front == capacity)
			front = 0;
		return result;
	}
	
	public E peek() throws RuntimeException {
		if (num <= 0) {
			System.out.println("큐가 비었습니다.");
			throw new RuntimeException();
		}
		return que[front];
	}
	
	public void clear() {
		rear = front = num = 0;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public int size() {
		return num;
	}
	
	public int indexOf(E x) { // 물리적 배열의 인덱스 반환
		for (int i = 0; i < num; i++) {
			int idx = (front + i) % capacity;
			if (que[idx] == x)
				return idx;
		}
		return -1;
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
			System.out.print(que[(front + i) % capacity] + " ");
		System.out.println();
	}
}
