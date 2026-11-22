package ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import base.Card;
import base.Rank;
import base.Suit;

/** Observable Deck, pull strategy. */
public class Deck implements ReadOnlyDeck
{
	private List<Card> aCards = new ArrayList<>();
	private final List<DeckObserver> aObservers = new ArrayList<>();
	private Card aLastDrawn;

	public Deck()
	{
		shuffle();
	}

	public void addObserver(DeckObserver pObserver)
	{
		aObservers.add(pObserver);
	}

	public void removeObserver(DeckObserver pObserver)
	{
		aObservers.remove(pObserver);
	}

	public void shuffle()
	{
		aCards.clear();
		for( Suit suit : Suit.values() )
		{
			for( Rank rank : Rank.values() )
			{
				aCards.add( new Card( rank, suit ));
			}
		}
		Collections.shuffle(aCards);
		notifySizeChanged();
	}

	public void push(Card pCard)
	{
		assert pCard != null;
		aCards.add(pCard);
		notifySizeChanged();
	}

	public Card draw()
	{
		assert !isEmpty();
		aLastDrawn = aCards.remove(aCards.size() - 1);
		for( DeckObserver observer : aObservers )
		{
			observer.cardDrawn(this);      // this is seen as a ReadOnlyDeck
		}
		notifySizeChanged();
		return aLastDrawn;
	}

	@Override
	public boolean isEmpty()
	{
		return aCards.isEmpty();
	}

	@Override
	public List<Card> getCards()
	{
		return Collections.unmodifiableList(aCards);
	}

	@Override
	public int size()
	{
		return aCards.size();
	}

	@Override
	public Card getLastDrawn()
	{
		return aLastDrawn;
	}

	private void notifySizeChanged()
	{
		for( DeckObserver observer : aObservers )
		{
			observer.sizeChanged(this);
		}
	}
}
