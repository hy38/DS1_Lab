
public class LinkedStack {

	private Node top; // top을 만들어준다.
	private int size; // 스택의 size를 측정하기 위한 변수 size를 만들어준다.

	public boolean isEmpty() { // 스택이 비었는지 확인해주는 메소드
		return (size == 0);
	}

	public Node peek() { // top에 있는 원소를 return해주는 메소드
		if (size == 0)
			throw new java.util.NoSuchElementException();
		return top;
	}

	public Node pop() { // top에 있는 원소를 빼내고, return해주는 메소드
		if (size == 0)
			throw new java.util.NoSuchElementException();
		Node oldTop = top;
		top = top.Next();
		--size;
		return oldTop;
	}

	public void push(int v) { // stack에 원소 v를 쌓는 메소드
		top = new Node(v, top);
		++size;
		System.out.println("Push : " + v);
	}

	public int size() { // size를 반환해주는 getter 메소드.
		return size;
	}

	public Node removeSecond() { // top 다음의 원소를 제거하고 반환해주는 메소드.
		if (top.Next() == null) // top의 next가 null이면 오류표시
			throw new java.util.NoSuchElementException();
		Node removedSecondNode; // 제거될 스택의 두번째 원소를 가질 노드를 생성한다.
		removedSecondNode = top.Next(); // 그리고 그 주소값을 준다.

		top.setNext(top.Next().Next()); // top의 next에 세번째 노드를 연결한다.
		removedSecondNode.setNext(null); // 기존스택의 두번째 노드의 next연결을 모두 끊는다.
		--size; // size를 하나 감소시킨다.
		return removedSecondNode; // 제거된 노드를 반환한다.
	}

	public void reverse() { // 스택을 reverse해주는 메소드
		Node temp = new Node(); // temp 노드를 생성하여
		while (top.Next() != null) { // top.next가 null일때까지 반복한다.
			if (temp.Next() == null) {
				temp.setNext(removeSecond());
			} else {
				Node temp2; // temp2 노드를 생성하여
				temp2 = removeSecond(); // temp2에 removedSecondNode의 주소값을 주고
				temp2.setNext(temp.Next()); // 연결된 temp2의 next에 (temp의 next)값을
											// 준다.
				temp.setNext(temp2); // temp의 next에 temp2값을 준다.
			}
		}
		Node q = temp; // q노드를 만들어 temp의 값을 준다.
		while (q.Next() != null) { // q.next가 null이 아닐동안 q를 이동시킨다.
			q = q.Next();
		}
		q.setNext(pop()); // q.next를 pop한다.
		top = temp; // temp를 top에 연결한다.
		top = top.Next(); // temp의 처음 노드 value가 0이므로 top을 한칸 전진이동한다.
	}

	public String toString() { // toString메소드를 작성.

		Node p = top; // Node p가 top의 주소를 얻는다.
		System.out.print("Current Elements of Stack : top -> ");
		while (p != null) { // p가 null일때까지 반복한다.

			System.out.print(p.Value() + " "); // p.value를 출력한다.
			p = p.Next();
			if (p != null) // 가독성을 위해 화살표도 출력한다.
				System.out.print("->");
		}

		return "";
	}

}
