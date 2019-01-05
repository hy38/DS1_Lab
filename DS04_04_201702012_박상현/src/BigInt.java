
public class BigInt { // BigInt class 구현

	private Node start; // start Node 생성

	private static class Node { // Node class 작성
		int digit; // digit 변수 생성
		Node next; // next 변수 생성

		Node(int digit) { // Node 생성자 생성
			this.digit = digit;
		}
	}

	public BigInt(int n) { // BigInt 생성자 생성
		if (n < 0) // n이 0보다 작을 경우 예외처리
			throw new IllegalArgumentException(n + "<0");
		start = new Node(n % 10); // n의 값을 10의자리 단위로 끊어서 Node에 하나씩 저장
		Node p = start;
		n = n / 10;
		while (n > 0) {
			p = p.next = new Node(n % 10);
			n = n / 10;
		}

	}

	public BigInt multiplyone(BigInt y) { // multiplyone 메소드 구현

		Node p = this.start; // Node p에 this.start 값 대입
		Node q = y.start; // Node q에 y.start 값 대입
		int n = p.digit * q.digit; // n 수식 작성
		BigInt z = new BigInt(n % 10);
		Node r = z.start;
		p = p.next;

		while (p != null) { // p가 null이 아닐동안 while문 반복
			n = n / 10 + p.digit * q.digit;
			r.next = new Node(n % 10);
			p = p.next;
			r = r.next;
		}
		if (n > 9)
			r.next = new Node(n / 10);

		return z; // 결과값 z 반환
	}

	static int countZero = 1; // static int형 변수 countZero 생성

	public void removeZeroAtFirst(BigInt y) { // 첫노드 ( 대체로 0 )을 제거하는 메소드 작성
		y.start = y.start.next;
	}

	public void insertZeroAtFirst(BigInt y) { // 첫노드에 0을 삽입하는 메소드 작성
		Node insertNode = new Node(0);
		insertNode.next = y.start;
		start = insertNode;
	}

	public BigInt multiply(BigInt y) { // multiplyone과 plus 메소드를 활용하는 multiply
										// 메소드 작성
		Node q = y.start;
		BigInt result = new BigInt(0); // 결과값을 나타내는 BigInt형 변수 result를 선언하고 0으로
										// 초기화한다.
		BigInt tempY = new BigInt(0); // y의 값을 받아서 하나씩 줄여나갈 BigInt형 변수 tempY를
										// 선언하고 0으로 초기화한다.
		tempY = tempY.plus(y); // tempY와 y와 같은 BigInt값을 갖는다.

		BigInt temp; // 임시 BigInt형 변수 temp 작성.

		while (q != null) { // q가 null이 아닐동안 while문 반복
			temp = this.multiplyone(tempY); // temp에 this와 tempY를 multiplyone한 값
											// 저장

			result = temp.plus(result); // result에 temp와 result를 plus한 값 저장

			tempY.start = tempY.start.next; // tempY의 첫원소 제거

			insertZeroAtFirst(this); // this의 첫 노드에 insertZeroAtFirst 메소드 이용하여
										// 0을 삽입

			q = q.next; // q를 움직여준다.
			countZero++; // countZero를 증가시켜준다.
		}
		for (int i = 1; i < countZero; i++) // removeZeroAtFirst를 이용하여 this 앞노드에
											// 붙은 0들을 제거한다.
			removeZeroAtFirst(this);

		countZero = 1; // static형 변수 countZero를 1로 다시 초기화해준다.
		return result; // result값을 반환한다.

	}

	public String toString() {	//	toString메소드를 작성.
		StringBuffer buf = new StringBuffer(Integer.toString(start.digit));
		Node p = start.next;
		while (p != null) {
			buf.insert(0, Integer.toString(p.digit));
			p = p.next;
		}
		return buf.toString();
	}

	public BigInt plus(BigInt y) {	//	plus 메소드를 작성.
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
