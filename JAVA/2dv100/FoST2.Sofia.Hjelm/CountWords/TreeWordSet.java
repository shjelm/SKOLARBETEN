package CountWords;

import java.util.Iterator;

public class TreeWordSet implements WordSet {
	private BST root = null;
	private int size = 0;
	
	private class BST { // private inner class
		Word value;
		BST left = null, right = null;
		BST(Word w) { value = w; }
		
		void add(Word w) { // recursive add
			if (value.compareTo(w) < 0) { // add to left branch
				if (left == null){
					left = new BST(w);
					
				}
				else{
					left.add(w);
				}
			}
			else { // add to right branch
				if ( right == null){
					right= new BST(w);
				}
				else{
					right.add(w);
				}
			}
			
		}
			
		public boolean contains(Word w) { // recursive look−up			
			if (root == null)
				return false;
			else if (value.compareTo(w) < 0)
				if (left == null)
					return false ;
				else
				return left.contains(w);
			else if (value.compareTo(w) > 0)
				if (right == null)
					return false;
				else
				return right.contains(w);
			else
				return true;
		}		
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Word word) {
		if (root==null){
			size++;
			root = new BST(word);
		}		
		else if(!contains(word)){
			size++;
			root.add(word);
		}
	}

	@Override
	public boolean contains(Word word) {
		if (root==null){
			root = new BST(word);
			return false;
		}
		else{
			return root.contains(word);
		}		
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public String toString()
	{
	    return "[" + toString(root) +"]";
	}
	
	public String toString(BST root) {
		StringBuffer s = new StringBuffer();
        if (root != null) {
                s.append(toString(root.left));	// append my left sub-tree
                s.append(root.value + ", ");	        // append myself
                s.append(toString(root.right));	// append my right sub-tree
        }
        return s.toString();
	}

}
