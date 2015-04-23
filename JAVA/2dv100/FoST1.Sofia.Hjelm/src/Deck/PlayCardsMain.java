package Deck;

public class PlayCardsMain {

	public static void main(String[] args) {
		/*Program PlayCardsMain, creates a deck and deals some cards, 
		 * tells the number of remaining cards and which cards that have been dealt.*/		
		Deck d = new Deck();
		
		System.out.println(d.handOutNextCard());
		System.out.println(d.handOutNextCard());
		System.out.println(d.handOutNextCard());
		System.out.println(d.handOutNextCard());
		System.out.println(d.handOutNextCard());
		
		System.out.println("Cards left in deck: " + d.deckSize());
		}

}
