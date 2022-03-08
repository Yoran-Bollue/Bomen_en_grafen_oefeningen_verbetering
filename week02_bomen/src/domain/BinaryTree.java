package domain;

import java.util.ArrayList;

public class BinaryTree<E> {
	private E data;
	private BinaryTree<E> leftTree, rightTree;
	
	public BinaryTree(E data){
		this(data,null,null);
	}
	
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree){
		if (data == null) {
			throw new IllegalArgumentException();
		}
		this.data= data;
		this.leftTree= leftTree;
		this.rightTree= rightTree;
	}
	
	public void printPreorder(){
			System.out.print(this.data + " ");
			if (this.leftTree != null) this.leftTree.printPreorder();
			if (this.rightTree != null) this.rightTree.printPreorder();
	}

	public void printInorder(){
		if (this.leftTree == null) {
			System.out.print(this.data + " ");
		} else {
			this.leftTree.printInorder();
			System.out.print(this.data + " ");
		}

		if (this.rightTree != null) this.rightTree.printInorder();
	}

	public void printPostorder(){
		if (this.leftTree != null){
			this.leftTree.printPostorder();
		}
		if (this.rightTree != null){
			this.rightTree.printPostorder();
		}
		System.out.print(this.data + " ");
	}

	public int countNodes(){
		int n = 1;
		if(this.leftTree != null){
			n += this.leftTree.countNodes();
		}
		if(this.rightTree != null){
			n += this.rightTree.countNodes();
		}
		return n;
	}

	public int getDepth(){
		int n = 1;
		if(this.leftTree != null && this.rightTree != null){
			n += Math.max(this.leftTree.getDepth(), this.rightTree.getDepth());
		}
		return n;
	}

	public boolean isLeaf(){
		return (this.leftTree == null && this.rightTree == null);
	}

	public int countLeaves(){
		int n = 0;
		if (this.isLeaf()) n+=1;
		else {
			if (this.leftTree != null) n += this.leftTree.countLeaves();
			if (this.rightTree != null) n += this.leftTree.countLeaves();
		}
		return n;
	}

	public ArrayList<E> getDataLeaves(){
		ArrayList<E> leaves = new ArrayList<>();
		if (this.isLeaf()){
			leaves.add(this.data);
		} else {
			if (this.leftTree != null){
				leaves.addAll(this.leftTree.getDataLeaves());
			}
			if (this.rightTree != null){
				leaves.addAll(this.rightTree.getDataLeaves());
			}
		}
		return leaves;
	}

	public boolean contains(E data){
		if (this.data == data) return true;
		else {
			return (this.leftTree == null ? false : this.leftTree.contains(data)) || (this.rightTree == null ? false : this.rightTree.contains(data));
		}
	}
}
