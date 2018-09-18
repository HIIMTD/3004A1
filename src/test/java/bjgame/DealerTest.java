package bjgame;

import junit.framework.TestCase;

public class DealerTest extends TestCase {
	// start without blackjack
	public void testStart1() {
		Dealer dealer = new Dealer();
		dealer.firstTwoDraw(new Card(CardSuit.H, CardRank.ACE), new Card(CardSuit.S, CardRank.NINE));
		assertFalse(dealer.isBlackjack());
		assertEquals(20, dealer.getHand1().getPoints());

	}

	// start with blackjack
	public void testStart2() {
		Dealer dealer = new Dealer();
		dealer.firstTwoDraw(new Card(CardSuit.S, CardRank.TEN), new Card(CardSuit.H, CardRank.ACE));
		assertTrue(dealer.isBlackjack());
		assertEquals(21, dealer.getHand1().getPoints());

	}

	// test if it's soft17

	// 6+11 is soft 17
	public void testSoft17() {
		Dealer dealer = new Dealer();
		dealer.firstTwoDraw(new Card(CardSuit.C, CardRank.SIX), new Card(CardSuit.H, CardRank.ACE));
		assertEquals(17, dealer.getHand1().getPoints());
		assertTrue(dealer.isSoft17());
	}

	// 6+10+1 is not soft17
	public void testSoft172() {
		Dealer dealer = new Dealer();
		dealer.firstTwoDraw(new Card(CardSuit.C, CardRank.SIX), new Card(CardSuit.H, CardRank.KING));
		assertEquals(16, dealer.getHand1().getPoints());
		assertFalse(dealer.isSoft17());
		dealer.hit(new Card(CardSuit.D, CardRank.ACE));
		assertFalse(dealer.isSoft17());
		assertEquals(17, dealer.getHand1().getPoints());
	}

	// 6+9+1+1 is not soft 17
	public void testSoft173() {
		Dealer dealer = new Dealer();
		dealer.firstTwoDraw(new Card(CardSuit.C, CardRank.SIX), new Card(CardSuit.H, CardRank.NINE));
		assertEquals(15, dealer.getHand1().getPoints());
		assertFalse(dealer.isSoft17());
		dealer.hit(new Card(CardSuit.D, CardRank.ACE));
		assertEquals(16, dealer.getHand1().getPoints());
		assertFalse(dealer.isSoft17());
		dealer.hit(new Card(CardSuit.S, CardRank.ACE));
		assertEquals(17, dealer.getHand1().getPoints());
		assertFalse(dealer.isSoft17());
	}

	// 3+3+11 is soft 17
	public void testSoft174() {
		Dealer dealer = new Dealer();
		dealer.firstTwoDraw(new Card(CardSuit.C, CardRank.THREE), new Card(CardSuit.H, CardRank.THREE));
		assertEquals(6, dealer.getHand1().getPoints());
		assertFalse(dealer.isSoft17());
		dealer.hit(new Card(CardSuit.S, CardRank.ACE));
		assertEquals(17, dealer.getHand1().getPoints());
		assertTrue(dealer.isSoft17());
	}

	public void testHit1() {
		Dealer dealer = new Dealer();
		dealer.firstTwoDraw(new Card(CardSuit.H, CardRank.SEVEN), new Card(CardSuit.S, CardRank.NINE));
		assertFalse(dealer.isBlackjack());
		assertEquals(16, dealer.getHand1().getPoints());
		dealer.hit(new Card(CardSuit.S, CardRank.KING));
		assertTrue(dealer.isBusted());
		assertEquals(26, dealer.getHand1().getPoints());
	}

	public void testHit2() {
		Dealer dealer = new Dealer();
		dealer.firstTwoDraw(new Card(CardSuit.H, CardRank.ACE), new Card(CardSuit.S, CardRank.NINE));
		assertFalse(dealer.isBlackjack());
		assertEquals(20, dealer.getHand1().getPoints());
		dealer.hit(new Card(CardSuit.S, CardRank.ACE));
		assertFalse(dealer.isBlackjack());
		assertEquals(21, dealer.getHand1().getPoints());
	}

	public void testHit3() {
		Dealer dealer = new Dealer();
		dealer.firstTwoDraw(new Card(CardSuit.H, CardRank.SEVEN), new Card(CardSuit.S, CardRank.SEVEN));
		assertFalse(dealer.isBlackjack());
		assertEquals(14, dealer.getHand1().getPoints());
		dealer.hit(new Card(CardSuit.D, CardRank.SEVEN));
		assertFalse(dealer.isBlackjack());
		assertEquals(21, dealer.getHand1().getPoints());
	}

	// test dealer busted
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

	// test dealer stand by 20
	public void testStand1() {
		Dealer dealer = new Dealer();
		dealer.firstTwoDraw(new Card(CardSuit.H, CardRank.NINE), new Card(CardSuit.S, CardRank.KING));
		assertEquals(19, dealer.getHand1().getPoints());
		assertTrue(dealer.stand());
	}

	// stand 17 by 7+10
	public void testStand2() {
		Dealer dealer = new Dealer();
		dealer.firstTwoDraw(new Card(CardSuit.H, CardRank.SEVEN), new Card(CardSuit.S, CardRank.TEN));
		assertEquals(17, dealer.getHand1().getPoints());
		assertTrue(dealer.stand());
	}

	// soft 17 by 11+6
	public void testStand3() {
		Dealer dealer = new Dealer();
		dealer.firstTwoDraw(new Card(CardSuit.H, CardRank.SIX), new Card(CardSuit.S, CardRank.ACE));
		assertEquals(17, dealer.getHand1().getPoints());
		assertFalse(dealer.stand());
	}

	// soft 17 by 3+3+11
	public void testStand4() {
		Dealer dealer = new Dealer();
		dealer.firstTwoDraw(new Card(CardSuit.C, CardRank.THREE), new Card(CardSuit.H, CardRank.THREE));
		assertEquals(6, dealer.getHand1().getPoints());
		assertFalse(dealer.stand());
		dealer.hit(new Card(CardSuit.S, CardRank.ACE));
		assertEquals(17, dealer.getHand1().getPoints());
		assertFalse(dealer.stand());
	}

	// 21 by blackjack
	public void testStand5() {
		Dealer dealer = new Dealer();
		dealer.firstTwoDraw(new Card(CardSuit.H, CardRank.TEN), new Card(CardSuit.S, CardRank.ACE));
		assertEquals(21, dealer.getHand1().getPoints());
		assertTrue(dealer.stand());
	}

}
