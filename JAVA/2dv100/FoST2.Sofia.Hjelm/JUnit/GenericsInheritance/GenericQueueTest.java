package GenericsInheritance;

import static org.junit.Assert.*;

import org.junit.*;

import GenericsInheritance.GenericQueue.QueueIterator;

public class GenericQueueTest<E> {

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
	 *             My GenericQueue tests
	 * 
	 * ************************************************************/
	
	@Test
	public void testSize(){
		GenericQueue<E> queue = buildQueue(3);
		assertEquals(3, queue.size());
	}
	
	@Test
	public void testIsEmpty(){
		GenericQueue<E> queue = buildQueue(1);
		assertEquals(false, queue.isEmpty());
		
		queue.dequeue();
		assertEquals(true, queue.isEmpty());
	}
	
	@Test
	public void testEnqueue(){
		GenericQueue<E> queue = buildQueue(2);
		E element = null;
		queue.enqueue(element);
		assertEquals(3, queue.size());
		assertEquals(element, queue.first());
	}
	
	
	@Test
	public void testDequeue(){
		GenericQueue<E> queue = buildQueue(2);
		queue.dequeue();
		assertEquals(1, queue.size());
	}
	
	@Test(expected = NullPointerException.class)
	public void testDequeueEmptyQueue(){
		GenericQueue<E> queue = buildQueue(0);
		queue.dequeue();
	}
	
	@Test
	public void testFirst(){
		GenericQueue<E> queue = buildQueue(0);
		E element = (E) new GenericQueueTest<E>();
		queue.enqueue(element);
		assertEquals(element, queue.first());
	}
	
	@Test(expected=NullPointerException.class)
	public void testFirstEmptyQueue(){
		GenericQueue<E> queue = buildQueue(0);
		queue.first();		
	}
	
	@Test
	public void testLast(){
		GenericQueue<E> queue = buildQueue(3);
		E element = (E) new GenericQueueTest<E>();
		queue.enqueue(element);
		assertEquals(element, queue.last());
	}
	
	@Test(expected=NullPointerException.class)
	public void testLastEmptyQueue(){
		GenericQueue<E> queue = buildQueue(0);
		queue.last();
	}
	@Test
	public void testIteratorHasNextEmpty(){
		GenericQueue<E> queue = buildQueue(0);
		QueueIterator it = (QueueIterator) queue.iterator();
		assertEquals(false, it.hasNext());
	}
	
	@Test
	public void testIteratorHasNext(){
		
		GenericQueue<E> queue = buildQueue(2);	
		QueueIterator it = (QueueIterator) queue.iterator();
		assertEquals(true, it.hasNext());
	}
	
	@Test(expected = NullPointerException.class)
	public void testIteratorNextEmpty(){ 
		GenericQueue<E> queue = buildQueue(0);
		QueueIterator it = (QueueIterator) queue.iterator();
		it.next();
	}
	
	/* ********************************************************
	 * 			Private help methods ==> Fixture
	 * ********************************************************/
	private GenericQueue<E> buildQueue(int size) {
		GenericQueue<E> queue = new GenericQueue<E>();
		for(int i = 1; i <= size; i++){
			E element = null;
			queue.enqueue(element);
		}
		return queue;
	}
}

