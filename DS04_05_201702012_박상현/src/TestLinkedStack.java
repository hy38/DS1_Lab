
public class TestLinkedStack {

	public static void main(String[] args) {

		LinkedStack a = new LinkedStack();	//	a��� �̸��� LinkedStack ��ü ����
		for (int i = 1; i < 6; i++) {	//	���� a�� 1���� 5���� push
			a.push(i);
		}
		System.out.println(a.toString());	//	���� a ���

		System.out.println();	//	�������� ���� ����

		System.out.println("[REMOVING SECOND]...");
		a.removeSecond();		//	���� a�� removeSecond()�޼ҵ� ����
		System.out.println(a.toString());	//	���� a ���

		System.out.println();	//	�������� ���� ����

		System.out.println("[REVERSING STACK]...");
		a.reverse();	//	���� a�� reverse()�޼ҵ� ����
		System.out.println(a.toString());	//	���� a ���

	}

}
