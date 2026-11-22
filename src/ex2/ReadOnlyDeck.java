package ex2;

import java.util.List;

import base.Card;

/**
 * Read-only view of a Deck (Interface Segregation Principle).
 * Observers only see this interface, so they cannot call draw(), push() or shuffle().
 */
public interface ReadOnlyDeck
{
	int size();
	boolean isEmpty();
	List<Card> getCards();
	Card getLastDrawn();
}
