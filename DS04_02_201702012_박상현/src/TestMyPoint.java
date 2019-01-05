
public class TestMyPoint {

	public static void main(String[] args) {

		MyPoint test = new MyPoint(); // 객체 생성

		test.setX(-1); // x좌표 설정
		test.setY(3); // y좌표 설정

		test.print(); // print() 메소드 호출

		test.moveTo(2, -5); // (2, -5)만큼 이동
		test.scaleTo(-2); // 각 좌표 -2배 시도
		test.scaleTo(2); // 각 좌표 2배 시도

	}

}
