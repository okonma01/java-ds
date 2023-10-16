package lab1;


import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;



import org.junit.FixMethodOrder;
import org.junit.Rule;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class RecursiveMethodsTest {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);
	
	@Test
	public void test_01_00_FibArray() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] rest = rm.fibArray(2);
		int[] exp = {1, 1};
		assertArrayEquals(exp, rest);
	}
	@Test
	public void test_01_01_FibArray() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] rest = rm.fibArray(3);
		int[] exp = {1, 1, 2};
		assertArrayEquals(exp, rest);
	}

	@Test
	public void test_01_03_FibArray() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] rest = rm.fibArray(4);
		int[] exp = {1, 1, 2, 3};
		assertArrayEquals(exp, rest);
	}
	
	@Test
	public void test_01_04_FibArray() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] rest = rm.fibArray(5);
		int[] exp = {1, 1, 2, 3, 5};
		assertArrayEquals(exp, rest);
	}
	
	@Test
	public void test_01_05_FibArray() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] rest = rm.fibArray(6);
		int[] exp = {1, 1, 2, 3, 5, 8};
		assertArrayEquals(exp, rest);
	}
	
	@Test
	public void test_01_06_FibArray() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] rest = rm.fibArray(12);
		int[] exp = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144};
		assertArrayEquals(exp, rest);
	}
	
	@Test
	public void test_02_01_isRelativelyPrime() {
		RecursiveMethods rm = new RecursiveMethods();
		
		assertTrue(rm.isRelativelyPrime(5, 6));
	
	}
	
	@Test
	public void test_02_02_isRelativelyPrime() {
		RecursiveMethods rm = new RecursiveMethods();
		

		assertTrue(rm.isRelativelyPrime(17,29));
	
	}
	
	@Test
	public void test_02_03_isRelativelyPrime() {
		RecursiveMethods rm = new RecursiveMethods();
		assertTrue(rm.isRelativelyPrime(11, 13));

		
	}
	
	@Test
	public void test_02_04_isRelativelyPrime() {
		RecursiveMethods rm = new RecursiveMethods();

		assertTrue(rm.isRelativelyPrime(19, 3));

		
	}
	@Test
	public void test_02_05_isRelativelyPrime() {
		RecursiveMethods rm = new RecursiveMethods();
		

		assertTrue(rm.isRelativelyPrime(21, 17));
		assertFalse(rm.isRelativelyPrime(8, 6));
		assertFalse(rm.isRelativelyPrime(15, 25));
		
	}
	
	
	
	@Test
	public void test_03_01_IntegerToBinary() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] rest = rm.IntegerToBinary(4);
		int[] exp = {0, 0, 1};
		assertArrayEquals(exp, rest);
		
	}
	@Test
	public void test_03_02_IntegerToBinary() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] rest = rm.IntegerToBinary(31);
		int[] exp = {1, 1, 1, 1, 1};
		assertArrayEquals(exp, rest);
		
	}
	@Test
	public void test_03_03_IntegerToBinary() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] rest = rm.IntegerToBinary(65535);
		int[] exp = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		assertArrayEquals(exp, rest);
		
	}
	
	
	@Test
	public void test_04_01_complementofDecimal() {
		RecursiveMethods rm = new RecursiveMethods();
		String  rest = rm.complementofDecimal(65535);
		String  exp = "45575";
		assertTrue(exp.equals(rest));
		
		
	}
	
	@Test
	public void test_04_02_complementofDecimal() {
		RecursiveMethods rm = new RecursiveMethods();
		String  rest = rm.complementofDecimal(500735);
		String  exp = "599375";
		assertTrue(exp.equals(rest));
		
		
	}
	
	@Test
	public void test_04_03_complementofDecimal() {
		RecursiveMethods rm = new RecursiveMethods();
		String  rest = rm.complementofDecimal(111500);
		String  exp = "999599";
		assertTrue(exp.equals(rest));
		
		
	}
	
	@Test
	public void test_05_01_numberOfFirstChar() {
		RecursiveMethods rm = new RecursiveMethods();
		int  rest = rm.numberOfFirstChar("aaaxd%fdsefg");
		int  exp = 3;
		assertTrue( exp==rest );
		
		
	}
	
	
	@Test
	public void test_05_02_numberOfFirstChar() {
		RecursiveMethods rm = new RecursiveMethods();
		int  rest = rm.numberOfFirstChar("drfefdsefg");
		int  exp = 1;
		assertTrue( exp==rest );
		
		
	}
	
	@Test
	public void test_05_03_numberOfFirstChar() {
		RecursiveMethods rm = new RecursiveMethods();
		int  rest = rm.numberOfFirstChar("");
		int  exp = 0;
		assertTrue( exp==rest );
		
		
	}
	
	@Test
	public void test_05_04_numberOfFirstChar() {
		RecursiveMethods rm = new RecursiveMethods();
		int  rest = rm.numberOfFirstChar("bbbcfreb$b");
		int  exp = 3;
		assertTrue( exp==rest );
		
		
	}

	
	@Test
	public void test_06_01_compressString() {
		RecursiveMethods rm = new RecursiveMethods();
		String  rest = rm.compressString("bbbcfreb$b");
		String  exp = "b3c1f1r1e1b1$1b1";
		assertTrue(exp.equals(rest));
		
		
	}
	
	
	@Test
	public void test_06_02_compressString() {
		RecursiveMethods rm = new RecursiveMethods();
		String  rest = rm.compressString("");
		String  exp = "";
		assertTrue(exp.equals(rest));
		
		
	}
	
	@Test
	public void test_06_03_compressString() {
		RecursiveMethods rm = new RecursiveMethods();
		String  rest = rm.compressString("bbbcfreb$b");
		String  exp = "b3c1f1r1e1b1$1b1";
		assertTrue(exp.equals(rest));
		
		
	}
	@Test
	public void test_06_04_compressString() {
		RecursiveMethods rm = new RecursiveMethods();
		String  rest = rm.compressString("bbbrrraaaaaazzzz");
		
		String  exp = "b3r3a6z4";
		assertTrue(exp.equals(rest));
		
		
	}
	
	@Test
	public void test_06_05_compressString() {
		RecursiveMethods rm = new RecursiveMethods();
		String  rest = rm.compressString("bbbbbbbbrrrrrrraaaaaazzzzzzzzzzzz");
		String  exp = "b8r7a6z12";
		assertTrue(exp.equals(rest));
	}
	
	
	
	@Test
	public void test_07_01_yorknacci() {
		RecursiveMethods rm = new RecursiveMethods();
		int  rest = rm.yorknacci(0);
		int  exp = 1;
		assertTrue(exp==rest);
	}
	@Test
	public void test_07_02_yorknacci() {
		RecursiveMethods rm = new RecursiveMethods();
		int  rest = rm.yorknacci(1);
		int  exp = 1;
		assertTrue(exp==rest);
	}
	
	@Test
	public void test_07_03_yorknacci() {
		RecursiveMethods rm = new RecursiveMethods();
		int  rest = rm.yorknacci(2);
		int  exp = 1;
		assertTrue(exp==rest);
	}
	
	@Test
	public void test_07_04_yorknacci() {
		RecursiveMethods rm = new RecursiveMethods();
		int  rest = rm.yorknacci(4);
		int  exp = 4;
		assertTrue(exp==rest);
	}
	
	
	@Test
	public void test_07_05_yorknacci() {
		RecursiveMethods rm = new RecursiveMethods();
		int  rest = rm.yorknacci(20);
		int  exp = 26244;
		assertTrue(exp==rest);
	}
	
	@Test
	public void test_08_01_YorknacciList() {
		RecursiveMethods rm = new RecursiveMethods();
		List<Integer> rest = rm.YorknacciList(2);
		int[] exp = {1, 1};
		
		List<Integer> expl = a2l(exp);
		assertEquals(rest, expl);
	}
	
	@Test
	public void test_08_02_YorknacciList() {
		RecursiveMethods rm = new RecursiveMethods();
		List<Integer> rest = rm.YorknacciList(3);
		int[] exp = {1, 1, 1};
		
		List<Integer> expl = a2l(exp);
		assertEquals(rest, expl);
	}
	
	@Test
	public void test_08_03_YorknacciList() {
		RecursiveMethods rm = new RecursiveMethods();
		List<Integer> rest = rm.YorknacciList(6);
		int[] exp = {1, 1, 1, 3, 4, 8};
		
		List<Integer> expl = a2l(exp);
		assertEquals(rest, expl);
	}
	
	@Test
	public void test_08_04_YorknacciList() {
		RecursiveMethods rm = new RecursiveMethods();
		List<Integer> rest = rm.YorknacciList(8);
		int[] exp = {1, 1, 1, 3, 4, 8, 12, 24};
		
		List<Integer> expl = a2l(exp);
		assertEquals(rest, expl);
	}
	
	
	
	@Test
	public void test_09_01_repeatCharNTimes() {
		RecursiveMethods rm = new RecursiveMethods();
		String rest = rm.repeatCharNTimes(4, 'e');
		String exp = "eeee" ;
		assertTrue(exp.equals(rest));
	}
	@Test
	public void test_09_02_repeatCharNTimes() {
		RecursiveMethods rm = new RecursiveMethods();
		String rest = rm.repeatCharNTimes(10, 'A');
		String exp = "AAAAAAAAAA" ;
		assertTrue(exp.equals(rest));
	}
	
	@Test
	public void test_09_03_repeatCharNTimes() {
		RecursiveMethods rm = new RecursiveMethods();
		String rest = rm.repeatCharNTimes(0, 'A');
		String exp = "" ;
		assertTrue(exp.equals(rest));
	}
	
	@Test
	public void test_09_04_repeatCharNTimes() {
		RecursiveMethods rm = new RecursiveMethods();
		String rest = rm.repeatCharNTimes(7, 'A');
		String exp = "AAAAAAA" ;
		assertTrue(exp.equals(rest));
	}
	
	
	@Test
	public void test_10_01_expandCompressedString() {
		RecursiveMethods rm = new RecursiveMethods();
		String rest = rm.expandCompressedString("A3B2");
		String exp = "AAABB" ;
		assertTrue(exp.equals(rest));
	}
	@Test
	public void test_10_02_expandCompressedString() {
		RecursiveMethods rm = new RecursiveMethods();
		String rest = rm.expandCompressedString("A2a3r4v0w1g4");
		String exp = "AAaaarrrrwgggg" ;
		assertTrue(exp.equals(rest));
	}
	
	@Test
	public void test_10_03_expandCompressedString() {
		RecursiveMethods rm = new RecursiveMethods();
		String rest = rm.expandCompressedString("A2a3v0w0g7");
		String exp = "AAaaaggggggg" ;
		assertTrue(exp.equals(rest));
	}
	
	@Test
	public void test_10_04_expandCompressedString() {
		RecursiveMethods rm = new RecursiveMethods();
		String rest = rm.expandCompressedString("A5a3v1w7g9");
		String exp = "AAAAAaaavwwwwwwwggggggggg" ;
		assertTrue(exp.equals(rest));
	}
	
	
	
	
	@Test
	public void test_11_01_IntegerToOctal() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] rest = rm.IntegerToOctal(4);
		int[] exp = {4};
		assertArrayEquals(exp, rest);
		
	}
	@Test
	public void test_11_02_IntegerToOctal() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] rest = rm.IntegerToOctal(31);
		int[] exp = {7, 3};
		assertArrayEquals(exp, rest);
		
	}
	
	
	@Test
	public void test_11_03_IntegerToOctal() {
		RecursiveMethods rm = new RecursiveMethods();
		int[] rest = rm.IntegerToOctal(65535);
		int[] exp = {7, 7, 7, 7, 7, 1};
		assertArrayEquals(exp, rest);
		
	}
	
	private List<Integer> a2l(int[] a) {
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < a.length; i ++) {
			list.add(a[i]);
		}
		return list;
	}

	
	

}
