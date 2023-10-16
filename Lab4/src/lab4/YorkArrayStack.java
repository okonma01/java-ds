package lab4;

import java.util.EmptyStackException;

/**
 * 
 * Stack using expandable Array of generic type E.
 * if the stack (array) is full, create a new stack (array) of twice the size, and copy the elements.
 *
 * @param <E>
 */
public class YorkArrayStack<E> implements Stack<E> {

	/**
	 * Initial size, default size, for the Array of stack 
	 * remember that an empty stack has zero elements
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	public static final int INITSIZE = 16;


	/**
	 * Add any other private data members or methods that are necessary 
	 * to manage the YorkArrayStack stored
	 */
	private E[] data = (E[]) new Object[INITSIZE];

	private int size = 0;
//	private int capacity = 0;
//	private int max = 0;


	/**
	 * No argument constructor
	 */
	public YorkArrayStack() {
		// TODO: Your implementation of this method starts here
		this(INITSIZE);
	}

	public YorkArrayStack(int capacity) {
		// TODO: Your implementation of this method starts here
		data = (E[]) new Object[capacity];
	}

	/**
	 * Constructor takes array of elements and then add then to 
	 * the end of the Array list 
	 * @param objects
	 */

	public YorkArrayStack(E[] objects) {
		this(objects.length);
		for (E obj : objects) {
			push(obj);
		}
	}

	@Override
	public int size() {
		// TODO: Your implementation of this method starts here
		return size;
	}

	@Override
	public void clear() {
		// TODO: Your implementation of this method starts here
		while (size != 0) {
			pop();
		}
	}



	@Override
	public boolean isEmpty() {
		// TODO: Your implementation of this method starts here
		return size == 0;
	}


	@Override
	public E top() throws EmptyStackException {
		//  TODO: Your implementation of this method starts here
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return data[size-1];
	}



	@Override
	public void push(E e) {
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
	public E pop() {
		// TODO: Your implementation of this method starts here
		E obj = data[size-1];
		data[size-1] = null;
		size--;
		return obj;
	}




}
