package bjgame;
import junit.framework.TestCase;

public class DeckTest extends TestCase{

		public void testCons() {
			Deck deck = new Deck();
			
			assertEquals(0, deck.size());
		}
		
		public void testCreateDeck() {
			Deck deck = new Deck();
			deck.createDeck();
			assertEquals(52, deck.size());
		}
		
		public void testShuffle() {
			Deck deck1 = new Deck();
			Deck deck2 = new Deck();
			//(deck1.equals(deck2));
			assertEquals(deck1, deck2);
			deck1.createDeck();
			deck2.createDeck();
			//assertEquals(deck1,deck2);
			//deck2.shuffle();
			//assertFalse(deck1.equals(deck2));
		}
}
