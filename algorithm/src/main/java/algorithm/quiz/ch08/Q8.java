package algorithm.quiz.ch08;

import java.util.Comparator;

// 배열을 사용하는 원형리스트 구현, retrieve, purge 메서드도.
public class Q8 {
	class ArrayLinkedList<E> {
		class Node<E> {
			E data;
			int next;
			int dnext;
			
			void set(E data, int next) {
				this.data = data;
				this.next = next;
			}
		}
		
		private int head;
		private int crnt;
		private int deleted;
		private int max;
		private int size;
		private int tail;
		private Node<E>[] n;
		public static final int NULL = -1;
		
		public ArrayLinkedList(int capacity) {
			head = crnt = deleted = tail = max = NULL;
			try {
				n = new Node[capacity];
				for (int i = 0; i < capacity; i++)
					n[i] = new Node<E>();
				size = capacity;
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
			if (head == NULL)
				return null;
			else {
				int ptr = head;
				while (ptr != NULL) {
					if (c.compare(obj, n[ptr].data) == 0) {
						crnt = ptr;
						return n[ptr];
					}
					ptr = n[ptr].next;
				}
				return null;
			}
		}
		
		public void addFirst(E obj) {
			int ptr = head;
			int rec = getInsertIndex();
			if (rec != NULL) {
				head = crnt = rec;
				n[rec].set(obj, ptr);
			}
			if (n[head].next == NULL)
				tail = head;
			n[tail].next = head;
			
		}
		
		public void addLast(E obj) {
			if (head == NULL)
				addFirst(obj);
			else {
				int rec = getInsertIndex();
				if (rec != NULL) {
					n[tail].next = rec;
					n[rec].set(obj, head);
					tail = crnt = rec;
				}
			}
		}
		
		public void removeFirst() {
			if (head != NULL) {
				int ptr = n[head].next;
				deleteIndex(head);
				n[tail].next = crnt = head = ptr;
			}
		}
		
		public void removeLast() {
			if (tail == NULL) {
				return;
			} else if (head == tail) {
				removeFirst();
			} else {
				int ptr = head;
				while (n[ptr].next != tail) {
					ptr = n[ptr].next;
				}
				n[ptr].next = head;
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
						if (ptr == NULL)
							return;
					}
					n[ptr].next = n[p].next;
					crnt = ptr;
				}
			}
		}
		
		public void removeCurrentNode() {
			remove(crnt);
		}
		
		public void clear() {
			while (head != NULL) 
				removeFirst();
		}
		
		public boolean next() {
			if (crnt == NULL || n[crnt].next == NULL)
				return false;
			crnt = n[crnt].next;
			return true;
		}
		
		public void printCurrentNode() {
			if (crnt == NULL)
				System.out.println("선택된 노드가 없습니다.");
			else
				System.out.println(n[crnt].data);
		}
		
		public void dump() {
			int ptr = head;
			while (ptr != NULL) {
				System.out.println(n[ptr].data);
				ptr = n[ptr].next;
			}
		}
		
		public void purge(Comparator<? super E> c) {
			if (head != NULL) {
				int ptr = head;
				while (n[ptr].next != NULL) {
					int cur = n[ptr].next;
					while (cur != NULL) {
						if (c.compare(n[ptr].data, n[cur].data) == 0)
							remove(cur);
						cur = n[cur].next;
					}
					ptr = n[ptr].next;
				}
			}
		}
		
		public Node<E> retrieve(int num) {
			if (num < 0)
				return null;
			int ptr = head;
			for (int i = 0; i < num; i++) {
				if (ptr == NULL) return null;
				ptr = n[ptr].next;
			}
			crnt = ptr;
			return n[ptr];
		}
	}
}
