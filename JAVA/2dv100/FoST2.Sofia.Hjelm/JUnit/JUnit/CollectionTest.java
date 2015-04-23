package JUnit;

import static org.junit.Assert.*;
import org.junit.*;

import da1031.ArrayIntList;
import da1031.ArrayIntStack;

public class CollectionTest {

	private static int test_count = 0;

	/* Is executed before every test method (not test case).*/
	@Before
	public void setUp() {
		test_count++;
		System.out.println("Test "+ test_count);
	}
	
	/* Is executed after every test method (not test case).*/
	@After
	public void tearDown() {}
	
	/* *********************************************************** 
	 * 
	 *             My ArrayIntStack tests
	 * 
	 * ************************************************************/
	
	@Test
	public void testPush(){
		ArrayIntStack stack = buildStack(4);
		assertEquals(4, stack.intCol.size());
	}
	
	@Test
	public void testPop(){
		ArrayIntStack stack = buildStack(4);
		assertEquals(4, stack.pop());
		assertEquals(3, stack.intCol.size());
	}
	
	@Test
	public void testPeek(){
		ArrayIntStack stack = buildStack(7);
		assertEquals(7, stack.peek());
	}
	
	@Test
	public void testStackIsEmpty(){
		ArrayIntStack stack = buildStack(2);
		assertEquals(false, stack.isEmpty());
		stack.pop();
		stack.pop();
		assertEquals(true, stack.isEmpty());
	}
	
	@Test
	public void testStackSize(){
		ArrayIntStack stack = buildStack(5);
		assertEquals(5, stack.size());
	}
	
	/* *********************************************************** 
	 * 
	 *             My ArrayIntList tests
	 * 
	 * ************************************************************/
	@Test
	public void testAdd(){
		ArrayIntList list = buildList(5);
		assertEquals(5, list.intCol.size());
	}
	
	@Test
	public void testAddAt(){
		ArrayIntList list = buildList(5);
		list.addAt(6, 2);
		assertEquals(6, list.get(2));
	}
	
	@Test
	public void testRemove(){
		ArrayIntList list = buildList(5);
		int beforeRemove = list.get(2);
		list.remove(2);
		assertEquals(4, list.intCol.size());
		
		int afterRemove = list.get(2);
		assertNotEquals(beforeRemove, afterRemove);
	}
	
	@Test
	public void testRemoveEmpty(){
		ArrayIntList list = buildList(0);
		list.remove(9);
	}
	
	@Test
	public void testGet(){
		ArrayIntList list = buildList(3);
		assertEquals(3,list.get(3));
	}
	
	@Test
	public void testIndexOfExisting(){
		ArrayIntList list = buildList(7);		
		assertEquals(3, list.indexOf(3));
	}
	
	@Test
	public void testIndexOfNonExisting(){
		ArrayIntList list = buildList(3);
		assertEquals(-1, list.indexOf(9));
	}
	
	@Test
	public void testIsEmpty(){
		ArrayIntList list = buildList(0);
		assertEquals(true, list.isEmpty());
		list = buildList(7);
		assertEquals(false, list.isEmpty());
	}
	
	@Test
	public void testListSize(){
		ArrayIntList list = buildList(4);
		assertEquals(4, list.size());
	}
	
	/* ********************************************************
	 * 			Private help methods ==> Fixture
	 * ********************************************************/
	private ArrayIntList buildList(int size) {
		ArrayIntList list = new ArrayIntList();
		for (int i=1;i<=size;i++)
			list.add(i);
		return list; 
	}
	
	private ArrayIntStack buildStack(int size) {
		ArrayIntStack list = new ArrayIntStack();
		for (int i=1;i<=size;i++){
			list.push(i);
		}
		return list; 
	}
}
