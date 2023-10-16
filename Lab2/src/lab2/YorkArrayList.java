package lab2;

import java.util.*;
import java.lang.annotation.*;


public class YorkArrayList<E> implements List<E> {

	/**
	 * Initial size, default size, for the Array list
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	public static final int INITSIZE = 16;

	/**
	 * 
	 * Stores the elements of the array list Remember that you can not instantiate
	 * an array of E[], but you can instantiate an array of Object and then typecast
	 * it.
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private E[] data = (E[]) new Object[INITSIZE];

	/**
	 * current number of elements
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private int size = 0;

	private int max = 0;
	/**
	 * No argument constructor
	 */
	public YorkArrayList() {
		// TODO: Your implementation of this method starts here

	}

	/**
	 * Constructor takes array of elements and then add then to 
	 * the end of the Array list 
	 * @param objects
	 */

	public YorkArrayList(E[] objects) {
		// TODO: Your implementation of this method starts here

		for (E obj : objects) {
			this.add(size, obj);
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

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(1)")
	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here

		if (i < 0 || i >= size) { // O(1)
			throw new IndexOutOfBoundsException(); // O(1)
		}

		return data[i]; // O(1)
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here

		if (i < 0 || i >= size) { // O(1)
			throw new IndexOutOfBoundsException(); // O(1)
		}

		E obj = this.remove(i); // O(n)
		
		
		for (int k = size-1; k >= i; k--) { // O(n)
			data[k+1] = data[k]; // O(1)
		}

		data[i] = e; // O(1)
		max = Math.max(max, size); // O(1)
		max = Math.max(max, i); // O(1)

		size++; // O(1)
		
		return obj; // O(1)
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here


		if (i < 0) { // O(1)
			throw new IndexOutOfBoundsException("Illegal index"); // O(1)
		}


		if (max >= data.length) { // O(1)
			E[] newData = (E[]) new Object[data.length*2 + 1]; // O(1)
			System.arraycopy(data, 0, newData, 0, data.length); // O(n)
			data = newData; // O(1)
		}

		for (int k = i; k < size; k++) { // O(n)
			data[k+1] = data[k]; // O(1)
		}

		data[i] = e; // O(1)
		max = Math.max(max, size); // O(1)
		max = Math.max(max, i); // O(1)
		size = max; // O(1)
		size++; // O(1)
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here

		if (i < 0 || i >= size) { // O(1)
			throw new IndexOutOfBoundsException(); // O(1)
		}

		E obj = data[i]; // O(1)

		for (int k = i; k < size-1; k++) { // O(n)
			data[k] = data[k+1]; // O(1)
		}
		data[size-1] = null; // O(1)
		max--; // O(1)
		size--; // O(1)

		return obj; // O(1)
	}




	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public boolean contains(E e) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		
		for (E obj : this) { // O(n)
			if (obj == null) { // O(1)
				throw new NullPointerException(); // O(1)
			}
			if (e.equals(obj)) { // O(1)
				return true; // O(1)
			}
		}

		return false; // O(1)

	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n^2)")
	@Override
	public boolean remove(E e) throws NullPointerException {
		// TODO Auto-generated method stub
		
		if (e == null) { // O(1)
			throw new NullPointerException(); // O(1)
		}
		
		for (int i = 0; i < size; i++) { // O(n)
			if (e.equals(data[i])) { // O(1)
				this.remove(i); // O(n)
				return true; // O(1)
			}
		}

		return false; // O(1)
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n^2)")
	@Override
	public boolean addAll(List<E> otherList) throws NullPointerException {
		// TODO Auto-generated method stub
		boolean result = false; // O(1)
		if (otherList == null || otherList.toString().contains("null")) { // O(1)
			throw new NullPointerException(); // O(1)
		}

		for (E obj : otherList) { // O(n)
			this.add(size(), obj); // O(n)
			result = true; // O(1)
		}
		return result; // O(1)
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n^3)")
	@Override
	public boolean removeAll(List<E> otherList) throws NullPointerException {
		// TODO Auto-generated method stub
		boolean result = false;
		
		if (otherList == null || otherList.toString().contains("null")) { // O(1)
			throw new NullPointerException(); // O(1)
		}
		for (E obj : this) { // O(n)

			if (otherList.contains(obj)) { // O(n)				
				this.remove(obj); // O(n)
				result = true; // O(1)
			}

		}

		return result;	 // O(1)
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n^3)")
	@Override
	public boolean retainAll(List<E> otherList) throws NullPointerException {
		// TODO Auto-generated method stub
		boolean result = false; // O(1)

		if (otherList == null || otherList.toString().contains("null")) { // O(1)
			throw new NullPointerException(); // O(1)
		}
		
		for (E obj : this) { // O(n)

			if (!otherList.contains(obj)) {	 // O(n)			
				this.remove(obj); // O(n)
				result = true; // O(1)
			}
			
		}

		return result; // O(1)
	}

	/**
	 * Return String value represent the content of list as 
	 * example "[30, 110, -110, -2, 1322]"
	 */
	@Override
	public String toString() {
		// TODO: Your implementation of this method starts here
		if (size == 0) {
			return "[]";
		}
		else {
			return Arrays.toString(Arrays.copyOf(data, max+1)); 
		}

	}

	@Override
	public Iterator<E> iterator() {
		// TODO: Your implementation of this method starts here
		return new YorkIterator();
	}

	private class YorkIterator implements Iterator<E> {
		private int current = 0;

		@Override
		public boolean hasNext() {
			return (current < size);
		}

		@Override
		public E next() {
			return data[current++];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

}


