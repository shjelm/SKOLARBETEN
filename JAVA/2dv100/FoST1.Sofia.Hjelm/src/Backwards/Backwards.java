package Backwards;
import java.util.Scanner;

public class Backwards {
	//Reads a string from the keyboard, prints it backwards
	public static void main(String[] args){	
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Write something: "); 		
		String text = scanner.nextLine (); 
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(text);		
		sb.reverse();
		
		text = sb.toString();
		
		System.out.print("Backwards: "+text);
		
		scanner.close();
	}

}
