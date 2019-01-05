
public class ArrayQueue implements Queue { // ArrayQueue class 작성

	public int rear = -1, front = -1; // rear, front 를 각각 생성하고, -1로 초기화해준다.
	int arrayQ[] = new int[10]; // arrayQ라는 크기가 10인 배열을 만든다.

	@Override
	public void add(int x) { // add() 메소드 작성
		if (rear == 9) // 배열의 마지막 index가 찼을 경우
			System.out.println("배열의 마지막 인덱스가 찼습니다."); // 다음 메세지 표시
		else { // 배열의 마지막 index가 차지 않았을 경우,
			rear++; // rear값을 하나 늘려주고,
			arrayQ[rear] = x; // 늘려준 rear의 index에 x값을 넣는다.
		}
	}

	@Override
	public int remove() { // remove() 메소드 작성
		if (!empty()) { // Queue가 empty가 아니라면,
			int temp = arrayQ[front + 1]; // temp라는 변수 생성하여 front+1 index에 있는 값을
											// 준다.
			arrayQ[front + 1] = 0; // front+1 index의 값을 0으로 만들어서 지워준다.
			front++; // front를 하나 늘려준다.
			return temp; // temp값을 반환한다.
		} else // Queue가 empty하다면,
			return 0; // 그냥 0을 반환한다.
	}

	public boolean empty() { // empty() 메소드 작성
		if (front == -1 && rear == -1) // front와 rear이 모두 -1 이면,
			return true; // true값을 반환한다.
		else // 그렇지 않다면,
			return false; // false값을 반환한다.
	}

	@Override
	public int first() { // first() 메소드 작성
		if (!empty()) // Queue가 empty하지 않다면
			return arrayQ[front + 1]; // front+1의 index에 있는 원소를 반환
		else // Queue가 empty하다면
			return 0; // 그냥 0을 반환한다.
	}

	public String toString() { // toString() 메소드 작성
		System.out.print("Array Queue = { "); // 다음과 같이 형식에 맞춰 작성한다.
		for (int i = 0; i <= rear; i++) {
			if (i == rear)
				if (arrayQ[i] == 0)
					System.out.print("null | ");
				else
					System.out.print(arrayQ[i]);
			else {
				if (arrayQ[i] == 0)
					System.out.print("null | ");
				else
					System.out.print(arrayQ[i] + " | ");
			}
		}
		System.out.println(" } (fron : " + front + ", rear : " + rear + ")");

		return "";
	}

	@Override
	public int size() { // size() 메소드 작성
		return rear - front; // rear-front 값을 반환한다.
	}
}
