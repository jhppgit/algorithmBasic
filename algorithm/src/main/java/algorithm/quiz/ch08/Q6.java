package algorithm.quiz.ch08;

import java.util.Comparator;

// 배열 연결 리스트에서 꼬리노드의 참조도 맴버로 갖고있게 만들기, retrieve, purge도 작성
public class Q6 {
	class ArrayLinkedList<E> {
		class Node<E> {
			E data;
			private int next;
			private int dnext;
			
			void set(E data, int next) {
				this.data = data;
				this.next = next;
			}
		}
		
		private int head;
		private int crnt;
		private int size;
		private int deleted;
		private int max;
		private int tail;
		private Node<E>[] n;
		public static final int NULL = -1;
		
		public ArrayLinkedList (int capacity) {
			head = crnt = deleted = max = tail = NULL;
			try {
				n = new Node[capacity];
				size = capacity;
				for (int i = 0; i < capacity; i++)
					n[i] = new Node<E>();
			} catch (OutOfMemoryError e) {
				size = 0;
			}
		}
		
		private int getInsertIndex() {
			if (deleted == NULL) {
				if (max < size)
					return max++;
				else
					return NULL;
			} else {
				int rec = deleted;
				deleted = n[rec].dnext;
				return rec;
			}
		}
		
		private void deleteIndex(int idx) {
			if (deleted == NULL) {
				deleted = idx;
				n[idx].dnext = NULL;
			} else {
				int rec = deleted;
				deleted = idx;
				n[idx].dnext = rec;
			}
		}
		
		public Node<E> search(E obj, Comparator<? super E> c) {
			int ptr = head;
			while (ptr != NULL) {
				if (c.compare(obj, n[ptr].data) == 0) {
					crnt = ptr;
					return n[ptr];
				}
			}
			return null;
		}
		
		public void addFirst(E obj) {
			int ptr = head;
			int rec = getInsertIndex();
			if (rec != NULL) {
				n[rec].set(obj, ptr);
				head = crnt = rec;
				if (tail == NULL)
					tail = rec;
			}
		}
		
		public void addLast(E obj) {
			if (head == NULL)
				addFirst(obj);
			else {
				int rec = getInsertIndex();
				n[rec].set(obj, NULL);
				n[tail].next = rec;
				tail = crnt = rec;
			}
		}
		
		public void removeFirst() {
			if (head != NULL) {
				int ptr = n[head].next;
				deleteIndex(head);
				head = crnt = ptr;
				if (head == NULL)
					tail = NULL;
			}
		}
		
		public void removeLast() {
			if (tail != NULL) {
				int ptr = head;
				if (head == tail) {
					deleteIndex(ptr);
					head = crnt = tail = NULL;
					return;
				}
				while (n[ptr].next != tail)
					ptr = n[ptr].next;
				n[ptr].next = NULL;
				deleteIndex(tail);
				tail = crnt = ptr;
			}
		}
		
		public void remove(int p) {
			if (head != NULL) {
				if (head == p)
					removeFirst();
				else if (tail == p)
					removeLast();
				else {
					int ptr = head;
					while (n[ptr].next != p) {
						ptr = n[ptr].next;
						if (ptr == NULL) return;
					}
					n[ptr].next = n[p].next;
					deleteIndex(p);
					crnt = ptr;
				}				
			}
		}
		
		public void removeCurrentNode() {
			remove(crnt);
		}
		
		public void clear() {
			int ptr = head;
			while (ptr != NULL) {
				removeFirst();
				ptr = n[ptr].next;
			}
			crnt = NULL;
		}
		
		// 프린트, 덤프 생략
		
		public void purge(Comparator<? super E> c) {
			int ptr = head;
			while (ptr != NULL) {
				int cur = n[ptr].next;
				while (cur != NULL) {
					if (c.compare(n[ptr].data, n[cur].data) == 0)
						remove(cur);
					cur = n[cur].next;
				}
				ptr = n[ptr].next;
			}
		}
		
		public Node<E> retrieve(int num) {
			if (num < 0 || head == NULL) 
				return null;
			int ptr = head;
			for (int i = 0; i < num; i++) {
				ptr = n[ptr].next;
				if (ptr == NULL)
					return null;
			}
			return n[ptr];
			
		}
	}
}
