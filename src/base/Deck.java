package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Original, non-observable Deck (from the book Chapter 2).
 * Used as-is by Exercise 4 (subclass solution).
 */
public class Deck
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
	}

	public void push(Card pCard)
	{
		assert pCard != null;
		aCards.add(pCard);
	}

	public Card draw()
	{
		assert !isEmpty();
		return aCards.remove(aCards.size() - 1);
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
