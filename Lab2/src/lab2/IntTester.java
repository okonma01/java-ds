package lab2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class IntTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		YorkArrayList<Integer> list = new YorkArrayList<Integer>();
		System.out.println("list: " + list);
		System.out.println("list size: " + list.size());
		Scanner	input = new Scanner(System.in);
		Set<String> set = new HashSet<String>();
		set.add("s");
		set.add("a");
		String in;
		
		while (true) {
			while (true) {
				System.out.println("\nenter one of: ");
//				System.out.println(" \"g\" for get() ");
				System.out.println(" \"s\" for set() ");
				System.out.println(" \"a\" for add() ");
//				System.out.println(" \"r\" for remove() \n");
				in = input.nextLine();
				if (set.contains(in)) {
					break;
				}
			}
			System.out.print("\nenter int: ");
			int i = input.nextInt();
			input.nextLine();
			
			System.out.print("\nenter Integer: ");
			Integer x = input.nextInt();
			input.nextLine();
			
			if (in.equals("s")) {
				list.set(i, x);
				System.out.println("\nset(" + i + ", " + x + "): ");
			}
			else if (in.equals("a")) {
				list.add(i, x);
				System.out.println("\nadd(" + i + ", " + x + "): ");
			}
			
			System.out.println("list: " + list);
			System.out.println("list size: " + list.size());
		}

	}

}
