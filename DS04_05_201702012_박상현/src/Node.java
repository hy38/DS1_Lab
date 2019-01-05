
public class Node {	//	Node 클래스 작성
	// field variables
	private Node next;	//	Node 형 변수 next 생성
	private int value;	//	int형 변수 value 생성

	// constructor
	public Node() {	//	Node 생성자 작성
	}

	public Node(int value) {		//	Node 생성자 작성
		this.value = value;
	}

	public Node(int value, Node next) {		//	Node 생성자 작성
		this.value = value;
		this.next = next;
	}

	// public methods
	public void setValue(int value) {	//	value 에 관한 setter 메소드작성
		this.value = value;
	}

	public int Value() {	//	value 에 관한 getter 메소드작성
		return value;
	}

	public void setNext(Node next) {	//	next 에 관한 setter 메소드작성
		this.next = next;
	}

	public Node Next() {		//	next 에 관한 getter 메소드작성
		return next;
	}
}
