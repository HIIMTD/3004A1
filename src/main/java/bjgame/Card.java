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
		String s = c.substring(0,1);
		String r = c.substring(1);
		try {
			suit = CardSuit.valueOf(s);
			rank = CardRank.getCardRank(r);
		} catch (RuntimeException e) {
			System.out.println("Invalid Card name:" + c);
			throw new RuntimeException(e);
		}
		
		if (suit == null || rank == null) {
			System.out.println("Invalid card name: " + c);
			throw new RuntimeException("Invalid card name: " + c);
		}
		
//		if (r.equals("A")) rank = getRank().ACE;
//		else if (r.equals("J")) rank = getRank().JACK;
//		else if (r.equals("Q")) rank = getRank().QUEEN;
//		else if (r.equals("K")) rank = getRank().KING;
//		else if(Integer.parseInt(r) == 2) rank = getRank().TWO;
//		else if(Integer.parseInt(r) == 3) rank = getRank().THREE;
//		else if(Integer.parseInt(r) == 4) rank = getRank().FOUR;
//		else if(Integer.parseInt(r) == 5) rank = getRank().FIVE;
//		else if(Integer.parseInt(r) == 6) rank = getRank().SIX;
//		else if(Integer.parseInt(r) == 7) rank = getRank().SEVEN;
//		else if(Integer.parseInt(r) == 8) rank = getRank().EIGHT;
//		else if(Integer.parseInt(r) == 9) rank = getRank().NINE;
//		else if(Integer.parseInt(r) == 10) rank = getRank().TEN;

		//else rank = Integer.parseInt(r);
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
