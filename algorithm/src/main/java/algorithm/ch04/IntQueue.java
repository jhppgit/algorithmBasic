package algorithm.ch04;

public class IntQueue {
	private int[] que;
	private int capacity;
	private int front;
	private int rear;
	private int num; // 현재 데이터 갯수, front와 rear가 같을 때 비어있는지 가득 찼는지 확인하기 위해
	
	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() {}
	}
	
	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {}
	}
	
	public IntQueue(int maxlen) { // 생성자는 변수만 정리, 초기화
		num = front = rear = 0;
		capacity = maxlen;
		try {
			que = new int[maxlen];
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}
	
	public int enque(int x) throws OverflowIntQueueException {
		if (num >= capacity)
			throw new OverflowIntQueueException();
		que[rear++] = x; // 넣고 나서 rear 증가
		num++;
		if (rear == capacity) // rear는 빈 요소를 가리키므로 인큐를 진행한 후 0으로 만들어도 범위를 넘어선 공간에 접근하지 않는다. capacity는 마지막인덱스 + 1
			rear = 0;
		return x; // 넣은거 반환
	}
	
	public int deque() throws EmptyIntQueueException { // 스택과 다르게 front와 rear가 한 방향으로만 움직인다.
		if (num <= 0)
			throw new EmptyIntQueueException();
		int x = que[front++]; // 값을 저장 후 프론트증가
		num--; // 갯수 감소
		if (front == capacity)
			front = 0;
		return x;
	}
	
	public int peek() throws EmptyIntQueueException {
		if (num <= 0)
			throw new EmptyIntQueueException();
		return que[front];
	}
	
	public void clear() {
		num = front = rear = 0;
	}
	
	public int indexOf(int x) {
		for (int i = 0; i < num; i++) { // 0부터 num - 1 까지 num개
			int idx = (i + front) % capacity; // 프론트부터 시작해서 capacity에 도달하면 다시 0부터
			if(que[idx] == x)
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
			System.out.println("큐가 비어있습니다");
		else {
			for (int i = 0; i < num; i++)
				System.out.print(que[(i + front) % capacity] + " ");
			System.out.println();
		}
	}
	
	// Q5 : 임의의 데이터를 검색하는 메서드 int search(int x). 큐안에 논리적으로 몇번째 있는지 반환 (프런트일 경우 1), 실패시 0
	public int search(int x) {
		int i = 0;
		while(i < num) {
			if (que[i] == x)
				return i + 1;
		}
		return 0;
	}
}
