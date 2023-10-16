package lab4;

import java.util.*;

/**
 * 
 * Queue using expandable circular Array of generic type E. This is called a
 * "circular" queue with expandable array. if the queue (array) is full, create
 * a new queue (array) of twice the size, and copy the elements.
 *
 * @param <E>
 */
public class YorkArrayQueue<E> implements Queue<E> {

	/**
	 * Initial size, default size, for the queue
	 * remember that an empty queue has zero elements
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	public static final int INITSIZE = 16;

	
	/**
	 * Add any other private data members or methods that are necessary 
	 * to manage the YorkArrayStack stored
	 */
	private E[] data = (E[]) new Object[INITSIZE];
	private int size = 0;
	
	/**
	 * No argument constructor
	 */
	public YorkArrayQueue() {
		// TODO: Your implementation of this method starts here
		this(INITSIZE);
	}

	public YorkArrayQueue(int capacity) {
		// TODO: Your implementation of this method starts here
		data = (E[]) new Object[capacity];;
	}

	/**
	 * Constructor takes array of elements and then add then to the end of the Array
	 * list
	 * 
	 * @param objects
	 */

	public YorkArrayQueue(E[] objects) {
		for (E obj : objects) {
			enqueue(obj);
		}
	}

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
	public void clear() {
		// TODO: Your implementation of this method starts here
		while (!isEmpty()) {
			dequeue();
		}
	}

	@Override
	public void enqueue(E e) {
		// TODO: Your implementation of this method starts here
		if (size == data.length) {
			E[] newData = (E[]) new Object[data.length*2 + 1];
			System.arraycopy(data, 0, newData, 0, data.length);
			data = newData;
		}
		data[size] = e;
		size++;
	}

	@Override
	public E first() throws NoSuchElementException {
		// TODO: Your implementation of this method starts here
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return data[0];
	}

	@Override
	public E dequeue() throws NoSuchElementException {
		// TODO: Your implementation of this method starts here
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		E obj = data[0];
		for (int i = 1; i <= size; i++) {
			data[i-1] = data[i];
		}
		size--;
		return obj;
	}

	@Override
	public boolean contains(E e) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if (e == null) {
			throw new NullPointerException();
		}
		for (E obj : data) {
			if (obj.equals(e)) {
				return true;
			}
		}
		return false;
	}

	
	/**
	 * 
	 *  Return String value represent the content of queue as 
	 * example "[30, 110, -110, -2, 1322]"
	 * 
	 * remember that you should displays the contents of the queue in insertion order (FIFO), so the
	 * most-recently inserted element should be the last element
	 * 
	 */
	@Override
	public String toString() {
		// TODO: Your implementation of this method starts here
		E[] newData = (E[]) new Object[size];
		System.arraycopy(data, 0, newData, 0, size);
		return Arrays.toString(newData);
	}
	
	



	
	

}
