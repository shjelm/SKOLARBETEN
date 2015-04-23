package Queue;

import java.util.Iterator;

public class LinkedQueue implements QueueInterface {
	private int size = 0;  
	private Node head = null,  tail = null;
	
	//Get size of queue
	public int size() {
		return size;
	}

	//Check if queue is empty
	public boolean isEmpty() {
		boolean isEmpty = false;
		if(head == null){
			isEmpty = true;
		}
		return isEmpty;
	}

	//Add the object to the queue
	public void enqueue(Object element) {
		Node n = (Node) element;
		if (isEmpty()){ 
			head = new Node(n.value);
			tail = head;
		}
		else {
			Node node = head;
			while (node.next != null ) 
			node = node.next;
			node.next = new Node(n.value); 
			tail = node.next;
			}
		size ++;
	}

	/* Remove and return the item on the queue least recently added. 
	 * Throw an exception if the queue is empty. */
	public Object dequeue() {
		if (isEmpty()){
			throw new RuntimeException("Queue is empty");
		}
        Object o = head.value;
        head = head.next;
        size--;
        if (isEmpty()){
           tail = null;
        }	
        return o;
	}

	//Return the first object in the queue
	public Object first() {
		if (isEmpty()) throw new RuntimeException("Queue is empty");
        return head.value;
	}

	//Return the last object in the queue
	public Object last() {
		if (isEmpty()) throw new RuntimeException("Queue is empty");
		return tail.value;
	}

	//Check if the queue contains object o
	public boolean contains(Object o) {  
		Iterator<Object> iter = iterator();
		Node k, l;
		l = (Node) o;
		
		while(iter.hasNext()){
			k = (Node)iter.next();
			if(k.value == l.value){
				return true;
			}
		}		
		return false;		
	}
	
	// Private inner Node class
	private class Node { 
		int value ;
		Node next = null;
		Node(int v) { value = v;}
	}
	
	public Iterator <Object> iterator () { return new ListIterator (); }
	
	class ListIterator implements Iterator<Object> {
		private Node current = head;

		// Returns true if there are objects left in the queue
		public boolean hasNext() {
			return current != null;
		}

		// Returns the next object.
		public Object next() {
			Object result = current;
			current = current.next;
			return result;
		}
	}
	
	//Test for the class
	public static void main(String[] args) {  
//		try{
//			LinkedQueue lq = new LinkedQueue();
//			Node x = lq.new Node(29);
//			for(int i = 1; i < 51; i++){
//				Node element = lq.new Node(i);
//				
//				lq.enqueue(element);
//				}
//			for(int i = 0; i<50; i++){
//	
//				System.out.println("Storlek: " +lq.size );
//				System.out.println("Contains("+x.value+") :" +lq.contains(x));
//				System.out.println(lq.dequeue());
//			}
//		}
//		catch(Exception e){
//			System.out.println(e.getMessage());
//		}		
	}
}
