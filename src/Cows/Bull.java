package Cows;

public class Bull extends Cow 
{
	private boolean fixed;
	
	public Bull(int id, String breed, String birthdate, String datePurchased, String purchasedFrom, 
			boolean vaccines, int mother, int father, String notes)
	{
		super(id, breed, birthdate, datePurchased, purchasedFrom, vaccines, mother, father, notes);
		this.fixed = false;
	}
	
	public void setFixed(boolean state)
	{
		fixed = state;
	}
	
	public boolean getFixedState()
	{
		return fixed;
	}
}
