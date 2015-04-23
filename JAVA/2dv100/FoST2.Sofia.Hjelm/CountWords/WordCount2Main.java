package CountWords;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCount2Main {
	public static void main (String[] args){ 	
		try{			
			HashWordSet hws = new HashWordSet();
			TreeWordSet tws = new TreeWordSet();
			
			String path=System.getProperty("user.dir");
	        String sourcePath = path+ ("\\src\\words.txt"); 
		    File file = new File(sourcePath); 
		    
		    Scanner scan = new Scanner(file);
		    
		    while (scan.hasNext()){ 
		        String text = scan.next();
		        Word w = new Word(text);
		        hws.add(w);
		        tws.add(w);
			}
		    System.out.println(hws.size()); // => 350
		    System.out.println(hws.toString()); // Funkar i princic  
		    
		    System.out.println(tws.size()); // => 350
		    System.out.println(tws.toString()); // 
		    scan.close();
		}
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}
	}
}
