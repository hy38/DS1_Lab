
public interface Point {	//Point Interface 생성
	double getX();	//getX getter 메소드 작성
	double getY();	//getY getter 메소드 작성
	
	void setX(double x);	//setX 설정자 메소드 작성
	void setY(double y);	//setY 설정자 메소드 작성
	
	void moveTo(double a, double b);	//moveTo 메소드 작성
	void scaleTo(double c);	//scaleTo 메소드 작성
	
}
