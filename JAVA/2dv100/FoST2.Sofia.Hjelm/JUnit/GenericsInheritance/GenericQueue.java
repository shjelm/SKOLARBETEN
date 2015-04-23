package GenericsInheritance;

import java.util.Iterator;

public class GenericQueue<E> implements Queue<E> {
	private int size = 0;
	private Node<E> head ,tail;
	
	public GenericQueue() {
		head = null;
		tail = null;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public void enqueue(E element) {
		Node<E> newNode= new Node<E>(element, null);
		if (head == null) {
			head = newNode;
		}
		else {
			tail.next = newNode;
		}
		tail = newNode;
		size++;
	}

	@Override
	public E dequeue() {
		E element = first();
		head = head.next;
		
		if (head == null){ 
			tail = null;
		}
		size--;
		return element;
	}

	@Override
	public E first() {
		if (isEmpty()) throw new NullPointerException();
		return head.data;
	}

	@Override
	public E last() {
		if (isEmpty()) throw new NullPointerException("Queue is empty");
		return tail.data;
	}

	@Override
	public Iterator iterator() {
		return new QueueIterator();
	}
	
	class QueueIterator implements Iterator<E> {
		private Node<E> current = head;

		public boolean hasNext() {
			return current != null;
		}

		public E next() {
			E result = (E) current;
			current = current.next;
			return result;
		}
	}
	
	private static class Node<E> {
		private E data;
		private Node<E> next;
		
		public Node(E element, Node<E> nextNode) {
			data = element;
			next = nextNode;
		}
	}

}
