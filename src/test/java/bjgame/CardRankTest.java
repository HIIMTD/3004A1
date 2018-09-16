package bjgame;

import junit.framework.TestCase;

public class CardRankTest extends TestCase {
	
	public void testRankValue() {
		assertEquals(10, CardRank.JACK.getValue());
	}
	

	public void testRankName() {
		assertEquals("J", CardRank.JACK.getName());
	}

	public void testGetRank() {
		assertEquals(CardRank.JACK, CardRank.valueOf("JACK"));
		assertEquals(CardRank.JACK, CardRank.getCardRank("J"));

		assertEquals(CardRank.NINE, CardRank.valueOf("NINE"));
		assertEquals(CardRank.NINE, CardRank.getCardRank("9"));
	}
	
	public void testGetValue() {
		assertEquals(10, CardRank.JACK.getValue());
	}
}
