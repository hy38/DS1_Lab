
public class BST {

	private Comparable key;
	private BST left, right;// left, right subtree
	private int size;// 트리의 사이즈를 저장

	private class Node implements Comparable {
		@Override
		public int compareTo(Object o) {
			int objects = (int) o;
			if ((int) key < objects)
				return -1;
			else if ((int) key > objects)
				return 1;
			else
				return 0;
		}
	}

	public BST() {
		this.key = null;
	}

	public BST(int key) {
		this.key = key;
		this.size = 1;
	}

	public int treesize() {
		return size;
	}

	public boolean recu_insert(int key) { // recursion을 사용한 insert 구현
		if (this.key == null) {
			this.key = key;
			size++;
			return true;
		} else if (this.key.compareTo(key) == 0) { // this.key == key
			return false; // 노드 추가 X
		} else if (this.key.compareTo(key) < 0) { // this.key < key -->right로이동

			if (right == null) {
				BST a = new BST(key);
				right = a;
				size++;
				// a.size++;
				return true;
			}
			if (right.recu_insert(key) == true) {
				size++;
				return true;
			}
			return false;
		} else {// this.key > key --> left에 추가
			if (left == null) {
				BST b = new BST(key);
				left = b;
				size++;
				// b.size++;
				return true;
			}
			if (left.recu_insert(key) == true) {
				size++;
				return true;
			}
			return false;
		}
	}

	int i = 0;
	int n = 100; // 배열인덱스 i와 배열크기 n을 선언

	public boolean iter_insert(int key) { // iteration을 사용한 insert 구현
		this.i = 0;
		BST[] a = new BST[n];
		if (this.key == null) {
			this.key = key;
			this.size++;
			return true;
		}
		BST cNode = this;
		BST temp;
		while (true) {
			if (cNode.key.compareTo(key) < 0) { // this.key < key-->right를
				temp = cNode;
				a[i++] = cNode;
				cNode = cNode.right;

				if (cNode == null) {
					cNode = new BST(key);
					temp.right = cNode;
					for (int j = 0; j < i; j++) {
						a[j].size++;
					}
					return true;
				}
			} else if (cNode.key.compareTo(key) > 0) {// this.key > key -->
														// left에
				temp = cNode;
				a[i++] = cNode;
				cNode = cNode.left;

				if (cNode == null) {
					cNode = new BST(key);
					temp.left = cNode;
					for (int j = 0; j < i; j++) {
						a[j].size++;
					}
					return true;
				}

			} else {
				return false;
			}
		}
	}

	public void inorder() {
		// 트리를 중위 순회 하면서 노드의 key와 해당 노드를 root로 하는 서브 트리의
		// size 출력
		if (this.left != null) {
			left.inorder();
		}
		System.out.println("Visited : " + key + ", TreeSize : " + treesize());

		if (this.right != null) {
			right.inorder();
		}
	}

	public String toString() { // for ease of debugging
		return "key : " + key + "   size : " + treesize();
	}
}