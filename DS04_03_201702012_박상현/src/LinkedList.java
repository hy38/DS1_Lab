
public class LinkedList {

	private Node startNode = new Node();		//	startNode 생성

	public boolean isEmpty() {	//	LinkedList가 비어있는지를 반환해주는 메소드
		if (startNode.Next() == null) // startNode == null 로 수정?	//	startNode가 null이면 true 반환
			return true;
		else	//startNode가 null이 아니면 false 반환
			return false;
	}

	public void insertlast(int x) {	//	x를 startNode가 가리키는 리스트의 맨 마지막 원소로 삽입하는 메소드

		if (isEmpty()) {	//	만약 비어있다면
			Node k = new Node(x, null);	//	value가 x이고 next가 null인 새로운 노드 k를 생성하고,
			startNode.setNext(k);	//	그 노드를 startNode의 next로 지정해준다.

		} else {	//	만약 비어있지 않다면
			Node p = startNode;		//	임의의 노드 p를 만들어 startNode의 값을 주고
			while (p.Next() != null) { // p.Next()가 null일 때 까지 p의 위치를 이동시킨다.
				p = p.Next();
			}

			Node a = new Node(x, p.Next());	//	value가 x이고 next가 p.next인 새로운 노드 a를 생성하고,
			// Node a = new Node(x);
			p.setNext(a);		//	p의 next에 연결시켜준다.

		}
	}

	public void insertfirst(int x) {	//	 x를 startNode가 가리키는 리스트의 맨 앞의 원소로 삽입하는 메소드
		Node newNode;	//newNode 선언
		if (isEmpty()) {	//	만약 비어있다면
				newNode = new Node(x, null);	//	value가 x이고 next가 null인 새로운 노드 newNode를 생성하고,
			startNode.setNext(newNode);		//	neNode의 next를 startNode로 지정해준다.
		} else {	//	만약 비어있지 않다면,
			newNode = new Node(x);		//	value가 x인 새로운 노드 newNode를 생성하고,
			newNode.setNext(startNode.Next());	//	newNode의 next를 startNode의 next로 설정해준다.
			startNode.setNext(newNode);		//	startNode의 next를 newNode로 설정해준다.
		}

	}

	public boolean contain(int x) {	//	x가 리스트에 있는지 아닌지를 리턴하는 메소드
		boolean doesContain = false;		 // 초기값 : false 인 boolean 타입의 변수 doesContain을 만든다.
		Node p = startNode;		//	임의의 노드 p를 만들어 startNode의 값을 주고
		while (p.Value() != x) {	// p.Next()가 null일 때 까지 p의 위치를 이동시킨다.
			p = p.Next();

			if (p.Value() == x) {	//	만약 노드 p의 value가 x랑 일치한다면
				System.out.println("it contains " + x);	//	다음 메세지를 출력하고,
				doesContain = true;	//	doesContain의 값을 true로 바꾼다.
				break;	//	그리고 while문을 나온다.
			} else if (p.Next() == null) {	//	그렇지 않고 만약 노드 p의 next가 null이라면
				System.out.println("it does NOT contain " + x);	//	다음 메세지를 출력하고,
				doesContain = false; // doesContain의 값을 false로 바꾼다.
				break;	//	그리고 while문을 나온다.
			}
		}
		return doesContain;	//	doesContain을 리턴한다.
	}

	public void print() {	//	startNode가 가르키는 리스트의 원소를 print해주는 메소드	
		for (Node p = startNode.Next(); p != null; p = p.Next())
			System.out.print(p.Value() + "  ");
	}

}