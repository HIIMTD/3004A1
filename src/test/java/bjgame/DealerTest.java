package bjgame;

import junit.framework.TestCase;

public class DealerTest extends TestCase{
	//start without blackjack
	public void testStart1() {
		Dealer dealer = new Dealer();
		dealer.firstTwoDraw(new Card(CardSuit.H, CardRank.ACE), new Card(CardSuit.S, CardRank.NINE));
		assertFalse(dealer.isBlackjack());
		assertEquals(16, dealer.getHand1().getPoints());
		
	}

	//start with blackjack
	public void testStart2() {
		Dealer dealer = new Dealer();
		dealer.firstTwoDraw(new Card(CardSuit.S, CardRank.TEN), new Card(CardSuit.H, CardRank.ACE));
		assertTrue(dealer.isBlackjack());
		assertEquals(21, dealer.getHand1().getPoints());
		
	}
	
	
	public void testSoft17() {
		Dealer dealer = new Dealer();
		dealer.firstTwoDraw(new Card(CardSuit.C, CardRank.SIX), new Card(CardSuit.H, CardRank.ACE));
		assertEquals(17, dealer.getHand1().getPoints());
		assertTrue(dealer.isSoft17());
	}
	
	
	public void testHit1()  {
		Dealer dealer = new Dealer();
		dealer.firstTwoDraw(new Card(CardSuit.H, CardRank.SEVEN), new Card(CardSuit.S, CardRank.NINE));
		assertFalse(dealer.isBlackjack());
		assertEquals(16, dealer.getHand1().getPoints());
		dealer.hit(new Card(CardSuit.S, CardRank.KING));
		assertTrue(dealer.isBusted());
		assertEquals(26, dealer.getHand1().getPoints());
	}
	
	public void testHit2()  {
		Dealer dealer = new Dealer();
		dealer.firstTwoDraw(new Card(CardSuit.H, CardRank.ACE), new Card(CardSuit.S, CardRank.NINE));
		assertFalse(dealer.isBlackjack());
		assertEquals(20, dealer.getHand1().getPoints());
		dealer.hit(new Card(CardSuit.S, CardRank.ACE));
		assertFalse(dealer.isBlackjack());
		assertEquals(21, dealer.getHand1().getPoints());
	}
	
	public void testHit3()  {
		Dealer dealer = new Dealer();
		dealer.firstTwoDraw(new Card(CardSuit.H, CardRank.SEVEN), new Card(CardSuit.S, CardRank.SEVEN));
		assertFalse(dealer.isBlackjack());
		assertEquals(14, dealer.getHand1().getPoints());
		dealer.hit(new Card(CardSuit.D, CardRank.SEVEN));
		assertFalse(dealer.isBlackjack());
		assertEquals(21, dealer.getHand1().getPoints());
	}
	
	//test dealer busted
	public void testIsBusted1() {
		Dealer dealer = new Dealer();
		dealer.firstTwoDraw(new Card(CardSuit.H, CardRank.KING), new Card(CardSuit.S, CardRank.KING));
		assertFalse(dealer.isBlackjack());
		assertEquals(20, dealer.getHand1().getPoints());
		dealer.hit(new Card(CardSuit.D, CardRank.KING));
		assertFalse(dealer.isBlackjack());
		assertTrue(dealer.isBusted());
		assertEquals(30, dealer.getHand1().getPoints());
		
	}
	
	
}
