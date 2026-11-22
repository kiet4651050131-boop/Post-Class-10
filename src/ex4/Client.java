package ex4;

import base.Card;

public class Client
{
	public static void main(String[] args)
	{
		ObservableDeck deck = new ObservableDeck();
		deck.addObserver(new DrawLogger());
		deck.addObserver(new SizeStatus());

		System.out.println("--- draw ---");
		Card card = deck.draw();
		System.out.println("--- draw ---");
		deck.draw();
		System.out.println("--- push back the first card ---");
		deck.push(card);
	}
}
