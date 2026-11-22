package ex3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import base.Card;
import base.Rank;
import base.Suit;

/** Deck whose observer support is inherited from the superclass DeckObservable. */
public class Deck extends DeckObservable
{
	private List<Card> aCards = new ArrayList<>();

	public Deck()
	{
		shuffle();
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
		notifySizeChanged(aCards.size());
	}

	public void push(Card pCard)
	{
		assert pCard != null;
		aCards.add(pCard);
		notifySizeChanged(aCards.size());
	}

	public Card draw()
	{
		assert !isEmpty();
		Card card = aCards.remove(aCards.size() - 1);
		notifyCardDrawn(card);
		notifySizeChanged(aCards.size());
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
}
