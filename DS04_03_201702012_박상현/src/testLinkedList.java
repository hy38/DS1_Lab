
public class testLinkedList {

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();	//	list1 按眉 积己

		for (int i = 1; i <= 10; i++)	//	insertfirst 皋家靛 test
			list1.insertfirst(i);
		
		list1.print();
		
		System.out.println("");

		list1.contain(5);	//	contain 皋家靛 test
		list1.contain(20);

		LinkedList list2 = new LinkedList();	//	list2 按眉 积己

		for (int i = 1; i <= 10; i++)	//	insertlast皋家靛 test
			list2.insertlast(i);
		
		list2.print();	//	list1阑 print

	}

}
