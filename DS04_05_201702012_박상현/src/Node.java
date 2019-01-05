
public class Node {	//	Node Ŭ���� �ۼ�
	// field variables
	private Node next;	//	Node �� ���� next ����
	private int value;	//	int�� ���� value ����

	// constructor
	public Node() {	//	Node ������ �ۼ�
	}

	public Node(int value) {		//	Node ������ �ۼ�
		this.value = value;
	}

	public Node(int value, Node next) {		//	Node ������ �ۼ�
		this.value = value;
		this.next = next;
	}

	// public methods
	public void setValue(int value) {	//	value �� ���� setter �޼ҵ��ۼ�
		this.value = value;
	}

	public int Value() {	//	value �� ���� getter �޼ҵ��ۼ�
		return value;
	}

	public void setNext(Node next) {	//	next �� ���� setter �޼ҵ��ۼ�
		this.next = next;
	}

	public Node Next() {		//	next �� ���� getter �޼ҵ��ۼ�
		return next;
	}
}
