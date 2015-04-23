package CountWords;

import java.util.Iterator;

public class HashWordSet implements WordSet {
	private int size = 0; // Current size
	private Node[] buckets = new Node[8];
	
	private class Node { // Private inner classes
		Word word;
		Node next = null;
		public Node (Word w) { word = w; }
		public String toString () {return word.toString();}
	}
	
	@Override
	public Iterator iterator() {
		return new HashWordIterator();
	}
	
	private class HashWordIterator implements Iterator<Word> {

        private int pos, index = 0;
        private Word[] words = new Word[size];
        private Node node;

        public HashWordIterator()
        {
            for(int i=0; i<words.length; i++){
            words[index++]=node.word;
            node = node.next;
            }
        }

        public boolean hasNext() {
            if (size > pos){
                return true;
            }
            return false;
        }

        public Word next() {
            return words[pos++];
        }
    }

	@Override
	public void add(Word w) {
		int pos = getBucketNumber(w);
		Node node = buckets[pos]; // First node in list
		
		if(!contains(w)){
			node = new Node(w); // Not found, add new node as first entry
			node.next = buckets[pos];
			buckets[pos] = node;
			size++;
			if (size == buckets.length){
				rehash ();
			}
		}
	}

	private int getBucketNumber(Word word) {
		int hc = word.hashCode();
		if (hc < 0) hc = -hc; // Make sure non−negative
		return hc % buckets.length; // Simple hash function
	}
	
	private void rehash() {
		Node[] temp = buckets; // Copy of old buckets
		buckets = new Node[2*temp.length]; // New empty buckets
		size = 0;
		for (Node n : temp) { // Insert old values into new buckets
			if (n == null) continue; // Empty bucket
				while (n != null ) {
				add(n.word); // Add elements again
				n = n.next;
			}
		}
	}
	
	@Override
	public boolean contains(Word w) {
		int pos = getBucketNumber(w);
		Node node = buckets[pos];
		while (node != null) {
			if (node.word.equals(w)){
				return true; // Found!
			}
			else{
				node = node.next;
			}
		}
		return false ;// Not found
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		String str = "[";
		for(int i= 0; i < buckets.length; i++){
			if(buckets[i]!=null){
				str +=buckets[i] +", ";
			}
		}
		str+="]";
		return str;
	}
}
