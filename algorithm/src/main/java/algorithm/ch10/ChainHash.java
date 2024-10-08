package algorithm.ch10;

// 체인법에 의한 해시
public class ChainHash<K, V> {
	// 해시를 구성하는 노드
	class Node<K, V> {
		private K key;				// 키값
		private V data;				// 데이터
		private Node<K, V> next;	// 다음 노드에 대한 참조
		
		// 생성자
		Node(K key, V data, Node<K, V> next) {
			this.key = key;
			this.data = data;
			this.next = next;
		}
		
		// 키값을 반환
		K getKey() {
			return key;
		}
		
		// 데이터를 반환
		V getValue() {
			return data;
		}
		
		// 키의 해시값을 반환
		public int hashCode() {
			return key.hashCode();
		}
	}
	
	private int size; // 해시 테이블의 크기
	private Node<K, V>[] table; // 해시 테이블
	
	// 생성자
	public ChainHash(int capacity) {
		try {
			table = new Node[capacity];
			size = capacity;
		} catch(OutOfMemoryError e) { // 테이블을 생성할 수 없음
			size = 0;
		}
	}
	
	// 해시값을 구함
	public int hashValue(Object key) {
		return key.hashCode() % size;
	}
	
	// 키값이 key인 요소를 검색(데이터를 반환)
	public V search(K key) {
		int hash = hashValue(key); // 검색할 데이터의 해시값
		Node<K, V> p = table[hash]; // 선택 노드
		
		while(p != null) {
			if (p.getKey().equals(key))
				return p.getValue(); // 검색 성공
			p = p.next; // 다음 노드를 선택
		}
		return null; // 검색 실패
	}
	
	// 키값이 key이고 데이터가 data인 요소를 추가
	public int add(K key, V data) {
		int hash = hashValue(key);
		Node<K, V> p = table[hash];
		
		while (p != null) {
			if (p.getKey().equals(key))
				return 1; // 이 값은 이미 등록됨
			p = p.next;
		}
		Node<K, V> temp = new Node<K, V>(key, data, table[hash]);
		table[hash] = temp; // 노드를 삽입(맨 앞에)
		return 0;
	}
	
	// 키값이 key인 요소를 삭제
	public int remove(K key) {
		int hash = hashValue(key); // 삭제할 데이터의 해시값
		Node<K, V> p = table[hash]; // 선택 노드
		Node<K, V> pp = null; // 바로 앞의 선택 노드
		
		while (p != null) {
			if (p.getKey().equals(key)) { // 찾으면
				if (pp == null) {
					table[hash] = p.next;
				} else 
					pp.next = p.next;
				return 0;
			}
			pp = p;
			p = p.next; // 다음 노드를 선택
		}
		return 1; // 그 키값은 없음
	}
	
	// 해시 테이블을 덤프
	public void dump() {
		for (int i = 0; i < size; i++) {
			Node<K, V> p = table[i];
			System.out.printf("%02d ", i);
			while(p != null) {
				System.out.printf("-> %s (%s)  ", p.getKey(), p.getValue());
				p = p.next;
			}
			System.out.println();
		}
	}
}
