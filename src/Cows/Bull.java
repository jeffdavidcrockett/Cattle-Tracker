package Cows;

public class Bull extends Cow 
{
	private boolean fixed;
	
	public Bull(int id, String breed, String gender, String birthdate, String datePurchased, String purchasedFrom, 
			String price, String vaccines, int mother, int father, String notes, boolean fixed)
	{
		super(id, breed, gender, birthdate, datePurchased, purchasedFrom, price, vaccines, mother, father, notes);
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
