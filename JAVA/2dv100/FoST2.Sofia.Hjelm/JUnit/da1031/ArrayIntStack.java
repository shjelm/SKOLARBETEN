package da1031;

public class ArrayIntStack extends AbstractIntCollection implements IntStack {

	public AbstractIntCollection intCol = new AbstractIntCollection() {
	};
	
	@Override
	public void push(int n) {
		if(intCol.size() == intCol.values.length){
			intCol.resize();
		}
		intCol.values[intCol.size++] = n;
	}

	@Override
	public int pop() {
		if(intCol.isEmpty()){
			throw new IndexOutOfBoundsException();
		}
		else{
			return intCol.values[--intCol.size];
		}
	}

	@Override
	public int peek() {
		return intCol.values[intCol.size-1];
	}
	
	@Override
	public String toString(){
		return intCol.toString();
	}
	
	@Override
	public boolean isEmpty(){
		return intCol.isEmpty();
	}
	
	@Override
	public int size(){
		return intCol.size();
	}

}
