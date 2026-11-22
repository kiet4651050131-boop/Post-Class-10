package ex1;

public class SizeStatus implements DeckObserver
{
	@Override
	public void sizeChanged(int pSize)
	{
		System.out.println("Deck size is now: " + pSize);
	}
}
