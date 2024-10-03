package algorithm.ch08;

import java.util.Comparator;

// 연결 리스트 클래스(배열 커서 버전)
/*
 * 배열에 데이터를 담은 연결 리스트에서 노드를 삭제하면 배열에 빈공간이 불규칙하게 생긴다
 * 그 빈공간의 인덱스들을 저장해 둘 프리 리스트를 연결리스트로 만든다.
 * 프리 리스트 : 부활 대기자 명단
 * deleted가 그 프리 리스트들의 헤드이고 max는 배열에서 현재 사용중인 공간의 끝값이다.
 * 배열에서 max 이후 인덱스들은 모두 비어있고. 필요하다면 max값을 늘려 배열의 더 넓은 공간을 사용한다(max가 배열의 크기는 아님)
 * ex) capacity가 8이고 max가 5라면 8 크기의 배열에서 6개칸만 사용중. 삭제해도 6개의 칸 안에서 삭제하고 채워놓고 한다.
 * 노드를 추가할 때 프리리스트의 head에 해당하는 인덱스(deleted)에 값을 대입하고 프리리스트를 removeFirst().
 *  -> n[deleted] = 추가하려는 노드; 
 *  n번째 record : 배열의 n번째 들이있는 노드
 */
public class ArrayLinkedList<E> {
	
	// 노드
	class Node<E> {
		private E data;
		private int next; // 리스트의 뒷쪽 포인터
		private int dnext; // 프리 리스트의 뒷쪽 포인터
		
		// data와 next를 설정
		void set(E data, int next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<E>[] n; // 리스트(배열) 본체
	private int size; // 리스트(배열) 본체 크기
	private int max; // 사용중인 꼬리 record -> 배열에서 인덱스가 max를 넘는 부분은 아직 사용중이 아니다.
	private int head; // 머리 노드
	private int crnt; // 선택 노드
	private int deleted; // 프리 리스트의 머리노드
	private static final int NULL = -1; // 다음노드 없음, 리스트가 가득 참
	
	// 생성자
	public ArrayLinkedList(int capacity) {
		head = crnt = max = deleted = NULL;
		try {
			n = new Node[capacity];
			for (int i = 0; i < capacity; i++)
				n[i] = new Node<E>(); // 배열을 노드로 채우기
			size = capacity;
		} catch (OutOfMemoryError e) { // 배열생성 실패
			size = 0;
		}
	}
	
	// 다음에 삽입하는 record의 인덱스를 구함
	private int getInsertIndex() {
		if (deleted == NULL) { // 삭제할 record가 없음 -> 프리 리스트가 비어있음
			if (max < size)
				return max++; // 사용하는 배열의 영역 넓히기, 새 record를 사용ㅇ
			else
				return NULL; // 용량 넘침
		}  else  {
			int rec = deleted; // 프리 리스트에서 헤드 가져오기
			deleted = n[rec].dnext; // 프리 리스트의 헤드를 다음 요소로 옮김
			return rec;
		}
	}
	
	// record idx를 프리 리스트에 등록
	private void deleteIndex(int idx) {
		if (deleted == NULL) { // 삭제할 record가 없음, 프리 리스트가 비어있음
			deleted = idx; // idx를 프리 리스트의 헤드에 등록
			n[idx].dnext = NULL; // 머리니까 다음은 null
		} else {
			int rec = deleted; // idx를 프리 리스트의 머리에 삽입
			deleted = idx;
			n[idx].dnext = rec; // 기존의 헤드를 새로운 헤드의 dnext에 대입
		}
	}
	
	// 노드를 검색
	public E search(E obj, Comparator<? super E> c) {
		int ptr = head; // 현재 스캔중인 노드
		
		while (ptr != NULL) {
			if (c.compare(obj, n[ptr].data) == 0) {
				crnt = ptr;
				return n[ptr].data;
			}
		}
		return null; // 검색 실패
	}
	
	// 머리에 노드를 삽입
	public void addFirst(E obj) {
		int ptr = head; // 삽입 전의 머리 노드
		int rec = getInsertIndex();
		if (rec != NULL) { // 들어갈 자리가 있다면
			head = crnt = rec; // 인덱스 rec인 record에 삽입
			n[rec].set(obj, ptr); // 기존의 머리를 next에 대입
		}
	}
	
	// 꼬리에 노드를 삽입
	public void addLast(E obj) {
		if (head == NULL)
			addFirst(obj); // 리스트가 비어있다면 머리에 넣기
		else {
			int ptr = head;
			while (n[ptr].next != NULL)
				ptr = n[ptr].next; // ptr을 연결리스트의 꼬리로 만들기
			int rec = getInsertIndex();
			if (rec != NULL) { // 들어갈 자리가 있다면
				n[rec].set(obj, NULL); // 새 꼬리를 만들고
				n[ptr].next = crnt = rec; // 선택 커서와 이전 꼬리의 next를 새 꼬리에 연결
			}
		}
	}
	
	// 머리 노드를 삭제
	public void removeFirst() {
		if (head != NULL) { // 리스트가 비어있지 않다면
			int ptr = n[head].next; // 머리 다음의 인덱스
			deleteIndex(head); // 기존 머리를 프리 리스트에 넣기
			head = crnt = ptr; // 새로운 헤드는 ptr
		}
	}
	
	// 꼬리 노드를 삭제
	public void removeLast() {
		if (head != NULL) { // 리스트가 비어있지 않다면
			if (n[head].next == NULL) // 노드가 하나만 있다면
				removeFirst(); // 머리노드를 삭제
			else {
				int ptr = head; // 스캔중인 노드
				int pre = head; // 스캔중인 노드의 앞 노드
				
				while (n[ptr].next != NULL) {
					pre = ptr;
					ptr = n[ptr].next;
				}
				n[pre].next = NULL; // pre는 삭제 후 꼬리 노드
				deleteIndex(ptr); // ptr을 프리 리스트에 넣기
				crnt = pre; // 선택 커서 옮기기
			}
		}
	}
	
	// record p를 삭제
	public void remove(int p) {
		if (head != NULL) { // 리스트가 비어있지 않다면
			if (p == head) // p가 머리노드라면
				removeFirst(); // 머리 노드를 삭제
			else {
				int ptr = head;
				
				while (n[ptr].next != p) { // 반복문을 빠져나오면 ptr이 n 바로 전 노드가 된닥
					ptr = n[ptr].next;
					if (ptr == NULL) return; // 리스트 끝까지 가도 p가 없음
				}
				n[ptr].next = NULL; // p 참조를 끊고
				deleteIndex(p); // 프리 리스트에 p를 추가하고
				n[ptr].next = n[p].next; // ptr에서 p의 다음 노드에 연결
				crnt = ptr; // 커서 변경
			}
		}
	}
	
	// 선택 노드를 삭제
	public void removeCurrentNode() {
		remove(crnt);
	}
	
	// 모든 노드를 삭제
	public void clear() {
		while (head != NULL) // 텅 빌 때까지
			removeFirst(); // 머리 노드를 삭제
		crnt = NULL;
	}
	
	// 선택 노드를 하나 뒤쪽으로 진행
	public boolean next() {
		if (crnt == NULL || n[crnt].next == NULL) // 선택 노드나 선택 노드 다음이 존재하지 않으면(다음으로 갈 수 없으면)
			return false; // false 반환
		crnt = n[crnt].next;
		return true;
	}
	
	// 선택 노드를 출력
	public void printCurrentNode() {
		if (crnt == NULL) // 선택된 노드가 없으면
			System.out.println("선택된 노드가 없습니다.");
		else
			System.out.println(n[crnt].data);
	}
	
	// 모든 노드를 출력
	public void dump() {
		int ptr = head;
		
		while (ptr != NULL) {
			System.out.println(n[ptr].data);
			ptr = n[ptr].next;
		}
	}
}




















