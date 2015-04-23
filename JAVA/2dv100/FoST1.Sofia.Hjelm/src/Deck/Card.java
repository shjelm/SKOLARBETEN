package Deck;

public class Card {
	private static enum Suite {
	    hearts(0), diamonds(1), spades(2), clover(3); 
	    
	    private Suite(int value) {
        }
	};
	
	private static enum Rank {
	    ace(1), two(2), three(3), four(4), five(5), six(6), seven(7), 
	    eight(8), nine(9), ten(10), jack(11), queen(12), king(13); 
	    
	    private Rank(int value) {
        }
	}
	
	private Suite cardSuite = null;
	private Rank cardRank = null;
	
	public Card(int suite, int rank){
			cardSuite = Suite.values()[suite];
			cardRank = Rank.values()[rank];	
	}
	
	public String toString(){
		return "Card is "+cardRank+" of "+cardSuite;
	}
}
