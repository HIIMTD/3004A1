package bjgame;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.PrinterLocation;

public class Hand {
	private List<Card> handcards;
	private int point;
	private boolean blackjack;
	private boolean bust;
	private boolean soft17;
	
	public Hand() {
		this.handcards = new ArrayList<Card>();
		point = 0;
		blackjack = false;
		bust = false;
		soft17 = false;
	}
	
	public void addCard(Card card) {
		handcards.add(card);
		addPoints();
	}
	
	public void addPoints() {
		int tempPoint = 0;
		int numberOfAce = 0;
		for(Card card : this.handcards) {
			if (card.getRank().getValue() == 11) {
				numberOfAce++;
			}
			tempPoint += card.getRank().getValue();
			point = tempPoint;
			
		}
		if (tempPoint > 21 && numberOfAce == 0) {
			bust = true;
			point = tempPoint;
		}else if (tempPoint >21 && numberOfAce > 0) {
			while(numberOfAce > 0) {
			tempPoint -= 10;
			numberOfAce --;
				if (tempPoint <= 21) {
					break;
				}
			}
			point = tempPoint;
			
		}
		

	}
	

	public int getHandSize() {
		return handcards.size();
	}
	
	
	public boolean isBlackjack() {
		return blackjack;
	}
	
	public boolean isBusted() {
		return bust;
	}
	
	private boolean isSoft17() {
		return soft17;
	}
//	public boolean canDealerHit() {
//		if (getValue() < 17 || isSoft17() ) {
//			return true;
//		}
//		
//		return false;
//	}

	public int getPoints() {
		return point;
	}
}
