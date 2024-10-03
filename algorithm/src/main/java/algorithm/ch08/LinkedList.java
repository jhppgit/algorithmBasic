package algorithm.ch08;

import java.util.Comparator;

// 연결리스트 클래스
public class LinkedList<E> {
	// 노드
	class Node<E> {
		private E data; // 데이터
		private Node<E> next; // 뒷쪽 포인터
		
		// 생성자
		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<E> head; // 머리 포인터
	private Node<E> crnt; // 선택 노드
	
	// 생성자
	public LinkedList() {
		head = crnt = null;
	}
	
	// 노드 검색
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head; // 현재 스캔중인 노드
		
		while (ptr != null) { // 리스트 끝까지
			if (c.compare(obj, ptr.data) == 0) { // 검색 성공
				crnt = ptr; // 선택 포인터 변경
				return ptr.data; // data 반환
			}
			ptr = ptr.next; // 다음 노드 선택
		}
		return null; // 검색 실패
	}
	
	// 머리에 노드삽입
	public void addFirst(E obj) {
		Node<E> ptr = head; // 삽입 전의 머리노드
		head = crnt = new Node<E>(obj, ptr); // 기존 헤드를 포인터에 대입
	}
	
	// 꼬리에 노드삽입
	/*
	 * 리스트가 비어있는지 확인
	 *  -> 비어있다면 헤드에 삽입(addFirst)
	 * 비어있지 않다면
	 *  -> 꼬리에 노드삽입
	 */
	public void addLast(E obj) {
		if (head == null)
			addFirst(obj);
		else {
			Node<E> ptr = head;
			while (ptr.next != null) // ptr의 다음이 null일 때 탈출 -> ptr은 꼬리
				ptr = ptr.next;
			ptr.next = crnt = new Node<E>(obj, null);
		}
	}
	
	// 머리노드를 삭제
	public void removeFirst() {
		if (head != null) // 리스트가 비어있지 않으면
			head = crnt = head.next;
	}
	
	// 꼬리노드를 삭제
	/*
	 * 리스트에 노드가 1개만 있는 경우
	 *  -> 머리노드 삭제
	 * 리스트에 노드가 2개 이상
	 *  -> 꼬리노드 삭제
	 */
	public void removeLast() {
		if (head != null) { // 비어있지 않다면
			if (head.next == null) // 노드가 하나라면
				removeFirst();
			else {
				Node<E> ptr = head; // 스캔중인 노드
				Node<E> pre = head; // 스캔중인 노드의 바로 전 노드
				
				while (ptr.next != null) {
					pre = ptr; // 넣고
					ptr = ptr.next; // ptr은 하나 앞으로
				}
				pre.next = null; // 바로 전 노드에서 잘라버리기
				crnt = pre;
			}
		}
	}
	
	// 노드 p를 삭제
	/*
	 * p가 머리노드일경우
	 *  -> 머리노드 삭제
	 * p가 머리노드가 아닐 경우
	 *  -> 연결리스트에서 p가 참조하는 노드 삭제
	 */
	public void remove(Node p) {
		if (head != null) { // 빈 리스트가 아니라면
			if (p == head)
				removeFirst();
			else {
				Node<E> ptr = head;
				while (ptr.next != p) {
					ptr = ptr.next;
					if (ptr == null) return; // p가 리스트에 없음
				}
				ptr.next = p.next;
				crnt = ptr;
			}
		}
	}
	
	// 선택 노드를 삭제
	public void removeCurrentNode() {
		remove(crnt);
	}
	
	public void clear() {
		while (head != null)
			removeFirst();
		crnt = null;
	}
	
	// 선택 노드를 하나 뒤쪽으로 진행
	public boolean next() {
		if (crnt == null || crnt.next == null)
			return false;
		crnt = crnt.next;
		return true;
	}
	
	// 선택 노드를 출력
	public void printCurrentNode() {
		if (crnt == null)
			System.out.println("선택한 노드가 없습니다.");
		else
			System.out.println(crnt.data);
	}
	
	// 모든 노드를 출력
	public void dump() {
		Node<E> ptr = head;
		
		while (ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
}
