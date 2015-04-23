package CountWords;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IdentyfyWordsMain {
	
	 public static void main (String[] args){ 
         try{
	         String newLine = ""; 
	         String originalText = "";
	         
	         String path=System.getProperty("user.dir");
	         String filePath = path+ ("\\src\\HistoryOfProgramming.txt"); 
	         String fileWrite = path +("\\src\\words.txt");            

             File file = new File(filePath); 
              
             Scanner scan = new Scanner(file); 
             PrintWriter write = new PrintWriter(fileWrite); 
             
             originalText = new Scanner(file).useDelimiter("\\A").next();
             
             while (scan.hasNextLine()){ 
                 String text = scan.nextLine(); 
                 newLine += "\n" + text.replaceAll("[^a-zA-Z]+"," ");                   
             } 
             
             write.println(newLine); 

             System.out.println("TEXT"); 
             System.out.println("====="); 
             System.out.println(originalText); 
             
             System.out.println("\nSEQUENCE OF WORDS"); 
             System.out.println("================="); 
             System.out.println(newLine); 
             scan.close(); 

             write.close(); 

         } catch (FileNotFoundException e){ 
             System.out.println(e.getMessage()); 
         } 
     } 

}
