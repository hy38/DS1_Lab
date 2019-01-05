import java.util.ArrayList;

public class ArrayQueue implements Queue { // ArrayQueue class �ۼ�
	ArrayList<Object> aQueue = new ArrayList<Object>(); // ArrayList ���

	@Override
	public void add(Object object) { // add() �ۼ�
		aQueue.add(aQueue.size(), object); // ArrayQueue�� size�� �ش��ϴ� �ε����� object
											// ����
	}

	@Override
	public Object first() { // first() �ۼ�
		return aQueue.get(0); // ArrayQueue�� 0��° �ε��� ����
	}

	@Override
	public Object remove() { // remove() �ۼ�
		return aQueue.remove(0); // ArrayQueue�� 0��° �ε����� ���� �� ����
	}

	@Override
	public int size() { // size() �ۼ�
		return aQueue.size(); // ArrayQueue�� ������ ����
	}
}
