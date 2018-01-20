import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Hand {
	protected final List<Card> cards = new ArrayList<>();
	public abstract int score();
	
	public void addCards(Card[] cards) {
		Collections.addAll(this.cards, cards);
	}
	
	public int size() {
		return cards.size();
	}
}