package lab78;

import java.util.Arrays;

public class BSTTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer[] numList = {38, 25, 51, 63, 17, 42, 31, 4, 21, 71, 55};
//		YorkBinarySearchTree<Integer> t = new YorkBinarySearchTree<Integer>(numList);
//		Position<Integer> root = t.root();
//		System.out.println(t.search(17).getElement());
//		System.out.println(t.size());
//		for (int i = 10; i >= 0; i--) {
//			t.remove(numList[i]);
//		}
//		t.insert(2);
////		t.insert(3);
////		t.insert(1);
//		System.out.println(t.isFullBST());
//		System.out.println(t.height());
		
		Integer[] numList = {30, 25, 71, 17, 65, 75, 27, 20};
		YorkBinarySearchTree<Integer> t = new YorkBinarySearchTree<Integer>(numList);
		
		System.out.println(t.numInternalNodes(t.root()));
		
//		Position<Integer> r = t.right(t.root());
//		t.remove(30);
//		System.out.println(t.inorder());
	}

}
