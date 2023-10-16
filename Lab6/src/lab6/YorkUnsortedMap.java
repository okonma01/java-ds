package lab6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;

public class YorkUnsortedMap<K, V> implements Map<K, V> {



	// -------------- nested MapEntry Class ------------------
	private static class MapEntry<K, V> implements Entry<K, V> {
		private K key;
		private V value;

		/**
		 * Constructor to set the key and value of this entry
		 * 
		 * @param key   the key
		 * @param value the value
		 */
		public MapEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			// TODO: Your implementation of this method starts here
			return this.key;
		}

		@Override
		public V getValue() {
			// TODO: Your implementation of this method starts here
			return this.value;
		}

		/**
		 * Sets the value of this Entry with specified value
		 * 
		 * @param newValue the new value
		 * @return old value of this entry
		 */
		public V setValue(V newValue) {
			// TODO: Your implementation of this method starts here
			V oldValue = this.value;
			this.value = newValue;
			return oldValue;
		}

		/**
		 * String representation for map entry
		 */
		@Override
		public String toString() {
			return "<" + key + ", " + value + ">";
		}
		
	}

	// ---- end of nested MapEntry class----------------------
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	// Define default load factor
	private static final double LOADFACTOR = 0.5;
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	// Define the default hash-table size. Must be a power of 2
	private static final int INITCAPACITY = 4;
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	// Define the maximum hash-table size. 1 << 30 is same as 2^30
	private static final int MAXCAPACITY = 1 << 30;
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	// The current hash-table capacity. Capacity must be a power of 2
	private int capacity;
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	// User specify a load factor used in this hash table
	private double loadFactor;
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	// The number of entries in the map
	private int size = 0;

	/**
	 * Add any other private data members or methods that are necessary to manage
	 * the YorkUnsortedMap You can use java.util.ArrayList or java.util.LinkedList
	 * (DoublyLinked) List to implement and store the map entries
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private List<MapEntry<K, V>> entries;
	
	private int hash(K key) {
		int res = Math.abs(key.toString().hashCode());
		
		return res % capacity;
	}
	
	private int threshold() {
		return (int) (loadFactor * capacity);
	}

	private void resize() throws Exception {
		YorkUnsortedMap<K, V> newMap = new YorkUnsortedMap<K, V>(2*capacity, loadFactor);
		
		for (Entry<K, V> e : entries) {
			if (e.getKey() != null) {
				newMap.put(e.getKey(), e.getValue());
			}
		}
		if (capacity >= MAXCAPACITY) {
			throw new Exception();
		}
		capacity = 2 * capacity;
		size = newMap.size();
		entries = newMap.entries;
	}
	
	private void fillEntries(int n) {
		for (int i = 0; i < n; i++) {
			entries.add(new MapEntry<K, V>(null, null));
		}
	}
	
	/**
	 * no argument constructor Construct a map with the default capacity and load
	 * factor
	 */
	public YorkUnsortedMap() {
		// TODO: Your implementation of this method starts here
		entries = new ArrayList<MapEntry<K, V>>(INITCAPACITY);
		fillEntries(INITCAPACITY);
		this.capacity = INITCAPACITY;
		this.loadFactor = LOADFACTOR;
	}

	/**
	 * One argument constructor Construct a map with the specified initial capacity
	 * and default load factor
	 */
	public YorkUnsortedMap(int capacity) {
		// TODO: Your implementation of this method starts here
		entries = new ArrayList<MapEntry<K, V>>(capacity);
		int pow = (int) Math.ceil( Math.log(capacity) / Math.log(2) );
		this.capacity = (int) Math.pow(2, pow);
		fillEntries(this.capacity);
		this.loadFactor = LOADFACTOR;
	}

	/**
	 * Construct a map with the specified initial capacity and load factor. Note:
	 * the capacity of map must be power of 2 User/client can specify any value as
	 * map capacity. You should make sure that the map is created with the power of
	 * 2 capacity that is greater than the user's given capacity. For example, if
	 * the user specifies the input capacity as 13, you should create a map with a
	 * capacity of 16.
	 * 
	 * @param capacity   map capacity specified by client
	 * @param loadFactor map loading factor
	 */
	public YorkUnsortedMap(int capacity, double loadFactor) {
		// TODO: Your implementation of this method starts here
		this(capacity);
		this.loadFactor = loadFactor;
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
	public V get(K key) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if (isEmpty()) return null;
		
		if (key == null) {
			throw new NullPointerException();
		}
		int i = hash(key);
		
		return entries.get(i).getValue();
	}

	@Override
	public void clear() {
		// TODO: Your implementation of this method starts here
		entries.clear();
		size = 0;
	}

	@Override
	public V put(K key, V value) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if (key == null) {
			throw new NullPointerException();
		}
		V result = null;
		
		int i = hash(key);
		
		if (entries.get(i).getKey() == null) {
			entries.set(i, new MapEntry<K, V>(key, value));
			size++;
		}
		else {
			if (key.equals(entries.get(i).getKey())) {				
				V oldValue = entries.get(i).setValue(value);
				result = oldValue;
			}
			else {
				while(entries.get(i) != null) {
					i++;
					i = i % capacity;
				}
				entries.set(i, new MapEntry<K, V>(key, value));
				size++;
			}
		}
		if (size >= threshold()) {
			try {				
				resize();
			}
			catch(Exception e) {
				
			}
		}
		return result;
	}

	@Override
	public V remove(K key) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if (key == null) {
			throw new NullPointerException();
		}

		V result = null;
		
		if (isEmpty()) return result;
		
		if (containsKey(key)) {			
			int i = hash(key);
			int j = i;
			
			if (entries.get(i).getKey() != null) {
				if (key.equals(entries.get(i).getKey())) {
					result = entries.remove(i).getValue();
					size--;
				}
				else {
					while (entries.get(j).getKey() != null) {
						j++;
						j = j % capacity;
						if (key.equals(entries.get(j).getKey())) {
							result = entries.remove(j).getValue();
							size--;
							break;
						}
					}
				}
				j++;
				j = j % capacity;
				while (entries.get(j).getKey() != null) {
					K k = entries.get(j).getKey();
					int index = hash(k);
					while ((index != j) && (entries.get(index).getKey() != null)) {
						index++;
						index = index % capacity;
					}
					if (index == i) {
						entries.set(i, entries.get(index));
						entries.remove(j);
					}
					j++;
					j = j % capacity;
				}
			}
			
		}
		
		return result;
	}

	@Override
	public boolean containsKey(K key) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if (isEmpty()) return false;
		if (key == null) {
			throw new NullPointerException();
		}
		for (Entry<K, V> entry : entrySet()) {
			if (entry.getKey().equals(key)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsValue(V value) {
		// TODO: Your implementation of this method starts here
		if (isEmpty()) return false;
		for (Entry<K, V> entry : entrySet()) {
			if (entry.getValue().equals(value)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterable<K> keySet() {
		// TODO: Your implementation of this method starts here
		List<K> keys = new ArrayList<K>();
		if (!isEmpty()) {			
			for (Entry<K, V> e : entries) {
				if (e.getKey() != null) {				
					keys.add(e.getKey());
				}
			}
		}
		return keys;
	}
	
	@Override
	public Iterable<V> values() {
		// TODO: Your implementation of this method starts here
		List<V> vals = new ArrayList<V>();
		if (!isEmpty()) {			
			for (Entry<K, V> e : entries) {
				if (e.getKey() != null) {				
					vals.add(e.getValue());
				}
			}
		}
		return vals;
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		// TODO: Your implementation of this method starts here
		List<Entry<K, V>> entrys = new ArrayList<Entry<K, V>>();
		if (!isEmpty()) {			
			for (Entry<K, V> e : entries) {
				if (e.getKey() != null) {				
					entrys.add(e);
				}
			}
		}
		return entrys;
	}

	/**
	 * Return String value represent the content of map 
	 *  if Map contains only two entries 
	 *  put("A1", 124); and put("A2", 125);
	 *  the output will be 
	 *   "[<A1, 124>,<A2, 125>]"
	 */
	@Override
	public String toString() {

		// TODO: Your implementation of this method starts here
		String str = "[";
		
		if (!isEmpty()) {			
			int i = 0;
			
			for (Entry<K, V> e : entrySet()) {
				if (e.getKey() == null) {
					continue;
				}
				str = str.concat(e.toString());
				if (i < size-1) {
					str = str.concat(",");
				}
				i++;
			}
		}
		
		return str.concat("]");
	}

}
