package ex3;

import java.util.ArrayList;
import java.util.List;

import base.Card;

/** Superclass that holds ALL the observer-supporting code. */
public abstract class DeckObservable
{
	private final List<DeckObserver> aObservers = new ArrayList<>();

	public void addObserver(DeckObserver pObserver)
	{
		aObservers.add(pObserver);
	}

	public void removeObserver(DeckObserver pObserver)
	{
		aObservers.remove(pObserver);
	}

	protected void notifyCardDrawn(Card pCard)
	{
		for( DeckObserver observer : aObservers )
		{
			observer.cardDrawn(pCard);
		}
	}

	protected void notifySizeChanged(int pSize)
	{
		for( DeckObserver observer : aObservers )
		{
			observer.sizeChanged(pSize);
		}
	}
}
