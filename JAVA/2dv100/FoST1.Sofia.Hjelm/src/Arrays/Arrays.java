package Arrays;
//INTE KLAR
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Arrays {
	//Computes the sum of all integers in the array
	public static int sum(int[] arr){
		int sum = 0;

		for(int i = 0; i < arr.length; i++){
			sum += Array.getInt(arr, i);
		}
		
		return sum;
	}
	
	public static String toString(int[] arr){
		String str = "";
		
		for(int i = 0; i < arr.length; i++){
			str += Array.getInt(arr, i);
			
			if(i < arr.length-1){
				str += ", ";
			}
		}
	     
		return "n = " +str;
	}
	
	//Adds n to all integers in arr 
	public static int[] addN(int[] arr, int n){
		
		int[] array = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++){
			array[i] = Array.getInt(arr, i) +n;
		}
	
		return array; 
	}

	//Creates and returns, a new array with all the elements in reverse order. 
	public static int[] reverse(int[] arr){
		int[] array = new int[arr.length];
		
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		
		for(int i = 0; i < arr.length; i++){			
			arrList.add(Array.getInt(arr, i));
		}
		
		Collections.reverse(arrList);
		            
		for(int j =0;j<arrList.size();j++){
		  array[j] = arrList.get(j);
		}

		return array;
	}

	//Replaces all occurrences of the element old with nw in arr.
	public static void replaceAll(int[] arr, int old, int nw){
		
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		
		
		for(int i = 0; i < arr.length; i++){
			
			arrList.add(Array.getInt(arr, i));
			
			if(arrList.get(i).equals(Integer.valueOf(old))){
				arrList.set(i, nw);
			}
			for(int j =0; j < arrList.size(); j++){
				arr[j] = arrList.get(j);			
			}
		}
	
	}
	//Returns a new sorted array
	public static int[] sort (int[] arr){
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		
		for(int i = 0; i < arr.length; i++){			
			arrList.add(Array.getInt(arr, i));
		}
		
		Collections.sort(arrList);
		
		int[] array = new int[arr.length];		
		
		for(int j =0; j < arrList.size(); j++){
			array[j] = arrList.get(j);			
		}
		
		return array;
		
	}
	
	//Returns true if the subsequence is part of arr
	public static boolean hasSubsequence(int[] arr, int[] sub){		
		boolean answer = false;
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		ArrayList<Integer> subList = new ArrayList<Integer>();
		
		for(int i = 0; i < arr.length; i++){			
			arrList.add(Array.getInt(arr, i));
		}
		for(int i = 0; i < sub.length; i++){
			subList.add(Array.getInt(sub,i));
		}
		
		if(sub.length > arr.length){
			answer = false;
		}
		else {
			if(Collections.indexOfSubList(arrList, subList) >= 0){
				answer = true;
			}
			else{
				answer = false;
			}
		}
		
		return answer;
	}
	
	public static int[] absDif(int[] arr1, int[] arr2){		
		/*Method int[] absDif(int[] arr1, int[] arr2) returns a new array 
		 * that is the absolute difference between array arr1 and array arr2. 
		 * That is result array dist(i) = |arr1(i) - arr2(i)|. For example, 
		 * in the case absDif({1,2,3,4,5}, {1,1,1,1,1}) the result is {0,1,2,3,4}. 
		 * Notice, that the sizes of both arrays should be the same, 
		 * in case they are different the method should throw an exception 
		 * and be handled within the program.*/
		
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		ArrayList<Integer> arrList2 = new ArrayList<Integer>();
		ArrayList<Integer> absList = new ArrayList<Integer>();		

		int[] array = new int[arr1.length];	
		
		try{
			if(arr1.length == arr2.length){
				
				for(int i = 0; i < arr1.length; i++){			
					arrList.add(Array.getInt(arr1, i));
					arrList2.add(Array.getInt(arr2,i));
				}
				for(int i = 0; i < arrList.size(); i++){
					absList.add(arrList.get(i) - arrList2.get(i));
					array[i] = absList.get(i);	
				}	
			}
			else{
				throw new IndexOutOfBoundsException("Arrays not the same length");
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return array; 
	}

}
