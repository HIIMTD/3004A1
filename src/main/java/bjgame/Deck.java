package bjgame;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	public List<Card> deck;


//cons
	public Deck() {
		this.deck = new ArrayList<Card>();
	}
	
	public void createDeck() {
		for(CardSuit suit : CardSuit.values() ) {
			for(CardRank rank: CardRank.values()) {
				this.deck.add(new Card(suit, rank));
			}
				
		}
		Collections.shuffle(deck);
		
//		for (int i = 0; i < deck.size(); i++) {
//			System.out.println(deck.get(i));
//		}
	}
	

	public int size() {
		return deck.size();
		
	}
	
	public Card draw() {
		return deck.remove(deck.size()-1);
	}
}
