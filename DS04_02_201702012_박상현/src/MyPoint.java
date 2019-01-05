
public class MyPoint implements Point {	//MyPoint class가 Point를 implements 하도록 설정.

	private double cordX;	//x좌표를 나타내는 필드 생성
	private double cordY;	//y좌표를 나타내는 필드 생성

	public void print() {	//현재 좌표를 출력하는 print()메소드 생성
		System.out.printf("현재 좌표 : (" + cordX + ", " + cordY + ")\n", cordX, cordY);
	}

	public double getX() {	//x좌표를 반환하는 getX()메소드 구체화
		return cordX;
	}

	public double getY() {	//y좌표를 반환하는 getY()메소드 구체화
		return cordY;
	}

	public void setX(double x) {	//x좌표를 설정하는 setX()메소드 구체화
		this.cordX = x;
	}

	public void setY(double y) {	//y좌표를 설정하는 setY()메소드 구체화
		this.cordY = y;
	}

	public void moveTo(double a, double b) {	//좌표를 (a, b)만큼 이동시키는 moveTo()메소드 구체화
		this.cordX += a;
		this.cordY += b;
		System.out.println("[move] x축으로 " + a + ", y축으로 " + b + "만큼 이동 완료 하였습니다.");
		print();	//현재 좌표 출력
	}

	public void scaleTo(double c) {	//좌표를 c배하는 scaleTo()메소드 구체화
		if (c > 0) {
			this.cordX *= c;
			this.cordY *= c;
		} else	//c가 0보다 크지 않으면 Error 메세지 호출.
			System.out.println("[Error] 입력하신 " + c + "는 양수가 아니므로 조건에 어긋납니다.");

		print();	//현재 좌표 출력
	}

}
