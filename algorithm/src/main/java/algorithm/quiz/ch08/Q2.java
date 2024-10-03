package algorithm.quiz.ch08;

import java.util.Comparator;

// 머리부터 n개 뒤의 노드에 대한 참조를 반환하는 메서드(배열처럼 접근)
// retrieve(int n), n이 음수이거나 노드 개수보다 크거나 같으면 null 반환
public class Q2 {
	class LinkedList<E> {
		class Node<E> {
			private E data;
			private Node<E> next;
			
			public Node (E data, Node<E> next) {
				this.data = data;
				this.next = next;
			}
		}
		
		private Node<E> head;
		private Node<E> crnt;
		
		public LinkedList (){
			head = crnt = null;
		}
		
		public E retrieve(int n) {
			if (head == null)
				return null;
			Node<E> ptr = head;
			for (int i = 0; i < n; i++) {
				if (ptr.next == null)
					return null;
				ptr = ptr.next;
			}
			crnt = ptr;
			return ptr.data;
		}
		
		public E search(E obj, Comparator<? super E> c) {
			Node<E> ptr = head;
			
			while (ptr != null) {
				if (c.compare(obj, ptr.data) == 0) {
					crnt = ptr;
					return ptr.data;
				}
				ptr = ptr.next;
			}
			return null;
		}
		
		public void addFirst(E obj) {
			Node<E> ptr = head;
			head = crnt = new Node<E>(obj, ptr);
		}
		
		public void addLast(E obj) {
			if (head == null)
				addFirst(obj);
			else {
				Node<E> ptr = head;
				while (ptr.next != null)
					ptr = ptr.next;
				ptr.next = crnt = new Node<E>(obj, null);
			}
		}
		
		public void removeFirst() {
			if (head != null) {
				head = crnt = head.next;
			}
		}
		
		public void removeLast() {
			if (head != null) {
				if (head.next == null)
					removeFirst();
				else {
					Node<E> ptr = head;
					Node<E> pre = head;
					while (ptr.next.next != null) {
						pre = ptr;
						ptr = ptr.next;
					}
					crnt = pre;
					pre.next = null;
				}
			}
		}
		
		public void remove(Node<E> p) {
			if (head == null) return;
			Node<E> ptr = head;
			while (ptr.next != p) {
				ptr = ptr.next;
			}
			ptr.next = p.next;
			crnt = ptr;
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
				System.out.println("선택한 노드가 없습니다");
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
			if (head == null) return;
			Node<E> ptr = head;
			while (ptr.next != null) {
				Node<E> cur = ptr.next;
				while (cur != null) {
					if (c.compare(ptr.data, cur.data) == 0)
						remove(cur);
					cur = cur.next;
				}
				ptr = ptr.next;
			}
		}
	}
}
