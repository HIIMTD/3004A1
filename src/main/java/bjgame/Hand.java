package bjgame;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<Card> cards = new ArrayList<>();
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public int getValue() {
		return 0;
	}
	
	public boolean isBlackJack() {
		return false;
	}
	
	public boolean isBusted() {
		return false;
	}
	
	private boolean isSoft17() {
		return false;
	}
	public boolean canDealerHit() {
		if (getValue() < 17 || isSoft17() ) {
			return true;
		}
		
		return false;
	}
}