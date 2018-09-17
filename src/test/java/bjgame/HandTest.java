package bjgame;


import junit.framework.TestCase;

public class HandTest extends TestCase{
	
	//test add point 
	public void testAddPoints1() {
		Hand handcards = new Hand();
		handcards.addCard(new Card(CardSuit.S, CardRank.KING));
		assertEquals(10, handcards.getPoints());
		handcards.addCard(new Card(CardSuit.H, CardRank.SEVEN));
		assertEquals(17, handcards.getPoints());
				
	}
	
	//ACE tests from professor
	public void testACE1() {
		Hand handcards = new Hand();
		handcards.addCard(new Card(CardSuit.S, CardRank.ACE));
		handcards.addCard(new Card(CardSuit.H, CardRank.ACE));
		handcards.addCard(new Card(CardSuit.C, CardRank.EIGHT));
		assertEquals(20, handcards.getPoints());
				
	}
	
	public void testACE2() {
		Hand handcards = new Hand();
		handcards.addCard(new Card(CardSuit.S, CardRank.ACE));
		handcards.addCard(new Card(CardSuit.H, CardRank.ACE));
		handcards.addCard(new Card(CardSuit.H, CardRank.EIGHT));
		handcards.addCard(new Card(CardSuit.S, CardRank.NINE));
		assertEquals(19, handcards.getPoints());
				
	}
	
	
	public void testACE3() {
		Hand handcards = new Hand();
		handcards.addCard(new Card(CardSuit.S, CardRank.ACE));
		handcards.addCard(new Card(CardSuit.H, CardRank.FIVE));
		handcards.addCard(new Card(CardSuit.D, CardRank.ACE));
		assertEquals(17, handcards.getPoints());
		handcards.addCard(new Card(CardSuit.C, CardRank.TEN));
		assertEquals(17, handcards.getPoints());

				
	}
	
	
	//test blackjack
//	public void testIsBackJack() {
//		Hand hand = new Hand();
//		hand.addCard(new Card(CardSuit.C, CardRank.ACE));
//		assertFalse(hand.isBlackjack());
//		
//		hand.addCard(new Card(CardSuit.S, CardRank.KING));
//		assertTrue(hand.isBlackjack());
//	}
	
	//test burst
//	public void testIsBusted1() {
//		Hand hand = new Hand();
//		hand.addCard(new Card(CardSuit.C, CardRank.KING));
//		hand.addCard(new Card(CardSuit.C, CardRank.QUEEN));
//		hand.addCard(new Card(CardSuit.C, CardRank.JACK));
//		assertTrue(hand.isBusted());
//		
//	}
	
//	public void testIsBusted2() {
//		Hand hand = new Hand();
//		hand.addCard(new Card(CardSuit.C, CardRank.NINE));
//		hand.addCard(new Card(CardSuit.H, CardRank.ACE));
//		hand.addCard(new Card(CardSuit.S, CardRank.ACE));
//		assertFalse(hand.isBusted());
//		
//	}

}
