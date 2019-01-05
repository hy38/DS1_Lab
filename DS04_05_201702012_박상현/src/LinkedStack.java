
public class LinkedStack {

	private Node top; // top�� ������ش�.
	private int size; // ������ size�� �����ϱ� ���� ���� size�� ������ش�.

	public boolean isEmpty() { // ������ ������� Ȯ�����ִ� �޼ҵ�
		return (size == 0);
	}

	public Node peek() { // top�� �ִ� ���Ҹ� return���ִ� �޼ҵ�
		if (size == 0)
			throw new java.util.NoSuchElementException();
		return top;
	}

	public Node pop() { // top�� �ִ� ���Ҹ� ������, return���ִ� �޼ҵ�
		if (size == 0)
			throw new java.util.NoSuchElementException();
		Node oldTop = top;
		top = top.Next();
		--size;
		return oldTop;
	}

	public void push(int v) { // stack�� ���� v�� �״� �޼ҵ�
		top = new Node(v, top);
		++size;
		System.out.println("Push : " + v);
	}

	public int size() { // size�� ��ȯ���ִ� getter �޼ҵ�.
		return size;
	}

	public Node removeSecond() { // top ������ ���Ҹ� �����ϰ� ��ȯ���ִ� �޼ҵ�.
		if (top.Next() == null) // top�� next�� null�̸� ����ǥ��
			throw new java.util.NoSuchElementException();
		Node removedSecondNode; // ���ŵ� ������ �ι�° ���Ҹ� ���� ��带 �����Ѵ�.
		removedSecondNode = top.Next(); // �׸��� �� �ּҰ��� �ش�.

		top.setNext(top.Next().Next()); // top�� next�� ����° ��带 �����Ѵ�.
		removedSecondNode.setNext(null); // ���������� �ι�° ����� next������ ��� ���´�.
		--size; // size�� �ϳ� ���ҽ�Ų��.
		return removedSecondNode; // ���ŵ� ��带 ��ȯ�Ѵ�.
	}

	public void reverse() { // ������ reverse���ִ� �޼ҵ�
		Node temp = new Node(); // temp ��带 �����Ͽ�
		while (top.Next() != null) { // top.next�� null�϶����� �ݺ��Ѵ�.
			if (temp.Next() == null) {
				temp.setNext(removeSecond());
			} else {
				Node temp2; // temp2 ��带 �����Ͽ�
				temp2 = removeSecond(); // temp2�� removedSecondNode�� �ּҰ��� �ְ�
				temp2.setNext(temp.Next()); // ����� temp2�� next�� (temp�� next)����
											// �ش�.
				temp.setNext(temp2); // temp�� next�� temp2���� �ش�.
			}
		}
		Node q = temp; // q��带 ����� temp�� ���� �ش�.
		while (q.Next() != null) { // q.next�� null�� �ƴҵ��� q�� �̵���Ų��.
			q = q.Next();
		}
		q.setNext(pop()); // q.next�� pop�Ѵ�.
		top = temp; // temp�� top�� �����Ѵ�.
		top = top.Next(); // temp�� ó�� ��� value�� 0�̹Ƿ� top�� ��ĭ �����̵��Ѵ�.
	}

	public String toString() { // toString�޼ҵ带 �ۼ�.

		Node p = top; // Node p�� top�� �ּҸ� ��´�.
		System.out.print("Current Elements of Stack : top -> ");
		while (p != null) { // p�� null�϶����� �ݺ��Ѵ�.

			System.out.print(p.Value() + " "); // p.value�� ����Ѵ�.
			p = p.Next();
			if (p != null) // �������� ���� ȭ��ǥ�� ����Ѵ�.
				System.out.print("->");
		}

		return "";
	}

}
