package bjgame;

import junit.framework.TestCase;

public class GameTest extends TestCase {
	
	
	//SA C8 H8 S9 H C10 player busted
	public void testGame1() {
		Player p = new Player();
		Dealer d = new Dealer();
		Game g = new Game();
		p.firstTwoDraw(new Card(CardSuit.H, CardRank.EIGHT),new Card(CardSuit.S, CardRank.NINE));
		d.firstTwoDraw(new Card(CardSuit.S, CardRank.ACE), new Card(CardSuit.C, CardRank.EIGHT));
		assertEquals(17, p.getHand1().getPoints());
		assertEquals(19, d.getHand1().getPoints());
		assertFalse(p.isBlackjack());
		assertFalse(d.isBlackjack());
		assertFalse(p.isBusted());
		p.hit(new Card(CardSuit.C, CardRank.TEN));
		assertEquals(27, p.getHand1().getPoints());
		assertTrue(p.isBusted());
		assertTrue(g.isEnd());
	}
	
	
	//HK SQ S5 C8 S C9 dealer busted
	public void testGame2() {
		Player p = new Player();
		Dealer d = new Dealer();
		Game g = new Game();
		p.firstTwoDraw(new Card(CardSuit.H, CardRank.KING),new Card(CardSuit.S, CardRank.QUEEN));
		d.firstTwoDraw(new Card(CardSuit.S, CardRank.FIVE), new Card(CardSuit.C, CardRank.EIGHT));
		assertEquals(20, p.getHand1().getPoints());
		assertEquals(13, d.getHand1().getPoints());
		assertFalse(p.isBlackjack());
		assertFalse(d.isBlackjack());
		assertFalse(d.stand());
		d.hit(new Card(CardSuit.C, CardRank.NINE));
		assertEquals(20, p.getHand1().getPoints());
		assertTrue(d.isBusted());
		assertTrue(g.isEnd());
	}
	
	//player gets black jack but not dealer
	public void testGame3() {
		Player p = new Player();
		Dealer d = new Dealer();
		Game g = new Game();
		p.firstTwoDraw(new Card(CardSuit.H, CardRank.KING),new Card(CardSuit.S, CardRank.ACE));
		d.firstTwoDraw(new Card(CardSuit.S, CardRank.FIVE), new Card(CardSuit.C, CardRank.EIGHT));
		assertEquals(21, p.getHand1().getPoints());
		assertEquals(13, d.getHand1().getPoints());
		assertTrue(p.isBlackjack());
		assertFalse(d.isBlackjack());
		assertTrue(g.isEnd());
	}
	
	//player gets black jack but dealer also gets
	public void testGame4() {
		Player p = new Player();
		Dealer d = new Dealer();
		Game g = new Game();
		p.firstTwoDraw(new Card(CardSuit.H, CardRank.KING),new Card(CardSuit.S, CardRank.ACE));
		d.firstTwoDraw(new Card(CardSuit.S, CardRank.TEN), new Card(CardSuit.C, CardRank.ACE));
		assertEquals(21, p.getHand1().getPoints());
		assertEquals(21, d.getHand1().getPoints());
		assertTrue(p.isBlackjack());
		assertTrue(d.isBlackjack());
		assertTrue(g.isEnd());
	}
	
	//dealer gets black jack but not player
	public void testGame5() {
		Player p = new Player();
		Dealer d = new Dealer();
		Game g = new Game();
		p.firstTwoDraw(new Card(CardSuit.H, CardRank.THREE),new Card(CardSuit.S, CardRank.TEN));
		d.firstTwoDraw(new Card(CardSuit.S, CardRank.KING), new Card(CardSuit.C, CardRank.ACE));
		assertEquals(13, p.getHand1().getPoints());
		assertEquals(21, d.getHand1().getPoints());
		assertFalse(p.isBlackjack());
		assertTrue(d.isBlackjack());
		assertTrue(g.isEnd());
	}
	
	
	//none of them get blackjack and no busted, player point is higher
	public void testGame6() {
		Player p = new Player();
		Dealer d = new Dealer();
		Game g = new Game();
		p.firstTwoDraw(new Card(CardSuit.H, CardRank.TWO),new Card(CardSuit.S, CardRank.EIGHT));
		d.firstTwoDraw(new Card(CardSuit.S, CardRank.NINE), new Card(CardSuit.D, CardRank.TWO));
		assertEquals(10, p.getHand1().getPoints());
		assertEquals(11, d.getHand1().getPoints());
		assertFalse(p.isBlackjack());
		assertFalse(d.isBlackjack());
		//assertFalse(g.isEnd());
		p.hit(new Card(CardSuit.C, CardRank.EIGHT));
		assertEquals(18, p.getHand1().getPoints());
		assertFalse(p.isBusted());
		assertFalse(d.stand());
		d.hit(new Card(CardSuit.D, CardRank.SIX));
		assertEquals(17, d.getHand1().getPoints());
		assertTrue(d.stand());
		assertTrue(g.isEnd());
	}
	

	
	
}
