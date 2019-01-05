
public class LinkedList {

	private Node startNode = new Node();		//	startNode ����

	public boolean isEmpty() {	//	LinkedList�� ����ִ����� ��ȯ���ִ� �޼ҵ�
		if (startNode.Next() == null) // startNode == null �� ����?	//	startNode�� null�̸� true ��ȯ
			return true;
		else	//startNode�� null�� �ƴϸ� false ��ȯ
			return false;
	}

	public void insertlast(int x) {	//	x�� startNode�� ����Ű�� ����Ʈ�� �� ������ ���ҷ� �����ϴ� �޼ҵ�

		if (isEmpty()) {	//	���� ����ִٸ�
			Node k = new Node(x, null);	//	value�� x�̰� next�� null�� ���ο� ��� k�� �����ϰ�,
			startNode.setNext(k);	//	�� ��带 startNode�� next�� �������ش�.

		} else {	//	���� ������� �ʴٸ�
			Node p = startNode;		//	������ ��� p�� ����� startNode�� ���� �ְ�
			while (p.Next() != null) { // p.Next()�� null�� �� ���� p�� ��ġ�� �̵���Ų��.
				p = p.Next();
			}

			Node a = new Node(x, p.Next());	//	value�� x�̰� next�� p.next�� ���ο� ��� a�� �����ϰ�,
			// Node a = new Node(x);
			p.setNext(a);		//	p�� next�� ��������ش�.

		}
	}

	public void insertfirst(int x) {	//	 x�� startNode�� ����Ű�� ����Ʈ�� �� ���� ���ҷ� �����ϴ� �޼ҵ�
		Node newNode;	//newNode ����
		if (isEmpty()) {	//	���� ����ִٸ�
				newNode = new Node(x, null);	//	value�� x�̰� next�� null�� ���ο� ��� newNode�� �����ϰ�,
			startNode.setNext(newNode);		//	neNode�� next�� startNode�� �������ش�.
		} else {	//	���� ������� �ʴٸ�,
			newNode = new Node(x);		//	value�� x�� ���ο� ��� newNode�� �����ϰ�,
			newNode.setNext(startNode.Next());	//	newNode�� next�� startNode�� next�� �������ش�.
			startNode.setNext(newNode);		//	startNode�� next�� newNode�� �������ش�.
		}

	}

	public boolean contain(int x) {	//	x�� ����Ʈ�� �ִ��� �ƴ����� �����ϴ� �޼ҵ�
		boolean doesContain = false;		 // �ʱⰪ : false �� boolean Ÿ���� ���� doesContain�� �����.
		Node p = startNode;		//	������ ��� p�� ����� startNode�� ���� �ְ�
		while (p.Value() != x) {	// p.Next()�� null�� �� ���� p�� ��ġ�� �̵���Ų��.
			p = p.Next();

			if (p.Value() == x) {	//	���� ��� p�� value�� x�� ��ġ�Ѵٸ�
				System.out.println("it contains " + x);	//	���� �޼����� ����ϰ�,
				doesContain = true;	//	doesContain�� ���� true�� �ٲ۴�.
				break;	//	�׸��� while���� ���´�.
			} else if (p.Next() == null) {	//	�׷��� �ʰ� ���� ��� p�� next�� null�̶��
				System.out.println("it does NOT contain " + x);	//	���� �޼����� ����ϰ�,
				doesContain = false; // doesContain�� ���� false�� �ٲ۴�.
				break;	//	�׸��� while���� ���´�.
			}
		}
		return doesContain;	//	doesContain�� �����Ѵ�.
	}

	public void print() {	//	startNode�� ����Ű�� ����Ʈ�� ���Ҹ� print���ִ� �޼ҵ�	
		for (Node p = startNode.Next(); p != null; p = p.Next())
			System.out.print(p.Value() + "  ");
	}

}