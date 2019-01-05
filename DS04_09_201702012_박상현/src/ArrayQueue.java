import java.util.ArrayList;

public class ArrayQueue implements Queue { // ArrayQueue class 작성
	ArrayList<Object> aQueue = new ArrayList<Object>(); // ArrayList 사용

	@Override
	public void add(Object object) { // add() 작성
		aQueue.add(aQueue.size(), object); // ArrayQueue의 size에 해당하는 인덱스에 object
											// 삽입
	}

	@Override
	public Object first() { // first() 작성
		return aQueue.get(0); // ArrayQueue의 0번째 인덱스 리턴
	}

	@Override
	public Object remove() { // remove() 작성
		return aQueue.remove(0); // ArrayQueue의 0번째 인덱스값 제거 후 리턴
	}

	@Override
	public int size() { // size() 작성
		return aQueue.size(); // ArrayQueue의 사이즈 리턴
	}
}
