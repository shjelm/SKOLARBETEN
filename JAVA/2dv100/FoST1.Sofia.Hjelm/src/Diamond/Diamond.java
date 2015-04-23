package Diamond;

import java.util.Scanner;

public class Diamond {
	//Makes a diamond with the width of an odd integer
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Provide an odd integer: ");
		
		int n = scanner.nextInt();
		int i, j,k,l;
		
		//Prints the diamond
		if(n%2 == 1){
			for (i = 1; i <= n; i+=2){
				for(l = n-i; l >0; l-=2 ){
					System.out.print(" ");
				}
				for(j = 1; j <= i; j++){
					System.out.print("*");
				}
				System.out.println("");
			}
			
			for (i = n-2; i >0; i-=2){	
				for(l = n-i; l >0; l-=2 ){
					System.out.print(" ");
				}
				for(k = 0; k <i; k++){
					System.out.print("*");
				}
				System.out.println("");
			}
		}
		else{
			System.out.print("That integer is not odd!");
		}
		scanner.close();
	}
}
