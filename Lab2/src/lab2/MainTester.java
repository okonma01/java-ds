package lab2;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;


public class MainTester {

	public static void main(String[] args) {
		
		String[] a =  new String [15];
		for (int i = 0; i < a.length; i++) {
			a[i]= "E50"+i;
		}
		
		YorkArrayList<String> mylist =  new YorkArrayList<>(a);
		
//		assertEquals("Size is not correct",15,mylist.size());
		
		for (int i = 0; i < 20; i++) {
			mylist.add(i,"E"+i);
		}
		
//		/// Test no-arg constructor
//	    YorkArrayList<Integer> blankList = new YorkArrayList<>();
//	    System.out.println("no-arg constructor: " + blankList);
//
//	    // Test array-arg constructor
//	    Integer[] numList = {15, 220, 110, -110, 152, 1322};
//	    YorkArrayList<Integer> list = new YorkArrayList<>(numList);
//	    System.out.println("array-arg constructor: " + list);
//
//	    // Test list functionality
//	    list.add(0, 10);
//	    System.out.println("list.add(0, 10): " + list);
//	    list.add(2, -7);
//	    System.out.println("list.add(2, -7): " + list);
//	    // add(index, object) needs a bounds check
//	    list.add(15, 15);
//	    System.out.println("list.add(15, 15): " + list);
//
//
//	    list = new YorkArrayList<>(numList);
//	    System.out.println("recreate list: " + list);
//	    System.out.println("list.contains(220): " + list.contains(220));
//	    System.out.println("list.contains(-2): " + list.contains(-2));
//	    System.out.println("list.get(0): " + list.get(0));
//	    System.out.println("list.get(3): " + list.get(3));
//	    System.out.println("list.get(5): " + list.get(5));
//	    // Throws proper exception on out-of-bounds
////	     System.out.println("list.get(6): " + list.get(6));
//
//
//	    list.add(list.size(),5);
//	    System.out.println("add(5): " + list);
//	    list.add(5, 0);
//	    System.out.println("add(5, 0): " + list);
//
//	    System.out.println("remove(0): " + list.remove(0));
//	    System.out.println("after remove(0): " + list);
//	    System.out.println("remove(3): " + list.remove(3));
//	    System.out.println("after remove(3): " + list);
//	    System.out.println("remove(5): " + list.remove(5));
//	    System.out.println("after remove(5): " + list);
//	    // Throws proper exception on out-of-bounds
//	    //System.out.println("remove(7): " + list.remove(7));
//
//	    System.out.println("set(0, 30): " + list.set(0, 30));
//	    System.out.println("after set(0, 30): " + list);
//	    System.out.println("set(3, -2): " + list.set(3, -2));
//	    System.out.println("after set(3, -2): " + list);
//	    // Throws proper exception on out-of-bounds
//	    // System.out.println("set(7, 27): " + list.set(7, 27));
//
//
//
//	    System.out.println("isEmpty(): " + list.isEmpty());
//	    System.out.println("size(): " + list.size());
//	    System.out.println("list: " + list);
//	    System.out.println("remove(new Integer(30)): " + list.remove(new Integer(30)));
//	    System.out.println("after remove(new Integer(30)): " + list);
//	    
//	    list = new YorkArrayList<>(numList);
//	    System.out.println("recreate list: " + list);
//	    Iterator<Integer> iter = list.iterator();
//	    System.out.println("testing iterator()");
//	    while (iter.hasNext()) {
//	      System.out.print(iter.next() + " ");
//	    }
//	    System.out.println();
	}

}
