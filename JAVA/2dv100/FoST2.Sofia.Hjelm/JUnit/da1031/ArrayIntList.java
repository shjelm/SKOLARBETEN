package da1031;

public class ArrayIntList extends AbstractIntCollection implements IntList {

	public AbstractIntCollection intCol = new AbstractIntCollection() {
	};
	
	@Override
	public void add(int n) {
		if(intCol.size() == intCol.values.length){
			intCol.resize();
		}
		intCol.values[intCol.size++] = n;
	}

	@Override
	public void addAt(int n, int index) {
		if(intCol.size() >= intCol.values.length){
			intCol.resize();
		}
		if(intCol.checkIndex(index-1,intCol.size())){
			for(int i = intCol.size(); i > index-1 ; i--){
				intCol.values[i] =  intCol.values[i-1];
				
			}
			intCol.values[index-1] = n;	
			intCol.size++;
		}
	}

	@Override
	public void remove(int index) {
		if(!intCol.isEmpty() && intCol.checkIndex(index-1,intCol.size())){
			for(int i = index; i <= intCol.size(); i++){
				intCol.values[i-1] =  intCol.values[i];
			}
			intCol.size--;
		}
	}

	@Override
	public int get(int index) {
		if(intCol.isEmpty() || !intCol.checkIndex(index-1,intCol.size())){
			throw new ArrayIndexOutOfBoundsException();
		}
		else{
			return intCol.values[index-1];
		}
	}

	@Override
	public int indexOf(int n) {
		if(!intCol.isEmpty()){
			for(int i=0; i<intCol.values.length; i++) {
		         if(intCol.values[i] == n){
		             return i+1;
		         }
			}
		}
		return -1;
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
