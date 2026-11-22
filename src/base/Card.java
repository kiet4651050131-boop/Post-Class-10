package base;

/** Immutable playing card (simplified version used for this exercise). */
public record Card(Rank rank, Suit suit)
{
	@Override
	public String toString()
	{
		return rank + " of " + suit;
	}
}
