package ex2;

public class SizeStatus implements DeckObserver
{
	@Override
	public void sizeChanged(ReadOnlyDeck pDeck)
	{
		System.out.println("Deck size is now: " + pDeck.size());     // pull
	}
}
