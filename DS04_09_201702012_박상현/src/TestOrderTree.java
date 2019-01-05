import java.util.*;

public class TestOrderTree { // TestOrderTree class �ۼ�

	public static void main(String[] args) { // main

		OrderedTree treeA, treeB, treeD, treeE, treeG; // �� ��� ����

		// ���� ��� ����
		OrderedTree treeC = new OrderedTree("C");
		OrderedTree treeF = new OrderedTree("F");
		OrderedTree treeH = new OrderedTree("H");
		OrderedTree treeI = new OrderedTree("I");
		OrderedTree treeJ = new OrderedTree("J");
		OrderedTree treeK = new OrderedTree("K");
		OrderedTree treeL = new OrderedTree("L");
		OrderedTree treeM = new OrderedTree("M");

		// ���� Ʈ���� �����ϰ� ��Ʈ ��忡 ������
		List<OrderedTree> subtreesOfE = new ArrayList<OrderedTree>();
		subtreesOfE.add(treeH);
		subtreesOfE.add(treeI);
		treeE = new OrderedTree("E", subtreesOfE);

		// ���� Ʈ���� �����ϰ� ��Ʈ ��忡 ������
		List<OrderedTree> subtreesOfB = new ArrayList<OrderedTree>();
		subtreesOfB.add(treeE);
		subtreesOfB.add(treeF);
		treeB = new OrderedTree("B", subtreesOfB);

		// ���� Ʈ���� �����ϰ� ��Ʈ ��忡 ������
		List<OrderedTree> subtreesOfG = new ArrayList<OrderedTree>();
		subtreesOfG.add(treeJ);
		subtreesOfG.add(treeK);
		subtreesOfG.add(treeL);
		subtreesOfG.add(treeM);
		treeG = new OrderedTree("G", subtreesOfG);

		// ���� Ʈ���� �����ϰ� ��Ʈ ��忡 ������
		List<OrderedTree> subtreesOfD = new ArrayList<OrderedTree>();
		subtreesOfD.add(treeG);
		treeD = new OrderedTree("D", subtreesOfD);

		// ���� Ʈ���� �����ϰ� ��Ʈ ��忡 ������
		List<OrderedTree> subtreesOfA = new ArrayList<OrderedTree>();
		subtreesOfA.add(treeB);
		subtreesOfA.add(treeC);
		subtreesOfA.add(treeD);
		treeA = new OrderedTree("A", subtreesOfA);

		// levelOrder() �޼ҵ� ȣ��
		treeA.levelOrder();

	}

}
