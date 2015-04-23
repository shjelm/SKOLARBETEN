package Backwards.java;
import java.util.Scanner;

public class Backwards {
	public static void main(String[] args){	
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Write something: "); 		
		String text = scanner.nextLine (); 
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(text);		
		sb.reverse();
		
		text = sb.toString();
		
		System.out.print("Backwards: "+text);
	}

}
