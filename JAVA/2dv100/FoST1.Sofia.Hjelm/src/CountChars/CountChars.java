package CountChars;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountChars {
	//Counts chars in a .txt
	public static void countCharsMain(String searchPath) throws FileNotFoundException{
		try{
		String text = new Scanner(new File(searchPath))
		    .useDelimiter("\\A").next();
		
		int upper = 0, lower = 0, whitespace = 0, other = 0, numbers = 0;
		for(int i = 0; i < text.length(); i++){
			char x = text.charAt(i);
			if(Character.isUpperCase(x)){
				upper++;
			}
			else if(Character.isLowerCase(x)){
				lower++;
			}			
			else if(Character.isDigit(x)){
				numbers++;
			}			
			else if(Character.isWhitespace(x)){
				whitespace++;
			}
			else{
				other++;
			}
		}
		
		System.out.println("Upper case letters: "+upper);
		System.out.println("Lower case letters: "+lower);
		System.out.println("Whitespaces: "+whitespace);
		System.out.println("Other characters: "+other);
		System.out.println("Numbers: "+numbers);

		}
		catch(Exception e){
			System.out.println(e.getMessage());			
		}
	}
	
	public static void main(String [] args){
		try{
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("Type in path to the source file: "); 		
			String path = scanner.nextLine ();  /*If you want to provide a static path instead 
												/of reading it from the keyboard, do it here
												/ ==> String path = C:\Users\....*/
			countCharsMain(path);
			
			scanner.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
		
		
}
