
public class BinarySearchTree {

	private Comparable key;
	private BinarySearchTree left, right;// left, right subtree
	private int size;// Ʈ���� ����� ����
	private Comparable returnedKey;	//	returnedKey�� ������ ���� ����

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

	public BinarySearchTree() {
		this.key = null;
	}

	public BinarySearchTree(int key) {
		this.key = key;
		this.size = 1;
	}

	public int treesize() {
		return size;
	}

	public boolean recu_insert(int key) { // recursion�� ����� insert ����
		if (this.key == null) {
			this.key = key;
			size++;
			return true;
		} else if (this.key.compareTo(key) == 0) { // this.key == key
			return false; // ��� �߰� X
		} else if (this.key.compareTo(key) < 0) { // this.key < key -->right���̵�

			if (right == null) {
				BinarySearchTree a = new BinarySearchTree(key);
				right = a;
				size++;
				return true;
			}
			if (right.recu_insert(key) == true) {
				size++;
				return true;
			}
			return false;
		} else {// this.key > key --> left�� �߰�
			if (left == null) {
				BinarySearchTree b = new BinarySearchTree(key);
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
	int n = 100;; // �迭�ε��� i�� �迭ũ�� n�� ����

	public boolean iter_insert(int key) { // iteration�� ����� insert ����
		this.i = 0;
		BinarySearchTree[] a = new BinarySearchTree[n];
		if (this.key == null) {
			this.key = key;
			this.size++;
			return true;
		}
		BinarySearchTree cNode = this;
		BinarySearchTree temp;
		while (true) {
			if (cNode.key.compareTo(key) < 0) { // this.key < key-->right��
				temp = cNode;
				a[i++] = cNode;
				cNode = cNode.right;

				if (cNode == null) {
					cNode = new BinarySearchTree(key);
					temp.right = cNode;
					for (int j = 0; j < i; j++) {
						a[j].size++;
					}
					return true;
				}
			} else if (cNode.key.compareTo(key) > 0) {// this.key > key -->
														// left��
				temp = cNode;
				a[i++] = cNode;
				cNode = cNode.left;

				if (cNode == null) {
					cNode = new BinarySearchTree(key);
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

	public boolean delete(int key) {
		// 1. ���� Ű�� ���� ��带 Ž���ϸ鼭 ��ġ�� ��� �θ��带 �迭�� ����
		// 2. Ž�� ���� :
		// case1 : Ž���� ��尡 ��������� ��� ���� �� return false
		// case2 : Ž���� ��尡 �ϳ��� ����Ʈ���� ���� ���
		// case3 : Ž���� ��尡 �� ����Ʈ�� ��θ� ������ ���
		// 3. Ž�� ���� : return false

		BinarySearchTree cNode = this;
		BinarySearchTree[] a = new BinarySearchTree[n];
		BinarySearchTree temp;
		this.i = 0;

		while (true) {
			if (cNode.key.compareTo(key) < 0) { // this.key < key-->right�� Ž��
				temp = cNode;
				a[i++] = cNode;
				cNode = cNode.right;

				if (cNode == null)
					return false;

			} else if (cNode.key.compareTo(key) > 0) { // this.key > key-->left�� Ž��
				temp = cNode;
				a[i++] = cNode;
				cNode = cNode.left;

				if (cNode == null)
					return false;

			} else if (cNode.key.compareTo(key) == 0) { // cNode���� ã��!
				//	case�з� ����!
				if (cNode.size == 1) { // case1
					if (a[i - 1].left == cNode)	//	�迭�� �̿��Ͽ� �θ� ����
						a[i - 1].left = null;
					if (a[i - 1].right == cNode)
						a[i - 1].right = null;
					for (int j = 0; j < i; j++)
						a[j].size--;
					return true;
				}

				else if (cNode.size == 2) { // case2
					if (a[i - 1].left == cNode) {	//	�迭�� �̿��Ͽ� �θ� ����
						if (cNode.left == null) { // �ڽ��� �����ʿ� ��ġ�ϸ�,
							a[i - 1].left = a[i - 1].left.right;
						} 
						else if (cNode.right == null) { // �ڽ��� ���ʿ� ��ġ�ϸ�,
							a[i - 1].left = a[i - 1].left.left;
						}
					} 
					else if (a[i - 1].right == cNode) {
						if (cNode.left == null) { // �ڽ��� �����ʿ� ��ġ�ϸ�,
							a[i - 1].right = a[i - 1].right.right;
						} 
						else if (cNode.right == null) { // �ڽ��� ���ʿ� ��ġ�ϸ�,
							a[i - 1].right = a[i - 1].right.left;
						}
					}
					
					for (int j = 0; j < i; j++)
						a[j].size--;
					return true;
				} 
				
				else { // case3
					returnedKey = cNode.key = delete_minimum(cNode);
					for (int j = 0; j < i; j++)
						a[j].size--;
					return true;
				}
			}
		}
	}

	public Comparable delete_minimum(BinarySearchTree T) { // T�� ������ ����Ʈ���� �ּڰ� ��ȯ �޼ҵ�
		int i = 0;
		BinarySearchTree[] array = new BinarySearchTree[100];
		if (T.left != null && T.right != null) { // case3�� BST������ �޼ҵ尡 �۵������ϰ�
													// ������ ��
			array[i++] = T; // �Ű������� ���� ó�� Tree(key�� ��ü�Ϸ��� tree)�� ù�ε����� ����
			T = T.right; // T�� right subtree���� minimum�� �����ؾ���.
			array[i++] = T; // �Ű������� ���� Tree�� right subtree�� �迭�� ����
		} else
			return false;

		while (true) { // search

			if (T.left.size == 1) {	//	T.left�� leaf����� ���
				Comparable temp = T.left.key;	//	temp�� leaf����� Ű�� �ְ�
				T.left = null;	//	leaf��带 �����ϰ�
				for (int j = 0; j < i; j++)	//	size�� update
					array[j].size--;

				return temp;	//	temp�� ����
			} 
			else if (T.left.left == null && T.left.right != null) {	//	T.left�� ������ �ڽ��� �ִ� ���
				Comparable temp = T.left.key;	//	temp�� leaf����� Ű�� �ְ�
				T.left = T.left.right;	//	leaf��带 �����ϰ�
				for (int j = 0; j < i; j++)	//	size�� update
					array[j].size--;

				return temp;	//	temp�� ����
			} 
			else {	//	�� �̿��� ���
				T = T.left;	//	������ ��� Ž���ϸ� delete_minimum ����
				array[i++] = T;
			}
		}
	}

	public void inorder() {
		// Ʈ���� ���� ��ȸ �ϸ鼭 ����� key�� �ش� ��带 root�� �ϴ� ���� Ʈ����
		// size ���
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

	public Comparable getReturnedKey() {
		return returnedKey;
	}

}