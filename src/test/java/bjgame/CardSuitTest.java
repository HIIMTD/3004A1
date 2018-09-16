package bjgame;

import junit.framework.TestCase;

public class CardSuitTest extends TestCase{

	public void testGetSuit() {
		assertEquals("Incorrect suit", CardSuit.S, CardSuit.valueOf("S"));
	}
}
