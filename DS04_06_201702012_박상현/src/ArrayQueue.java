
public class ArrayQueue implements Queue { // ArrayQueue class �ۼ�

	public int rear = -1, front = -1; // rear, front �� ���� �����ϰ�, -1�� �ʱ�ȭ���ش�.
	int arrayQ[] = new int[10]; // arrayQ��� ũ�Ⱑ 10�� �迭�� �����.

	@Override
	public void add(int x) { // add() �޼ҵ� �ۼ�
		if (rear == 9) // �迭�� ������ index�� á�� ���
			System.out.println("�迭�� ������ �ε����� á���ϴ�."); // ���� �޼��� ǥ��
		else { // �迭�� ������ index�� ���� �ʾ��� ���,
			rear++; // rear���� �ϳ� �÷��ְ�,
			arrayQ[rear] = x; // �÷��� rear�� index�� x���� �ִ´�.
		}
	}

	@Override
	public int remove() { // remove() �޼ҵ� �ۼ�
		if (!empty()) { // Queue�� empty�� �ƴ϶��,
			int temp = arrayQ[front + 1]; // temp��� ���� �����Ͽ� front+1 index�� �ִ� ����
											// �ش�.
			arrayQ[front + 1] = 0; // front+1 index�� ���� 0���� ���� �����ش�.
			front++; // front�� �ϳ� �÷��ش�.
			return temp; // temp���� ��ȯ�Ѵ�.
		} else // Queue�� empty�ϴٸ�,
			return 0; // �׳� 0�� ��ȯ�Ѵ�.
	}

	public boolean empty() { // empty() �޼ҵ� �ۼ�
		if (front == -1 && rear == -1) // front�� rear�� ��� -1 �̸�,
			return true; // true���� ��ȯ�Ѵ�.
		else // �׷��� �ʴٸ�,
			return false; // false���� ��ȯ�Ѵ�.
	}

	@Override
	public int first() { // first() �޼ҵ� �ۼ�
		if (!empty()) // Queue�� empty���� �ʴٸ�
			return arrayQ[front + 1]; // front+1�� index�� �ִ� ���Ҹ� ��ȯ
		else // Queue�� empty�ϴٸ�
			return 0; // �׳� 0�� ��ȯ�Ѵ�.
	}

	public String toString() { // toString() �޼ҵ� �ۼ�
		System.out.print("Array Queue = { "); // ������ ���� ���Ŀ� ���� �ۼ��Ѵ�.
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
	public int size() { // size() �޼ҵ� �ۼ�
		return rear - front; // rear-front ���� ��ȯ�Ѵ�.
	}
}
