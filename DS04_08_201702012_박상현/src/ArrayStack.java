import java.util.ArrayList;

public class ArrayStack implements Stack {	//	ArrayStack class �ۼ�

	ArrayList<Object> aStack = new ArrayList<Object>();	//	ArrayList ���

	@Override
	public Object peek() {	//	peek() �ۼ�
		return aStack.get(aStack.size() - 1);	//	ArrayStack�� ������ �ε����� ���Ҹ� ����
	}

	@Override
	public Object pop() {	//	pop() �ۼ�
		return aStack.remove(aStack.size() - 1);	//	ArrayStack�� ������ �ε����� ���Ҹ� �����ϰ� ����
	}

	@Override
	public void push(Object object) {	//	push() �ۼ�
		aStack.add(object);		//	ArrayStack�� ������ �ε����� object ����
	}

	@Override
	public int size() {	//	size() �ۼ�
		return aStack.size();	//	ArrayStack�� ������ ����
	}

}
