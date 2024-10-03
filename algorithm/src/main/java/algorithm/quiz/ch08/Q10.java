package algorithm.quiz.ch08;

import java.util.Comparator;

// 원형 이중 연결 리스트에 purge retrieve 메서드 추가
public class Q10 {
	class DoubleLinkedList<E> {
		class Node<E> {
			private E data;
			private Node<E> next;
			private Node<E> prev;
			
			Node() {
				data = null;
				next = this;
				prev = this;
			}
			
			Node(E obj, Node<E> prev, Node<E> next) {
				data = obj;
				this.next = next;
				this.prev = prev;
			}
		}
		
		private Node<E> head;
		private Node<E> crnt;
		
		DoubleLinkedList() {
			head = crnt = new Node<E>();
		}
		
		public boolean isEmpty() {
			return head.next == head;
		}
		
		public Node<E> search(E obj, Comparator<? super E> c) {
			Node<E> ptr = head.next;
			while (ptr != head) {
				if (c.compare(obj, ptr.data) == 0) {
					crnt = ptr;
					return ptr;
				}
				ptr = ptr.next;
			}
			return null;
		}
		
		public void printCurrentNode() {
			if (isEmpty()) 
				System.out.println("선택된 노드가 없습니다");
			else
				System.out.println(crnt.data);
		}
		
		public void dump() {
			Node<E> ptr = head.next;
			while (ptr != head) {
				System.out.println(ptr.data);
				ptr = ptr.next;
			}
		}
		
		public void dumpReverse() {
			Node<E> ptr = head.prev;
			while (ptr != head) {
				System.out.println(ptr.data);
				ptr = ptr.prev;
			}
		}
		
		public boolean next() {
			if (isEmpty() || crnt.next == head)
				return false;
			crnt = crnt.next;
			return true;
		}
		
		public boolean prev() {
			if (isEmpty() || crnt.prev == head)
				return false;
			crnt = crnt.prev;
			return true;
		}
		
		public void add(E obj) {
			Node<E> node = new Node<E>(obj, crnt, crnt.next);
			crnt = crnt.next = crnt.next.prev = node;
		}
		
		public void addFirst(E obj) {
			crnt = head;
			add(obj);
		}
		
		public void addLast(E obj) {
			crnt = head.prev;
			add(obj);
		}
		
		public void removeCurrentNode() {
			if (!isEmpty()) {
				crnt.prev.next = crnt.next;
				crnt.next.prev = crnt.prev;
				crnt = crnt.prev;
				if (crnt == head)
					crnt = crnt.next;
			}
		}
		
		public void remove(Node<E> p) {
			if (!isEmpty()) {
				Node<E> ptr = head.next;
				while (ptr.next != head) {
					if (ptr == p) {
						crnt = ptr;
						removeCurrentNode();
						break;
					}
					ptr = ptr.next;
				}
			}
		}
		
		public void removeFirst() {
			crnt = head.next;
			removeCurrentNode();
		}
		
		public void removeLast() {
			crnt = head.prev;
			removeCurrentNode();
		}
		
		public void clear() {
			while (!isEmpty())
				removeFirst();
		}
		
		public void purge(Comparator<? super E> c) {
			if (!isEmpty()) {
				Node<E> ptr = head.next;
				while (ptr.next != null) {
					Node<E> cur = ptr.next;
					if (c.compare(ptr.data, cur.data) == 0) {
						crnt = cur;
						removeCurrentNode();
					}
					cur = cur.next;
				}
				ptr = ptr.next;
			}
		}
		
		public Node<E> retrieve(int n) {
			if (n < 0) 
				return null;
			Node<E> ptr = head.next;
			for (int i = 0; i < n; i++) {
				if (ptr == head)
					return null;
				ptr = ptr.next;
			}
			return ptr;
		}
	}
}
