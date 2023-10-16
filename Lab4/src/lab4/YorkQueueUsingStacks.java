package lab4;

import java.util.*;

/**
 * 
 * Implement the queue interface using two stacks 
 * 
 * @param <E>
 */

public class YorkQueueUsingStacks<E> implements Queue<E> {
	
	
	/**
	 * Add any other private data members or methods that are necessary 
	 * to manage the YorkArrayStack stored
	 */
	private YorkArrayStack<E> data = new YorkArrayStack<E>();
	private YorkArrayStack<E> altData = new YorkArrayStack<E>();
	

	public YorkQueueUsingStacks(){
		// TODO: Your implementation of this method starts here
		data = new YorkArrayStack<E>();
		altData = new YorkArrayStack<E>();
	}
	
	
	@Override
	public int size() {
		// TODO: Your implementation of this method starts here
		return data.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO: Your implementation of this method starts here
		return data.isEmpty();
	}

	@Override
	public void clear() {
		// TODO: Your implementation of this method starts here
		data.clear();
	}

	@Override
	public void enqueue(E e) {
		// TODO: Your implementation of this method starts here
		data.push(e);
	}

	@Override
	public E first() throws NoSuchElementException {
		// TODO: Your implementation of this method starts here
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		while (!isEmpty()) {
			altData.push(data.pop());
		}
		E obj = altData.top();
		
		while (!altData.isEmpty()) {
			data.push(altData.pop());
		}
		return obj;
	}

	@Override
	public E dequeue() throws NoSuchElementException {
		// TODO: Your implementation of this method starts here
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		while (!isEmpty()) {
			altData.push(data.pop());
		}
		E obj = altData.pop();
		
		while (!altData.isEmpty()) {
			data.push(altData.pop());
		}
		return obj;	
	}

	@Override
	public boolean contains(E e) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		boolean res = false;
		
		if (e == null) {
			throw new NoSuchElementException();
		}
		
		while (!isEmpty()) {			
			E obj = data.pop();
			if (obj.equals(e)) {
				res = true;
			}
			altData.push(obj);
		}
		
		while (!altData.isEmpty()) {
			data.push(altData.pop());
		}
		return res;
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
		E[] newData = (E[]) new Object[size()];
		while (!isEmpty()) {
			altData.push(data.pop());
		}
		
		while (!altData.isEmpty()) {
			E obj = altData.pop();
			newData[size()] = obj;
			data.push(obj);
		}
		return Arrays.toString(newData);
	}
	

}
