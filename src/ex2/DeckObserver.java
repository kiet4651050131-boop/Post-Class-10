package ex2;

/** Observer interface, pull data-flow: observers get a read-only reference to the deck. */
public interface DeckObserver
{
	default void cardDrawn(ReadOnlyDeck pDeck) {}
	default void sizeChanged(ReadOnlyDeck pDeck) {}
}
