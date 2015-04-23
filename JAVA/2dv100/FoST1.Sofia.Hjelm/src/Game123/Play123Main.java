package Game123;

public class Play123Main {
	
	public static boolean playGame(){
		Deck deck = new Deck();
		
		int correct = 0;
		
		for(int i = 1; i < 4; i++){
			Card card = deck.handOutNextCard();
			if(card.getRank() != i){
				correct++;
			}
		}
		if(correct == 3){
			return true;
		}
		return false;
		
	}
	public static void main(String[] args) {
		double maxTimes = 1000;
		double win = 0;
		
		//Computes the probability of winning the game
		for (int i = 0; i < maxTimes; i++){
			boolean didYouWin = playGame();	
			if(didYouWin == true){
				win++;
			}
		}	
		double probability = win/maxTimes;
		
		System.out.println("The chance of winning this game is: " + probability +"%");
		
	}
}
