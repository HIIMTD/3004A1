package bjgame;

import org.hamcrest.core.Is;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {
	public void testStart() {
		Player player = new Player();
		player.firstTwoDraw(new Card(CardSuit.H, CardRank.SEVEN), new Card(CardSuit.S, CardRank.NINE));
		assertFalse(blackjack);
		assertEquals(16, player.getHandcard().getPoints());
		
	}
	
	public void testHit() {
		Player player = new Player();
		player.firstTwoDraw(new Card(CardSuit.H, CardRank.SEVEN), new Card(CardSuit.S, CardRank.NINE));
		assertFalse(blackjack);
		player.hit(new Card(CardSuit.S, CardRank.KING));
		assertTrue(bust);
		assertEquals(26, player.getHandcard().getPoints());
	}
}
