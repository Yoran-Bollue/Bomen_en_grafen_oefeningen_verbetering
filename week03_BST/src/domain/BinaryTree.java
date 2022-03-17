package domain;

import java.util.ArrayList;
import java.util.Collection;

public class BinaryTree<E> {
	E data;
	BinaryTree<E> leftTree, rightTree;

	public BinaryTree(E data) {
		this(data, null, null);
	}

	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		if (data == null) {
			throw new IllegalArgumentException();
		}
		this.data = data;
		this.leftTree = leftTree;
		this.rightTree = rightTree;
	}

	public void printInorder() {
		if (this.leftTree != null) this.leftTree.printInorder();
		System.out.print(this.data + " ");
		if (this.rightTree != null) this.rightTree.printInorder();
	}

	public int getDepth() {
		int n = 1;
		if (this.leftTree != null && this.rightTree != null) {
			n += Math.max(this.leftTree.getDepth(), this.rightTree.getDepth());
		}
		return n;
	}

	public boolean isLeaf() {
		return (this.leftTree == null && this.rightTree == null);
	}

	public int count(){
		int total = 1;
		if (this.leftTree != null) {
			total += this.leftTree.count();
		}
		if (this.rightTree != null){
			total += this.rightTree.count();
		}
		return total;
	}

	public int count(E geg) {
		if (geg == null) {
			return 0;
		}
		return (this.data.equals(geg) ? 1 : 0)
				+ (this.leftTree != null ? this.leftTree.count(geg) : 0)
				+ (this.rightTree != null ? this.rightTree.count(geg) : 0);
	}


	//*ONDERSTAANDE METHODES NIET IMPLEMENTEREN! DEZE MOETEN GEIMPLEMENTEERD WORDEN IN DE BinarySearchTree file!*//
	boolean lookup(E data) {
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	boolean addNode(E data) {
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	boolean removeNode(E data) {
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	E searchSmallest() {
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	E searchGreatest() {
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	public ArrayList<E> getPath(E data) {
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	protected void cleanUp(){
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}
}
