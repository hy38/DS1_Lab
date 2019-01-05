
public class TestBigInt {	//	TestBigInt class ±¸Çö

	public static void main(String[] args) {
			
		BigInt x = new BigInt(54321);	//	x : 54321
		BigInt y = new BigInt(9);	//	y : 9
		BigInt z = new BigInt(8888);	//	z : 8888
		
		BigInt x2 = new BigInt(8888);	// x2 : 8888
		BigInt z2 = new BigInt(54321);	// z2 : 54321

		System.out.println(x.multiply(z).toString());		//	54321 * 8888
		System.out.println(z.multiply(x).toString());		//	8888 * 54321
		
		
		System.out.println(x2.multiply(z2).toString());	// 8888 * 54321
		System.out.println(z2.multiply(x2).toString());	//	54321 * 8888
		
		
	}

}
