package bjgame;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	public List<Card> cards;


//cons
	public Deck() {
		this.cards = new ArrayList<Card>();
	}
	
	public void createDeck() {
		cards.clear();
		for(CardSuit suit : CardSuit.values() ) {
			for(CardRank rank: CardRank.values()) {
				this.cards.add(new Card(suit, rank));
			}
				
		}
		Collections.shuffle(cards);
		
//		for (int i = 0; i < deck.size(); i++) {
//			System.out.println(deck.get(i));
//		}
	}
	

	public int size() {
		return cards.size();
		
	}
	
	public Card draw() {
		return cards.remove(cards.size()-1);
	}
}
