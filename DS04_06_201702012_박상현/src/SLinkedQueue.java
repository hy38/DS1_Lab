
public class SLinkedQueue implements Queue {	//	SLinkedQueue class 작성

	Node head; // head Node 생성
	Node rear; // rear 노드 생성
	private int size = 0; // size를 나타낼 변수 생성(초기값 0)

	@Override
	public void add(int x) { // add() 메소드 작성
		Node insertNode; // insertNode 생성
		if (empty()) { // Queue가 비어있다면
			insertNode = new Node(x, null); // insertNode라는 x값을 가지고있는 Node를 만들고
			head = rear = insertNode; // 그 값을 head와 rear에게 준다.
			size++; // size를 증가시킨다.
		} else { // Queue가 비어있지 않다면,
			insertNode = new Node(x, null); // insertNode라는 x값을 가지고있는 Node를 만들고
			rear.next = insertNode; // rear의 next에 insertNode를 연결시키고,
			rear = rear.next; // rear이 rear.next로 이동한다.
			size++; // size를 증가시킨다.
		}
	}

	@Override
	public int remove() { // remove() 메소드 작성
		int oldHead = 0; // oldHead라는 변수를 생성한다.
		if (empty()) { // 만약 Queue가 비어있다면,
			System.out.println("Queue is empty and can not be deleted"); // 다음과
																			// 같은
																			// 메세지를
																			// 출력하고,
		} else { // 비어있지 않다면,
			oldHead = head.value; // oldHead에 head.value값을 주고,
			head = head.next; // head는 head.next값을 받는다.
			size--; // size를 감소시킨다.
		}
		return oldHead; // oldHead를 반환해준다.
	}

	public boolean empty() { // empty() 메소드 작성
		if (size == 0) // 만약 size가 0이라면
			return true; // true 반환
		else // 아니면
			return false; // false 반환
	}

	@Override
	public int first() { // first() 메소드 작성
		if (!empty()) // 만약 Queue가 비어있지 않다면,
			return head.value; // head.value ( 가장 먼저 들어온 값)을 반환
		else // 비어있다면
			return 0; // 그냥 0을 반환
	}

	@Override
	public String toString() { // toString() 메소드 작성
		Node p = head; // Node p를 만들어 head값을 주고 다음과 같이 작성한다.
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

	public ArrayQueue toArrayQueue() {	//	toArrayQueue() 메소드 작성
		Node p = head;	//	Node p를 만들어 head값을 주고,
		ArrayQueue toA_Q = new ArrayQueue();	//	toA_Q 라는 ArrayQueue 객체를 만들어서
		while (p != null) {	//	SL_Q가의 마지막 Node까지
			toA_Q.add(p.value);	//	SL_Q의 value들을 각각 toA_Q 객체에 옮긴다.
			p = p.next;
		}
		System.out.println("[Change from SLinked_Q to Array_Q]");
		return toA_Q;	//	toA_Q 객체를 반환한다.

	}

	@Override
	public int size() {	//	size() getter 메소드를 작성한다.
		return size;	//	size를 return 한다.
	}

	private class Node {	//	Node class를 작성한다.
		int value;
		Node next;

		Node(int x, Node next) {
			this.value = x;
			this.next = next;
		}
	}
}
