package bjgame;


import junit.framework.TestCase;

public class HandTest extends TestCase{
	
	public void testAddPoints() {
		Hand handcards = new Hand();
		handcards.addCard(new Card(CardSuit.S, CardRank.KING));
		assertEquals(10, handcards.getScore());
				
	}
	public void testIsBackJack() {
		Hand hand = new Hand();
		hand.addCard(new Card(CardSuit.C, CardRank.ACE));
		assertFalse(hand.isBlackJack());
		
		hand.addCard(new Card(CardSuit.S, CardRank.KING));
		assertTrue(hand.isBlackJack());
	}
	

	public void testIsBusted() {
		
	}

}
