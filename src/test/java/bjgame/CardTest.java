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
	
	//test JQK count as 10
	public void testJQKas10() {
		Card card1 = new Card(CardSuit.S, CardRank.JACK);
		assertEquals(10, card1.getRank().getValue());
		
		Card card2 = new Card(CardSuit.H, CardRank.QUEEN);
		assertEquals(10, card2.getRank().getValue());
		
		Card card3 = new Card(CardSuit.D, CardRank.KING);
		assertEquals(10, card3.getRank().getValue());
	}
	
	public void testCardByInput() {
		Card card1 = new Card("CQ");
		assertEquals(CardSuit.C, card1.getSuit());
		assertEquals(CardRank.QUEEN,card1.getRank());
		Card card2 = new Card("HA");
		assertEquals(CardSuit.H, card1.getSuit());
		assertEquals(CardRank.ACE,card1.getRank());
		Card card3 = new Card("D5");
		assertEquals(CardSuit.D, card1.getSuit());
		assertEquals(CardRank.FIVE,card1.getRank());
	}
}
