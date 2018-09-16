package bjgame;

import java.util.HashMap;
import java.util.Map;

public enum CardRank {
	ACE(1,"A"),
	TWO(2, "2"), 
	THREE(3, "3"),
	FOUR(4,"4"),
	FIVE(5,"5"),
	SIX(6,"6"),
	SEVEN(7,"7"),
	EIGHT(8,"8"),
	NINE(9,"9"),
	TEN(10,"10"),
	JACK(10, "J"),
	QUEEN(10,"Q"),
	KING(10,"K");
	
	private static Map<String, CardRank> nameToRank = new HashMap<>();
	private final String name;
	private final int value;
	
	static {
		for (CardRank rank: CardRank.values()) {
			nameToRank.put(rank.getName(), rank);
		}
	}
	private CardRank(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}
	
	public static CardRank getCardRank(String name) {
		return nameToRank.get(name);
	}
	
	
}
