
public class TestQueue {	//	TestQueue class 작성.

	public static void main(String[] args) {

		ArrayQueue aq = new ArrayQueue();	//	aq라는 이름의 ArrayQueue 객체 생성

		for (int i = 1; i < 6; i++)	//	aq 객체에 1부터 5까지의 원소 삽입
			aq.add(i);
		System.out.println(aq);	//	aq객체 출력 (add() 메소드 test)

		aq.remove();		//	aq객체에 remove() 메소드 두번 진행
		aq.remove();
		System.out.println(aq);		//	remove() 메소드 잘 작동하는지 test

		SLinkedQueue slq = new SLinkedQueue();	//	slq라는 이름의 SLinkedQueue 객체 생성
		
		for (int i = 6; i < 10; i++)	//	slq 객체에 6부터 9까지의 원소 삽입
			slq.add(i);
		System.out.println(slq.toString());	//	slq객체 출력(add() 메소드 test)

		System.out.println();	//	가독성을 위한 개행

		for (int i = 0; i < 4; i++)		//	slq 객체에 remove() 메소드 3번 수행
			slq.remove();
		System.out.println(slq.toString());	//	slq객체 출력
		System.out.println();	//	가독성을 위한 개행

		for (int i = 10; i < 13; i++)	//	slq객체에 10부터 12까지의 원소 add
			slq.add(i);
		System.out.println(slq.toString());	//	add() 메소드 test
		System.out.println();

		System.out.println(slq.toArrayQueue());	//	toArrayQueue() 메소드 수행 및 test.

	}

}
