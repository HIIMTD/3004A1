package bjgame;


import junit.framework.TestCase;

public class HandTest extends TestCase{
	
	//test add point 
	public void testAddPoints() {
		Hand handcards = new Hand();
		handcards.addCard(new Card(CardSuit.S, CardRank.KING));
		assertEquals(10, handcards.getPoints());
		handcards.addCard(new Card(CardSuit.H, CardRank.SEVEN));
		assertEquals(17, handcards.getPoints());
				
	}
	
	//test blackjack
	public void testIsBackJack() {
		Hand hand = new Hand();
		hand.addCard(new Card(CardSuit.C, CardRank.ACE));
		assertFalse(hand.isBlackjack());
		
		hand.addCard(new Card(CardSuit.S, CardRank.KING));
		assertTrue(hand.isBlackjack());
	}
	
	//test burst
	public void testIsBusted() {
		Hand hand = new Hand();
		hand.addCard(new Card(CardSuit.C, CardRank.KING));
		hand.addCard(new Card(CardSuit.C, CardRank.QUEEN));
		hand.addCard(new Card(CardSuit.C, CardRank.JACK));
		assertTrue(hand.isBusted());
		
	}

}
