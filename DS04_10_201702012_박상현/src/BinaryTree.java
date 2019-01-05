import java.util.*;

public class BinaryTree {	//	BinaryTree class 累己
	private int[] tree;
	private int size;

	public BinaryTree() { // constructs the empty tree
	}

	public BinaryTree(int a, int seed) { // 积己磊1 累己
		size = a;
		tree = new int[a];
		Random r = new Random(seed);
		for (int i = 0; i < tree.length; i++)
			tree[i] = r.nextInt(20) - 10;
	}

	public BinaryTree(int a) {	//	积己磊2 累己
		tree = new int[a];
		size = a;
		for (int i = 0; i < tree.length; i++)
			tree[i] = i;
	}

	public void levelOrder() {	//	levelOrder() 皋家靛 累己
		for (int i = 0; i < tree.length; i++)
			System.out.print(tree[i] + " ");
	}

	public void preOrder(int i) {	//	preOrder() 皋家靛 累己

		if (i < size) {
			System.out.print(" " + tree[i]);
			preOrder(2 * i + 1);
			preOrder(2 * i + 2);
		}

	}

	public int size() {	//	size() 皋家靛 累己
		return size;
	}

}
