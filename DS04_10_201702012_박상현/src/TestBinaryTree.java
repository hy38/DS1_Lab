
public class TestBinaryTree {

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree(15);
		tree.levelOrder();
		System.out.println();
		tree.preOrder(0);
		System.out.println();
		
		BinaryTree tree2 = new BinaryTree(15, 20);
		tree2.levelOrder();
		System.out.println();
		tree2.preOrder(0);
		System.out.println();
		
		
	}

}
