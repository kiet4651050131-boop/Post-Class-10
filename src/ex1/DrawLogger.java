package ex1;

import base.Card;

public class DrawLogger implements DeckObserver
{
	@Override
	public void cardDrawn(Card pCard)
	{
		System.out.println("Card drawn: " + pCard);
	}
}
