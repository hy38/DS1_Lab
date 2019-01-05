

public class test {

	public static void main(String[] args) {

		IntArrays a = new IntArrays(10);
		a.print();

		for(int i=1; i<8; i++){
			a.add(i);
			System.out.println("LAST INDEX : " + a.searchLastIndex());
			System.out.println("배열의 크기 : " + a.size);
		}

		a.remove(1);
		System.out.println("LAST INDEX : " + a.searchLastIndex());
		System.out.println("배열의 크기 : " + a.size);
		a.remove(3);
		System.out.println("LAST INDEX : " + a.searchLastIndex());
		System.out.println("배열의 크기 : " + a.size);
		a.remove(7);
		System.out.println("LAST INDEX : " + a.searchLastIndex());
		System.out.println("배열의 크기 : " + a.size);
		a.remove(100);
		
		

	}

}
