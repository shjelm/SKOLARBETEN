package CountWords;

public class Word implements Comparable<Word> {
	
	public static void main( String args[] )  // Test for Word
	{
		Word newWord = new Word("Choklad");
		Word equalWord = new Word("CHOKLAD");
		Word anotherWord = new Word("Ostbågar");
		Word anotherWord2 = new Word("Boll");
		Word anotherWord3 = new Word("Apa");
		
		System.out.println(newWord.toString()); // => Choklad
//		
		System.out.println(newWord.hashCode() == equalWord.hashCode()); // =>TRUE
		System.out.println(newWord.hashCode() == anotherWord.hashCode()); // =>FALSE
//		
		System.out.println(newWord.equals(equalWord)); // TRUE
		
		System.out.println(newWord.equals(anotherWord)); // FALSE
		
		System.out.println(newWord.compareTo(anotherWord)); 
		System.out.println(newWord.compareTo(equalWord)); 
		System.out.println(newWord.compareTo(anotherWord2)); 
		System.out.println(newWord.compareTo(anotherWord3)); 
//		
	}
	
	private String word;

	public Word(String str) {
		word = str;
	}
	
	public String toString() { 
		return word; 
	}
	
	/* Override Object methods */
	@Override
	public int hashCode() { //Blir fel eftersom orden är olika långa. Hur lösa?
		int hc = 0;
		for ( int i=0;i<word.length();i++) {
			char c = word.toLowerCase().charAt(i);
			hc += Character.getNumericValue(c);
//			hc = hc/word.length()*100;
			}
		return hc;
		
//		return word.toLowerCase().hashCode();
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof Word) {
			Word otherWord = (Word) other;
			return word.toLowerCase().equals(otherWord.word.toLowerCase()); 
		}
		return false ;
	}
	
	/* Implement Comparable */
	@Override
	public int compareTo(Word w) {
		System.out.println(hashCode());
		System.out.println(w.hashCode());
        if(hashCode() < w.hashCode()){
        	return -1;
        }
        else if(hashCode() > w.hashCode()){
        	return 1;
        }
        else{
        	return 0;
        }
		//return word.toLowerCase().compareTo(w.word.toLowerCase());
	}
}
