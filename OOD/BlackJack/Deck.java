import java.util.ArrayList;
import java.util.List;

public class Deck {
	private final List<Card> deck;
	private int dealIndex = 0;
	public Deck(){
		deck = new ArrayList<>();
		for (int i = 1; i <= 13; i++) {
			for(Suit suit: Suit.values()) {
				deck.add(new Card(suit, i));
			}
		}
	}
	
	public void shuffle() {
		for(int i = deck.size() - 1; i >= 0 ; i--) {
			int index = (int)(Math.random() * (i + 1));
			Card temp = deck.get(index);
			deck.set(index, deck.get(i));
			deck.set(i, temp);
		}
	}
	
	private int remainingCards() {
		return deck.size() - dealIndex;
	}
	
	public Card[] dealHead(int number) {
		if (remainingCards() < number) {
			return null;
		}
		Card[] cards = new Card[number];
		for(int i = 0; i < number; i++) {
			cards[i] = dealHead();
		}
		return cards;
	}
	public Card dealHead() {
		return remainingCards() == 0 ? null : deck.get(dealIndex++);
	}
}
