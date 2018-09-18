package bjgame;

public class Card {
	
	private CardRank rank;
	private CardSuit suit;
	
	//cons
	public Card(CardSuit suit, CardRank rank){
		this.suit = suit;
		this.rank = rank;
	}
	
	public Card(String c) {

	}
	
	//get function
	public CardSuit getSuit() {return suit;}
	public CardRank getRank() {return rank;}
	
	public String getShortName() {
		return suit.toString() + rank.getName();
	}
	
//	public String getLongName() {
//		return rank.getName() + " of " + suit.toString() + "s";
//	}
	
	public String toString() {
		return getShortName();
	}
	
}
