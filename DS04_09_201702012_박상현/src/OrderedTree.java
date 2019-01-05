import java.util.*;
import java.util.ArrayList;

public class OrderedTree { // OrderedTree class �ۼ�
	private Object root;
	private List subtrees;
	private int size;

	public OrderedTree() { // constructs the empty tree
	}

	public OrderedTree(Object root) { // constructs a singleton
		this.root = root;
		subtrees = new LinkedList<>();
		size = 1;
	}

	public OrderedTree(Object root, List trees) { // OrderedTree ������ ����. List ���
		this(root);
		for (Iterator it = trees.iterator(); it.hasNext();) {
			Object object = it.next();
			if (object instanceof OrderedTree) {
				OrderedTree tree = (OrderedTree) object;
				subtrees.add(tree);
				size += tree.size();
			}
		}
	}

	public void levelOrder() { // queue�� ���̺귯�� ��� ����
		Queue aq = new ArrayQueue();// 1. ť�� �ʱ�ȭ.

		aq.add(this);// 2. ��Ʈ�� ť�� ����.

		while (aq.size() != 0) {// 3. ť�� ����(null)�� �� ������ �ܰ� 4-6�� �ݺ�.
			OrderedTree removed; // ť���� ������ ���Ҹ� ������ removed ���� ����
			removed = (OrderedTree) aq.remove(); // Object type�� remove�� ����ȯ
													// removed ������ ť���� ������ ���� ����
													// 4. ť���� ù��° ��� x�� ����.

			System.out.print(removed.root); // root ���

			for (int i = 0; i < removed.subtrees.size(); i++) { // for���� �̿��Ͽ�
																// removed�� ���
																// subtrees��
																// �湮�Ͽ� ť�� ����
				aq.add(removed.subtrees.get(i));
			} // 5. x�� �湮.//6. x�� ��� �ڽĵ��� ������� ť�� ����.
			System.out.print(" ");
		}
	}

	public int size() {
		return size;
	}

}
