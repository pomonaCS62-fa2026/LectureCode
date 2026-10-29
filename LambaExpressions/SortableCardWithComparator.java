import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortableCardWithComparator extends Card implements Comparable<SortableCardWithComparator> {
	public SortableCardWithComparator(int number, String suit) {
		super(number, suit);
	}

	public int compareTo(SortableCardWithComparator o) {
		// sort based on suit first then number
		int comparison = suit.compareTo(o.suit);

		return comparison == 0 ? Integer.compare(number, o.number) : comparison;
	}

	public static Comparator<SortableCardWithComparator> bridgeOrderingComparator() {
		return (SortableCardWithComparator o1, SortableCardWithComparator o2) -> {
			int suitCompare = o1.getSuit().compareTo(o2.getSuit());

			if (suitCompare == 0) {
				int num1 = promoteAce(o1.getNumber());
				int num2 = promoteAce(o2.getNumber());

				return -Integer.compare(num1, num2); // higher is better, so reverse
			} else {
				return -suitCompare; // reverse alphabetic.
			}
		};
	}

	private static int promoteAce(int num) {
		return num == 1 ? num + 20 : num;
	}

	public static void naturalSort() {
		ArrayList<SortableCardWithComparator> cards = new ArrayList<SortableCardWithComparator>();

		CardDealer dealer = new CardDealer(1);

		while (dealer.hasNext()) {
			Card c = dealer.next();
			System.out.println(c);
			cards.add(new SortableCardWithComparator(c.getNumber(), c.getSuit()));
		}

		System.out.println("Sorting by natural ordering!");
		Collections.sort(cards);

		for (SortableCardWithComparator c : cards) {
			System.out.println(c);
		}
	}

	public static void bridgeOrderingSort() {
				ArrayList<SortableCardWithComparator> cards = new ArrayList<SortableCardWithComparator>();

				CardDealer dealer = new CardDealer(1);
				
				while( dealer.hasNext() ) {
					Card c = dealer.next();
					System.out.println(c);
					cards.add(new SortableCardWithComparator(c.getNumber(), c.getSuit()));
				}
				
				System.out.println("Sorting by bridge ordering!");
				cards.sort(bridgeOrderingComparator());
				
				for( SortableCardWithComparator c: cards ) {
					System.out.println(c);
				}
			}

	public static void main(String[] args) {
		bridgeOrderingSort();
	}
}