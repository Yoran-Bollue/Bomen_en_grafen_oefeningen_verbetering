package ui;

import domain.BinaryTree;

import javax.lang.model.element.Element;

public class BinaryTreeDriver {

	public static void main(String[] args) {
		/*BinaryTree<String> nodeD = new BinaryTree<>("D");
		BinaryTree<String> nodeF = new BinaryTree<>("F");
		BinaryTree<String> nodeB = new BinaryTree<>("B");
		BinaryTree<String> nodeH = new BinaryTree<>("H");
		
		// knoop A heeft links D en rechts F
		BinaryTree<String> nodeA = new BinaryTree<>("A",nodeD, nodeF);
		// knoop E heeft links H
		BinaryTree<String> nodeE = new BinaryTree<>("E",nodeH,null);
		// knoop G heeft links E en rechts B
		BinaryTree<String> nodeG = new BinaryTree<>("G",nodeE, nodeB);
		
		// boom heeft root C en heeft links A en rechts G
		BinaryTree<String> boom = new BinaryTree<>("C",nodeA, nodeG);
		boom.printPreorder();*/

		BinaryTree<String> nodeA = new BinaryTree<>("A");
		BinaryTree<String> nodeC = new BinaryTree<>("C");
		BinaryTree<String> nodeE = new BinaryTree<>("E");
		BinaryTree<String> nodeH = new BinaryTree<>("H");

		BinaryTree<String> nodeD = new BinaryTree<>("D", nodeC, nodeE);
		BinaryTree<String> nodeI = new BinaryTree<>("I", nodeH, null);
		BinaryTree<String> nodeB = new BinaryTree<>("B", nodeA, nodeD);
		BinaryTree<String> nodeG = new BinaryTree<>("G", null, nodeI);
		BinaryTree<String> boom = new BinaryTree<>("F", nodeB, nodeG);

		System.out.print("");
		boom.printPreorder();

		System.out.println("");

		boom.printInorder();

		System.out.println("");

		boom.printPostorder();

		System.out.println();
		System.out.println("Er zijn " + boom.countNodes() + " nodes.");
		System.out.println("De maximum Diepte is " + boom.getDepth());
		System.out.println("Er zijn " + boom.countLeaves() + " leaves.");
		System.out.println("Leaves' data is: " + boom.getDataLeaves());
		System.out.println("De boom bevat " + (boom.contains("D")?"wel":"niet") + " D.");
		System.out.println("De boom bevat " + (boom.contains("H")?"wel":"niet") + " H.");
		System.out.println("De boom bevat " + (boom.contains("F")?"wel":"niet") + " F.");
		System.out.println("De boom bevat " + (boom.contains("Q")?"wel":"niet") + " Q.");

	}

}
