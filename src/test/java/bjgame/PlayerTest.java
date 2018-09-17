package bjgame;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {
	
	//start without blackjack
	public void testStart1() {
		Player player = new Player();
		player.firstTwoDraw(new Card(CardSuit.H, CardRank.SEVEN), new Card(CardSuit.S, CardRank.NINE));
		assertFalse(player.isBlackjack());
		assertEquals(16, player.getHand1().getPoints());
		
	}
	
	public void testStart2() {
		Player player = new Player();
		player.firstTwoDraw(new Card(CardSuit.C, CardRank.ACE), new Card(CardSuit.S, CardRank.NINE));
		assertFalse(player.isBlackjack());
		assertEquals(20, player.getHand1().getPoints());
		
	}

	//start with blackjack
	public void testStart3() {
		Player player = new Player();
		player.firstTwoDraw(new Card(CardSuit.S, CardRank.TEN), new Card(CardSuit.H, CardRank.ACE));
		assertTrue(player.isBlackjack());
		assertEquals(21, player.getHand1().getPoints());
		
	}
	
	//test hit and correct points for player
	public void testHit1()  {
		Player player = new Player();
		player.firstTwoDraw(new Card(CardSuit.H, CardRank.SEVEN), new Card(CardSuit.S, CardRank.NINE));
		assertFalse(player.isBlackjack());
		assertEquals(16, player.getHand1().getPoints());
		player.hit(new Card(CardSuit.S, CardRank.KING));
		assertTrue(player.isBusted());
		assertEquals(26, player.getHand1().getPoints());
	}
	
	public void testHit2()  {
		Player player = new Player();
		player.firstTwoDraw(new Card(CardSuit.H, CardRank.ACE), new Card(CardSuit.S, CardRank.NINE));
		assertFalse(player.isBlackjack());
		assertEquals(20, player.getHand1().getPoints());
		player.hit(new Card(CardSuit.S, CardRank.ACE));
		assertFalse(player.isBlackjack());
		assertEquals(21, player.getHand1().getPoints());
	}
	
	public void testHit3()  {
		Player player = new Player();
		player.firstTwoDraw(new Card(CardSuit.H, CardRank.SEVEN), new Card(CardSuit.S, CardRank.SEVEN));
		assertFalse(player.isBlackjack());
		assertEquals(14, player.getHand1().getPoints());
		player.hit(new Card(CardSuit.D, CardRank.SEVEN));
		assertFalse(player.isBlackjack());
		assertEquals(21, player.getHand1().getPoints());
	}
	
	//test player bust
	public void testIsBusted1() {
		Player player = new Player();
		player.firstTwoDraw(new Card(CardSuit.H, CardRank.KING), new Card(CardSuit.S, CardRank.KING));
		assertFalse(player.isBlackjack());
		assertEquals(20, player.getHand1().getPoints());
		player.hit(new Card(CardSuit.D, CardRank.KING));
		assertFalse(player.isBlackjack());
		assertTrue(player.isBusted());
		assertEquals(30, player.getHand1().getPoints());
		
	}

//	public void testStand() {
//		Player player = new Player();
//		player.firstTwoDraw(new Card(CardSuit.H, CardRank.SEVEN), new Card(CardSuit.S, CardRank.NINE));
//		assertEquals(20, player.getHand1().getPoints());
//		assertTrue(player.isStand());
//		
	}