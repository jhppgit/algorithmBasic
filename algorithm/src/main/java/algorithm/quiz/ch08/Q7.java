package algorithm.quiz.ch08;

import java.util.Comparator;

// 원형리스트 구현해보기(배열 x), 연습문제 메서드 포함
public class Q7 {
	class LinkedListX<E> {
		class Node<E> {
			private E data;
			private Node<E> next;
			
			Node (E data, Node<E> next) {
				this.data = data;
				this.next = next;
			}
		}
		
		private Node<E> head;
		private Node<E> tail;
		private Node<E> crnt;
		
		LinkedListX() {
			head = tail = crnt = null;
		}
		
		public Node<E> search(E obj, Comparator<? super E> c) {
			Node<E> ptr = head;
			while (ptr != null) {
				if (c.compare(obj, ptr.data) == 0) {
					crnt = ptr;
					return ptr;
				}
				ptr = ptr.next;
			}
			return null;
		}
		
		public void addFirst(E obj) {
			Node<E> ptr = head;
			head = crnt = new Node<E>(obj, ptr);
			if (tail == null)
				tail = head;
		}
		
		public void addLast(E obj) {
			if (head == null) {
				addFirst(obj);
				return;
			}
			Node<E> ptr = tail;
			tail = crnt = new Node<E>(obj, head);
			ptr.next = tail;
		}
		
		public void removeFirst() {
			if (head != null) {
				head = crnt = head.next;
				if (head == null)
					tail = null;
			}
		}
		
		public void removeLast() {
			if (head != null) {
				if (head.next == null)
					removeFirst();
				else {
					Node<E> ptr = head;
					while (ptr.next != tail)
						ptr = ptr.next;
					tail = ptr;
					ptr.next = head;
					crnt = ptr;
				}
			}
		}
		
		public void remove(Node<E> p) {
			if (p == head)
				removeFirst();
			else if (p == tail)
				removeLast();
			else if (head != null) {
				Node<E> ptr = head;
				while (ptr.next != p) {
					ptr = ptr.next;
					if (ptr == null) 
						return;
				}
				ptr.next = p.next;
				crnt = ptr;
					
			}
		}
		
		public void removeCurrentNode() {
			remove(crnt);
		}
		
		public void clear() {
			while (head != null)
				removeFirst();
			crnt = null;
		}
		
		public boolean next() {
			if (crnt == null || crnt.next == null)
				return false;
			crnt = crnt.next;
			return true;
		}
		
		public void printCurrentNode() {
			if (crnt == null)
				System.out.println("선택된 노드가 없습니다.");
			else 
				System.out.println(crnt.data);
		}
		
		public void dump() {
			Node<E> ptr = head;
			while (ptr != null) {
				System.out.println(ptr.data);
				ptr = ptr.next;
			}
		}
		
		public void purge(Comparator<? super E> c) {
			if (head != null) {
				Node<E> ptr = head;
				while (ptr.next != null) {
					Node<E> cur = ptr.next;
					if (c.compare(ptr.data, cur.data) == 0)
						remove(cur);
					cur = cur.next;
				}
				ptr = ptr.next;
			}
		}
		
		public Node<E> retrieve(int num) {
			if (num < 0)
				return null;
			Node<E> ptr = head;
			for (int i = 0; i < num; i++) {
				if (ptr == null)
					return null;
				ptr = ptr.next;
			}
			crnt = ptr;
			return ptr;
		}
		
	}
}
