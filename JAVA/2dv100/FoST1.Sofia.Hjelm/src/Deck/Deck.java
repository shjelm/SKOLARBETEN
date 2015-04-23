package Deck;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private static final int SUITE_SIZE = 4;
	private static final int RANK_SIZE = 13;
	private static final int DECK_SIZE = 52;
	
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public Deck()
    {
        for (int suiteIx = 0; suiteIx < SUITE_SIZE; suiteIx++)
        {
            for (int rankIx = 0; rankIx < RANK_SIZE; rankIx++)
            {
                Card c = new Card(suiteIx,rankIx);
                cards.add(c);
            }
        }        
        shuffle();
    }
	
	private void shuffle(){
		Random rnd = new Random();		
		
		if(cards.size() == DECK_SIZE){
	        for (int i = 0; i < DECK_SIZE; i++)
	        {
	            int index = rnd.nextInt((51-1)+1);
	            Card c = cards.get(index);
	            cards.remove(index);
	            cards.add(c);	            
	        }
		}          
	}
	
	public Card handOutNextCard(){		
		Card c = cards.get(0);
        cards.remove(0);
        return c;
	}
	
	public int deckSize(){
		return cards.size();
	}
}
