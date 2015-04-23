package CountDigits;

import java.util.Scanner;

public class CountDigits {
	//Reads an int; prints number of zeroes, odd digits, even digits and the computed sum
	public static void main(String[] args) {
		try{
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("Provide a positive integer: ");
			int n = scanner.nextInt();
			int zeros = 0, odd = 0, even = 0, sum = 0;
			
			scanner.close();
			if (n < 1){
				throw new Exception("Something went wrong. Provide a positive integer next time!");
			}
			else {
				
				String temp = Integer.toString(n);	
				
				for ( int i = 0; i < temp.length(); i++) {
	
					if (temp.charAt(i) == '0')					{
						zeros++;
						continue;
					}
					if((int)temp.charAt(i)%2 == 0 ){	
						even++;
					}
					else  {
						odd++;
					}
					String s = Character.toString(temp.charAt(i));
					sum += Integer.parseInt(s);
				}
				
				System.out.println("Zeros: " + zeros); 
				System.out.println("Odd: " + odd );
				System.out.println("Even: " + even );
				System.out.println("Sum: " + sum );
			}
		}
		catch(Exception e){
			if(e.getMessage() != null){
				System.out.println(e.getMessage());
			}
			else{
				System.out.println("Something went wrong. Provide a positive integer next time!");
			}
		}
		
	}

}
