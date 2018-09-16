package bjgame;

import junit.framework.TestCase;

public class CardsTest extends TestCase{
	
	public void testConstructor() {
		Cards card = new Cards(CardSuit.S, CardRank.JACK);
		assertEquals(CardRank.JACK, card.getRank());
		assertEquals(CardSuit.S, card.getSuit());
	}
	
	public void testToString1() {
		Cards card = new Cards(CardSuit.H, CardRank.JACK);
		assertEquals("HJ", card.toString());
	}
}
