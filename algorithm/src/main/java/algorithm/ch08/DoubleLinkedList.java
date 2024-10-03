package algorithm.ch08;

import java.util.ArrayList;
import java.util.Comparator;

// 원형 이중 연결 리스트
public class DoubleLinkedList<E> {
	
	// 노드
	class Node<E> {
		private E data;
		private Node<E> prev; // 앞쪽 포인터
		private Node<E> next; // 뒷쪽 포인터
		
		// 생성자1 (리스트 생성시 사용)
		Node() {
			data = null;
			prev = next = this; // 전과 후가 자기 자신을 참조하는 더미노드
		}
		
		// 생성자2
		Node(E obj, Node<E> prev, Node<E> next) {
			data = obj;
			this.prev = prev;
			this.next = next;
		}
	}
	
	private Node<E> head; // 머리 포인터
	private Node<E> crnt; // 선택 포인터
	
	// 생성자
	public DoubleLinkedList() {
		head = crnt = new Node<E>(); // 더미노드를 생성
	}
	/*
	 * head는 항상 더미노드를 가리키고 있다.
	 * 그러므로 기존 연결 리스트의 머리에 해당하는 노드는 head.next,
	 * 꼬리에 해당하는 노드는 head.prev
	 */
	
	// 리스트가 비어있는가?
	public boolean isEmpty() {
		return head.next == head; // 자기 자신을 참조하고 있다.
	}
	
	// 노드를 검색
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head.next;
		
		while (ptr.next != head) {
			if (c.compare(obj, ptr.data) == 0) {
				crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next;
		}
		return null;
	}
	
	// 선택 노드를 출력
	public void printCurrentNode() {
		if (isEmpty())
			System.out.println("선택 노드가 없습니다.");
		else 
			System.out.println(crnt.data);
	}
	
	// 모든 노드를 출력
	public void dump() {
		Node<E> ptr = head.next;
		
		while (ptr != head) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
	
	// 모든 노드를 거꾸로 출력
	public void dumpReverse() {
		Node<E> ptr = head.prev;
		
		while (ptr.prev != head) {
			System.out.println(ptr.data);
			ptr = ptr.prev;
		}
	}
	
	// 선택 노드를 하나 뒤쪽으로 진행
	public boolean next() {
		if (isEmpty() || crnt.next == head)
			return false;
		crnt = crnt.next;
		return true;
	}
	
	// 선택 노드를 하나 앞쪽으로 진행
	public boolean prev() {
		if (isEmpty() || crnt.prev == head) 
			return false;
		crnt = crnt.prev;
		return true;
	}
	
	// 선택노드 바로 뒤에 노드를 삽입
	public void add(E obj) {
		Node<E> node = new Node<E>(obj, crnt, crnt.next);
		crnt.next = crnt.next.prev = node;
		crnt = node;
	}
	
	// 머리에 노드를 삽입
	public void addFirst(E obj) {
		crnt = head;
		add(obj);
	}
	
	// 꼬리에 노드를 삽입
	public void addLast(E obj) {
		crnt = head.prev;
		add(obj);
	}
	
	// 선택 노드를 삭제
	public void removeCurrentNode() {
		if (!isEmpty()) {
			crnt.prev.next = crnt.next;
			crnt.next.prev = crnt.prev;
			crnt = crnt.prev;
			if (crnt == head)
				crnt = head.next;
		}
	}
	
	// 노드 p를 삭제
	public void remove(Node<E> p) {
		Node<E> ptr = head.next; // 기존 머리
		
		while (ptr != head) { // 머리부터 한바퀴 돌기
			if (ptr == p) { // p를 찾으면
				crnt = p; // 선택노드 두고
				removeCurrentNode(); // 삭제
				break; // 반복 끝
			}
			ptr = ptr.next;
		}
	}
	
	// 머리 노드를 삭제
	public void removeFirst() {
		crnt = head.next;
		removeCurrentNode();
	}
	
	// 꼬리 노드를 삭제
	public void removeLast() {
		crnt = head.prev;
		removeCurrentNode();
	}
	
	// 모든 노드를 삭제
	public void clear() {
		while (!isEmpty())
			removeFirst();
	}
}
