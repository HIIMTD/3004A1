package bjgame;

import java.io.File;
import java.util.Scanner;

public class GameConsole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean stop = false;
		Scanner s = new Scanner(System.in);
		while (!stop) {
			System.out.println("Please choose the game mode: \n"
					+ "c - console\n"
					+ "f - input file\n"
					+ "q - quit");
			
			String input = s.nextLine();
			
			switch (input) {
			case "c":
				Game g = new Game();
				boolean isContinue = true;
				while (isContinue) {
					g.startConsoleGame();
					g.printGameStatus();
					int result = 0;
					while ((result = g.hasWinner(false)) == 0) {
						System.out.println("h - hit\n"
								+ "s = stand");
						String playerMove = s.nextLine();
						if (playerMove.equals("s")) {
							break;
						}
						if (playerMove.equals("h")) {
							g.getPlayer().hit(g.getDeck().draw());
							System.out.println("Player get" + g.getPlayer().getHand1().getHandcards());
							System.out.println("Player has " + g.getPlayer().getHand1().getPoints()+ " points");
						}
					}
					
					if (result == 0) {
						while (!g.getDealer().stand()) {
							g.getDealer().hit(g.getDeck().draw());
							System.out.println("Dealer get" + g.getDealer().getHand1().getHandcards());
							System.out.println("Dealer has " + g.getDealer().getHand1().getPoints()+" points");
						}
						result = g.hasWinner(true);
					}
					
					System.out.println("Game result: " + result);
					System.out.println("c - continuue with a new game");
					if (!s.nextLine().equals("c")) {
						isContinue = false;
					} 
				}
				break;
			case "f":
				System.out.println("Please provide the file path:");
				String filePath = s.nextLine();
				File file = new File(filePath);
				String commands= "";
				g = new Game();
				g.startFileGame(commands);
						
				break;
			case "q":
				stop = true;
				break;
			default:
				System.out.println("Invalid input");
			}
		}
		s.close();

	}

}
