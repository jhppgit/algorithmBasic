package algorithm.quiz.ch08;

import java.util.Comparator;

// 배열 커서 버전의 연결리스트에 void purge(Comparator<? super E> c)(중복 data 삭제) 메서드 추가
public class Q4 {
	class ArrayLinkedList<E> {
		class Node<E> {
			private E data;
			private int next;
			private int dnext;
			
			// data와 next 변경
			void set(E data, int next) {
				this.data = data;
				this.next = next;
			}
		} // Node
		
		private Node<E>[] n;
		private int size;
		private int max;
		private int head;
		private int crnt;
		private int deleted;
		private static final int NULL = -1;
		
		// 생성자
		public ArrayLinkedList(int capacity) {
			head = crnt = max = deleted = NULL;
			try {
				n = new Node[capacity];
				for (int i = 0; i < capacity; i++)
					n[i] = new Node<>();
				size = capacity;
			} catch (OutOfMemoryError e) {
				size = 0;
			}
		} // 생성자
		
		private int getInsertIndex() {
			if (deleted == NULL) { // 부활 대기자 명단이 비었다면
				if (max < size) // 사용 영역을 늘릴 수 있으면
					return max++; // 사용영역 늘리고 그 인덱스를 반환
				else
					return NULL;
			} else {
				int rec = deleted;
				deleted = n[rec].dnext;
				return rec;
			}
		}
		
		private void deletedIndex(int idx) {
			if (deleted == NULL) {
				deleted = idx;
				n[idx].dnext = NULL;
			} else {
				int rec = deleted;
				deleted = idx;
				n[idx].dnext = rec;
			}
		}
		
		public E search(E obj, Comparator<? super E> c) {
			int ptr = head;
			
			while (ptr != NULL) {
				if (c.compare(obj, n[ptr].data) == 0) {
					crnt = ptr;
					return n[ptr].data;
				}
				ptr = n[ptr].next;
			}
			return null;
		}
		
		public void addFirst(E obj) {
			int ptr = head;
			int rec = getInsertIndex();
			if (rec != NULL) {
				head = crnt = rec;
				n[rec].set(obj, ptr);
			}
		}
		
		public void addLast(E obj) {
			if (head == NULL) 
				addFirst(obj);
			else {
				int ptr = head;
				while (n[ptr].next != NULL)
					ptr = n[ptr].next;
				int rec = getInsertIndex();
				if (rec != NULL) {
					n[rec].set(obj, NULL);
					n[ptr].next = crnt = rec;
				}
			}
		}
		
		public void removeFirst() {
			if (head != NULL) {
				int ptr = n[head].next;
				deletedIndex(head);
				head = crnt = ptr;
			}
		}
		
		public void removeLast() {
			if (head != NULL) {
				if (n[head].next == NULL)
					removeFirst();
				else {
					int ptr = head;
					int pre = head;
					
					while (n[ptr].next != NULL) {
						pre = ptr;
						ptr = n[ptr].next;
					}
					n[pre].next = NULL;
					deletedIndex(ptr);
					crnt = pre;
				}
			}
		}
		
		public void remove(int p) {
			if (head != NULL) {
				if (p == head)
					removeFirst();
				else {
					int ptr = head;
					
					while (n[ptr].next != p) {
						ptr = n[ptr].next;
						if (ptr == NULL) return;
					}
					n[ptr].next = NULL;
					deletedIndex(p);
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
			crnt = NULL;
		}
		
		public boolean next() {
			if (crnt == NULL || n[crnt].next == NULL)
				return false;
			crnt = n[crnt].next;
			return true;
		}
		
		public void printCurrentNode() {
			if (crnt == NULL)
				System.out.println("선택된 노드가 없습니다");
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
		
	} // ArrayLinkedList
} // Q4
