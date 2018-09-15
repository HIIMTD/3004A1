package bjgame;

import junit.framework.TestCase;

public class CardsTest extends TestCase{
	
	public void testConstructor() {
		Cards card = new Cards(Cards.Suit.S,11);
		assertEquals(11, card.getRank);
		assertEquals(Cards.Suit.S, card.getSuit);
	}
	
	public void testToString() {
		Cards card = new Cards(Cards.Suit.H,4);
		assertEquals("H4", card.toString());
	}
	
	public void testToString() {
		Cards card = new Cards(Cards.Suit.D,13);
		assertEquals("DK", card.toString());
	}
}
