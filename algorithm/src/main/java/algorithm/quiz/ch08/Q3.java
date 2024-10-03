package algorithm.quiz.ch08;

import java.util.Comparator;

// 꼬리노드에 대한 참조 tail을 갖고있는 LinkedListX<E> 작성, purge와 retrieve도 포함
public class Q3 {
	class LinkedListX<E> {
		class Node<E> {
			E data;
			Node<E> next;
			
			public Node(E data, Node<E> next) {
				this.data = data;
				this.next = next;
			}
		}
		
		private Node<E> head;
		private Node<E> tail;
		private Node<E> cur;
		
		public LinkedListX() {
			head = tail = cur = null;
		}
		
		public E search(E obj, Comparator<? super E> c) {
			Node<E> ptr = head;
			
			while (ptr != null) {
				if (c.compare(obj, ptr.data) == 0) {
					cur = ptr;
					return ptr.data;
				}
				ptr = ptr.next;
			}
			return null;
		}
		
		public void addFirst(E obj) {
			Node<E>	ptr = head;
			head = cur = new Node<E>(obj, ptr);
		}
		
		public void addLast(E obj) {
			if (head == null)
				addFirst(obj);
			else {
				tail.next = new Node<E>(obj, null);
				tail = tail.next;
			}
		}
		
		public void removeFirst() {
			if (head != null) {
				head = cur = head.next;
				if (head == null)
					tail = null;
			}
		}
		
		public void removeLast() {
			if (head != null) {
				Node<E> ptr = head;
				Node<E> pre = head;
				while (ptr.next != null) {
					pre = ptr;
					ptr = ptr.next;
				}
				pre.next = null;
				cur = tail = pre;
			}
		}
		
		public void remove(Node<E> p) {
			if (head != null) {
				if (p == head)
					removeFirst();
				else if (p == tail)
					removeLast();
				else {
				Node<E> ptr = head;
				while (ptr.next != p) {
					ptr = ptr.next;
					if (ptr == null)
						return;
				}
				ptr.next = p.next;
				cur = ptr;
				}
			}
		}
		
		public void removeCurrentNode() {
			remove(cur);
		}
		
		public void clear() {
			while (head != null)
				removeFirst();
			cur = null;
		}
		
		public boolean next() {
			if (cur == null || cur.next == null) 
				return false;
			cur = cur.next;
			return true;
		}
		
		public void printCurrentNode() {
			if (cur == null)
				System.out.println("선택된 노드가 없습니다.");
			else
				System.out.println(cur.data);
		}
		
		public void dump() {
			Node<E> ptr = head;
			while (ptr != null) {
				System.out.println(ptr.data);
				ptr = ptr.next;
			}
		}
		
		public void purge(Comparator<? super E> c) {
			Node<E> ptr = head;
			while (ptr.next != null) {
				Node<E> cursor = ptr.next;
				while (cursor != null) {
					if (c.compare(cursor.data, ptr.data) == 0)
						remove(cursor);
					cursor = cursor.next;
				}
				ptr = ptr.next;
			}
		}
		
		public Node<E> retrieve(int n) {
			Node<E> ptr = head;
			for (int i = 0; i < n; i++) {
				if (ptr == null)
					return ptr;
				ptr = ptr.next;
				
			}
			return ptr;
		}
	}
}
