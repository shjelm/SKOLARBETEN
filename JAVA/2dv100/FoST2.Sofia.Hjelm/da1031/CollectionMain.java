package da1031;

public class CollectionMain {

	public static void main(String[] args) {
		/* Demonstration of ArrayIntStack*/
		ArrayIntStack arrStack = new ArrayIntStack();
		System.out.println(arrStack.isEmpty()); // TRUE
		for(int i = 1; i < 16; i++){
			arrStack.push(i);
		}
		
		System.out.println(arrStack.peek() +" peek"); // => 15
		System.out.println(arrStack.isEmpty()); // False
		System.out.println(arrStack.toString()); //All elements		
		System.out.println("Size: "+arrStack.size()); // 15
		
		for(int j = 0; j < 14; j++){
			arrStack.pop();
		}
		
		System.out.println(arrStack.peek() +" peek"); // => 1
		System.out.println(arrStack.isEmpty()); // False
		System.out.println(arrStack.toString()); //All elements
		System.out.println("Size: "+arrStack.size()); // 1
		
		arrStack.pop();

		System.out.println(arrStack.isEmpty()); // TRUE
		System.out.println(arrStack.toString()); //All elements		
		System.out.println("Size: "+arrStack.size()); // 0
		
		
		/* Demonstration of ArrayIntList*/
		ArrayIntList arrIntList = new ArrayIntList();
		System.out.println("Size: "+arrIntList.size());
		
		for(int i = 1; i < 15; i+=2){
			arrIntList.add(i);
		}
		System.out.println("");
		System.out.println("Index(2): " +arrIntList.get(2)); //=> 3
		System.out.println("Index of 57: " + arrIntList.indexOf(57)); //=> -1
		System.out.println("Index of 13: " + arrIntList.indexOf(13)); //=> 7
		
		System.out.println(arrIntList.toString());
		arrIntList.addAt(8,4);
		arrIntList.addAt(12,6);
		
		System.out.println(arrIntList.toString());
		for(int j = 1; j < 6; j++){
			System.out.println("Index("+j+"): " +arrIntList.get(j)); 
		}
		System.out.println(arrIntList.toString());
		arrIntList.remove(2);
		System.out.println(arrIntList.toString());
		arrIntList.remove(2);
		System.out.println(arrIntList.toString());
		System.out.println("Size: "+arrIntList.size());
		
		for(int k = 1; k < 4; k++){
			System.out.println("Index("+k+"): " +arrIntList.get(k)); 
		}
		System.out.println(arrIntList.toString());
		System.out.println("Size: "+arrIntList.size());
		for(int l = arrIntList.size(); l > 0 ; l--){
			arrIntList.remove(l);					//Remove all elements
		}
		System.out.println(arrIntList.toString());
		System.out.println("Size: "+arrIntList.size());
		
		
	}

}
