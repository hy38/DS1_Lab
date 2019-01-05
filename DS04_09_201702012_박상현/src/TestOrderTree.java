import java.util.*;

public class TestOrderTree { // TestOrderTree class 작성

	public static void main(String[] args) { // main

		OrderedTree treeA, treeB, treeD, treeE, treeG; // 각 노드 선언

		// 리프 노드 생성
		OrderedTree treeC = new OrderedTree("C");
		OrderedTree treeF = new OrderedTree("F");
		OrderedTree treeH = new OrderedTree("H");
		OrderedTree treeI = new OrderedTree("I");
		OrderedTree treeJ = new OrderedTree("J");
		OrderedTree treeK = new OrderedTree("K");
		OrderedTree treeL = new OrderedTree("L");
		OrderedTree treeM = new OrderedTree("M");

		// 서브 트리를 구축하고 루트 노드에 연결함
		List<OrderedTree> subtreesOfE = new ArrayList<OrderedTree>();
		subtreesOfE.add(treeH);
		subtreesOfE.add(treeI);
		treeE = new OrderedTree("E", subtreesOfE);

		// 서브 트리를 구축하고 루트 노드에 연결함
		List<OrderedTree> subtreesOfB = new ArrayList<OrderedTree>();
		subtreesOfB.add(treeE);
		subtreesOfB.add(treeF);
		treeB = new OrderedTree("B", subtreesOfB);

		// 서브 트리를 구축하고 루트 노드에 연결함
		List<OrderedTree> subtreesOfG = new ArrayList<OrderedTree>();
		subtreesOfG.add(treeJ);
		subtreesOfG.add(treeK);
		subtreesOfG.add(treeL);
		subtreesOfG.add(treeM);
		treeG = new OrderedTree("G", subtreesOfG);

		// 서브 트리를 구축하고 루트 노드에 연결함
		List<OrderedTree> subtreesOfD = new ArrayList<OrderedTree>();
		subtreesOfD.add(treeG);
		treeD = new OrderedTree("D", subtreesOfD);

		// 서브 트리를 구축하고 루트 노드에 연결함
		List<OrderedTree> subtreesOfA = new ArrayList<OrderedTree>();
		subtreesOfA.add(treeB);
		subtreesOfA.add(treeC);
		subtreesOfA.add(treeD);
		treeA = new OrderedTree("A", subtreesOfA);

		// levelOrder() 메소드 호출
		treeA.levelOrder();

	}

}
