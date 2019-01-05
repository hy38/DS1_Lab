
public class TestLinkedStack {

	public static void main(String[] args) {

		LinkedStack a = new LinkedStack();	//	a라는 이름의 LinkedStack 객체 생성
		for (int i = 1; i < 6; i++) {	//	스택 a에 1부터 5까지 push
			a.push(i);
		}
		System.out.println(a.toString());	//	스택 a 출력

		System.out.println();	//	가독성을 위한 개행

		System.out.println("[REMOVING SECOND]...");
		a.removeSecond();		//	스택 a에 removeSecond()메소드 수행
		System.out.println(a.toString());	//	스택 a 출력

		System.out.println();	//	가독성을 위한 개행

		System.out.println("[REVERSING STACK]...");
		a.reverse();	//	스택 a에 reverse()메소드 수행
		System.out.println(a.toString());	//	스택 a 출력

	}

}
