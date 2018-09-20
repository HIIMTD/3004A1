package bjgame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.NotActiveException;
import java.nio.channels.NonWritableChannelException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.omg.PortableServer.POAPackage.WrongAdapter;

public class GameConsole {

	public static List<String> readFile() {
		Scanner f = new Scanner(System.in);
		String filename = f.nextLine();
		String path = Paths.get("src/main/resources", filename).toAbsolutePath().toString();
		String line = null;
		String temp = "";
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(path);

			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				temp += line;
			}

			bufferedReader.close();
			String[] arr = temp.split("\\s+");
			ArrayList<String> tempList = new ArrayList<String>();
			tempList.addAll(Arrays.asList(arr));
			System.out.println(tempList);
			return tempList;

			// tempList.get();

		} catch (FileNotFoundException e) {
			throw new RuntimeException("Wrong filename or file not exist: ", e);
		} catch (IOException ex) {
			throw new RuntimeException("Error reading file '" + filename + "'", ex);
		}
	}
	
	public static boolean hasDuplicatedCards(List<String> inputs) {
		Set<String> set = new HashSet<>();
		for (String s: inputs) {
			if (s.length() >= 2) {
				if (set.contains(s)) {
					System.out.println("Card duplicated: " + s);
					return true;
				}
				set.add(s);
			}
		}
		return false;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean stop = false;
		Scanner s = new Scanner(System.in);
		while (!stop) {
			System.out.println("Welcome, please choose the game mode: \n" + "C - console game\n"
					+ "F - fileinput game\n" + "Q - quit");

			String input = s.nextLine();

			switch (input) {
			case "C":
				Game g = new Game();
				boolean isContinue = true;
				while (isContinue) {
					g.startConsoleGame();
					g.printGameStatus();
					int result = 0;
					while ((result = g.hasWinner(false)) == 0) {
						System.out.println("H - to hit\n" + "S - to stand");
						String playerMove = s.nextLine();
						if (playerMove.equals("S")) {
							break;
						}
						if (playerMove.equals("H")) {
							g.getPlayer().hit(g.getDeck().draw());
							System.out.println("Player get " + g.getPlayer().getHand1().getHandcards());
							System.out.println("Player has " + g.getPlayer().getHand1().getPoints() + " points");
						}
					}
					if (!g.getPlayer().isBusted()) {
						System.out.println("Dealer get " + g.getDealer().getHand1().getHandcards());
						System.out.println("Dealer has " + g.getDealer().getHand1().getPoints() + " points");
					}
					if (result == 0) {
						while (!g.getDealer().stand()) {
							g.getDealer().hit(g.getDeck().draw());
							System.out.println("Dealer get " + g.getDealer().getHand1().getHandcards());
							System.out.println("Dealer has " + g.getDealer().getHand1().getPoints() + " points");
						}
						result = g.hasWinner(true);
					}

					System.out.println("Game result: " + result);
					System.out.println("press C to continuue with a new game, press any other key to quit");
					if (!s.nextLine().equals("C")) {
						isContinue = false;
					}
				}
				break;
			case "F":
				boolean isContinuef = true;
				while (isContinuef) {
					System.out.println("Please provide the file name:");
					List<String> inputs = GameConsole.readFile();
					if (GameConsole.hasDuplicatedCards(inputs)) {
						System.out.println("Invalid file input: " + inputs);
						break;
					}

					Game fileGame = new Game();
					try {
						fileGame.startFileGame(inputs);
					} catch (Throwable e) {
						System.out.println("Invalid file input: " + inputs);
					}
					
//				String commands= "";
//				g = new Game();
//				g.startFileGame(commands);
//						
//				break;
					System.out.println("press C to continuue input file name, press any other key to quit");
					if (!s.nextLine().equals("C")) {
						isContinuef = false;
					}
				
				}
				break;
			case "Q":
				stop = true;
				break;
			default:
				System.out.println("Invalid input, please choose again ");
			}
		}
		s.close();

	}

}
