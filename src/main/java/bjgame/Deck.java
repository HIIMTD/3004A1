package bjgame;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck {
	public ArrayList<Cards> deck;


//cons
	public Deck() {
		this.deck = new ArrayList<Cards>();
	}
	
	public void createDeck() {
		for(Cards.Suit suit : Cards.Suit.values() ) {
			for(int i = 1; i < 14 ; i++)
				this.deck.add(new Cards(suit, i));
		}
		Collections.shuffle(deck);
	}
	/*
	public void shuffle() {
		Collections.shuffle(deck);
	}
	*/
	public int size() {
		return deck.size();
		
	}
}
