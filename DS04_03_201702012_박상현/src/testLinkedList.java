
public class testLinkedList {

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();	//	list1 ��ü ����

		for (int i = 1; i <= 10; i++)	//	insertfirst �޼ҵ� test
			list1.insertfirst(i);
		
		list1.print();
		
		System.out.println("");

		list1.contain(5);	//	contain �޼ҵ� test
		list1.contain(20);

		LinkedList list2 = new LinkedList();	//	list2 ��ü ����

		for (int i = 1; i <= 10; i++)	//	insertlast�޼ҵ� test
			list2.insertlast(i);
		
		list2.print();	//	list1�� print

	}

}
