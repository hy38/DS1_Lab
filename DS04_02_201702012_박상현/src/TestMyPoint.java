
public class TestMyPoint {

	public static void main(String[] args) {

		MyPoint test = new MyPoint(); // ��ü ����

		test.setX(-1); // x��ǥ ����
		test.setY(3); // y��ǥ ����

		test.print(); // print() �޼ҵ� ȣ��

		test.moveTo(2, -5); // (2, -5)��ŭ �̵�
		test.scaleTo(-2); // �� ��ǥ -2�� �õ�
		test.scaleTo(2); // �� ��ǥ 2�� �õ�

	}

}
