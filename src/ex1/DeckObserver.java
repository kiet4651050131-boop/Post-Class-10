package ex1;

import base.Card;

/** Observer interface, push data-flow: data is passed as parameters. */
public interface DeckObserver
{
	/** Called after a card is drawn; the card is pushed to the observer. */
	default void cardDrawn(Card pCard) {}

	/** Called after the size of the deck changes; the new size is pushed. */
	default void sizeChanged(int pSize) {}
}
