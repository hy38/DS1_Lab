
public class BinarySearchTree {

	private Comparable key;
	private BinarySearchTree left, right;// left, right subtree
	private int size;// 트리의 사이즈를 저장
	private Comparable returnedKey;	//	returnedKey를 저장할 변수 생성

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

	public boolean recu_insert(int key) { // recursion을 사용한 insert 구현
		if (this.key == null) {
			this.key = key;
			size++;
			return true;
		} else if (this.key.compareTo(key) == 0) { // this.key == key
			return false; // 노드 추가 X
		} else if (this.key.compareTo(key) < 0) { // this.key < key -->right로이동

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
		} else {// this.key > key --> left에 추가
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
	int n = 100;; // 배열인덱스 i와 배열크기 n을 선언

	public boolean iter_insert(int key) { // iteration을 사용한 insert 구현
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
			if (cNode.key.compareTo(key) < 0) { // this.key < key-->right를
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
														// left에
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
		// 1. 같은 키를 가진 노드를 탐색하면서 거치는 모든 부모노드를 배열에 저장
		// 2. 탐색 성공 :
		// case1 : 탐색한 노드가 리프노드인 경우 삭제 후 return false
		// case2 : 탐색한 노드가 하나의 서브트리를 가진 경우
		// case3 : 탐색한 노드가 두 서브트리 모두를 가지는 경우
		// 3. 탐색 실패 : return false

		BinarySearchTree cNode = this;
		BinarySearchTree[] a = new BinarySearchTree[n];
		BinarySearchTree temp;
		this.i = 0;

		while (true) {
			if (cNode.key.compareTo(key) < 0) { // this.key < key-->right를 탐색
				temp = cNode;
				a[i++] = cNode;
				cNode = cNode.right;

				if (cNode == null)
					return false;

			} else if (cNode.key.compareTo(key) > 0) { // this.key > key-->left를 탐색
				temp = cNode;
				a[i++] = cNode;
				cNode = cNode.left;

				if (cNode == null)
					return false;

			} else if (cNode.key.compareTo(key) == 0) { // cNode까지 찾음!
				//	case분류 시작!
				if (cNode.size == 1) { // case1
					if (a[i - 1].left == cNode)	//	배열을 이용하여 부모를 접근
						a[i - 1].left = null;
					if (a[i - 1].right == cNode)
						a[i - 1].right = null;
					for (int j = 0; j < i; j++)
						a[j].size--;
					return true;
				}

				else if (cNode.size == 2) { // case2
					if (a[i - 1].left == cNode) {	//	배열을 이용하여 부모를 접근
						if (cNode.left == null) { // 자식이 오른쪽에 위치하면,
							a[i - 1].left = a[i - 1].left.right;
						} 
						else if (cNode.right == null) { // 자식이 왼쪽에 위치하면,
							a[i - 1].left = a[i - 1].left.left;
						}
					} 
					else if (a[i - 1].right == cNode) {
						if (cNode.left == null) { // 자식이 오른쪽에 위치하면,
							a[i - 1].right = a[i - 1].right.right;
						} 
						else if (cNode.right == null) { // 자식이 왼쪽에 위치하면,
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

	public Comparable delete_minimum(BinarySearchTree T) { // T의 오른쪽 서브트리의 최솟값 반환 메소드
		int i = 0;
		BinarySearchTree[] array = new BinarySearchTree[100];
		if (T.left != null && T.right != null) { // case3의 BST에서만 메소드가 작동가능하게
													// 제약을 둠
			array[i++] = T; // 매개변수로 받은 처음 Tree(key를 교체하려는 tree)를 첫인덱스에 삽입
			T = T.right; // T의 right subtree에서 minimum을 삭제해야함.
			array[i++] = T; // 매개변수로 받은 Tree의 right subtree를 배열에 삽입
		} else
			return false;

		while (true) { // search

			if (T.left.size == 1) {	//	T.left가 leaf노드인 경우
				Comparable temp = T.left.key;	//	temp에 leaf노드의 키를 넣고
				T.left = null;	//	leaf노드를 제거하고
				for (int j = 0; j < i; j++)	//	size를 update
					array[j].size--;

				return temp;	//	temp를 리턴
			} 
			else if (T.left.left == null && T.left.right != null) {	//	T.left가 오른쪽 자식이 있는 경우
				Comparable temp = T.left.key;	//	temp에 leaf노드의 키를 넣고
				T.left = T.left.right;	//	leaf노드를 제거하고
				for (int j = 0; j < i; j++)	//	size를 update
					array[j].size--;

				return temp;	//	temp를 리턴
			} 
			else {	//	그 이외의 경우
				T = T.left;	//	왼쪽을 계속 탐색하며 delete_minimum 수행
				array[i++] = T;
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

	public Comparable getReturnedKey() {
		return returnedKey;
	}

}