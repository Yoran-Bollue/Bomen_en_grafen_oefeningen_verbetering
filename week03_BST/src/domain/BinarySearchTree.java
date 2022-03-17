package domain;

import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	public BinarySearchTree(E data, BinarySearchTree<E> leftTree, BinarySearchTree<E> rightTree) {
		super(data, leftTree, rightTree);
	}

	public BinarySearchTree(E data) {
		super(data);
	}

	@Override
	public boolean lookup(E data) {
		if (data.compareTo(this.data) == 0) {
			return true;
		} else if (this.leftTree != null && this.leftTree.lookup(data)) {
			return true;
		} else if (this.rightTree != null && this.rightTree.lookup(data)) {
			return true;
		} else return false;
	}

	public boolean addNode(E data) {
		if (data == null) throw new IllegalArgumentException();
		if (data.compareTo(this.data) == 0) {
			return false;
		} else if (data.compareTo(this.data) < 0) {
			if (this.leftTree == null) {
				this.leftTree = new BinarySearchTree<>(data);
				return true;
			} else {
				this.leftTree.addNode(data);
			}
		} else {
			if (this.rightTree == null) {
				this.rightTree = new BinarySearchTree<>(data);
				return true;
			} else {
				this.rightTree.addNode(data);
			}
		}
		return false;
	}

	/*public boolean removeNode(E data){
		if (data == null) throw new IllegalArgumentException();
		if (this.lookup(data)) {
			if (this.data.compareTo(data) == 0) {
				if (this.leftTree == null && this.rightTree == null) {
					this.data = null;
					return true;
				} else if (this.leftTree == null) {
					E smallest = this.rightTree.searchSmallest();
					this.data = smallest;
					this.rightTree.removeNode(smallest);
					return true;
				} else if (this.rightTree == null) {
					E greatest = this.leftTree.searchGreatest();
					this.data = greatest;
					this.leftTree.removeNode(greatest);
					return true;
				} else {
					E what = (this.leftTree.getDepth() > this.rightTree.getDepth() ? this.leftTree.searchGreatest() : this.rightTree.searchSmallest());
					this.data = what;
					this.leftTree.removeNode(what);
					return true;
				}
			} else if (this.data.compareTo(data) < 0 && this.rightTree != null){
				return this.rightTree.removeNode(data);
			} else if (this.data.compareTo(data) > 0 && this.leftTree != null){
				return this.leftTree.removeNode(data);
			} else return false;
		} else return false;
	}*/

	public boolean removeNode(E data) {
		if (data == null) {
			throw new IllegalArgumentException();
		}
		if (this.data == null) {
			return false;
		}
		if (this.data.compareTo(data) == 0) {//data gevonden
			if (this.isLeaf()) {
				this.data = null;
				return true;
// in dit geval blijft een leeg blaadje achter
// clean kan dan enkel via gehele boom
			} else {
				if (this.leftTree != null) {//linkerboom is niet leeg
					E grootsteLinks = this.leftTree.searchGreatest();
					this.data = grootsteLinks;
					boolean verwijderenGelukt = this.leftTree.removeNode(grootsteLinks);
					if (verwijderenGelukt) {
						this.leftTree.cleanUp();
					}
					return verwijderenGelukt;
				} else {//rechterboom is niet leeg
					E kleinsteRechts = this.rightTree.searchGreatest();
					this.data = kleinsteRechts;
					boolean verwijderenGelukt = this.rightTree.removeNode(kleinsteRechts);
					if (verwijderenGelukt) {
						this.rightTree.cleanUp();
					}
					return verwijderenGelukt;
				}
			}
		} else {
			if (this.data.compareTo(data) > 0) {//zoek in linkerboom
				if (this.leftTree == null){
					return false;
				} else {
					boolean result = this.leftTree.removeNode(data);
					this.leftTree.cleanUp();
					return result;
				}
				//return (this.leftTree == null ? false : this.leftTree.removeNode(data));
			} else {//zoek in rechterboom
				if (this.rightTree == null){
					return false;
				} else {
					boolean result = this.rightTree.removeNode(data);
					this.rightTree.cleanUp();
					return result;
				}
				//return (this.rightTree == null ? false : this.rightTree.removeNode(data));
			}
		}
	}

	public void cleanUp(){
		if (this.data != null) {
			if (this.leftTree != null) {
				if (this.leftTree.data == null) {
					this.leftTree = null;
				} else {
					this.leftTree.cleanUp();
				}
			}
			if (this.rightTree != null) {
				if (this.rightTree.data == null) {
					this.rightTree = null;
				} else {
					this.rightTree.cleanUp();
				}
			}
		}
	}

	public ArrayList<E> getPath(E data){
		ArrayList<E> path = new ArrayList<>();
		if (this.data.compareTo(data) == 0){
			path.add(this.data);
			return path;
		} else {
			path.add(this.data);
			if (this.data.compareTo(data) < 0){
				if (this.rightTree != null) {
					path.addAll(this.rightTree.getPath(data));
				} else {
					throw new IllegalArgumentException("cannot find data.");
				}
			} else {
				if (this.leftTree != null){
					path.addAll(this.leftTree.getPath(data));
				} else  {
					throw new IllegalArgumentException("cannot find data.");
				}
			}
		}
		return path;
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


