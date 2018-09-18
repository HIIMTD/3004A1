package bjgame;

public class Game {
	private Player player;
	private Dealer dealer;
	private Deck deck;
	//private boolean end;

	public Game() {
		player = new Player();
		dealer = new Dealer();
		deck = new Deck();
		//end = false;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Dealer getDealer() {
		return dealer;
	}
	
	public Deck getDeck() {
		return deck;
	}
	
	
	public void startConsoleGame() {
		if (deck.size() < 15) {
			deck.createDeck();
			System.out.println("Not enought cards, shuffle cards");
		}
		player.reset();
		dealer.reset();
		
		player.firstTwoDraw(deck.draw(), deck.draw());
		dealer.firstTwoDraw(deck.draw(), deck.draw());
	}
	
	public void startFileGame(String commands) {
		player.reset();
		dealer.reset();
	}
//	
//	public boolean isEnd() {
//		if(player.isBlackjack() && !dealer.isBlackjack()) {
//			System.out.println("Player wins by BJ");
//			end = true;
//		}else if(!(player.isBlackjack()) && dealer.isBlackjack()) {
//			System.out.println("Dealer wins by BJ");
//			end = true;
//		}else if(player.isBlackjack() && dealer.isBlackjack()) {
//			System.out.println("Dealer wins by tie BJ");
//			end = true;
//		}else if(player.isBusted()) {
//			System.out.println("Player busted, Dealer wins");
//			end = true;
//		}
//		else if(!player.isBusted() && player.getHand1().getPoints() > dealer.getHand1().getPoints()) {
//			System.out.println("Player wins by higher points");
//		}else if(!player.isBusted() && player.getHand1().getPoints() <= dealer.getHand1().getPoints()) {
//			System.out.println("Dealer wins by higher points or tie");
//		}else if(!player.isBusted() && dealer.isBusted()) {
//			System.out.println("Dealer Busted, Player wins");
//			end = true;
//		}
//		return end;
//	}
//	
	/**
	 * 
	 * @param dealerStand
	 * 
	 * @return 0 = no winner, 1 = dealer wins, 2 = player wins
	 */
	public int hasWinner(boolean dealerStand) {
		if(player.isBlackjack() && !dealer.isBlackjack()) {
			System.out.println("Player wins by BJ");
			return 2;
		}else if(!(player.isBlackjack()) && dealer.isBlackjack()) {
			System.out.println("Dealer wins by BJ");
			return 1;
		}else if(player.isBlackjack() && dealer.isBlackjack()) {
			System.out.println("Dealer wins by tie BJ");
			return 1;
		}else if(player.isBusted()) {
			System.out.println("Player busted, Dealer wins");
			return 1;
		}else if(!player.isBusted() && dealer.isBusted()) {
			System.out.println("Dealer Busted, Player wins");
			return 2;
		} else if (!dealerStand) {
			return 0;
		} else {
			if (player.getHand1().getPoints() > dealer.getHand1().getPoints()) {
				System.out.println("Player wins by higher points");
				return 2;
			} else {
				System.out.println("Dealer wins by higher points or tie");
				return 1;
			}
		}
	}
	
	public void printGameStatus() {
		System.out.println("Player get" + player.getHand1().getHandcards());
		System.out.println("Player has " + player.getHand1().getPoints()+ " points");
		System.out.println("Dealer get card " + dealer.getHand1().getHandcards().get(0) + " face up");
		//System.out.println("Dealer has " + dealer.getHand1().getPoints()+" points");
	}
}
