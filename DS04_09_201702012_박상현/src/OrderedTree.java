import java.util.*;
import java.util.ArrayList;

public class OrderedTree { // OrderedTree class 작성
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

	public OrderedTree(Object root, List trees) { // OrderedTree 생성자 구현. List 사용
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

	public void levelOrder() { // queue는 라이브러리 사용 가능
		Queue aq = new ArrayQueue();// 1. 큐를 초기화.

		aq.add(this);// 2. 루트를 큐에 삽입.

		while (aq.size() != 0) {// 3. 큐가 공백(null)이 될 때까지 단계 4-6을 반복.
			OrderedTree removed; // 큐에서 삭제한 원소를 저장할 removed 변수 생성
			removed = (OrderedTree) aq.remove(); // Object type의 remove를 형변환
													// removed 변수에 큐에서 삭제한 원소 삽입
													// 4. 큐에서 첫번째 노드 x를 삭제.

			System.out.print(removed.root); // root 출력

			for (int i = 0; i < removed.subtrees.size(); i++) { // for문을 이용하여
																// removed의 모든
																// subtrees를
																// 방문하여 큐에 삽입
				aq.add(removed.subtrees.get(i));
			} // 5. x를 방문.//6. x의 모든 자식들을 순서대로 큐에 삽입.
			System.out.print(" ");
		}
	}

	public int size() {
		return size;
	}

}
