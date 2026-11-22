package ex3;

import base.Card;

public interface DeckObserver
{
	default void cardDrawn(Card pCard) {}
	default void sizeChanged(int pSize) {}
}
