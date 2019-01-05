
public class SLinkedQueue implements Queue {	//	SLinkedQueue class �ۼ�

	Node head; // head Node ����
	Node rear; // rear ��� ����
	private int size = 0; // size�� ��Ÿ�� ���� ����(�ʱⰪ 0)

	@Override
	public void add(int x) { // add() �޼ҵ� �ۼ�
		Node insertNode; // insertNode ����
		if (empty()) { // Queue�� ����ִٸ�
			insertNode = new Node(x, null); // insertNode��� x���� �������ִ� Node�� �����
			head = rear = insertNode; // �� ���� head�� rear���� �ش�.
			size++; // size�� ������Ų��.
		} else { // Queue�� ������� �ʴٸ�,
			insertNode = new Node(x, null); // insertNode��� x���� �������ִ� Node�� �����
			rear.next = insertNode; // rear�� next�� insertNode�� �����Ű��,
			rear = rear.next; // rear�� rear.next�� �̵��Ѵ�.
			size++; // size�� ������Ų��.
		}
	}

	@Override
	public int remove() { // remove() �޼ҵ� �ۼ�
		int oldHead = 0; // oldHead��� ������ �����Ѵ�.
		if (empty()) { // ���� Queue�� ����ִٸ�,
			System.out.println("Queue is empty and can not be deleted"); // ������
																			// ����
																			// �޼�����
																			// ����ϰ�,
		} else { // ������� �ʴٸ�,
			oldHead = head.value; // oldHead�� head.value���� �ְ�,
			head = head.next; // head�� head.next���� �޴´�.
			size--; // size�� ���ҽ�Ų��.
		}
		return oldHead; // oldHead�� ��ȯ���ش�.
	}

	public boolean empty() { // empty() �޼ҵ� �ۼ�
		if (size == 0) // ���� size�� 0�̶��
			return true; // true ��ȯ
		else // �ƴϸ�
			return false; // false ��ȯ
	}

	@Override
	public int first() { // first() �޼ҵ� �ۼ�
		if (!empty()) // ���� Queue�� ������� �ʴٸ�,
			return head.value; // head.value ( ���� ���� ���� ��)�� ��ȯ
		else // ����ִٸ�
			return 0; // �׳� 0�� ��ȯ
	}

	@Override
	public String toString() { // toString() �޼ҵ� �ۼ�
		Node p = head; // Node p�� ����� head���� �ְ� ������ ���� �ۼ��Ѵ�.
		System.out.print("Singly Linked Queue = head ");
		if (empty())
			System.out.print("");
		else {
			System.out.print("-> ");

			while (p != null) {
				if (p.next == null)
					System.out.print(p.value);
				else
					System.out.print(p.value + " -> ");
				p = p.next;
			}
		}
		return "";
	}

	public ArrayQueue toArrayQueue() {	//	toArrayQueue() �޼ҵ� �ۼ�
		Node p = head;	//	Node p�� ����� head���� �ְ�,
		ArrayQueue toA_Q = new ArrayQueue();	//	toA_Q ��� ArrayQueue ��ü�� ����
		while (p != null) {	//	SL_Q���� ������ Node����
			toA_Q.add(p.value);	//	SL_Q�� value���� ���� toA_Q ��ü�� �ű��.
			p = p.next;
		}
		System.out.println("[Change from SLinked_Q to Array_Q]");
		return toA_Q;	//	toA_Q ��ü�� ��ȯ�Ѵ�.

	}

	@Override
	public int size() {	//	size() getter �޼ҵ带 �ۼ��Ѵ�.
		return size;	//	size�� return �Ѵ�.
	}

	private class Node {	//	Node class�� �ۼ��Ѵ�.
		int value;
		Node next;

		Node(int x, Node next) {
			this.value = x;
			this.next = next;
		}
	}
}
