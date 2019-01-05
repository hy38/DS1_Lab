import java.util.*;

public class BinaryTree {	//	BinaryTree class �ۼ�
	private int[] tree;
	private int size;

	public BinaryTree() { // constructs the empty tree
	}

	public BinaryTree(int a, int seed) { // ������1 �ۼ�
		size = a;
		tree = new int[a];
		Random r = new Random(seed);
		for (int i = 0; i < tree.length; i++)
			tree[i] = r.nextInt(20) - 10;
	}

	public BinaryTree(int a) {	//	������2 �ۼ�
		tree = new int[a];
		size = a;
		for (int i = 0; i < tree.length; i++)
			tree[i] = i;
	}

	public void levelOrder() {	//	levelOrder() �޼ҵ� �ۼ�
		for (int i = 0; i < tree.length; i++)
			System.out.print(tree[i] + " ");
	}

	public void preOrder(int i) {	//	preOrder() �޼ҵ� �ۼ�

		if (i < size) {
			System.out.print(" " + tree[i]);
			preOrder(2 * i + 1);
			preOrder(2 * i + 2);
		}

	}

	public int size() {	//	size() �޼ҵ� �ۼ�
		return size;
	}

}
