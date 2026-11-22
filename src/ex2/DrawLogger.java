package ex2;

public class DrawLogger implements DeckObserver
{
	@Override
	public void cardDrawn(ReadOnlyDeck pDeck)
	{
		System.out.println("Card drawn: " + pDeck.getLastDrawn());   // pull
	}
}
