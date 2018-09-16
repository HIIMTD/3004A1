package bjgame;

import junit.framework.TestCase;

public class CardSuitTest extends TestCase{

	public void testGetSuit() {
		assertEquals(CardSuit.S, CardSuit.valueOf("S"));
	}
}
