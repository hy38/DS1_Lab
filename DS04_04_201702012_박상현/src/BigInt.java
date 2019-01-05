
public class BigInt { // BigInt class ����

	private Node start; // start Node ����

	private static class Node { // Node class �ۼ�
		int digit; // digit ���� ����
		Node next; // next ���� ����

		Node(int digit) { // Node ������ ����
			this.digit = digit;
		}
	}

	public BigInt(int n) { // BigInt ������ ����
		if (n < 0) // n�� 0���� ���� ��� ����ó��
			throw new IllegalArgumentException(n + "<0");
		start = new Node(n % 10); // n�� ���� 10���ڸ� ������ ��� Node�� �ϳ��� ����
		Node p = start;
		n = n / 10;
		while (n > 0) {
			p = p.next = new Node(n % 10);
			n = n / 10;
		}

	}

	public BigInt multiplyone(BigInt y) { // multiplyone �޼ҵ� ����

		Node p = this.start; // Node p�� this.start �� ����
		Node q = y.start; // Node q�� y.start �� ����
		int n = p.digit * q.digit; // n ���� �ۼ�
		BigInt z = new BigInt(n % 10);
		Node r = z.start;
		p = p.next;

		while (p != null) { // p�� null�� �ƴҵ��� while�� �ݺ�
			n = n / 10 + p.digit * q.digit;
			r.next = new Node(n % 10);
			p = p.next;
			r = r.next;
		}
		if (n > 9)
			r.next = new Node(n / 10);

		return z; // ����� z ��ȯ
	}

	static int countZero = 1; // static int�� ���� countZero ����

	public void removeZeroAtFirst(BigInt y) { // ù��� ( ��ü�� 0 )�� �����ϴ� �޼ҵ� �ۼ�
		y.start = y.start.next;
	}

	public void insertZeroAtFirst(BigInt y) { // ù��忡 0�� �����ϴ� �޼ҵ� �ۼ�
		Node insertNode = new Node(0);
		insertNode.next = y.start;
		start = insertNode;
	}

	public BigInt multiply(BigInt y) { // multiplyone�� plus �޼ҵ带 Ȱ���ϴ� multiply
										// �޼ҵ� �ۼ�
		Node q = y.start;
		BigInt result = new BigInt(0); // ������� ��Ÿ���� BigInt�� ���� result�� �����ϰ� 0����
										// �ʱ�ȭ�Ѵ�.
		BigInt tempY = new BigInt(0); // y�� ���� �޾Ƽ� �ϳ��� �ٿ����� BigInt�� ���� tempY��
										// �����ϰ� 0���� �ʱ�ȭ�Ѵ�.
		tempY = tempY.plus(y); // tempY�� y�� ���� BigInt���� ���´�.

		BigInt temp; // �ӽ� BigInt�� ���� temp �ۼ�.

		while (q != null) { // q�� null�� �ƴҵ��� while�� �ݺ�
			temp = this.multiplyone(tempY); // temp�� this�� tempY�� multiplyone�� ��
											// ����

			result = temp.plus(result); // result�� temp�� result�� plus�� �� ����

			tempY.start = tempY.start.next; // tempY�� ù���� ����

			insertZeroAtFirst(this); // this�� ù ��忡 insertZeroAtFirst �޼ҵ� �̿��Ͽ�
										// 0�� ����

			q = q.next; // q�� �������ش�.
			countZero++; // countZero�� ���������ش�.
		}
		for (int i = 1; i < countZero; i++) // removeZeroAtFirst�� �̿��Ͽ� this �ճ�忡
											// ���� 0���� �����Ѵ�.
			removeZeroAtFirst(this);

		countZero = 1; // static�� ���� countZero�� 1�� �ٽ� �ʱ�ȭ���ش�.
		return result; // result���� ��ȯ�Ѵ�.

	}

	public String toString() {	//	toString�޼ҵ带 �ۼ�.
		StringBuffer buf = new StringBuffer(Integer.toString(start.digit));
		Node p = start.next;
		while (p != null) {
			buf.insert(0, Integer.toString(p.digit));
			p = p.next;
		}
		return buf.toString();
	}

	public BigInt plus(BigInt y) {	//	plus �޼ҵ带 �ۼ�.
		Node p = start;
		Node q = y.start;
		int n = p.digit + q.digit;
		BigInt z = new BigInt(n % 10);
		Node r = z.start;
		p = p.next;
		q = q.next;

		while (p != null && q != null) {
			n = n / 10 + p.digit + q.digit;
			r.next = new Node(n % 10);
			p = p.next;
			q = q.next;
			r = r.next;
		}
		while (p != null) {
			n = n / 10 + p.digit;
			r.next = new Node(n % 10);
			p = p.next;
			r = r.next;
		}
		while (q != null) {
			n = n / 10 + q.digit;
			r.next = new Node(n % 10);
			q = q.next;
			r = r.next;
		}
		if (n > 9)
			r.next = new Node(n / 10);

		return z;

	}

}
