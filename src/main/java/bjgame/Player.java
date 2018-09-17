package bjgame;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Player {

	private Hand pHand1;
	//private Hand pHand2;
	private boolean blackjack;
	
	public Player() {
		pHand1 = new Hand();
		blackjack = false;
	}
	public Hand getHand1() {return pHand1;}
	
	public void firstTwoDraw(Card card1, Card card2) {
		pHand1.addCard(card1);
		pHand1.addCard(card2);
		if(card1.getRank().getValue() + card2.getRank().getValue() == 21) {
			blackjack = true;
		}

	}
	public void hit(Card card) {
		pHand1.addCard(card);
		
	}
	
	public boolean isBlackjack() {
		return blackjack;
		
	}
		
	
//	public boolean isBlackjack() {
//	return blackjack;
//}

		
	

}
