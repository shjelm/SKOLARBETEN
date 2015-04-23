package LargestK;

import java.util.Scanner;

public class LargestK {
	//Reads an int, calculates and prints the largest k 
	public static void main(String[] args){
		try{
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("What's N? ");
			int n = scanner.nextInt();
			int j = 0, k = 0;
			
			for(int i=0; i < n; i+=2){
				j +=i;
				if((j+(i+2)) > n){
					k=i;
					break;
				}
			}
			scanner.close();
			
			System.out.println("K: "+k);
			}
		catch(Exception e){
			if(e.getMessage() == null){
				System.out.println("Something went wrong. Try again!");
			}
			else{
				System.out.println(e.getMessage());
			}
		
		}
	}
}
