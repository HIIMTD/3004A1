package bjgame;

public class Game {
	private Player player;
	private Dealer dealer;
	private Deck deck;
	private boolean end;

	public Game() {
		player = new Player();
		dealer = new Dealer();
		deck = new Deck();
		end = false;
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
	
	
	public void gameStart() {
		player.firstTwoDraw(deck.draw(), deck.draw());
		dealer.firstTwoDraw(deck.draw(), deck.draw());
	}
	
	public boolean isEnd() {
		if(player.isBlackjack() == true && dealer.isBlackjack() == false) {
			System.out.println("Player wins by BJ");
			end = true;
		}else if(!(player.isBlackjack()) && dealer.isBlackjack()) {
			System.out.println("Dealer wins by BJ");
			end = true;
		}else if(player.isBlackjack() && dealer.isBlackjack()) {
			System.out.print("Dealer wins by tie BJ");
			end = true;
		}else if(!(player.isBlackjack()) && !(dealer.isBlackjack()) && player.getHand1().getPoints() > dealer.getHand1().getPoints()) {
			System.out.println("Player wins by higher points");
			end = true;
		}else if(!(player.isBlackjack()) && !(dealer.isBlackjack()) && player.getHand1().getPoints() <= dealer.getHand1().getPoints()) {
			System.out.println("Dealer wins by higher points or tie");
			end = true;
		}
		return end;
	}
}
