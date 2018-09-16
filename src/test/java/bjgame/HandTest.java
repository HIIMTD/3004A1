package bjgame;

import static org.junit.Assert.*;

import org.junit.Test;

public class HandTest {

	@Test
	public void testIsBackJack() {
		Hand hand = new Hand();
		hand.addCard(new Card(CardSuit.C, CardRank.ACE));
		assertFalse(hand.isBlackJack());
		
		hand.addCard(new Card(CardSuit.S, CardRank.KING));
		assertTrue(hand.isBlackJack());
	}
	
	@Test
	public void testIsBusted() {
		
	}

}
