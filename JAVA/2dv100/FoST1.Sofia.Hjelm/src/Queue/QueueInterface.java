package Queue;

import java.util.Iterator;

public interface QueueInterface {

	    int size();                          // current queue size 	    
	    boolean isEmpty();                   // true if queue is empty
		void enqueue(Object element);        // add element at end of queue
	    Object dequeue();                    // return and remove first element.
	    Object first();                      // return (without removing) first element
	    Object last();                       // return (without removing) last element
	    boolean contains(Object o);			 // return "true" if this queue contains the specified element  
	    Iterator iterator();                 // element iterator
}
