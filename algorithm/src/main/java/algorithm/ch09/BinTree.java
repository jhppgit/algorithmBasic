package algorithm.ch09;

import java.util.Comparator;

// 이진검색트리
public class BinTree<K, V> {
	// 노드
	static class Node<K, V> {
		private K key;
		private V data;
		private Node<K, V> left; // 왼쪽 포인터(자식)
		private Node<K, V> right; // 오른쪽 포인터(자식)
		
		// 생성자
		Node(K key, V data, Node<K, V> left, Node<K, V> right) {
			this.key = key;
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		// 키값을 반환
		K getKey() {
			return key;
		}
		
		V getValue() {
			return data;
		}
		
		void print() {
			System.out.println(data);
		}
	}
	
	private Node<K, V> root; // 루트
	private Comparator<? super K> comparator = null;
	
	// 생성자
	public BinTree() {
		root = null; // 자연 순서에 따라 키값을 비교
	}
	
	public BinTree(Comparator<? super K> c) {
		this();
		comparator = c;
	}
	
	// 두 키값을 비교
	private int comp(K key1, K key2) {
		return (comparator == null) ? ((Comparable<K>)key1).compareTo(key2) // comparator가 정의되지 않았으면 자료형에 맞는거 알아서
				: comparator.compare(key1, key2); // 정의됐으면 comparator 사용
	}
	
	// 키로 검색
	public V search(K key) {
		Node<K, V> p = root; // 루트에 주목
		
		while (true) {
			if (p == null) // 더이상 진행할 수 없으면
				return null; // 검색 실패
			int cond = comp(key, p.getKey()); // key와 노드p의 키값을 비교
			if (cond == 0) // 같으면
				return p.getValue(); // 검색 성공
			else if (cond < 0) // key쪽이 작으면
				p = p.left; // 왼쪽 서브트리에서 검색
			else // key쪽이 크면
				p = p.right; // 오른쪽 서브트리에서 검색
		}
	}
	
	// node를 루트로 하는 서브트리에 노드<K, V>를 삽입
	private void addNode(Node<K, V> node, K key, V data) {
		int cond = comp(key, node.getKey());
		if (cond == 0)
			return; // key가 이진트리에 이미 있음
		else if (cond < 0) {
			if (node.left == null) // 자리가 비었으면
				node.left = new Node<K, V>(key, data, null, null); // 노드 넣기
			else
				addNode(node.left, key, data); // 왼쪽 서브트리에 주목
		} else {
			if (node.right == null)
				node.right = new Node<K, V>(key, data, null, null);
			else
				addNode(node.right, key, data); // 오른쪽 서브트리에 주목
		}
	}
	
	// 노드를 삽입
	public void add(K key, V data) {
		if (root == null) // 루트가 비었다면
			root = new Node<K, V>(key, data, null, null); // 루트에 넣기
		else
			addNode(root, key, data);
	}
	
	// key값이 key인 노드를 삭제
	/*
	 * case 1) 자식이 없는 노드를 삭제
	 * case 2) 자식이 하나인 노드를 삭제
	 * case 3) 자식이 둘인 노드를 삭제
	 * 
	 * 삭제하려는 노드 node
	 * 1) node의 부모에서 참조를 끊는다. 왼쪽 자식이면 부모노드.left = null;
	 * 2) node의 부모가 참조하던 것을 node의 자식으로 바꾼다
	 * 3) node의 자식 중 가장 큰것(왼쪽 서브트리중 제일 오른쪽 잎)의 값을 복사해 node에 넣고
	 *    복사한 노드를 삭제
	 */
	public boolean remove(K key) {
		Node<K, V> p = root; // 스캔중인 노드(포인터)
		Node<K, V> parent = null; // 스캔중인 노드의 부모노드
		boolean isLeftChild = true; // p가 부모의 자식노드?
		
		while (true) { // 검색
			if (p == null) 						// 더이상 나아갈 수 없다면
				return false; 					// 그 키값은 없음
			int cond = comp(key, p.getKey()); 	// 키와 노드 p의 키값을 비교
			if (cond == 0) 						// 같으면
				break; 							// 검색 성공
			else {
				parent = p; 					// 가지로 내려가기 전에 미리 부모를 설정
				if (cond < 0) { 				// key쪽이 작으면
					isLeftChild = true; 		// 왼쪽 자식으로 내려감
					p = p.left; 				// 왼쪽 서브트리에서 검색
				} else { 						// key쪽이 크면
					isLeftChild = false; 		// 오른쪽 자식으로 내려감
					p = p.right;				// 오른쪽 서브트리에서 검색
				}
			}
		} // 검색 완료. p는 삭제 대상 노드를 가리킨다.
		
		if (p.left == null) {			// p에 왼쪽 자식이 없음
			if (p == root) // 삭제하려는 대상이 루트일 때
				root = p.right;
			else if (isLeftChild)
				parent.left = p.right; // 부모의 왼쪽 포인터가 오른쪽 자식을 가리킴
			else
				parent.right = p.right; // 부모의 오른쪽 포인터가 오른쪽 자식을 가리킴
		} else if (p.right == null) { // p에 오른쪽 자식이 없음
			if (p == root) // 삭제하려는 대상이 루트일 때
				root = p.left;
			else if (isLeftChild)
				parent.left = p.left; // 부모의 왼쪽 포인터가 왼쪽 자식을 가리킴
			else
				parent.right = p.left; // 부모의 오른쪽 포인터가 왼쪽 자식을 가리킴
		} else {
			parent = p;
			Node<K, V> left = p.left; // 서브트리 가운데 가장 큰 노드
			isLeftChild = true;
			while (left.right != null) { // 가장 큰 노드 left를 검색
				parent = left;
				left = left.right;
				isLeftChild = false;
			}
			p.key = left.key; // left의 키값을 p로 옮김
			p.data = left.data; // left의 데이터를 p로 옮김
			if(isLeftChild)
				parent.left = left.left; // left를 삭제
			else
				parent.right = left.left; // left를 삭제
		}
		return true;
	}
	
	// node를  루트로 하는 서브트리의 노드를 키값의 오름차순으로 출력 (중위순회)
	private void printSubTree(Node<K, V> node) {
		if (node != null) {
			printSubTree(node.left); // 왼쪽 서브트리를 키값으 오름차순으로 출력
			System.out.println(node.key + " "  + node.data);
			printSubTree(node.right); // 오른쪽 서브트리를 키값의 오름차순으로 출력
		}
	}
	
	public void print() {
		printSubTree(root);
	}
	
}


























