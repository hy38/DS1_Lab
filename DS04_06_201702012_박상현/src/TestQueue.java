
public class TestQueue {	//	TestQueue class �ۼ�.

	public static void main(String[] args) {

		ArrayQueue aq = new ArrayQueue();	//	aq��� �̸��� ArrayQueue ��ü ����

		for (int i = 1; i < 6; i++)	//	aq ��ü�� 1���� 5������ ���� ����
			aq.add(i);
		System.out.println(aq);	//	aq��ü ��� (add() �޼ҵ� test)

		aq.remove();		//	aq��ü�� remove() �޼ҵ� �ι� ����
		aq.remove();
		System.out.println(aq);		//	remove() �޼ҵ� �� �۵��ϴ��� test

		SLinkedQueue slq = new SLinkedQueue();	//	slq��� �̸��� SLinkedQueue ��ü ����
		
		for (int i = 6; i < 10; i++)	//	slq ��ü�� 6���� 9������ ���� ����
			slq.add(i);
		System.out.println(slq.toString());	//	slq��ü ���(add() �޼ҵ� test)

		System.out.println();	//	�������� ���� ����

		for (int i = 0; i < 4; i++)		//	slq ��ü�� remove() �޼ҵ� 3�� ����
			slq.remove();
		System.out.println(slq.toString());	//	slq��ü ���
		System.out.println();	//	�������� ���� ����

		for (int i = 10; i < 13; i++)	//	slq��ü�� 10���� 12������ ���� add
			slq.add(i);
		System.out.println(slq.toString());	//	add() �޼ҵ� test
		System.out.println();

		System.out.println(slq.toArrayQueue());	//	toArrayQueue() �޼ҵ� ���� �� test.

	}

}
