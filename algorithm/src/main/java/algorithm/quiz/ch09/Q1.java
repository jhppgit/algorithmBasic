package algorithm.quiz.ch09;

import java.util.Comparator;

// 이진검색트리에 모든 노드를 키값의 내림차순으로 출력하는 메서드 printReverse() 작성
public class Q1 {
	public class BinTree<K, V> {
		static class Node<K, V> {
			private K key;
			private V data;
			private Node<K, V> left;
			private Node<K, V> right;
			
			Node(K key, V data, Node<K, V> left, Node<K, V> right){
				this.key = key;
				this.data = data;
				this.left = left;
				this.right = right;
			}
			
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
		
		Node<K, V> root;
		Comparator<? super K> comparator = null;
		
		public BinTree() {
			root = null;
		}
		
		public BinTree(Comparator<? super K> c) {
			this();
			comparator = c;
		}
		
		private int comp(K key1, K key2) {
			return (comparator == null) ? ((Comparable<K>)key1).compareTo(key2) : comparator.compare(key1, key2);
		}
		
		public V search(K key) {
			Node<K, V> p = root;
			
			while (p != null) {
				int cond = comp(key, p.getKey());
				if (cond == 0)
					return p.getValue();
				else if (cond > 0)
					p = p.right;
				else
					p = p.left;
			}
			return null;
		}
		
		public void addNode(Node<K, V> node, K key, V data) {
			int cond = comp(key, node.getKey());
			if (cond == 0)
				return;
			else if (cond < 0) {
				if (node.left == null)
					node.left = new Node<K, V>(key, data, null, null);
				else
					addNode(node.left, key, data);
			} else {
				if (node.right == null)
					node.right = new Node<K, V>(key, data, null, null);
				else 
					addNode(node.right, key, data);
			}
		}
		
		public void add(K key, V data) {
			if (root == null)
				root = new Node<K, V>(key, data, null, null);
			else
				addNode(root, key, data);
		}
		
		public boolean remove(K key) {
			// key와 일치하는 p를 찾고 그 부모도 노드로 저장
			Node<K, V> p = root;
			Node<K, V> parent = null;
			boolean isLeftChild = false;
			
			while (true) {
				if (p == null)
					return false;
				int cond = comp(key, p.getKey());
				if (cond == 0)
					break;
				else {
					parent = p;
					if (cond > 0) {
						isLeftChild = false;
						p = p.right;
					} else {
						isLeftChild = true;
						p = p.left;
					}
				}			
			}
			
			if (p.left == null) { // 왼쪽 자식이 없으면
				if (p == root)
					root = p.right;
				else if (isLeftChild)
					parent.left = p.right;
				else
					parent.right = p.right;
			} else if (p.right == null) {
				if (p == root)
					root = root.left;
				else if (isLeftChild)
					parent.left = p.left;
				else
					parent.right = p.left;
			} else { // 둘다 있으면
				parent = p;
				Node<K, V> node = p.left;
				isLeftChild = true;
				while (node.right != null) {
					parent = node;
					node = node.right;
					isLeftChild = false;
				}
				p.key = node.key;
				p.data = node.data;
				if (isLeftChild)
					parent.left = null;
				else
					parent.right = null;
			}
			return true;
		}
		
		private void printSubTree(Node<K, V> node) {
			if (node != null) {
				printSubTree(node.left);
				System.out.println(node.key + " " + node.data);
				printSubTree(node.right);
			}
		}
		
		public void print() {
			printSubTree(root);
		}
		
		private void printSubTreeReverse(Node<K, V> node) {
			if (node != null) {
				printSubTreeReverse(node.right);
				System.out.println(node.key + " " + node.data);
				printSubTreeReverse(node.left);
			}
		}
		
		public void printReverse() {
			printSubTreeReverse(root);
		}
		
	}
}
