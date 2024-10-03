package algorithm.quiz.ch08;

import java.util.Comparator;

// LinkedList에 서로 같은 노드를 찾아 가장 앞쪽의 노드만 남기고 모두 삭제하는 메서드
// void purge(Comparator<? super E> c) 추가
public class Q1 {
	public class LinkedList<E> {
		class Node<E> {
			private E data;
			private Node<E> next;
			
			Node(E data, Node<E> next) {
				this.data = data;
				this.next = next;
			}
		}
		
		private Node<E> head;
		private Node<E> crnt;
		
		LinkedList() {
			head = crnt = null;
		}
		
		public E search(E obj, Comparator<E> c) {
			Node<E> ptr = head;
			
			while (ptr.next != null) {
				if (c.compare(obj, ptr.data) == 0) {
					crnt = ptr;
					return ptr.data;
				}
				ptr = ptr.next;
			}
			return null;
		}
		
		public void addFirst(E obj) {
			head = crnt = new Node<E>(obj, head);
		}
		
		public void addLast(E obj) {
			if (head == null)
				addFirst(obj);
			else {
				Node<E> ptr = head;
				while (ptr.next != null) {
					ptr = ptr.next;
				}
				ptr.next = crnt = new Node<E>(obj, null);
			}
		}
		
		public void removeFirst() {
			if (head != null)
				head = crnt = head.next;
		}
		
		public void removeLast() {
			if (head != null) {
				if (head.next == null)
					removeFirst();
				else {
					Node<E> ptr = head;
					Node<E> pre = head;
					while (ptr.next != null) {
						pre = ptr;
						ptr = ptr.next;
					}
					pre.next = null;
					crnt = pre;
				}
			}
		}
		
		public void remove(Node<E> p) {
			if (head != null) {
				if (p == head)
					removeFirst();
				else {
					Node<E> ptr = head;
					while (ptr.next != p) {
						ptr = ptr.next;
						if (ptr.next == null) return;
					}
					ptr.next = p.next;
					crnt = ptr;
				}
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
			else {
				crnt = crnt.next;
				return true;
			}
		}
		
		public void printCurrentNode() {
			if (crnt == null)
				System.out.println("선택한 노드가 없습니다.");
			else
				System.out.println(crnt.data);
		}
		
		public void dump() {
			Node<E> ptr = head;
			while (ptr.next != null) {
				System.out.println(ptr.data);
				ptr = ptr.next;
			}
		}
		
		// Q1
		public void purge(Comparator<? super E> c) {
			Node<E> ptr = head;
			if (head == null)
				return;
			while (ptr.next != null) {
				Node<E> cursor = ptr.next; // ptr 다음부터 순회할 커서
				while (cursor.next != null) {
					if (c.compare(ptr.data, cursor.data) == 0) // ptr과 커서가 같으면 제거
						remove(cursor);
					cursor = cursor.next; // cursor는 아직 next로 다음 노드를 가리키고있다.
				}
				ptr = ptr.next;
			}
		}
	}
}
