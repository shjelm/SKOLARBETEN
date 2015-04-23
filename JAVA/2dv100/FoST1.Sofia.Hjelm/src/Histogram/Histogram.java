package Histogram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Histogram {
	//Reads int from file, and prints a histogram
	private static ArrayList<Integer> getIntegers(String path)throws FileNotFoundException{
		ArrayList<Integer> intList = new ArrayList<Integer>();
		try 
		{			
			Scanner fileScan = new Scanner(new File(path)).useDelimiter(",\\s*|\\s*,|\n|\r\n|\\s+");
			
			//Reads all int(1,200)
			while(fileScan.hasNextInt())
			{
				int x = fileScan.nextInt();
				if(x >0 && x<=200){
					intList.add(x); 
				}
			}			
		} 
		catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(0);
		}
		return intList;
	}
	
	private static void showHistogram(ArrayList<Integer> intList, String path) {
		try{
			int onetToHundred = 0; 
			int theRest = 0;
			
			int x1 = 0, x2 = 0, x3 = 0, x4 = 0, x5 = 0, x6 = 0,
					x7 = 0, x8 = 0, x9 = 0, x10 = 0;
			
			for(int i = 0; i < intList.size(); i++){
				int x = (int) intList.get(i);
				if(x <= 100){
					onetToHundred++;
					if(x <=10){
						x1++;
					}
					else if(x<=20){
						x2++;
					}
					else if(x<=30){
						x3++;
					}
					else if(x<=40){
						x4++;
					}
					else if(x<=50){
						x5++;
					}
					else if(x<=60){
						x6++;
					}
					else if(x<=70){
						x7++;
					}
					else if(x<=80){
						x8++;
					}
					else if(x<=90){
						x9++;
					}
					else {
						x10++;
					}
				}
				else{
					theRest++;
				}
			}
			System.out.println("Reading integers from file: "+path);
			System.out.println("Number of integers in the interval[1,100]: "+ onetToHundred);
			System.out.println("in the interval[101,200]: "+ theRest);
			System.out.println("");
			
			System.out.println("HISTOGRAM");
			System.out.println("  1 - 10    | "+ getAsterix(x1));
			System.out.println("  11 - 20   | "+ getAsterix(x2));
			System.out.println("  21 - 30   | "+ getAsterix(x3));
			System.out.println("  31 - 40   | "+ getAsterix(x4));
			System.out.println("  41 - 50   | "+ getAsterix(x5));
			System.out.println("  51 - 60   | "+ getAsterix(x6));
			System.out.println("  61 - 70   | "+ getAsterix(x7));
			System.out.println("  71 - 80   | "+ getAsterix(x8));
			System.out.println("  81 - 90   | "+ getAsterix(x9));
			System.out.println("  91 - 100  | "+ getAsterix(x10));
			System.out.println("  101 - 200 | "+ getAsterix(theRest));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	private static String getAsterix(int x) {
		String str = "";
		for(int i = 0; i < x; i++){
			str += "*";
		}
		return str;
	}

	public static void main(String[] args)throws FileNotFoundException {
		try{
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("Type in path to the source file: "); 		
			String path = scanner.nextLine (); 						/* Path can be replaced with
			 														* a static path if wanted
																	* ==> path = C:\Users\.... */
			ArrayList<Integer> intList = getIntegers(path);
			showHistogram(intList, path);
			scanner.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	

}
