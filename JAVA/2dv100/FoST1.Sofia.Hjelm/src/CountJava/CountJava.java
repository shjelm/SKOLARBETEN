package CountJava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class CountJava {
	//Prints a numbered list of alla .java in directory and sub-directories
	    public static void findJavaFiles(File directory) throws IOException
	    {    	
	    	try{
	    		int index = 1;
		    	File dir = directory;
				String extension[] = new String[]{"java"};
				System.out.println("Getting all .java files in root directory: " + dir.getCanonicalPath());
				List<File> files = (List<File>) FileUtils.listFiles(dir, extension, true);
				for (File file : files) {
					
					BufferedReader reader = new BufferedReader(new FileReader(file));
					int lines = 0;
					while (reader.readLine() != null) lines++;
					reader.close();	
					
					System.out.println("File "+index+++": "+file.getName()+" Lines = " + lines);		
				}
	    	}
	    	catch(Exception e){
	    		System.out.println(e.getMessage() +". Try again!");
	    	}

	    	
	    }
	    
	public static void main(String[] args) throws IOException {
		try{
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("Type in the directory you want to search: "); 		
			String directory = scanner.nextLine (); /* Can replace directory with static path*/
	        findJavaFiles(new File(directory));
			
	        scanner.close();
		}
        catch(Exception e){
        	System.out.println(e.getMessage());
        }
	}

}
