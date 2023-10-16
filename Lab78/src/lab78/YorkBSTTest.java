package lab78;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class YorkBSTTest {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);

	@Test
	public void test_00() {
		YorkBinarySearchTree<Integer> t = new YorkBinarySearchTree<>();

		assertEquals("Root is null", null, t.root());
		assertEquals("Size is not correct", 0, t.size());

		try {
			assertEquals("Root depth is not correct", 0, t.depth(t.root()));
			fail();
		} catch (IllegalArgumentException e) {} // good
	}

	@Test
	public void test_01() {
		YorkBinarySearchTree<Integer> t = new YorkBinarySearchTree<>();

		t.insert(2);

		assertEquals("Size is not correct", 1, t.size());
		assertEquals("Root has no children", 0, t.numChildren(t.root()));
		assertEquals("Parent of root is null", null, t.parent(t.root()));
	}

	@Test
	public void test_02() {
		YorkBinarySearchTree<Integer> t = new YorkBinarySearchTree<>();

		t.insert(2);

		assertEquals("Root of tree is external", true, t.isExternal(t.root()));
		assertEquals("Root of tree is internal", false, t.isInternal(t.root()));
	}


	@Test
	public void test_03() {
		Integer[] numList = {2};
		YorkBinarySearchTree<Integer> t = new YorkBinarySearchTree<>(numList);

		t.insert(10);

		assertNotEquals("Root is not null", null, t.root());
		assertEquals("Tree height is not correct", 1, t.height());
		assertEquals("Tree height is not correct", 1, t.height(t.root()));
		assertEquals("Depth of root's left child is not correct", 1, t.depth(t.right(t.root())));
	}


	@Test
	public void test_04() {
		Integer[] numList = {2};
		YorkBinarySearchTree<Integer> t = new YorkBinarySearchTree<>(numList);

		t.insert(10);

		assertEquals("Root of tree is not external", false, t.isExternal(t.root()));
		assertEquals("Right child of root is internal", false, t.isInternal(t.right(t.root())));
	}


	@Test
	public void test_05() {
		YorkBinarySearchTree<Integer> t = new YorkBinarySearchTree<>();

		t.insert(10);
		t.insert(2);
		
		assertEquals("Root of tree is not external", true, t.isInternal(t.root()));
		assertEquals("Left child of root is internal", true, t.isExternal(t.left(t.root())));
	}
	
	
	@Test
	public void test_06() {
		Integer[] numList = {15, 220, 110, -110, 152, 1322};
		YorkBinarySearchTree<Integer> t = new YorkBinarySearchTree<>(numList);

		assertEquals("Size is not correct", 6, t.size());
		assertEquals("Tree height is not correct", 3, t.height());

		Position<Integer> node = t.left(t.right(t.root())); 
		assertEquals("Left of 110 is null", null, t.left(node));
		t.remove(node);

		try {
			t.validate(node);
			fail();
		} catch (IllegalArgumentException e) {} // good

		assertEquals("Size is not correct", 5, t.size());


	}


	
	@Test
	public void test_07() {
		Integer[] numList = {38, 25, 51, 63, 17, 42, 31, 4, 21, 71, 55};
		YorkBinarySearchTree<Integer> t = new YorkBinarySearchTree<>(numList);
		
		assertEquals("Size is not correct", 11, t.size());
		
		t.insert(28);
		t.insert(35);
		t.insert(49);
		t.insert(40);
		
		assertEquals("Size is not correct", 15, t.size());
		assertEquals("Tree is not sorted", true, t.isSorted(t));
		
	}
	
	@Test
	public void test_08() {
		Integer[] numList = {38, 25, 51, 63, 17, 42, 31, 4, 21, 71, 55, 28, 35, 49, 40};
		YorkBinarySearchTree<Integer> t = new YorkBinarySearchTree<>(numList);
		
		String preStr = "[38, 25, 17, 4, 21, 31, 28, 35, 51, 42, 40, 49, 63, 55, 71]";
		String postStr = "[4, 21, 17, 28, 35, 31, 25, 40, 49, 42, 55, 71, 63, 51, 38]";
		String inStr =  "[4, 17, 21, 25, 28, 31, 35, 38, 40, 42, 49, 51, 55, 63, 71]";
		
		List<String> preL = new LinkedList<>();
		for (Position<Integer> pos : t.preorder()) {
			preL.add( pos.getElement().toString() );
		}
		
		List<String> postL = new LinkedList<>();
		for (Position<Integer> pos : t.postorder()) {
			postL.add( pos.getElement().toString() );
		}
		
		List<String> inL = new LinkedList<>();
		for (Position<Integer> pos : t.inorder()) {
			inL.add( pos.getElement().toString() );
		}
		
		assertEquals("Preorder traversal incorrect", preStr, preL.toString());
		assertEquals("Postorder traversal incorrect", postStr, postL.toString());
		assertEquals("Inorder traversal incorrect", inStr, inL.toString());
		
	}

	@Test
	public void test_09() {
		YorkBinarySearchTree<Integer> t = new YorkBinarySearchTree<>();

	}
	
	@Test
	public void test_10() {
		YorkBinarySearchTree<Integer> t = new YorkBinarySearchTree<>();

	}
	
}
