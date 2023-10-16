package lab78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import lab78.YorkLinkedBinaryTree.Node;

/**
 * The YorkBinarySearchTree tree is an binary search tree 
 * 
 * 
 * In a YorkBinarySearchTree tree extends YorkLinkedBinaryTree 
 * and adopts same  convention in which we set a node
 * parent pointer to itself when removed from a tree to recognize it as an
 * invalid position later on. Thus, in your implementation for the
 * YorkLinkedBinaryTree tree, you must validate the received input position
 * every time to ensure that it is a valid tree node.
 * 
 * Note: You are responsible for creating and running the tests necessary to ensure 
 * that you have correct implementation of YorkBinarySearchTree tree. 
 * 
 *
 */
public class YorkBinarySearchTree<E extends Comparable<E>> extends YorkLinkedBinaryTree<E> {


	/**
	 * Add any other private data members or methods that are necessary to manage
	 * the YorkLinkedBinaryTree 
	 */

	/**
	 *  Constructs an empty binary search tree.
	 */
	public YorkBinarySearchTree() {
		// TODO: Your implementation of this method starts here
		super();
	}

	/**
	 *  Constructs a binary search tree with given element at root 
	 */
	public YorkBinarySearchTree(E e) {
		// TODO: Your implementation of this method starts here
		super();
		addRoot(e);
	}

	/**
	 * 
	 * @param objects array of element to be added into this tree 
	 */

	public YorkBinarySearchTree(E[] objects) {
		// TODO: Your implementation of this method starts here
		for (E e : objects) {
			insert(e);
		}
	}

	/**
	 * Search of element inside the tree 
	 * if the element is found, then return the position of the element 
	 * if the element  is not found, return null 
	 * @param e  input element 
	 * @return  position of element if element exist inside the tree or null if element not exist
	 */

	public Position<E> search(E e) {
		// TODO: Your implementation of this method starts here
		if (e != null) {
			return searchHelper(root(), e);
		}
		return null;
	}

	private Position<E> searchHelper(Position<E> pos, E e) {
		if (e.compareTo(pos.getElement()) > 0) {
			if (right(pos) == null) {
				return null;
			}
			else {
				return searchHelper(right(pos), e);
			}
		}
		else if (e.compareTo(pos.getElement()) < 0) {
			if (left(pos) == null) {
				return null;
			}
			else {
				return searchHelper(left(pos), e);
			}
		}
		else {
			return pos;
		}
	}

	/**
	 * Remove element e from tree.
	 * if the element is found, remove its position and  return the position of its parent 
	 * if the element  is not found, return null
	 *  
	 * 
	 * @param e the input element for remove  
	 * @return  parent position of the  removed element or null 
	 */

	public Position<E> remove (E e){
		// TODO: Your implementation of this method starts here
		if (!isEmpty()) {
			setRoot(deleteRec(root(), 0, e));
		}

		return parent(search(e));
	}


	private Position<E> deleteRec(Position<E> pos, int key, E e) {

		/* Base Case: If the tree is empty */
		if (pos == null) {			
			return null;
		}

		/* Otherwise, recur down the tree */
		if (e.compareTo(root().getElement()) < 0)
			((Node<E>) pos).setLeft((Node<E>) deleteRec(left(pos), key, e));
		else if (e.compareTo(root().getElement()) > 0)
			((Node<E>) pos).setRight((Node<E>) deleteRec(right(pos), key, e));

		// if key is same as root's
		// key, then This is the
		// node to be deleted
		else {
			// node with only one child or no child
			if (left(pos) == null)
				return right(pos);
			else if (right(pos) == null)
				return left(pos);

			// node with two children: Get the inorder
			// successor (smallest in the right subtree)
			int index = 1 + ((List<Position<E>>) inorder()).indexOf(pos);
			
			E h = set(root(), ((List<Position<E>>) inorder()).get(index).getElement());

			// Delete the inorder successor
			((Node<E>) pos).setRight((Node<E>) right(pos));
			((Node<E>) right(pos)).setParent((Node<E>) pos);
			
			for (Position<E> p : inorder()) {
				if (p.getElement().equals(root().getElement()) && !isRoot(p)) {
					((Node<E>) p).setParent((Node<E>) p);
				}
			}
		}

		return root();
	}



	/**
	 * Adds the input  element to the binary search tree in 
	 * the appropriate position.  
	 * Note that equal elements are added to the right.
	 * @param e the element that will be added to binary search tree 
	 * @return the Position of the newly added element 
	 */

	// find the position first
	// verify that it is external
	// then insert (left/right)

	public Position<E> insert(E e) {
		// TODO: Your implementation of this method starts here
		if (isEmpty()) {
			return addRoot(e);
		}
		Position<E> node = insertHelper(root(), e);

		return node;
	}

	private Position<E> insertHelper(Position<E> pos, E e) {
		if (e.compareTo(pos.getElement()) >= 0) {
			if (right(pos) == null) {
				return insertRight(pos, e);
			}
			else {
				return insertHelper(right(pos), e);
			}
		}
		else {
			if (left(pos) == null) {
				return insertLeft(pos, e);
			}
			else {
				return insertHelper(left(pos), e);
			}
		}

	}

	/**
	 * Returns true if the tree is a full binary tree
	 * @return  true if the tree is a full binary tree
	 */

	public boolean isFullBST() {
		// TODO: Your implementation of this method starts here
		if (!isEmpty()) {			
			int leaves = 0;

			for (Position<E> pos : positions()) {
				if (isExternal(pos)) {
					leaves++;
				}
			}

			return leaves == Math.pow(2, height());
		}
		return false;
	}



	/**
	 * Returns the number of leaf nodes  
	 * @return Returns the number of leaf nodes 
	 */
	public int getNumberOfLeaves() {
		// TODO: Your implementation of this method starts here
		int leaves = 0;

		if (!isEmpty()) {			
			for (Position<E> pos : positions()) {
				if (isExternal(pos)) {
					leaves++;
				}
			}
		}

		return leaves;
	}


	/**
	 * Returns the number of non-leaf nodes
	 * @return Returns the number of non-leaf nodes
	 */
	public int getNumberofNonLeaves() {
		// TODO: Your implementation of this method starts here
		int nonLeaves = 0;

		if(!isEmpty()) {			
			for (Position<E> pos : positions()) {
				if (isInternal(pos)) {
					nonLeaves++;
				}
			}
		}

		return nonLeaves;
	}

	/**
	 * Returns an iterable collection of positions of the tree, reported in inorder.
	 * @return  iterable collection of positions of the tree, reported in inorder
	 */
	public Iterable<Position<E>> inorder() {
		// TODO: Your implementation of this method starts here
		List<Position<E>> positions = new ArrayList<Position<E>>();
		if (!isEmpty()) {
			inorderHelper(root(), positions);
		}
		return positions;
	}

	private void inorderHelper(Position<E> node, List<Position<E>> positions) {
		if (node != null) {
			if (isExternal(node)) {
				positions.add(node);
			}
			else {
				inorderHelper(left(node), positions);
				positions.add(node);
				inorderHelper(right(node), positions);
			}
		}
	}



	/**
	 * Returns an iterable collection of positions of the tree, reported in preorder
	 * 
	 * @return iterable collection of positions of the tree, reported in preorder
	 */
	public Iterable<Position<E>> preorder() {
		// TODO: Your implementation of this method starts here
		List<Position<E>> positions = new ArrayList<Position<E>>();
		if (!isEmpty()) {
			preorderHelper(root(), positions);
		}
		return positions;
	}

	private void preorderHelper(Position<E> node, List<Position<E>> positions) {
		if (node != null) {
			if (isExternal(node)) {
				positions.add(node);
			}
			else {
				positions.add(node);
				preorderHelper(left(node), positions);
				preorderHelper(right(node), positions);
			}
		}
	}



	/**
	 * 
	 * Returns an iterable collection of positions of the tree, reported in postorder
	 * 
	 * @return iterable collection of positions of the tree, reported in postorder
	 */
	public Iterable<Position<E>> postorder() {
		// TODO: Your implementation of this method starts here
		List<Position<E>> positions = new ArrayList<Position<E>>();
		if (!isEmpty()) {
			postorderHelper(root(), positions);
		}
		return positions;
	}

	private void postorderHelper(Position<E> node, List<Position<E>> positions) {
		if (node != null) {
			if (isExternal(node)) {
				positions.add(node);
			}
			else {
				postorderHelper(left(node), positions);
				postorderHelper(right(node), positions);
				positions.add(node);
			}
		}
	}




	/**
	 * Returns an iterable collection of positions of the tree in breadth-first
	 * order.
	 * @return iterable collection of positions of the tree in breadth-first order
	 */
	public Iterable<Position<E>> breadthfirst() {
		// TODO: Your implementation of this method starts here
		List<Position<E>> positions = new ArrayList<Position<E>>();
		Queue<Position<E>> q = new LinkedList<>();
		if (!isEmpty()) {			
			q.add(root());

			do {
				Position<E> p = q.remove();
				positions.add(p);
				for (Position<E> pos : children(p)) {
					q.add(pos);
				}

			} while (!q.isEmpty());
		}
		return positions;		
	}



	/**
	 * Overrides positions to make inorder the default order for binary trees.
	 */
	@Override
	public Iterable<Position<E>> positions() {
		// TODO: Your implementation of this method starts here
		return inorder();
	}



	public boolean isSorted(YorkBinarySearchTree<E> t) {
		if (!t.isEmpty()) {
			Iterable<Position<E>> positions = t.inorder();
			Position<E> first = null;
			boolean checkedFirst = false;
			for (Position<E> pos : positions) {
				if (!checkedFirst) {
					first = pos;
					checkedFirst = true;
					continue;
				}
				if ( ((Node<E>) pos).getElement().compareTo(((Node<E>) first).getElement()) < 0) {
					return false;
				}
				first = pos;
			}
			return true;
		}

		return false;
	}

	@Override
	public void attach(Position<E> p, YorkLinkedBinaryTree<E> t1, YorkLinkedBinaryTree<E> t2)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (!isSorted((YorkBinarySearchTree<E>) t1)) {
			throw new IllegalArgumentException("t1 is not a BST");
		}

		if (!isSorted((YorkBinarySearchTree<E>) t2)) {
			throw new IllegalArgumentException("t2 is not a BST");
		}

		super.attach(p, t1, t2);
	}

	public String toString() {
		List<String> l = new LinkedList<>(); 
		if (!isEmpty()) {
			for (Position<E> pos : inorder()) {
				l.add(pos.getElement().toString());
			}
		}
		return l.toString();
	}


}
