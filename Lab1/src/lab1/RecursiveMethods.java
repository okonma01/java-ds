package lab1;

import java.util.*;

/**
 * Lab1 Requirement:
 * You are required to implement all methods recursively.
 * <strong>You receive a zero if there is any occurrence of a loop (e.g., for, while).</strong> 
 *  
 * <p><strong> Do not use a loop. Use only recursion.
 *  Solutions using loop will not receive credit.</strong></p>
 *  
 *  <p>	Hint: For some of the public recursive methods in <code>RecursiveMethods</code> 
 *  class you may consider adding private recursive helper methods. </p>
 *  
 * 
 */

public class RecursiveMethods {
	
	
	
	/**
	 * Return an array storing the first n numbers in a Fibonacci sequence.
	 * The Fibonacci starts with the first two numbers being 1 and 1, then 
	 * starting from the 3rd number, it is the sum of the previous two numbers.  
	 * You can assume that n is positive.
	 * e.g., fibArray(5) returns an array {1, 1, 2, 3, 5}.
	 * @param n the first n Fibonacci numbers 
	 * @return an array representing the first n Fibonacci numbers
	 * 
	 * You are forbidden to use the fibList method below to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while). 
	 */
	public int[] fibArray(int n) {
		if (n <= 0) return new int[0];
		int[] result = new int[n];
		result[0] = 1;
		if (n > 1) {
			result[n-1] = fib(result, n-1);			
		}
		return result;
	}
	
	private int fib(int[] arr, int i) {
		int result = 0;
		if (i <= 1) {
			result = 1;
		}
		else {
			result = fib(arr, i-1) + fib(arr, i-2);
		}
		
		arr[i] = result;
		return result;
	}
	
		
	
	/**
	 * <p><strong> This method determine if p and q are relatively prime.</strong> </p>
	 * 
	 *<p> Two integers p and q are said to be  relatively Prime  if the Greatest Common Divisor of them is 1.
	 * </p>
	 * Hints: 
	 * <p> A <em> positive integer </em> {@code n > 1} is called <strong> prime</strong> 
	 * if the only positive factors of {@code n}  are {@code  1}  and {@code  n} . 
	 * A positive integer that is greater than one and is not prime is called <strong> composite</strong>.</p>
	 * <p> An integer {@code  n} is <strong> composite </strong> 
	 * if and only if there exists an integer {@code a} such that
	 * <strong> <em>  {@code a}  divides {@code n}  </em></strong> and {@code 1 < a < n}.</p>
	 * 
	 * <p> <strong> Hint:  1 is neither prime nor composite. It forms its own special category as a "unit".</strong></p>
	 * 
	 * <p> This method checks the two positive integers are relatively prime or not.</p>
	 *  <pre>
	 *  Example:
	 *  
	 *  
	 *  isRelativelyPrime (8, 6) returns false
	 *  isRelativelyPrime (15, 25) returns false
	 *  isRelativelyPrime (7, 2) returns true 
	 *  isRelativelyPrime (19, 3) returns true 
	 *  isRelativelyPrime (11, 13) returns true 
	 *  isRelativelyPrime (21, 17) returns true 
	 *  isRelativelyPrime (17, 29) returns true 
	 *  </pre>
	 * 
	 * @param p  positive integer
	 * @param q  positive integer 
	 * @return true  if p and q are relatively prime, else false
	 * @pre.
	 * 		{@code p > 0 } and {@code q > 0 } 
	 */
	public boolean  isRelativelyPrime( int p , int q) {
//		boolean result = false;
		int x = 0;
		if (Math.abs(p) != 1 && Math.abs(q) != 1) {			
			int min = 0;
			int max = 0;
			if (p >= q) {
				max = p;
				min = q;
			}
			else {
				max = q;
				min = p;
			}
			x = primeHelper(1, min, max);
		}
		
		return !(x > 0);
	}
	private int primeHelper(int n, int min, int max) {
//		n = Math.abs(n);
//		min = Math.abs(min);
//		max = Math.abs(max);
		if (n == min) {
			if (min % n == 0 && max % n == 0) {
				return 1;
			}
			else {
				return 0;
			}
		}
		else {
			if ((min % n == 0 && max % n == 0) && n != 1) {
				return 1;
			}
			else {
				return primeHelper(n+1, min, max);
			}
		}
	}
	
	
	
	/** 
	 * 
	 * <p> Write a recursive function convert any  decimal number {@code n > 0 }  and {@code n <= 65535} 
	 * into a binary number, return an array represents  the binary number </p>
	 * 
	 * <p>
	 * a binary (base-2) number. A binary number is made up 
	 * of one or more binary digits called bits. A bit has a value that is equal to
	 *  either 0 or 1.
	 * </p>
	 * 
	 * 
	 * <pre>
	 *  Example:
	 *  
	 * IntegerToBinary (4)  return [0, 0, 1], where (0*1)+(0*2)+(1*4) = 4 
	 * IntegerToBinary (9)  return [1, 0, 0, 1], where (1*1)+(0*2)+(0*4)+(1*8) = 9
	 * IntegerToBinary (31)  return [1, 1, 1, 1, 1], where (1*1)+(1*2)+(1*4)+(1*8)+(1*16) =31
	 * </pre>
	 * @param n
	 * 			positive integer 
	 *  @return  array  represents  the binary number
	 *  
	 * @pre.
	 * 		{@code n > 0 }
	 */
	public int[]  IntegerToBinary (int n) {
		int plus = 0;
		int[] myArray = new int[0];
		if (n > 0) {			
			if (isExp(n, 2)) {
				plus = 1;
			}
			int bound2 = (int) Math.ceil(Math.log10(n) / Math.log10(2)) + plus;
			myArray = new int[bound2];
			binHelper(n, myArray, 0);
		}
		else if (n == 0) {
			myArray = new int[1];
		}
		
		return myArray;
	}
	private int binHelper(int n, int[] arr, int i) {
		if (i == arr.length-1) {
			arr[i] = n % 2;
			return 1;
		}
		else {
			arr[i] = n % 2;
			return binHelper(n/2, arr, i+1);
		}
	}
	private boolean isExp(int n, int a) {
		double sq = (Math.log10(n) / Math.log10(a));
		return ((sq - Math.floor(sq)) == 0);
	}
	

	
	/** 
	 * <p> Write a recursive function returns  the complement of decimal integer  n, 
	 * as a String.The complement of integer  n is defined as follows:
	 * (1) a 0 in n's decimal representation is replaced by 9 .
	 * (2) a digit {@code d > 0} in n's decimal representation is replaced by 10-d.
	 * 
	 * <pre>
	 *  Example:
	 *  for n = 43, return "67" and for n = 10203, return "99897"
	 *  </pre>
	 * @param n  integer 
	 * @return  string complement of the decimal integer as defined above
	 * 
	 * @pre.
	 * 		{@code n > 0 } 
	 *
	 */
	
	public String complementofDecimal(int n) {
		String res = "";
		String str = String.valueOf(Math.abs(n));
//		boolean isneg = false;
		int len = str.length();
		if (len > 0) {		
			res = complementHelper(str, "", 0, len);
		}
		if(n < 0) {
			res = "-".concat(res);
		}
		
		return res;
	}
	
	private String complementHelper(String str, String res, int i, int len) {
		int x = toInt(str.charAt(i));
		if (x == 0) {
			x = 9;
		}
		else {
			x = 10 - x;
		}
		if (i == len-1) {
			res = res.concat(String.valueOf(x));
			return res;
		}
		else {
			res = res.concat(String.valueOf(x));
			return complementHelper(str, res, i+1, len);
		}
	}
	
	
	
	
	
	
	/**
	 * 
	 * <p> Write a recursive function numberOfFirstChar 
	 * returns the number of times the first char of string {@code str}
	 * appears at the beginning of string {@code str}.
	 * </p>
	 * 
	 *  
	 *   
	 * <p> Hint: You can String functions such as charAt, length, and substring.</p>
	 *  
	 *  <pre>
	 *  Example:
	 *  numberOfFirstChar("")  return 0 , empty string 
	 *  numberOfFirstChar("bbbcfreb$b") return  3
	 *  numberOfFirstChar("beqecb$bbb") return  1
	 *  
	 *  </pre>
	 *  
	 * @param str   is not null String 
	 * 
	 * @return
	 * 			the number of times
	 * 			the first char of string str appears at the beginning of string str.
	 * 			
	 * 
	 * @pre. 
	 * 		{@code str }   is not null String 
	 */
	public int numberOfFirstChar(String str) {
		int result = 0;
		Integer count = 0;
		if (!str.equals("")) {			
			int len = str.length();
//			char first = str.charAt(0);
			result = helper(str, count, 0, len-1);
		}
		
		return result;
	}
	private int helper(String str, Integer n, int i, int len) {
		boolean successive = str.charAt(0) == str.charAt(i);
		if (successive) {
			n = n + 1;
			if (i != len) {					
				return helper(str, n, i+1, len);
			}
			else {
				return n;
			}
		}
		else {
			return n;
		}

	}

	
	/** 
	 * <p> Write a recursive function compressString that 
	 *  compression long String {@code str} that contain many adjacent equal characters
	 * (but no digits).  
	 *  
	 *  <pre>
	 *  Example:
	 *  compressString("")  return "" , empty string 
	 *  compressString("bbbcfreb$b") return  "b3c1f1r1e1b1$1b1"
	 *  compressString("bbbrrraaaaaazzzz") return  "b3r3a6z4"
	 *  
	 *  </pre>
	 *  
	 *   	
	 * @param str :
	 * 			string to be compressed, {@code str} is not null
	 * @pre.  
	 * 		Precondition: s does not contain a digit in '0'.. '9'. 
	 * @return
	 * 		the compressed version of long string as explained above
	 *  	
	 *  
	 * 
	 * @pre. 
	 * 		{@code str }   is not null String and 
	 * 		{@code str }  does not contain a digit in '0'.. '9'.  
	 */
	public String compressString(String str) {
		String res = "";
		Integer count = 0;
		if (!str.equals("")) {
			int len = str.length();
			res = compressHelper(str, count, res, 0, 0, len-1);
		}
		return res;
	}
	private String compressHelper(String str, Integer n, String res, int i, int j, int len) {
		boolean successive = str.charAt(i) == str.charAt(j);
		if (successive) {
			n = n + 1;
			if (j != len) {			
				return compressHelper(str, n, res, i, j+1, len);
			}
			else {				// end of string
				res = res.concat(String.valueOf(str.charAt(i)) + n);
				return res;
			}
		}
		else {
			res = res.concat(String.valueOf(str.charAt(i)) + n);
			return compressHelper(str, 0, res, i+n, i+n, len);
		}

	}
	
	
	
	
	/**
	 * <p> Write a recursive function returns Yorknacci number y(n). </p>
	 * 
	 * <p> Recall the Fibonacci numbers: Fibonacci number an is defined as the sum of
	 * the 2 previous Fibonacci numbers: a(n) = a(n-1)+a(n-2), with a(0) =0,  a(1) = a(2) = 1..
	 * Based on Fibonacci numbers, we define the Yorknacci numbers as the list of numbers
	 * where Yorknacci number y(n)  is defined as <strong> the sum of the previous 3
	 * Yorknacci numbers if n is odd and the sum of the previous 2 Yorknacci numbers if n is even.</strong>
	 * The first three Yorknacci numbers y(0), y(1), and y(2) are 1. 
	 * {@code y(0)=y(1)=y(2)=1}
	 * 
	 * <pre>
	 *  Example:
	 *  yorknacci(0)  return 1 
	 *  yorknacci(1)  return 1
	 *  yorknacci(2)  return 1
	 *  yorknacci(3)  return 3
	 *  yorknacci(4)  return 4    
	 *  yorknacci(5)  return 8 
	 * 
	 *  
	 *  </pre>
	 *  
	 * 
	 * @param n :
	 * 			integer value for Yorknacci,  {@code n>=0 }
	 * 
	 * @return
	 * 			Return Yorknacci number y(n).
	 * 
	 * @pre. {@code n>=0}
	 */
	public static int yorknacci(int n) {
		if (n == 0) {
			return 1;
		}
		else if (n == 1) {
			return 1;
		}
		else if (n == 2) {
			return 1;
		}
		else {
			if (n % 2 == 1) {
				return yorknacci(n-1) + yorknacci(n-2) + yorknacci(n-3);
			}
			else {
				return yorknacci(n-1) + yorknacci(n-2);
			}
		}
	}

	
	/**
	 * <p> Write a recursive function returns a list storing the first {@code n } numbers 
	 * in a Yorknacci sequence. </p>
	 * 
	 * <p> <strong> The Yorknacci number  is defined above. ( check the API of yorknacci method)</strong></p>  
	 *   
	 * <p> You can assume that n is  {@code n>1}.
	 * e.g., YorknacciList(5) returns a list {y(0), y(1), y(2), y(3) , y(4)}= {1, 1, 1, 3, 4}.
	 * 
	 * <pre>
	 *  Example:
	 *  YorknacciList(2)  return {1, 1} 
	 *  YorknacciList(3)  return {1, 1, 1}
	 *  YorknacciList(5)  return {1, 1, 1, 3, 4}
	 *  
	 * 
	 *  
	 *  </pre>
	 * 
	 * @param n the first {@code n}  Yorknacci numbers 
	 * 
	 * @return a list representing the first n Yorknacci numbers
	 * 
	 * 
	 * 
	 * @pre. {@code n>1}
	 */
	public List<Integer> YorknacciList(int n) {
		Integer[] a = new Integer[n];
		if (n > 0) {			
			listHelper(a, 0);
		}

		return Arrays.asList(a);
	}
	private void listHelper(Integer[] arr, int i) {
		if (i == arr.length-1) {
			arr[i] = yorknacci(i);
		}
		else {
			arr[i] = yorknacci(i);
			listHelper(arr, i+1);
		}
	}
	
	
	
	/**
	 * <p> Write a recursive function  returns a String 
	 * containing {@code n} occurrences of character {@code c} . </p>
	 * 
	 * 
	 * <pre>
	 *  Example:
	 *  repeatCharNTimes(2, 'd')  return  "dd"
	 *  repeatCharNTimes(3, 'c')  return  "ccc"
	 *  repeatCharNTimes(5, 'a')  return  "aaaaa"
	 *   
	 *  </pre>
	 *  
	 * @param n : 
	 * 			Number of occurrence 
	 * @param c:
	 * 			Char to be repeated 
	 * 
	 * @return
	 * 		return String containing {@code n} occurrences of character {@code c}.
	 * 
	 * @pre. 
	 * 		{@code n >= 0}.
	 */
	public String repeatCharNTimes(int n, char c) {
		String result = "";
		if (n > 0) {
			result = repeatHelper(String.valueOf(c), n);
		}
		return result;
	}
	private String repeatHelper(String str, int n) {
		if (n == 1) {
			return str;
		}
		else {
			return repeatHelper(str.concat(str.substring(0,1)), n-1);
		}
	}
	
	
	/**
	 * <p> Write a recursive function  returns 
	 *  String s but with each pair "ci" of characters, where i is a digit,
	 * replaced by i occurrences of c. </p>
	 * <pre>
	 *  Example:
	 *  expandCompressedString("d2")  return  "dd"
	 *  expandCompressedString("c3d2")  return  "cccdd"
	 *  expandCompressedString("a5x4f1")  return  "aaaaaxxxxf"
	 *  expandCompressedString("a5x0f1")  return  "aaaaaf"
	 *  </pre>
	 * 
	 * 
	 * 
	 * @param str
	 * 			input compressed String 
	 * 
	 * 
	 * 
	 * 
	 * @return
	 * 		a String Expansion of compressed string 
	 * 		
	 * @pre. 
	 * 		 str  contains an even number of characters, and the
	 * 		first of each pair is a char and the second is a digit.
	 */
	public String expandCompressedString(String str) {
		String result = "";
		int len = str.length();
		if (len % 2 == 0 && len > 0) {
			result = expandHelper(str, "", 0, len);
		}
		return result;
	}
	private String expandHelper(String str, String res, int start, int len) {
		if (start == len-2) {
			int n = toInt(str.charAt(start+1));
			res = res.concat(repeatCharNTimes(n, str.charAt(start)));
			return res;
		}
		else {
			int n = toInt(str.charAt(start+1));
			res = res.concat(repeatCharNTimes(n, str.charAt(start)));
			return expandHelper(str, res, start+2, len);
		}
	}
	private int toInt(char c) {
		return Integer.valueOf(String.valueOf(c));
	}
	
	
	
	
	
	/** 
	 * 
	 * <p> Write a recursive function convert any  decimal number {@code n > 0 }  and {@code n <= 65535} 
	 * into a octal number, return an array represents  the octal  number </p>
	 * 
	 * <p>
	 * A octal  (base-8) number. A octal  number is made up 
	 * of one or more octal digits {0, 1, 2, 3, 4, 5, 6, 7}. 
	 * 
	 * </p>
	 * 
	 * 
	 * <pre>
	 *  Example:
	 *  
	 * IntegerToOctal (4)  return [4], where (4*1) = 4 
	 * IntegerToOctal (9)  return [1, 1], where (1*1)+(1*8) = 9
	 * IntegerToOctal (31)  return [7, 3], where (7*1)+(3*8) =31
	 * 
	 * IntegerToOctal (65535)  return [7, 7, 7, 7, 7, 1], 
	 * 		where (7*1)+(7*8)+ (7*64)+ (7*512)+(7*4096)+ (1*32768) =65535
	 * </pre>
	 * @param n
	 * 			positive integer 
	 *  @return  array  represents  the octal number
	 *  
	 * @pre.
	 * 		{@code n > 0 }
	 */
	public  int []  IntegerToOctal (int n) {
		int plus = 0;
		int[] myArray = new int[0];
		if (n > 0) {			
			if (isExp(n, 8)) {
				plus = 1;
			}
			int bound8 = (int) Math.ceil(Math.log10(n) / Math.log10(8)) + plus;
			myArray = new int[bound8];
			octHelper(n, myArray, 0);
		}
		else if (n == 0) {
			myArray = new int[1];
		}
		
		return myArray;
	}
	private int octHelper(int n, int[] arr, int i) {
		if (i == arr.length-1) {
			arr[i] = n % 8;
			return 1;
		}
		else {
			arr[i] = n % 8;
			return octHelper(n/8, arr, i+1);
		}
	}
	

}
