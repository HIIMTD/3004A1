package bjgame;

public class Dealer {

	private Hand pHand1 = new Hand();
	// private Hand pHand2;
	private boolean blackjack;
	private boolean bust;
	private boolean isSoft17;

	public Dealer() {
		reset();
	}
	
	public void reset() {
		pHand1.reset();
		blackjack = false;
		bust = false;
		isSoft17 = false;
	}
	

	public Hand getHand1() {
		return pHand1;
	}

	public void firstTwoDraw(Card card1, Card card2) {
		pHand1.addCard(card1);
		pHand1.addCard(card2);
		if (card1.getRank().getValue() + card2.getRank().getValue() == 21) {
			blackjack = true;
		}

	}

	public void hit(Card card) {
		pHand1.addCard(card);

	}

	public boolean isBlackjack() {
		return blackjack;

	}

	public boolean isSoft17() {
		if (pHand1.getPoints() == 17 && pHand1.numberOfAce == 1 && pHand1.numberOfTen == 0) {
			isSoft17 = true;
		}
		return isSoft17;
	}

	public boolean isBusted() {
		if (pHand1.getPoints() > 21) {
			bust = true;
		}
		return bust;
	}

	public boolean stand() {
		if (pHand1.getPoints() < 17 || isSoft17()) {
			return false;
		}
		return true;
	}
	
	public void printHands() {
		System.out.println("Dealer hand " + pHand1.getHandcards() + " - " + pHand1.getPoints());
	}
}
