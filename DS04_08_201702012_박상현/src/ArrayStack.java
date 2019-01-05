import java.util.ArrayList;

public class ArrayStack implements Stack {	//	ArrayStack class 작성

	ArrayList<Object> aStack = new ArrayList<Object>();	//	ArrayList 사용

	@Override
	public Object peek() {	//	peek() 작성
		return aStack.get(aStack.size() - 1);	//	ArrayStack의 마지막 인덱스의 원소를 리턴
	}

	@Override
	public Object pop() {	//	pop() 작성
		return aStack.remove(aStack.size() - 1);	//	ArrayStack의 마지막 인덱스의 원소를 삭제하고 리턴
	}

	@Override
	public void push(Object object) {	//	push() 작성
		aStack.add(object);		//	ArrayStack의 마지막 인덱스에 object 삽입
	}

	@Override
	public int size() {	//	size() 작성
		return aStack.size();	//	ArrayStack의 사이즈 리턴
	}

}
