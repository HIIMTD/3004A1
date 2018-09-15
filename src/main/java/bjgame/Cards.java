package bjgame;

public class Cards {
	
	public enum Suit {S,C,D,H};
	private int rank;
	private Suit suit;
	
	//cons
	public Cards(Suit s, int r){
		this.suit = s;
		this.rank = r;
	}
	
	//get function
	public Suit getSuit() {return suit;}
	public int getRank() {return rank;}
	
	public String toString() {
		String s = suit.toString();
		String name = new String();
		switch (rank) {
		case 1:
			name = s+"A";
			break;
		case 11:
			name = s+"J";
			break;
		case 12:
			name = s+"Q";
			break;
		case 13:
			name = s+"K";
			break;

		default:
			name = s + rank;
			break;
		}
		return name;
	}
	
}
