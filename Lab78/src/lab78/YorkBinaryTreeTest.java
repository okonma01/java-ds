package lab78;

public class YorkBinaryTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		YorkLinkedBinaryTree<Integer> t = new YorkLinkedBinaryTree<Integer>();
		Position<Integer> root = t.root();
		t.addRoot(11);
		t.insertLeft(t.root(), 17);
		t.insertRight(t.root(), 9);
//		t.;
//		Position<String> node = root;
//		Position<String> pLeft = t.insertLeft(t.root(), "left");
//		Position<String> pRight = t.insertRight(t.root(), "right");
//		pLeft = t.insertLeft(pLeft, "left");
//		node = t.right(t.root());
//		System.out.println(t.size());
		System.out.println(t);
	}

}
