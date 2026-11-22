package ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import base.Card;
import base.Rank;
import base.Suit;

/** Observable Deck, push strategy. */
public class Deck
{
	private List<Card> aCards = new ArrayList<>();
	private final List<DeckObserver> aObservers = new ArrayList<>();

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
		Card card = aCards.remove(aCards.size() - 1);
		for( DeckObserver observer : aObservers )
		{
			observer.cardDrawn(card);              // push the card
		}
		notifySizeChanged();
		return card;
	}

	public boolean isEmpty()
	{
		return aCards.isEmpty();
	}

	public List<Card> getCards()
	{
		return Collections.unmodifiableList(aCards);
	}

	private void notifySizeChanged()
	{
		for( DeckObserver observer : aObservers )
		{
			observer.sizeChanged(aCards.size());   // push the size
		}
	}
}
