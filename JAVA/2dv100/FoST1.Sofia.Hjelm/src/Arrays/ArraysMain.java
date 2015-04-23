package Arrays;

public class ArraysMain {
	//Test for the arrays class
	public static void main(String[] args) {
		int[] test = {1,2,3,4};
		int[] test2 = {1,6,1,9,2,4,3,5};
		int[] test3 = {1,5,3,7,2};
		
		
		//Test for sum()
		System.out.println("Test for sum");
		System.out.println(Arrays.sum(test)); // =>10
		
		//Test for toString()
		System.out.println("");
		System.out.println("Test for toString");
		System.out.println(Arrays.toString(test)); //=> n = 1, 2, 3, 4
		
		
		///Test for addN()
		System.out.println("");
		System.out.println("Test for addN");
		int increaseWith = 2;
		int[] addedArr = Arrays.addN(test,increaseWith);
		System.out.println(Arrays.toString(addedArr)); // => n = 3, 4, 5, 6
		
		//Test for reverse() 
		System.out.println("");
		System.out.println("Test for reverse");
		int[] reverseArr = Arrays.reverse(test2);
		System.out.println(Arrays.toString(reverseArr)); //=> n = 5,3,4,2,9,1,6,1
		
		//Test for replaceAll() 
		System.out.println("");
		int oldInt = 1;
		int replaceWith = 9;		
		System.out.println("Test for replaceAll");
		Arrays.replaceAll(test2, oldInt, replaceWith);
		System.out.println(Arrays.toString(test2)); //=> n = 9, 6, 9, 9, 2, 4, 3, 5
				

		//Test for sort()  
		System.out.println("");
		System.out.println("Test for sort");
		
		int[] sortArr = Arrays.sort(test3);
		System.out.println(Arrays.toString(sortArr)); //=> n = 1, 2, 3, 5, 7
		
		//Test for hasSubsequence()  
		System.out.println("");
		System.out.println("Test for hasSubsequence");
		int[] sub = new int[]{1,3,4};
		System.out.println(Arrays.hasSubsequence(test,sub)); // => false
		
		//Test for absDif()  
		System.out.println("");
		System.out.println("Test for absDif");
		int[] absArr = new int[]{1,1,1,1};
		int[] absArrRes = Arrays.absDif(test, absArr);
		
		System.out.println(Arrays.toString(absArrRes)); // => n = 0,1,2,3
	}

}
