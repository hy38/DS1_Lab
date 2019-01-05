
public class MyPoint implements Point {	//MyPoint class�� Point�� implements �ϵ��� ����.

	private double cordX;	//x��ǥ�� ��Ÿ���� �ʵ� ����
	private double cordY;	//y��ǥ�� ��Ÿ���� �ʵ� ����

	public void print() {	//���� ��ǥ�� ����ϴ� print()�޼ҵ� ����
		System.out.printf("���� ��ǥ : (" + cordX + ", " + cordY + ")\n", cordX, cordY);
	}

	public double getX() {	//x��ǥ�� ��ȯ�ϴ� getX()�޼ҵ� ��üȭ
		return cordX;
	}

	public double getY() {	//y��ǥ�� ��ȯ�ϴ� getY()�޼ҵ� ��üȭ
		return cordY;
	}

	public void setX(double x) {	//x��ǥ�� �����ϴ� setX()�޼ҵ� ��üȭ
		this.cordX = x;
	}

	public void setY(double y) {	//y��ǥ�� �����ϴ� setY()�޼ҵ� ��üȭ
		this.cordY = y;
	}

	public void moveTo(double a, double b) {	//��ǥ�� (a, b)��ŭ �̵���Ű�� moveTo()�޼ҵ� ��üȭ
		this.cordX += a;
		this.cordY += b;
		System.out.println("[move] x������ " + a + ", y������ " + b + "��ŭ �̵� �Ϸ� �Ͽ����ϴ�.");
		print();	//���� ��ǥ ���
	}

	public void scaleTo(double c) {	//��ǥ�� c���ϴ� scaleTo()�޼ҵ� ��üȭ
		if (c > 0) {
			this.cordX *= c;
			this.cordY *= c;
		} else	//c�� 0���� ũ�� ������ Error �޼��� ȣ��.
			System.out.println("[Error] �Է��Ͻ� " + c + "�� ����� �ƴϹǷ� ���ǿ� ��߳��ϴ�.");

		print();	//���� ��ǥ ���
	}

}
