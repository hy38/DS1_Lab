import java.util.Random;

//배열의 원소의 0이면 빈 Index로 간주함.

public class IntArrays {

	Random rg;
	private int[] arrayA;
	int size; // 배열 A의 최대 크기
	private int[] arrayB;

	public IntArrays(int size) {// 생성자 생성
		rg = new Random();
		arrayA = new int[size]; // 배열 arrayA 생성
		this.size = size;
		for (int i = 0; i < arrayA.length / 2; i++) {
			arrayA[i] = rg.nextInt(9) + 1; // 1부터 9까지의 난수 발생
		}
		System.out.println("길이 " + size + "인 배열을 생성하였습니다.");
	}

	public boolean isFull() { // 배열 arrayA가 Full 한지 확인하는 메소드
		return (arrayA[size - 1] != 0);
	}

	public void print() { // 배열에 있는 모든 원소를 출력해주는 메소드
		System.out.print("배열 데이터 : ");
		for (int i = 0; i < arrayA.length; i++) {
			if (arrayA[i] == 0)
				break;
			System.out.print(arrayA[i] + "  ");
		}
		System.out.println();
	}

	private static int lastIndex = 0; // 배열의 마지막 원소의 인덱스값을 static형의 변수
										// lastIndex로 정의

	public int searchLastIndex() { // arrayA의 lastIndex의 값을 반환해주는 메소드
		// lastIndex = 0;
		for (int i = 0; i < arrayA.length; i++) {
			if (arrayA[i] == 0) {
				lastIndex = i - 1;
				break;
			}
		}
		return lastIndex;
	}

	public void add(int x) {// 배열이 이미 가득 차 있을 경우를 고려해야함.

		if (isFull()) { // arrayA가 꽉차있다면,
			arrayB = new int[size]; // temp배열인 arrayB배열 생성(size는 A와 동일)
			System.arraycopy(arrayA, 0, arrayB, 0, size); // arrayA를
															// arrayB에 복사,

			arrayA = new int[size * 2]; // A배열을 size*2로 sizeup
			System.arraycopy(arrayB, 0, arrayA, 0, size); // arrayB를 arrayA에 다시
															// 복사
			this.size = size * 2; // size 필드 재정의

			arrayA[lastIndex + 1] = x;

			lastIndex++;
		}

		else { // arrayA가 꽉차있지 않다면
				// arrayA[searchLastIndex() + 1] = x;
			arrayA[lastIndex + 1] = x;
			lastIndex++;
		}

		System.out.println("[ADD] 데이터 " + x + "의 삽입이 완료되었습니다.");
		print();
	}

	private int removedElement;
	private int removeIndex;

	public int remove(int x) {

		for (int i = 0; i < arrayA.length; i++) {
			if (arrayA[i] == x) { // 배열에 삭제하고자하는 원소 x가 있을때
				removeIndex = i;
				removedElement = x;
				arrayA[removeIndex] = 0;

				System.out.println("[REMOVE] 데이터 " + removedElement + "의 삭제가 완료되었습니다.");

				System.arraycopy(arrayA, removeIndex + 1, arrayA, removeIndex, size - removeIndex - 1); // 빈
																										// 인덱스를
																										// 채운다.

				lastIndex--;

				print();

				break;
			}

			else if (i == lastIndex) { // 배열에 x가 없을때
				System.out.println("[REMOVE] 삭제하고자하는 원소를 찾을 수 없습니다.");
			}

		}

		return removedElement;
	}

}
