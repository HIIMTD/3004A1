package bjgame;

import junit.framework.TestCase;

public class CardTest extends TestCase {

	public void testConstructor() {
		Card card = new Card(CardSuit.S, CardRank.JACK);
		assertEquals(CardRank.JACK, card.getRank());
		assertEquals(CardSuit.S, card.getSuit());
	}

	public void testToString1() {
		Card card = new Card(CardSuit.H, CardRank.JACK);
		assertEquals("HJ", card.toString());
	}
}
