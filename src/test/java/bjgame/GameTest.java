package bjgame;

import java.nio.file.ReadOnlyFileSystemException;

import junit.framework.TestCase;

public class GameTest extends TestCase {
	
	
	//SA C8 H8 S9 H C10 player busted
	public void testGame1() {
		Game g = new Game();
		Player p = g.getPlayer();
		Dealer d = g.getDealer();
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
		assertEquals(1, g.hasWinner(false));
		assertEquals(1, g.hasWinner(true));
	}
	
	
	//HK SQ S5 C8 S C9 dealer busted
	public void testGame2() {
		Game g = new Game();
		Player p = g.getPlayer();
		Dealer d = g.getDealer();
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
		assertEquals(2, g.hasWinner(false));
		assertEquals(2, g.hasWinner(true));
	}
	
	//player gets black jack but not dealer
	public void testGame3() {

		Game g = new Game();
		Player p = g.getPlayer();
		Dealer d = g.getDealer();
		p.firstTwoDraw(new Card(CardSuit.H, CardRank.KING),new Card(CardSuit.S, CardRank.ACE));
		d.firstTwoDraw(new Card(CardSuit.S, CardRank.FIVE), new Card(CardSuit.C, CardRank.EIGHT));
		assertEquals(21, p.getHand1().getPoints());
		assertEquals(13, d.getHand1().getPoints());
		assertTrue(p.isBlackjack());
		assertFalse(d.isBlackjack());
		assertEquals(2, g.hasWinner(false));
		assertEquals(2, g.hasWinner(true));
	}
	
	//player gets black jack but dealer also gets
	public void testGame4() {
		Game g = new Game();
		Player p = g.getPlayer();
		Dealer d = g.getDealer();
		p.firstTwoDraw(new Card(CardSuit.H, CardRank.KING),new Card(CardSuit.S, CardRank.ACE));
		d.firstTwoDraw(new Card(CardSuit.S, CardRank.TEN), new Card(CardSuit.C, CardRank.ACE));
		assertEquals(21, p.getHand1().getPoints());
		assertEquals(21, d.getHand1().getPoints());
		assertTrue(p.isBlackjack());
		assertTrue(d.isBlackjack());
		assertEquals(1, g.hasWinner(false));
		assertEquals(1, g.hasWinner(true));
	}
	
	//dealer gets black jack but not player
	public void testGame5() {
		Game g = new Game();
		Player p = g.getPlayer();
		Dealer d = g.getDealer();
		p.firstTwoDraw(new Card(CardSuit.H, CardRank.THREE),new Card(CardSuit.S, CardRank.TEN));
		d.firstTwoDraw(new Card(CardSuit.S, CardRank.KING), new Card(CardSuit.C, CardRank.ACE));
		assertEquals(13, p.getHand1().getPoints());
		assertEquals(21, d.getHand1().getPoints());
		assertFalse(p.isBlackjack());
		assertTrue(d.isBlackjack());
		assertEquals(1, g.hasWinner(false));
		assertEquals(1, g.hasWinner(true));
	}
	
	
	//none of them get blackjack and no busted, player point is higher
	public void testGame6() {
		Game g = new Game();
		Player p = g.getPlayer();
		Dealer d = g.getDealer();
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
		assertEquals(2, g.hasWinner(true));
	}
	
	//none of them get blackjack and no busted, Dealer point is higher
	public void testGame7() {
		Game g = new Game();
		Player p = g.getPlayer();
		Dealer d = g.getDealer();
		p.firstTwoDraw(new Card(CardSuit.S, CardRank.NINE), new Card(CardSuit.D, CardRank.NINE));
		d.firstTwoDraw(new Card(CardSuit.H, CardRank.TWO),new Card(CardSuit.S, CardRank.EIGHT));
		assertEquals(18, p.getHand1().getPoints());
		assertEquals(10, d.getHand1().getPoints());
		assertFalse(p.isBlackjack());
		assertFalse(d.isBlackjack());
		assertEquals(0, g.hasWinner(false));
		assertFalse(p.isBusted());
		assertFalse(d.stand());
		d.hit(new Card(CardSuit.D, CardRank.TEN));
		assertEquals(20, d.getHand1().getPoints());
		assertTrue(d.stand());
		assertEquals(1, g.hasWinner(true));
	}
	
	public void testGame8() {
		Game g = new Game();
		Player p = g.getPlayer();
		Dealer d = g.getDealer();
		p.firstTwoDraw(new Card(CardSuit.S, CardRank.NINE), new Card(CardSuit.D, CardRank.NINE));
		d.firstTwoDraw(new Card(CardSuit.H, CardRank.ACE),new Card(CardSuit.S, CardRank.SIX));
		assertEquals(18, p.getHand1().getPoints());
		assertEquals(17, d.getHand1().getPoints());
		assertFalse(p.isBlackjack());
		assertFalse(d.isBlackjack());
		//assertTrue(d.isSoft17());
		assertEquals(0, g.hasWinner(false));
		assertFalse(p.isBusted());
		//assertFalse(d.stand());
		d.hit(new Card(CardSuit.D, CardRank.THREE));
		assertEquals(20, d.getHand1().getPoints());
		assertFalse(d.isSoft17());
		assertTrue(d.stand());
		assertEquals(1, g.hasWinner(true));
	}
	
	//input file SK HA HQ CA
	public void testInutFile1() {
		Game g = new Game();
		Player p = g.getPlayer();
		Dealer d = g.getDealer();
		//GameConsole.readFile();
		p.firstTwoDraw(new Card("SK"), new Card("HA"));
		d.firstTwoDraw(new Card("HQ"),new Card("CA"));
		assertEquals(21, p.getHand1().getPoints());
		assertEquals(21, d.getHand1().getPoints());
		assertTrue(p.isBlackjack());
		assertTrue(d.isBlackjack());
		assertEquals(1, g.hasWinner(true));
		
	}
	
	public void testInutFile2() {
		Game g = new Game();
		Player p = g.getPlayer();
		Dealer d = g.getDealer();
		//GameConsole.readFile();
		p.firstTwoDraw(new Card("SK"), new Card("HQ"));
		d.firstTwoDraw(new Card("SQ"),new Card("C5"));
		assertEquals(20, p.getHand1().getPoints());
		assertEquals(15, d.getHand1().getPoints());
		assertFalse(p.isBlackjack());
		assertFalse(d.isBlackjack());
		assertEquals(0, g.hasWinner(false));
		assertEquals(false,d.stand());
		d.getHand1().addCard(new Card("DJ"));
		assertEquals(true,d.stand());
		assertEquals(25, d.getHand1().getPoints());
		assertEquals(true,d.isBusted());
		assertEquals(2, g.hasWinner(true));
		
	}
	
	
	
}
