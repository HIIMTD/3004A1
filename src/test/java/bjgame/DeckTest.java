package bjgame;

import junit.framework.TestCase;

public class DeckTest extends TestCase {

	public void testCons() {
		Deck deck = new Deck();

		assertEquals(0, deck.size());
	}

	public void testCreateDeck() {
		Deck deck = new Deck();
		deck.createDeck();
		assertEquals(52, deck.size());
	}

	public void testShuffle() {
		Deck deck1 = new Deck();
		Deck deck2 = new Deck();
		deck1.createDeck();
		deck2.createDeck();
		int duplicate = 0;
		for (int i = 0; i < 52; i++) {
			Card a = deck1.draw();
			Card b = deck2.draw();
			if (a.getSuit() == b.getSuit() && a.getRank()==b.getRank()) {
				duplicate++;
			}
		assertTrue(duplicate<5);
			
		}
		


		// assertEquals(deck1,deck2);
		// deck2.shuffle();
		// assertFalse(deck1.equals(deck2));
	}
}
