package bjgame;

import java.util.List;

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
			System.out.println("shuffle cards");
		}
		player.reset();
		dealer.reset();
		
		player.firstTwoDraw(deck.draw(), deck.draw());
		dealer.firstTwoDraw(deck.draw(), deck.draw());
	}
	
	public void startFileGame(List<String> commands) throws RuntimeException {
		if (commands.size() < 4) {
			throw new RuntimeException("invalid commands: " + commands);
		}
		player.reset();
		dealer.reset();
		
		Card card1 = new Card(commands.get(0));
		Card card2 = new Card(commands.get(1));
		Card card3 = new Card(commands.get(2));
		Card card4 = new Card(commands.get(3));
		
		player.firstTwoDraw(card1, card2);
		dealer.firstTwoDraw(card3, card4);
		
		printGameStatus();
		if (hasWinner(false) != 0) {
			return;
		}
		
		boolean gameOver = false;
		for (int i = 4; i < commands.size() && !gameOver; i++) {
			String command = commands.get(i);
			switch (command) {
			case "H":
				System.out.println("Player hits");
				if (commands.get(i+1) == null) {
					throw new RuntimeException("invalid commands, there should be a card after Hit");
				}
				Card card = new Card(commands.get(i+1));
				player.hit(card);
				player.printHands();
				i++;
				if (hasWinner(false) != 0) {
					gameOver = true;
				}
				break;
			case "S":
				System.out.println("Player stands");
				for (int j = i+1; j < commands.size(); j++) {
					if (dealer.stand()) {
						System.out.println("Dealer stand cannot accept any more cards");
						throw new RuntimeException("Dealer stand cannot accept any more cards");
					}
					card = new Card(commands.get(j));
					System.out.println("Dealer hit");
					dealer.hit(card);
					dealer.printHands();
				}
				
				if (!dealer.stand()) {
					System.out.println("Dealer cannot stand, has to hit");
					throw new RuntimeException("Dealer cannot stand, has to hit");
				}
				hasWinner(true);
				gameOver = true;
				break;
			default:
			}
		}
		
		if (hasWinner(false) == 0) {
			System.out.println("Game is not over, player has to hit or stand");
		}
		
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
		System.out.println("Player get " + player.getHand1().getHandcards());
		System.out.println("Player has " + player.getHand1().getPoints()+ " points");
		System.out.println("Dealer get card " + dealer.getHand1().getHandcards().get(0) + " face up");
		//System.out.println("Dealer has " + dealer.getHand1().getPoints()+" points");
	}
}
