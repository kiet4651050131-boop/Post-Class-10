package ex4;

import java.util.ArrayList;
import java.util.List;

import base.Card;
import base.Deck;

/**
 * Subclass of the ORIGINAL Deck (unchanged) that holds ALL the
 * observer-supporting code.
 */
public class ObservableDeck extends Deck
{
	private List<DeckObserver> aObservers = new ArrayList<>();

	public void addObserver(DeckObserver pObserver)
	{
		aObservers.add(pObserver);
	}

	public void removeObserver(DeckObserver pObserver)
	{
		aObservers.remove(pObserver);
	}

	@Override
	public void shuffle()
	{
		super.shuffle();
		notifySizeChanged();
	}

	@Override
	public void push(Card pCard)
	{
		super.push(pCard);
		notifySizeChanged();
	}

	@Override
	public Card draw()
	{
		Card card = super.draw();
		for( DeckObserver observer : aObservers )
		{
			observer.cardDrawn(card);
		}
		notifySizeChanged();
		return card;
	}

	private void notifySizeChanged()
	{
		// Deck constructor calls shuffle() BEFORE this subclass fields are
		// initialized, so aObservers is still null at that point.
		if( aObservers == null )
		{
			return;
		}
		for( DeckObserver observer : aObservers )
		{
			observer.sizeChanged(getCards().size());
		}
	}
}
