package CountWords;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class WordCount1Main {
	
	public static void main (String[] args){ 
		HashSet<Word> hashSet = new HashSet<Word>();
		TreeSet<Word> treeSet = new TreeSet<Word>();
		
		try{			
			String path=System.getProperty("user.dir");
			String sourcePath = path+ ("\\src\\words.txt"); 
		    File file = new File(sourcePath); 
		    
		    Scanner scan = new Scanner(file);
		    
		    while (scan.hasNext()){ 
		        String text = scan.next();
		        hashSet.add(new Word(text));
		        treeSet.add(new Word(text));
			}
		    //Test code for the class
//		    System.out.println(hashSet.size()); //=> 350
//		    System.out.println(hashSet.toString()); // All elelements
		    System.out.println(treeSet.size()); //=> 350
		    System.out.println(treeSet.toString()); // Alphabetical order
		    
//		    for (Iterator<Word> iter = treeSet.iterator(); iter.hasNext(); ) {
//		        System.out.println((Word) iter.next());
//		    }ast());
		    
		    scan.close();
		}
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}
	}
}
