package lab5;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.*;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.Rule;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class YorkSortedDoublyLinkedListTest {
	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);

	@Test
	public void test_00_01_() {
		YorkSortedDoublyLinkedList<Integer> mylist =  new YorkSortedDoublyLinkedList<>();
		
		assertEquals("Size is not correct", 0,mylist.size());
	}
	
	
	@Test
	public void test_00_02_() {
		Integer[] numList = {15, 220, 110, -110, 152, 1322};
		YorkSortedDoublyLinkedList<Integer> mylist =  new YorkSortedDoublyLinkedList<>(numList);
		
		assertEquals("Size is not correct",6,mylist.size());
	}
	
	@Test
	public void test_00_03_() {
		YorkSortedDoublyLinkedList<Integer> mylist =  new YorkSortedDoublyLinkedList<>();
		for (int i = 4; i < 20; i++) {
			mylist.add(i-1,i);
		}
		assertEquals("Size is not correct",16,mylist.size());
		
	}
	

	
	
	@Test
	public void test_00_04_() {
		YorkSortedDoublyLinkedList<Integer> mylist =  new YorkSortedDoublyLinkedList<>();
		for (int i = 1; i < 5; i++) {
			mylist.add(i-1,i);
		}
		mylist.add(1, 5);
		
		assertEquals(mylist.get(1), new Integer(5));
		
		assertEquals(mylist.size(), 5);

		try {
		    mylist.set(-1, 0);
		    fail();
		} catch (IndexOutOfBoundsException e) {} // good

	    mylist.set(4, 0);
		mylist.add(0, 6);
		assertEquals(mylist.get(0), new Integer(6));
		mylist.add(5, 7);
		assertEquals(mylist.get(5), new Integer(7));
		
	}
	@Test
	public void test_00_05_() {
		YorkSortedDoublyLinkedList<Integer> mylist =  new YorkSortedDoublyLinkedList<>();
		for (int i = 4; i < 20; i++) {
			mylist.add(i-1,i);
		}
		assertEquals("Size is not correct",16,mylist.size());
		
		while (mylist.size()>0) {
			mylist.remove(0);
			
		}
		assertEquals("Size is not correct",0,mylist.size());
	
	}
	
	@Test
	public void test_00_06_() {
		YorkSortedDoublyLinkedList<String> mylist =  new YorkSortedDoublyLinkedList<>();
		for (int i = 0; i < 20; i++) {
			mylist.add(i,"E"+i);
		}
		assertEquals("Size is not correct",20,mylist.size());
		assertTrue(mylist.remove("E1"));
		assertTrue(mylist.remove("E10"));
		assertFalse(mylist.remove("E30"));
		assertEquals("Size is not correct",18,mylist.size());
	}
	@Test
	public void test_00_07_() {
		
		String[] a =  new String [15];
		for (int i = 0; i < a.length; i++) {
			a[i]= "E50"+i;
		}
		
		YorkSortedDoublyLinkedList<String> mylist =  new YorkSortedDoublyLinkedList<>(a);
		
		assertEquals("Size is not correct",15,mylist.size());
		
		for (int i = 0; i < 20; i++) {
			mylist.add(i,"E"+i);
		}
		assertEquals("Size is not correct",35,mylist.size());
		assertTrue(mylist.remove("E1"));
		assertTrue(mylist.remove("E10"));
		assertFalse(mylist.remove("E30"));
		assertEquals("Size is not correct",33,mylist.size());
	}
	
	@Test
	public void test_00_08_() {
		
	
		YorkSortedDoublyLinkedList<String> mylist =  new YorkSortedDoublyLinkedList<>();
		
		assertEquals("Size is not correct",0,mylist.size());
		
		for (int i = 0; i < 20; i++) {
			mylist.add(i,"E"+i);
		}
		
		assertEquals("Size is not correct",20,mylist.size());
		
		mylist.set(19, "V100");
		mylist.set(0, "V200");
		assertEquals("Size is not correct",20,mylist.size());
		assertEquals(mylist.get(19),"V100");
		assertTrue(mylist.remove("V200"));
		
	}
	@Test
	public void test_00_09_() {
		
	
		YorkSortedDoublyLinkedList<String> mylist =  new YorkSortedDoublyLinkedList<>();
		
		assertEquals("Size is not correct",0,mylist.size());
		
		for (int i = 0; i < 20; i++) {
			mylist.add(i,"E"+i);
		}
		
		assertEquals("Size is not correct",20,mylist.size());

		try {
			mylist.remove(null);
			fail();
		}
		catch (NullPointerException e) {
			
		} 
	
	}
	
	
	@Test
	public void test_00_10_() {
		
	
		YorkSortedDoublyLinkedList<String> mylistA =  new YorkSortedDoublyLinkedList<>();
		YorkSortedDoublyLinkedList<String> mylistB =  new YorkSortedDoublyLinkedList<>();
		
		assertEquals("Size is not correct",0,mylistA.size());
		assertEquals("Size is not correct",0,mylistB.size());
		
		for (int i = 0; i < 20; i++) {
			mylistA.add(i,"E"+i);
			mylistB.add(i,"E"+i);
		}
		for (int i = 0; i < 10; i++) {
			mylistA.add(i,"A"+i);
			mylistB.add(i,"B"+i);
		}
		assertEquals("Size is not correct",30,mylistB.size());
		assertEquals("Size is not correct",30,mylistA.size());
		
		assertTrue(mylistA.contains("E1"));
		assertTrue(mylistA.contains("A1"));
		assertFalse(mylistA.contains("B8"));
		assertTrue(mylistB.contains("E1"));
		assertFalse(mylistB.contains("A1"));
		assertTrue(mylistB.contains("B8"));
		
		
	
	}
	
	
	
	@Test
	public void test_00_11_() {
		
	
		YorkSortedDoublyLinkedList<String> mylistA =  new YorkSortedDoublyLinkedList<>();
		YorkSortedDoublyLinkedList<String> mylistB =  new YorkSortedDoublyLinkedList<>();
		
		assertEquals("Size is not correct",0,mylistA.size());
		assertEquals("Size is not correct",0,mylistB.size());
		
		for (int i = 0; i < 20; i++) {
			mylistA.add(i,"E"+i);
			mylistB.add(i,"E"+i);
		}
		for (int i = 0; i < 10; i++) {
			mylistA.add(i,"A"+i);
			mylistB.add(i,"B"+i);
		}
		assertEquals("Size is not correct",30,mylistB.size());
		assertEquals("Size is not correct",30,mylistA.size());
		
		assertTrue(mylistA.addAll(mylistB));
		assertEquals("Size is not correct",60,mylistA.size());
		assertEquals("Size is not correct",30,mylistB.size());
		
		assertTrue(mylistA.contains("E1"));
		assertTrue(mylistA.contains("A1"));
		assertTrue(mylistA.contains("B8"));
		assertTrue(mylistB.contains("E1"));
		assertFalse(mylistB.contains("A1"));
		assertTrue(mylistB.contains("B8"));
		
		
	
	}
	

	@Test
	public void test_00_12_() {
		
	
		YorkSortedDoublyLinkedList<String> mylistA =  new YorkSortedDoublyLinkedList<>();
		YorkSortedDoublyLinkedList<String> mylistB =  new YorkSortedDoublyLinkedList<>();
		
		assertEquals("Size is not correct",0,mylistA.size());
		assertEquals("Size is not correct",0,mylistB.size());
		
		for (int i = 0; i < 20; i++) {
			mylistA.add(i,"E"+i);
			mylistB.add(i,"E"+i);
		}
		for (int i = 0; i < 10; i++) {
			mylistA.add(i,"A"+i);
			mylistB.add(i,"B"+i);
		}
		assertEquals("Size is not correct",30,mylistB.size());
		assertEquals("Size is not correct",30,mylistA.size());
		mylistB= null;
		
		try{
			mylistA.addAll(mylistB);
			fail();			
		} 
		catch (NullPointerException e) {
		
		}	
	
	}
	
	

	@Test
	public void test_00_13_() {
		
	
		YorkSortedDoublyLinkedList<String> mylistA =  new YorkSortedDoublyLinkedList<>();
		YorkSortedDoublyLinkedList<String> mylistB =  new YorkSortedDoublyLinkedList<>();
		
		assertEquals("Size is not correct",0,mylistA.size());
		assertEquals("Size is not correct",0,mylistB.size());
		
		for (int i = 0; i < 20; i++) {
			mylistA.add(i,"E"+i);
			mylistB.add(i,"E"+i);
		}
		for (int i = 0; i < 10; i++) {
			mylistA.add(i,"A"+i);
			mylistB.add(i,"B"+i);
		}
		assertEquals("Size is not correct",30,mylistB.size());
		assertEquals("Size is not correct",30,mylistA.size());
		mylistB.add(5, null);
		
		try{
			mylistA.addAll(mylistB);
			fail();			
		} 
		catch (NullPointerException e) {
		
		}

		
		
	
	}
	
	

	@Test
	public void test_00_14_() {
		
	
		YorkSortedDoublyLinkedList<String> mylistA =  new YorkSortedDoublyLinkedList<>();
		YorkSortedDoublyLinkedList<String> mylistB =  new YorkSortedDoublyLinkedList<>();
		
		assertEquals("Size is not correct",0,mylistA.size());
		assertEquals("Size is not correct",0,mylistB.size());
		
		for (int i = 0; i < 20; i++) {
			mylistA.add(i,"E"+i);
			mylistB.add(i,"E"+i);
		}
		for (int i = 0; i < 10; i++) {
			mylistA.add(i,"A"+i);
			mylistB.add(i,"B"+i);
		}
		assertEquals("Size is not correct",30,mylistB.size());
		assertEquals("Size is not correct",30,mylistA.size());

		assertTrue(mylistA.removeAll(mylistB));
		assertEquals("Size is not correct",30,mylistB.size());
		assertEquals("Size is not correct",10,mylistA.size());
		assertFalse(mylistA.contains("E1"));
		assertTrue(mylistA.contains("A1"));
		assertFalse(mylistA.contains("B8"));
		assertTrue(mylistB.contains("E1"));
		assertFalse(mylistB.contains("A1"));
		assertTrue(mylistB.contains("B8"));
	
	}
	
	
	@Test
	public void test_00_15_() {
		
	
		YorkSortedDoublyLinkedList<String> mylistA =  new YorkSortedDoublyLinkedList<>();
		YorkSortedDoublyLinkedList<String> mylistB =  new YorkSortedDoublyLinkedList<>();
		
		assertEquals("Size is not correct",0,mylistA.size());
		assertEquals("Size is not correct",0,mylistB.size());
		
		for (int i = 0; i < 20; i++) {
			mylistA.add(i,"E"+i);
			mylistB.add(i,"E"+i);
		}
		for (int i = 0; i < 10; i++) {
			mylistA.add(i,"A"+i);
			mylistB.add(i,"B"+i);
		}
		assertEquals("Size is not correct",30,mylistB.size());
		assertEquals("Size is not correct",30,mylistA.size());
		mylistB= null;
		
		try{
			mylistA.removeAll(mylistB);
			fail();			
		} 
		catch (NullPointerException e) {
		
		}	
	
	}
	
	

	@Test
	public void test_00_16_() {
		
	
		YorkSortedDoublyLinkedList<String> mylistA =  new YorkSortedDoublyLinkedList<>();
		YorkSortedDoublyLinkedList<String> mylistB =  new YorkSortedDoublyLinkedList<>();
		
		assertEquals("Size is not correct",0,mylistA.size());
		assertEquals("Size is not correct",0,mylistB.size());
		
		for (int i = 0; i < 20; i++) {
			mylistA.add(i,"E"+i);
			mylistB.add(i,"E"+i);
		}
		for (int i = 0; i < 10; i++) {
			mylistA.add(i,"A"+i);
			mylistB.add(i,"B"+i);
		}
		assertEquals("Size is not correct",30,mylistB.size());
		assertEquals("Size is not correct",30,mylistA.size());
		mylistB.add(5, null);
		
		try{
			mylistA.removeAll(mylistB);
			fail();			
		} 
		catch (NullPointerException e) {
		
		}
	}

		

		@Test
		public void test_00_17_() {
			
		
			YorkSortedDoublyLinkedList<String> mylistA =  new YorkSortedDoublyLinkedList<>();
			YorkSortedDoublyLinkedList<String> mylistB =  new YorkSortedDoublyLinkedList<>();
			
			assertEquals("Size is not correct",0,mylistA.size());
			assertEquals("Size is not correct",0,mylistB.size());
			
			for (int i = 0; i < 20; i++) {
				mylistA.add(i,"E"+i);
				mylistB.add(i,"E"+i);
			}
			for (int i = 0; i < 10; i++) {
				mylistA.add(i,"A"+i);
				mylistB.add(i,"B"+i);
			}
			assertEquals("Size is not correct",30,mylistB.size());
			assertEquals("Size is not correct",30,mylistA.size());
			assertTrue(mylistB.retainAll(mylistA));
			assertEquals("Size is not correct",20,mylistB.size());
			assertEquals("Size is not correct",30,mylistA.size());
			assertTrue(mylistA.contains("E1"));
			assertTrue(mylistA.contains("A1"));
			assertFalse(mylistA.contains("B8"));
			assertTrue(mylistB.contains("E1"));
			assertFalse(mylistB.contains("A1"));
			assertFalse(mylistB.contains("B8"));
		
	
	}
	
		
		
		@Test
		public void test_00_18_() {
			
		
			YorkSortedDoublyLinkedList<String> mylistA =  new YorkSortedDoublyLinkedList<>();
			YorkSortedDoublyLinkedList<String> mylistB =  new YorkSortedDoublyLinkedList<>();
			
			assertEquals("Size is not correct",0,mylistA.size());
			assertEquals("Size is not correct",0,mylistB.size());
			
			for (int i = 0; i < 20; i++) {
				mylistA.add(i,"E"+i);
				mylistB.add(i,"E"+i);
			}
			for (int i = 0; i < 10; i++) {
				mylistA.add(i,"A"+i);
				mylistB.add(i,"B"+i);
			}
			assertEquals("Size is not correct",30,mylistB.size());
			assertEquals("Size is not correct",30,mylistA.size());
			mylistB= null;
			
			try{
				mylistA.retainAll(mylistB);
				fail();			
			} 
			catch (NullPointerException e) {
			
			}	
		
		}
	
		

		@Test
		public void test_00_19_() {
			
		
			YorkSortedDoublyLinkedList<String> mylistA =  new YorkSortedDoublyLinkedList<>();
			YorkSortedDoublyLinkedList<String> mylistB =  new YorkSortedDoublyLinkedList<>();
			
			assertEquals("Size is not correct",0,mylistA.size());
			assertEquals("Size is not correct",0,mylistB.size());
			
			for (int i = 0; i < 20; i++) {
				mylistA.add(i,"E"+i);
				mylistB.add(i,"E"+i);
			}
			for (int i = 0; i < 10; i++) {
				mylistA.add(i,"A"+i);
				mylistB.add(i,"B"+i);
			}
			assertEquals("Size is not correct",30,mylistB.size());
			assertEquals("Size is not correct",30,mylistA.size());
			mylistB.add(5, null);
			
			try{
				mylistB.retainAll(mylistA);
				fail();			
			} 
			catch (NullPointerException e) {
				
			
			}

		}
		
		@Test
		public void test_00_20_() {
			
		
			YorkSortedDoublyLinkedList<String> mylistA =  new YorkSortedDoublyLinkedList<>();
			YorkSortedDoublyLinkedList<String> mylistB =  new YorkSortedDoublyLinkedList<>();
			
			assertEquals("Size is not correct",0,mylistA.size());
			assertEquals("Size is not correct",0,mylistB.size());
			
			for (int i = 0; i < 20; i++) {
				mylistA.add(i,"E"+i);
				
				}
			for (int i = 0; i < 10; i++) {
				mylistA.add(i,"A"+i);
				
			}
			assertEquals("Size is not correct",0,mylistB.size());
			assertEquals("Size is not correct",30,mylistA.size());
			assertFalse(mylistA.removeAll(mylistB));
			assertFalse(mylistA.retainAll(mylistB));
			assertFalse(mylistA.addAll(mylistB));

		}
		@Test
		public void test_00_21_() {
			
		
			YorkSortedDoublyLinkedList<String> mylistA =  new YorkSortedDoublyLinkedList<>();
			assertEquals("Size is not correct",0,mylistA.size());
			
			for (int i = 0; i < 20; i++) {
				mylistA.add(i,"E"+i);
				
				}
			
			Iterator<String> itra = mylistA.iterator();
			int i = 0;
			while(itra.hasNext() && i<5) {
				assertEquals(itra.next(),"E"+i);
				i++;
			}
			assertEquals(itra.next(),"E5");

			for (i = 0; i < 10; i++) {
				mylistA.add(i,"A"+i);
				
			}
			
			assertEquals("Size is not correct",30,mylistA.size());
			

		}
		@Test
		public void test_00_22_() {
			
		
			YorkSortedDoublyLinkedList<String> mylistA =  new YorkSortedDoublyLinkedList<>();
			assertEquals("Size is not correct",0,mylistA.size());
			
			for (int i = 0; i < 20; i++) {
				mylistA.add(i,"E"+i);
				
				}
			
			Iterator<String> itra = mylistA.iterator();
			int i = 0;
			while(itra.hasNext() && i<5) {
				assertEquals(itra.next(),"E"+i);
				i++;
			}
			
			assertEquals(itra.next(),"E5");
			itra.remove();
			itra.next();itra.remove();
			itra.next();itra.remove();
			
			assertEquals(itra.next(),"E8");
		
			for (i = 0; i < 10; i++) {
				mylistA.addFirst("A"+i);
				
			}
			
			
			assertEquals("Size is not correct",27,mylistA.size());
			

		}
		
		@Test
		public void test_00_23_() {
			
		
			YorkSortedDoublyLinkedList<String> mylistA =  new YorkSortedDoublyLinkedList<>();
			assertEquals("Size is not correct",0,mylistA.size());
			
			for (int i = 0; i < 20; i++) {
				mylistA.add(i,"E"+i);
				
				}
			int i =0;
			for (String e: mylistA) {
				assertEquals(e,"E"+i);
				i++;
				
			}

			for (i = 0; i < 10; i++) {
				mylistA.addLast("A"+i);
				
			}
			
			assertEquals("Size is not correct",30,mylistA.size());
			

		}
		
		
		@Test
		public void test_00_24_() {
			
		
			YorkSortedDoublyLinkedList<String> mylistA =  new YorkSortedDoublyLinkedList<>();
			assertEquals("Size is not correct",0,mylistA.size());
			
			for (int i = 0; i < 20; i++) {
				mylistA.add(i,"E"+i);
				
				}
			
			Iterator<String> itra = mylistA.iterator();
			int i = 0;
			while(itra.hasNext() && i<5) {
				assertEquals(itra.next(),"E"+i);
				i++;
			}
			assertEquals(itra.next(),"E5");
			itra.next();itra.remove();
			itra.next();itra.remove();
			itra.next();itra.remove();
			assertEquals(itra.next(),"E9");
			
			
			

			for (i = 0; i < 10; i++) {
				mylistA.addFirst("A"+i);
				
			}
			Iterator<String> itrb = mylistA.iterator();
			
			i =0;
			while(itrb.hasNext()&& i<5) {
				assertEquals(itrb.next(),"A"+(9-i));
				i++;
			}
			
			
			assertEquals("Size is not correct",27,mylistA.size());
			

		}
		@Test
		public void test_00_25_() {
			String[] numList = {"15", "220", "110", "-110", "152", "1322"};
			YorkSortedDoublyLinkedList<String> mylist =  new YorkSortedDoublyLinkedList<>(numList);
			
			assertEquals("Size is not correct",6,mylist.size());
			Iterator<String> itrb = mylist.iterator();
			while(itrb.hasNext()) {
				itrb.next(); itrb.remove();
				
			}
			assertEquals("Size is not correct",0,mylist.size());
		}
		
		
		
		
		@Test
		public void test_00_26_() {
			YorkSortedDoublyLinkedList<Integer> mylist =  new YorkSortedDoublyLinkedList<>();
			for (int i = 4; i < 20; i++) {
				mylist.addFirst(i);
			}
			
			assertEquals("Size is not correct",16,mylist.size());
			
			assertEquals(mylist.getFirst(), new Integer(19));
			assertEquals(mylist.getLast(), new Integer(4));
			
		}
		
		
		@Test
		public void test_00_27_() {
			YorkSortedDoublyLinkedList<Integer> mylist =  new YorkSortedDoublyLinkedList<>();
			for (int i = 4; i < 20; i++) {
				mylist.addLast(i);
			}
			
			
			assertEquals("Size is not correct",16,mylist.size());
			
			assertEquals(mylist.getFirst(), new Integer(4));
			assertEquals(mylist.getLast(), new Integer(19));
			
		}
		
		@Test
		public void test_00_28_() {
			YorkSortedDoublyLinkedList<Integer> mylist =  new YorkSortedDoublyLinkedList<>();
			System.out.println(mylist);
			assertEquals("Size is not correct",0,mylist.size());
			
			assertEquals(mylist.getFirst(), null);
			
		}
		
		@Test
		public void test_00_29_() {
			YorkSortedDoublyLinkedList<Integer> mylist =  new YorkSortedDoublyLinkedList<>();

			

			assertEquals("Size is not correct",0,mylist.size());
			
			assertEquals(mylist.getLast(), null);
			assertEquals(mylist.getFirst(), null);
			
		}
		
		@Test
		public void test_00_30_() {
			YorkSortedDoublyLinkedList<Integer> mylist =  new YorkSortedDoublyLinkedList<>();
			for (int i = 0; i < 20; i++) {
				mylist.addLast(i);
			}
			
			
			assertEquals("Size is not correct",20,mylist.size());
			
			assertEquals(mylist.getFirst(), new Integer(0));
			assertEquals(mylist.getLast(), new Integer(19));
			
			mylist.remove(0);
			assertEquals(mylist.getFirst(), new Integer(1));
			mylist.removeFirst();
			assertEquals(mylist.getFirst(), new Integer(2));
			
			mylist.removeLast();
			assertEquals(mylist.getLast(), new Integer(18));
		}

		
		@Test
		public void test_00_31_() {
			YorkSortedDoublyLinkedList<Integer> mylist =  new YorkSortedDoublyLinkedList<>();
			for (int i = 0; i < 10; i++) {
				mylist.addLast(i);
			}
			
			
			assertEquals("Size is not correct",10,mylist.size());
			
			assertEquals(mylist.getFirst(), new Integer(0));
			assertEquals(mylist.getLast(), new Integer(9));
			mylist.addLast(5);mylist.addLast(5);
			mylist.addLast(5);mylist.addLast(5);
			mylist.addFirst(5);mylist.addFirst(5);
			
			assertEquals(2, mylist.lastIndexOf(0));
			assertEquals(15, mylist.lastIndexOf(5));
			assertEquals(11, mylist.lastIndexOf(9));
			mylist.addLast(0);mylist.addLast(0);
			assertEquals(15, mylist.lastIndexOf(5));
			mylist.addLast(15);mylist.addLast(9);
			assertEquals(17, mylist.lastIndexOf(0));

			assertEquals(-1, mylist.lastIndexOf(20));
		}
		
		
		@Test
		public void test_00_32_() {
			YorkSortedDoublyLinkedList<Integer> mylist =  new YorkSortedDoublyLinkedList<>();
			for (int i = 0; i < 10; i++) {
				mylist.addLast(i);
			}
			
			
			assertEquals("Size is not correct",10,mylist.size());
			
			assertEquals(mylist.getFirst(), new Integer(0));
			assertEquals(mylist.getLast(), new Integer(9));
			mylist.addLast(5);mylist.addLast(5);
			mylist.addLast(5);mylist.addLast(5);
			mylist.addFirst(5);mylist.addFirst(5);
			
			assertEquals(2, mylist.indexOf(0));
			assertEquals(0, mylist.indexOf(5));
			assertEquals(11, mylist.indexOf(9));
			mylist.addLast(0);mylist.addLast(0);
			assertEquals(0, mylist.indexOf(5));
			mylist.addLast(15);mylist.addLast(9);
			assertEquals(2, mylist.indexOf(0));
			
			assertEquals(-1, mylist.indexOf(20));

		}
		
}