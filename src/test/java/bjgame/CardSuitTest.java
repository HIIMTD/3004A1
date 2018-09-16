package bjgame;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardSuitTest {
	@Test
	public void testGetSuit() {
		assertEquals("Incorrect suit", CardSuit.S, CardSuit.valueOf("S"));
	}
}
