package bjgame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.NotActiveException;
import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.omg.PortableServer.POAPackage.WrongAdapter;

public class GameConsole {
	
	public static ArrayList<String> readFile(){
		
		Scanner f = new Scanner(System.in);
		String filename = f.nextLine();
		String path = "scr/main/resources/" + filename;
		String line = null;
		String temp = "";
		try {
	        // FileReader reads text files in the default encoding.
	        FileReader fileReader =
	            new FileReader(path);

	        BufferedReader bufferedReader =
	            new BufferedReader(fileReader);
	        		while((line = bufferedReader.readLine()) != null) {
	            temp += line;
        		}
	     
	        bufferedReader.close();
	        String[] arr = temp.split("\\s+");
		    ArrayList<String> tempList = new ArrayList<String>();
		    tempList.addAll(Arrays.asList(arr));
		    System.out.println(tempList);
		    //tempList.get();
			
	    }
		catch(FileNotFoundException e){
			System.out.println("Wrong filename or file not exist");
		}
	    catch(IOException ex) {
	        System.out.println("Error reading file '"+ filename + "'");
	    }
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean stop = false;
		Scanner s = new Scanner(System.in);
		while (!stop) {
			System.out.println("Welcome, please choose the game mode: \n"
					+ "C - console\n"
					+ "F - file input\n"
					+ "Q - quit");
			
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
						System.out.println("h - hit\n"
								+ "s = stand");
						String playerMove = s.nextLine();
						if (playerMove.equals("S")) {
							break;
						}
						if (playerMove.equals("H")) {
							g.getPlayer().hit(g.getDeck().draw());
							System.out.println("Player get" + g.getPlayer().getHand1().getHandcards());
							System.out.println("Player has " + g.getPlayer().getHand1().getPoints()+ " points");
						}
					}
					if(!g.getPlayer().isBusted()) {
					System.out.println("Dealer get" + g.getDealer().getHand1().getHandcards());
					System.out.println("Dealer has " + g.getDealer().getHand1().getPoints()+" points");
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
					System.out.println("press C to continuue with a new game, press any other key to quit");
					if (!s.nextLine().equals("C")) {
						isContinue = false;
					} 
				}
				break;
			case "F":
				boolean isContinuef = true;
				while(isContinuef) {
				System.out.println("Please provide the file name:");
				ArrayList<String> getInput = new ArrayList<String>();
				GameConsole.readFile();
			
//				String commands= "";
//				g = new Game();
//				g.startFileGame(commands);
//						
//				break;
				System.out.println("press C to continuue input file name, press any other key to quit");
				if (!s.nextLine().equals("C")) {
					isContinuef = false;
				} 
				break;
				}
			case "Q":
				stop = true;
				break;
			default:
				System.out.println("Invalid input, ");
			}
		}
		s.close();

	}

}
