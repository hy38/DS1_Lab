
public class TestBST {

	public static void main(String[] args) {
		BinarySearchTree a = new BinarySearchTree();
		a.recu_insert(5);	a.recu_insert(10);	a.recu_insert(1);
		a.recu_insert(3);	a.recu_insert(7);	a.recu_insert(13);
		a.recu_insert(11);	a.recu_insert(15);	a.recu_insert(12);

		a.inorder();

		System.out.println();
		
		a.delete(12);
		a.delete(1);
		a.delete(10);

		a.inorder();
		
		System.out.println("Returned Key from delete_minimum() : " + a.getReturnedKey());

	}

}
