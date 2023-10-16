package lab2;

import java.util.*;
import java.util.List;

public class MyTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		YorkArrayList<String> list = new YorkArrayList<String>();
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
			
			System.out.print("\nenter String: ");
			String str = input.nextLine();
			
			if (in.equals("s")) {
				list.set(i, str);
				System.out.println("\nset(" + i + ", " + str + "): ");
			}
			else if (in.equals("a")) {
				list.add(i, str);
				System.out.println("\nadd(" + i + ", " + str + "): ");
			}
			
			System.out.println("list: " + list);
			System.out.println("list size: " + list.size());
		}
//		list.add(0, "first");
//		System.out.println("list size: " + list.size());
//		System.out.println("list: " + list);
//		list.add(2, "second");
//		System.out.println("list size: " + list.size());
//		System.out.println("list: " + list);

	}

}
