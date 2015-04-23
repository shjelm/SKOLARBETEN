package HighLow;

import java.util.Random;
import java.util.Scanner;

public class HighLow {
	public static void main (String[] args){
		try{
			//Create random number generator 
			Random rand = new Random();
			int n = rand.nextInt (100) +1; // Random between 1 and 100
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Welcome to High and Low. You should guess a number between 1 and 100. Let's begin!");
			
			String text = "";
			String hint = "";
			
			//Checks if guess is correct, or should be higher/lower
			for(int i =1; i <=10; i++){
				System.out.print("Guess "+i+": ");			
				int guess = scanner.nextInt();
	
				if(guess > 0 && guess <= 100){
					if(guess == n){
						if(i == 1){
							text = "Correct after only "+i+" guess!";
						}
						else{
							text = "Correct after only "+i+" guesses!";
						}
						break;
					}
					else{
						if(guess < n){
							hint = "Higher!";
						}
						else{
							hint = "Lower!";
						}
						System.out.println("Hint: "+hint);
						text = "Sorry, you lost.";
					}
				}
				else{
					throw new Exception("You provided an incorrect number, try again!");
				}

			}		
			System.out. println (text);

			scanner.close();
		}
		catch(Exception e){
			if(e.getMessage() != null){
				System.out.println(e.getMessage());
			}
			else{
				System.out.println("Something went wrong. Try again!");
			}
		}
	}

}
