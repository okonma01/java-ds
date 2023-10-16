package lab5;

import java.util.*;


/**
 * 
 * You need to complete the implementation of a YorkSortedDoublyLinkedList class
 * The YorkSortedDeoublyLinkedList uses sentinel nodes, header and trailer.
 * Therefore, you need to keep in mind that the first element of a nonempty list
 * is stored in the node just after the header (not in the header itself), and
 * similarly that the last element is stored in the node just before the
 * trailer.
 * 
 * @param <E>
 */
public class YorkSortedDoublyLinkedList<E> implements List<E> {
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private static class Node<E> {
		E element;
		Node<E> next;
		Node<E> prev;

		public Node(E element) {
			this.element = element;
		}
	}

	/////////////////////////////////////
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private Node<E> header; // header sentinel
	private Node<E> trailer; // trailer sentinel
	private int size = 0; // number of elements in the list
	//////////////////////////////////

	/**
	 * Add any other private data members or methods that are necessary 
	 * to manage the YorkSortedDoublyLinkedList 
	 */



	public YorkSortedDoublyLinkedList() {
		// TODO: Your implementation of this method starts here
		header = new Node<E>(null);
		trailer = new Node<E>(null);
		header.next = trailer;
		trailer.prev = header;
	}

	/**
	 * 
	 * Take the elements from the input array one by one and then insert them into
	 * the list. you should insert the elements at the end of the list
	 */
	public YorkSortedDoublyLinkedList(E[] objects) {
		// TODO: Your implementation of this method starts here
		this();
		for (E e : objects) {
			addLast(e);
		}
	}

	/**
	 * Returns (but does not remove) the first element stored in the first node of
	 * the list. if the list is empty return null otherwise return the first element
	 * stored inside the first node of the list
	 * 
	 * @return
	 */
	public E getFirst() {
		if (isEmpty()) {
			return null;
		}
		return header.next.element;
	}

	/**
	 * Add the newly created node to the beginning of this list
	 * 
	 * 
	 * @param e
	 */
	public void addFirst(E e) {
		// TODO: Your implementation of this method starts here
		Node<E> newNode = new Node<E>(e);
		header.next.prev = newNode;
		newNode.next = header.next;
		newNode.prev = header;
		header.next = newNode;
		size++;
	}

	/**
	 * Add the newly created node to the end of this list
	 * 
	 * 
	 * 
	 * @param e
	 */

	public void addLast(E e) {
		// TODO: Your implementation of this method starts here
		Node<E> newNode = new Node<E>(e);
		trailer.prev.next = newNode;
		newNode.prev = trailer.prev;
		newNode.next = trailer;
		trailer.prev = newNode;
		size++;
	}

	/**
	 * Return the last element stored inside the last node in this list if the list
	 * is empty returns null.
	 * 
	 * 
	 * @return
	 */
	public E getLast() {
		// TODO: Your implementation of this method starts here
		if (isEmpty()) {
			return null;
		}
		return trailer.prev.element;
	}

	/**
	 * Remove the first node and then return the element stored inside this node the
	 * method return null if this list is empty
	 * 
	 * 
	 * @return
	 */

	public E removeFirst() {
		// TODO: Your implementation of this method starts here
		if (isEmpty()) {
			return null;
		}
		Node<E> node = header.next;
		header.next = node.next;
		header.next.prev = header;
		node.prev = null;
		node.next = null;
		size--;
		return node.element;
	}

	/**
	 * Remove the last node in this list then return the element stored inside the
	 * last node. the method returns null if this list is empty
	 * 
	 * 
	 * @return
	 */
	public E removeLast() {
		// TODO: Your implementation of this method starts here
		Node<E> node = trailer.prev;
		trailer.prev = node.prev;
		trailer.prev.next = trailer;
		node.prev = null;
		node.next = null;
		size--;
		return node.element;
	}

	/**
	 * 
	 * Search this list and return the first match index. If this list does not
	 * contain the element, it is unchanged and return -1 . More formally, returns
	 * the the lowest index {@code i} such that {@code equals(e, get(i))} (if such
	 * an element exists). Returns {@code i} if this list contained the specified
	 * element .
	 * 
	 * @param e
	 * @return
	 */
	public int indexOf(E e) {
		// TODO: Your implementation of this method starts here
		int i = 0;
		for (E elem : this) {
			if (elem.equals(e)) {
				return i;
			}
			i++;
		}
		return -1;
	}

	/**
	 * Search this list and return the last match index. If this list does not
	 * contain the element, it is unchanged and return -1 . More formally, returns
	 * the the largest index {@code i} such that {@code equals(e, get(i))} (if such
	 * an element exists). Returns {@code i} if this list contained the specified
	 * element .
	 * 
	 * @param e
	 * @return
	 */

	public int lastIndexOf(E e) {
		// TODO: Your implementation of this method starts here
		int i = 0;
		int res = -1;
		for (E elem : this) {
			if (elem.equals(e)) {
				res = i;
			}
			i++;
		}
		return res;
	}

	private class YorkComparator implements Comparator<E>{

		@Override
		public int compare(E o1, E o2) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
	/**
	 * Sorts a list in ascending order by using a Comparator object
	 * 
	 * @param comparator
	 */
	public void sortAscending(Comparator<E> comparator) {

		// TODO: Your implementation of this method starts here
		if (size > 1) {			
			YorkSortedDoublyLinkedList<E> newList = new YorkSortedDoublyLinkedList<E>();
			E smallest = this.getFirst();
			int i = 0;
			int realSize = size();
			while(newList.size() != realSize) {			
				for (E e : this) {
					if (comparator.compare(smallest, e) > 0) {
						smallest = e;
					}
				}
				i = indexOf(smallest);
				remove(i);
				newList.addLast(smallest);
				smallest = this.getFirst();
			}
//			removeAll(newList);
			addAll(newList);
		}
		
	}

	/**
	 * 
	 * Sorts a list in descending order by using a Comparator object
	 * 
	 * 
	 * @param comparator
	 */
	public void sortDescending(Comparator<E> comparator) {

		// TODO: Your implementation of this method starts here
		if (size > 1) {			
			YorkSortedDoublyLinkedList<E> newList = new YorkSortedDoublyLinkedList<E>();
			E smallest = this.getFirst();
			int i = 0;
			int realSize = size;
			while(newList.size() != realSize) {			
				for (E e : this) {
					if (comparator.compare(smallest, e) < 0) {
						smallest = e;
					}
				}
				i = indexOf(smallest);
				remove(i);
				newList.addLast(smallest);
				smallest = this.getFirst();
			}
//			removeAll(newList);
			addAll(newList);
		}
	}

	private List<E> asList() {
		
		return null;
	}
	
	///////

	@Override
	public int size() {
		// TODO: Your implementation of this method starts here
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO: Your implementation of this method starts here
		return size == 0;
	}

	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		checkIndexException(i);
		int j = 0;
		for (E elem : this) {
			if (j == i) {
				return elem;
			}
			j++;
		}
		return null;
	}

	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		checkIndexException(i);

		if (!isEmpty()) {			
			Node<E> node = header;
			int j = -1;
			do {
				node = node.next;
				j++;
			} while(j < i);
			E elem = node.element;
			node.element = e;
			return elem;
		}

		return null;
	}

	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		if (i < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (i >= size) {
			addLast(e);
		}
		else {
			Node<E> node = header;
			int j = -1;
			do {
				node = node.next;
				j++;
			} while (j < i);
			Node<E> newNode = new Node<E>(e);
			newNode.prev = node.prev;
			newNode.next = node;
			node.prev.next = newNode;
			node.prev = newNode;
			size++;
		}
	}

	/**
	 * 
	 * Inserts the new element e after the specified index i in this list. Shifts
	 * the elements after the index i (if any)
	 * 
	 * Remember that You need if the index i is greater than the list size then you
	 * need to add the element e at the end of the list
	 * 
	 * @param i the index at which the new element should be stored
	 * @param e the new element to be stored
	 */

	public void addAfter(int i, E e) {
		// TODO: Your implementation of this method starts here
		if (i < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (i >= size) {
			addLast(e);
		}
		else {
			add(i+1, e);
		}
	}

	/**
	 * Removes all elements between the given lowerindex and upperindex inclusive.
	 * shifting all subsequent elements in the list closer to the front. Index: 0 1
	 * 2 3 4 5 6 Example: if list contains [ 1, 2, 3, 5, 6, 7, 8] you call
	 * removeBetween(2,4) then list will contains [1, 2, 7, 8] Hence, three elements
	 * are removed
	 * 
	 * Note: if the lower or upper index is greater than the size of the list then 
	 * the lower or upper index will be updated to be the end of the list
	 * 
	 * 
	 * 
	 * 
	 * @param lowerindex the lower index
	 * @param upperindex the upper index,
	 * @throws IndexOutOfBoundsException if the index is negative or lowerindex is
	 *                                   greater than upperindex
	 * 
	 */

	public void removeBetween(int lowerIndex, int upperIndex) {
		// TODO: Your implementation of this method starts here
		if (lowerIndex < 0 || upperIndex < 0) {
			throw new IndexOutOfBoundsException();
		}
		else if (lowerIndex > upperIndex) {
			throw new IndexOutOfBoundsException();
		}
		while (upperIndex >= lowerIndex) {
			remove(lowerIndex);
			lowerIndex--;
		}
	}

	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		checkIndexException(i);
		if (i == size-1) {
			return removeLast();
		}
		else {
			Node<E> node = header;
			int j = -1;
			do {
				node = node.next;
				j++;
			} while (j < i);
			E e = node.element;
			node.prev.next = node.next;
			node.next.prev = node.prev;
			node.prev = null;
			node.next = null;
			size--;
			return e;
		}

	}

	@Override
	public boolean contains(E e) throws NullPointerException {
		// TODO Auto-generated method stub
		if (e == null) {
			throw new NullPointerException();
		}
		if (!isEmpty()) {			
			for (E elem : this) {
				if (elem.equals(e)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean remove(E e) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if (e == null) {
			throw new NullPointerException();
		}

		try {			
			remove(indexOf(e));
		}
		catch (IndexOutOfBoundsException ex) {			
			return false;
		}
		return true;
	}

	@Override
	public boolean addAll(List<E> otherList) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if (otherList == null) {
			throw new NullPointerException();
		}
		for (E e : otherList) {
			if (e == null) {
				throw new NullPointerException();
			}
		}
		if (otherList.size() == 0) {
			return false;
		}
		boolean res = false;
		for (E e : otherList) {
			addLast(e);
			res = true;
		}
		return res;
	}

	@Override
	public boolean removeAll(List<E> otherList) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if (otherList == null) {
			throw new NullPointerException();
		}
		if (otherList.size() == 0) {
			return false;
		}
		else {			
			for (E e : otherList) {
				if (e == null) {
					throw new NullPointerException();
				}
			}
		}
		boolean res = false;
		for (E e : this) {
			if (otherList.contains(e)) {
				while (contains(e)) {
					remove(e);
					res = true;
				}
			}
		}
		return res;
	}

	@Override
	public boolean retainAll(List<E> otherList) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if (otherList == null) {
			throw new NullPointerException();
		}
		if (otherList.size() == 0) {
			return false;
		}
		else {			
			for (E e : otherList) {
				if (e == null) {
					throw new NullPointerException();
				}
			}
		}
		boolean res = false;
		for (E e : this) {
			if (!otherList.contains(e)) {
				while (contains(e)) {
					remove(e);
					res = true;
				}
			}
		}
		return res;
	}

	/**
	 * Return String value represent the content of list as example "[30, 110, -110,
	 * -2, 1322]"
	 */
	@Override
	public String toString() {
		// TODO: Your implementation of this method starts here
		String res = "[";
		if (!isEmpty()) {
			Node<E> node = header.next;
			do {
				res = res.concat(node.element.toString());
				if (node.next.next != null) {					
					res = res.concat(", ");
				}
				node = node.next;
			} while (node.next != null);
		}
		return res.concat("]");
	}


	private void unlink(int i) {
		remove(i);
	}

	private void unlink(E e) {
		remove(e);
	}
	
	private void checkIndexException(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i > size-1) {			
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public Iterator<E> iterator() {
		// TODO: Your implementation of this method starts here
		return new DoublyLinkedListIterator();
	}

	private class DoublyLinkedListIterator implements Iterator<E> {

		Node<E> node = header.next;
		E elem = node.element;
		int lastReturned = -1;
//		int index = 0;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
//			lastReturned = null;
			return node.next != null;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			elem = node.element;
			node = node.next;
//			index++;
			lastReturned++;
			return elem;
		}

		@Override
		public void remove() throws IllegalStateException {
			if (lastReturned < 0) {
				throw new IllegalStateException();
			}
			
			try {
				unlink(lastReturned);
				lastReturned = -1;
			} catch (IndexOutOfBoundsException ex) {
				
			}
			
//			unlink(next());
		}

	}

}
