package bjgame;

import java.util.ArrayList;
import java.util.List;


public class Hand {
	private List<Card> handcards = new ArrayList<Card>();
	private int point;
	int numberOfAce;
	int numberOfTen;


	
	public Hand() {
		reset();
	}
	
	public void reset() {
		handcards.clear();
		point = 0;
		numberOfAce = 0;
		numberOfTen = 0;
	}
	
	public void addCard(Card card) {
		handcards.add(card);
		addPoints();
	}
	
	public List<Card> getHandcards() {
		return handcards;
	}
	
	public void addPoints() {
		int tempPoint = 0;
		int countAce = 0;
		int counterTen = 0;
		for(Card card : this.handcards) {
			if (card.getRank().getValue() == 11) {
				countAce++;
			}
			if(card.getRank().getValue() == 10) {
				counterTen++;
			}
			tempPoint += card.getRank().getValue();
			point = tempPoint;
			numberOfAce = countAce;
			numberOfTen = counterTen;
		}if (tempPoint >21 && numberOfAce > 0) {
			while(countAce > 0) {
			tempPoint -= 10;
			countAce --;
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
	
	
//	public boolean isBlackjack() {
//		return blackjack;
//	}
//	
//	public boolean isBusted() {
//		return bust;
//	}
	

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
