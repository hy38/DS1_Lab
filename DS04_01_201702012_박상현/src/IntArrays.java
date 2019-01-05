import java.util.Random;

//�迭�� ������ 0�̸� �� Index�� ������.

public class IntArrays {

	Random rg;
	private int[] arrayA;
	int size; // �迭 A�� �ִ� ũ��
	private int[] arrayB;

	public IntArrays(int size) {// ������ ����
		rg = new Random();
		arrayA = new int[size]; // �迭 arrayA ����
		this.size = size;
		for (int i = 0; i < arrayA.length / 2; i++) {
			arrayA[i] = rg.nextInt(9) + 1; // 1���� 9������ ���� �߻�
		}
		System.out.println("���� " + size + "�� �迭�� �����Ͽ����ϴ�.");
	}

	public boolean isFull() { // �迭 arrayA�� Full ���� Ȯ���ϴ� �޼ҵ�
		return (arrayA[size - 1] != 0);
	}

	public void print() { // �迭�� �ִ� ��� ���Ҹ� ������ִ� �޼ҵ�
		System.out.print("�迭 ������ : ");
		for (int i = 0; i < arrayA.length; i++) {
			if (arrayA[i] == 0)
				break;
			System.out.print(arrayA[i] + "  ");
		}
		System.out.println();
	}

	private static int lastIndex = 0; // �迭�� ������ ������ �ε������� static���� ����
										// lastIndex�� ����

	public int searchLastIndex() { // arrayA�� lastIndex�� ���� ��ȯ���ִ� �޼ҵ�
		// lastIndex = 0;
		for (int i = 0; i < arrayA.length; i++) {
			if (arrayA[i] == 0) {
				lastIndex = i - 1;
				break;
			}
		}
		return lastIndex;
	}

	public void add(int x) {// �迭�� �̹� ���� �� ���� ��츦 ����ؾ���.

		if (isFull()) { // arrayA�� �����ִٸ�,
			arrayB = new int[size]; // temp�迭�� arrayB�迭 ����(size�� A�� ����)
			System.arraycopy(arrayA, 0, arrayB, 0, size); // arrayA��
															// arrayB�� ����,

			arrayA = new int[size * 2]; // A�迭�� size*2�� sizeup
			System.arraycopy(arrayB, 0, arrayA, 0, size); // arrayB�� arrayA�� �ٽ�
															// ����
			this.size = size * 2; // size �ʵ� ������

			arrayA[lastIndex + 1] = x;

			lastIndex++;
		}

		else { // arrayA�� �������� �ʴٸ�
				// arrayA[searchLastIndex() + 1] = x;
			arrayA[lastIndex + 1] = x;
			lastIndex++;
		}

		System.out.println("[ADD] ������ " + x + "�� ������ �Ϸ�Ǿ����ϴ�.");
		print();
	}

	private int removedElement;
	private int removeIndex;

	public int remove(int x) {

		for (int i = 0; i < arrayA.length; i++) {
			if (arrayA[i] == x) { // �迭�� �����ϰ����ϴ� ���� x�� ������
				removeIndex = i;
				removedElement = x;
				arrayA[removeIndex] = 0;

				System.out.println("[REMOVE] ������ " + removedElement + "�� ������ �Ϸ�Ǿ����ϴ�.");

				System.arraycopy(arrayA, removeIndex + 1, arrayA, removeIndex, size - removeIndex - 1); // ��
																										// �ε�����
																										// ä���.

				lastIndex--;

				print();

				break;
			}

			else if (i == lastIndex) { // �迭�� x�� ������
				System.out.println("[REMOVE] �����ϰ����ϴ� ���Ҹ� ã�� �� �����ϴ�.");
			}

		}

		return removedElement;
	}

}
