package lab1;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MyTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		RecursiveMethods rm = new RecursiveMethods();
		while (true) {
			System.out.println("enter int:");
			int x = input.nextInt();
//			System.out.println("enter int:");
//			int y = input.nextInt();
//			try {
//				int[] my_arr = IntegerToBinary(x);
//			}
			System.out.println("complementofDecimal(" + x + /*", " + y + */"): " + rm.complementofDecimal((x)));
//			catch(Exception e) {
//
//			}
			System.out.printf("\n\n");
		}

	}
	
	
//	public static String complementofDecimal(int n) {
//		String res = "";
//		String str = String.valueOf(n);
//		int len = str.length();
//		if (len > 0) {			
//			res = complementHelper(str, "", 0, len);
//		}
//		
//		return res;
//	}
//	
//	private static String complementHelper(String str, String res, int i, int len) {
//		int x = toInt(str.charAt(i));
//		if (x == 0) {
//			x = 9;
//		}
//		else {
//			x = 10 - x;
//		}
//		if (i == len-1) {
//			res = res.concat(String.valueOf(x));
//			return res;
//		}
//		else {
//			res = res.concat(String.valueOf(x));
//			return complementHelper(str, res, i+1, len);
//		}
//	}
//	
//	
//	public static int[]  IntegerToBinary (int n) {
//		int plus = 0;
//		if (isExp(n, 2)) {
//			plus = 1;
//		}
//		int bound2 = (int) Math.ceil(Math.log10(n) / Math.log10(2)) + plus;
//		int[] myArray = new int[bound2];
//		Rem(n, myArray, bound2-1);
//		
//		return myArray;
//	}
//	private static int Rem (int n, int[] arr, int i) {
//		if (n == 0) {
//			arr[0] = 1;
//			return 1;
//		}
//		else {
//			arr[i] = n % 2;
//			return Rem(n/2, arr, i-1);
//		}
//	}
//	private static boolean isExp(int n, int a) {
//		double sq = (Math.log10(n) / Math.log10(a));
//		return ((sq - Math.floor(sq)) == 0);
//	}
//	
//	
//	public static int numberOfFirstChar(String str) {
//		int result = 0;
//		Integer count = 0;
//		if (!str.equals("")) {			
//			int len = str.length();
////			char first = str.charAt(0);
//			result = helper(str, count, 0, len-1);
//		}
//		
//		return result;
//	}
//	private static int helper(String str, Integer n, int i, int len) {
//		boolean successive = str.charAt(0) == str.charAt(i);
//		if (successive) {
//			n = n + 1;
//			if (i != len) {					
//				return helper(str, n, i+1, len);
//			}
//			else {
//				return n;
//			}
//		}
//		else {
//			return n;
//		}
//
//	}
//	
//	public static String compressString(String str) {
//		String res = "";
//		Integer count = 0;
//		if (!str.equals("")) {
//			int len = str.length();
//			res = compressHelper(str, count, res, 0, 0, len-1);
//		}
//		return res;
//	}
//	private static String compressHelper(String str, Integer n, String res, int i, int j, int len) {
//		boolean successive = str.charAt(i) == str.charAt(j);
//		if (successive) {
//			n = n + 1;
//			if (j != len) {			
//				return compressHelper(str, n, res, i, j+1, len);
//			}
//			else {				// end of string
//				res = res.concat(String.valueOf(str.charAt(i)) + n);
//				return res;
//			}
//		}
//		else {
//			res = res.concat(String.valueOf(str.charAt(i)) + n);
//			return compressHelper(str, 0, res, i+n, i+n, len);
//		}
//
//	}
//	
//	
//	public static int yorknacci(int n) {
//		if (n == 0) {
//			return 1;
//		}
//		else if (n == 1) {
//			return 1;
//		}
//		else if (n == 2) {
//			return 1;
//		}
//		else {
//			if (n % 2 == 1) {
//				return yorknacci(n-1) + yorknacci(n-2) + yorknacci(n-3);
//			}
//			else {
//				return yorknacci(n-1) + yorknacci(n-2);
//			}
//		}
//	}
//	private static int oddHelper(int n, int a, int b, int c) {
//		if (n == 0) {
//			return a;
//		}
//		else if (n == 1) {
//			return b;
//		}
//		else if (n == 2) {
//			return c;
//		}
//		else {
//			return oddHelper(n-1, b, c, a+b+c);
//		}
//	}
//	private static int evenHelper(int n, int a, int b, int c) {
//		if (n == 0) {
//			return a;
//		}
//		else if (n == 1) {
//			return b;
//		}
//		else if (n == 2) {
//			return c;
//		}
//		else {
//			return evenHelper(n-1, b, a+b, b+c);
//		}
//	}
//	
//	
//	public static String repeatCharNTimes(int n, char c) {
//		String result = "";
//		if (n > 0) {
//			result = repeatHelper(String.valueOf(c), n);
//		}
//		return result;
//	}
//	private static String repeatHelper(String str, int n) {
//		if (n == 1) {
//			return str;
//		}
//		else {
//			return repeatHelper(str.concat(str.substring(0,1)), n-1);
//		}
//	}
//	
//	
//	public static String expandCompressedString(String str) {
//		String result = "";
//		int len = str.length();
//		if (len % 2 == 0 && len > 0) {
//			result = expandHelper(str, "", 0, len);
//		}
//		return result;
//	}
//	private static String expandHelper(String str, String res, int start, int len) {
//		if (start == len-2) {
//			int n = toInt(str.charAt(start+1));
//			res = res.concat(repeatCharNTimes(n, str.charAt(start)));
//			return res;
//		}
//		else {
//			int n = toInt(str.charAt(start+1));
//			res = res.concat(repeatCharNTimes(n, str.charAt(start)));
//			return expandHelper(str, res, start+2, len);
//		}
//	}
//	private static int toInt(char c) {
//		return Integer.valueOf(String.valueOf(c));
//	}
//	
//	
//	public static  int []  IntegerToOctal (int n) {
//		int plus = 0;
//		int[] myArray = new int[0];
//		if (n > 0) {			
//			if (isExp(n, 8)) {
//				plus = 1;
//			}
//			int bound8 = (int) Math.ceil(Math.log10(n) / Math.log10(8)) + plus;
//			myArray = new int[bound8];
//			octHelper(n, myArray, 0);
//		}
//		else if (n == 0) {
//			myArray = new int[1];
//		}
//		
//		return myArray;
//	}
//	private static int octHelper(int n, int[] arr, int i) {
//		if (i == arr.length-1) {
//			arr[i] = n % 8;
//			return 1;
//		}
//		else {
//			arr[i] = n % 8;
//			return octHelper(n/8, arr, i+1);
//		}
//	}
//	
//	
//	public static List<Integer> YorknacciList(int n) {
//		Integer[] a = new Integer[n];
//		if (n > 0) {			
//			listHelper(a, 0);
//		}
//
//		return Arrays.asList(a);
//	}
//	private static void listHelper(Integer[] arr, int i) {
//		if (i == arr.length-1) {
//			arr[i] = yorknacci(i);
//		}
//		else {
//			arr[i] = yorknacci(i);
//			listHelper(arr, i+1);
//		}
//	}
//	
//	
//	public static boolean  isRelativelyPrime( int p , int q) {
////		boolean result = false;
//		int min = 0;
//		int max = 0;
//		if (p >= q) {
//			max = p;
//			min = q;
//		}
//		else {
//			max = q;
//			min = p;
//		}
//		int x = primeHelper(2, p, q);
//		
//		return !(x > 0);
//	}
//	private static int primeHelper(int n, int min, int max) {
//		if (n == min) {
//			if (min % n == 0 && max % n == 0) {
//				return 1;
//			}
//			else {
//				return 0;
//			}
//		}
//		else {
//			if (min % n == 0 && max % n == 0) {
//				return 1;
//			}
//			else {
//				return primeHelper(n+1, min, max);
//			}
//		}
//	}
//
}
