package domain;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	public BinarySearchTree(E data, BinarySearchTree<E> leftTree, BinarySearchTree<E> rightTree) {
		super(data, leftTree, rightTree);
	}
			
	public BinarySearchTree(E data) {
		super(data);
	}

	@Override
	public boolean lookup(E data) {
		if (data.compareTo(this.data) == 0){
			return true;
		} else if (this.leftTree.lookup(data)){
			return true;
		} else return this.rightTree.lookup(data);
	}

	public boolean addNode(E data) {
		if (data == null) throw new IllegalArgumentException();
		if (data.compareTo(this.data) == 0){
			return false;
		} else if (data.compareTo(this.data) < 0){
			if (this.leftTree == null){
				this.leftTree = new BinarySearchTree<>(data);
				return true;
			} else {
				this.leftTree.addNode(data);
			}
		} else {
			if (this.rightTree == null){
				this.rightTree = new BinarySearchTree<>(data);
				return true;
			} else {
				this.rightTree.addNode(data);
			}
		}
		return false;
	}

	public boolean removeNode(E data){
		if (data == null) throw new IllegalArgumentException();
		if (this.data.compareTo(data) == 0){
			if (this.leftTree == null && this.rightTree == null){

			}
		}
		if (this.data.compareTo(data) > 0)
	}

	public E searchSmallest(){
		if (this.leftTree == null) return this.data;
		else return this.leftTree.searchSmallest();
	}

	public E searchGreatest(){
		if (this.rightTree== null) return this.data;
		else return this.rightTree.searchGreatest();
	}
}


