package puzzles;

import java.util.Random;

public class Shuffle {

	public static void main(String[] args) {

		Card[] cards = { new Card(1), new Card(2),new Card(3), new Card(4), new Card(5), new Card(6),new Card(7), new Card(8) };
		
		System.out.println(toString(cards));		
		shuffle(cards);
		System.out.println(toString(cards));
	}

	static void shuffle(Card[] cards) {
		Random r = new Random();
		for(int i = 0; i < cards.length; i++) {			
			int indx = r.nextInt(cards.length);
			//System.out.println(indx);
			Card temp = cards[i];
			cards[i] = cards[indx];
			cards[indx] = temp; 
		}
	}
	
	static String toString(Card[] cards) {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < cards.length; i++) {
			sb.append(cards[i].value);
		}
		return sb.toString();
	}
	
	static class Card {
		public int value;
		public Card(int v) {
			value = v;
		}
	}
}
