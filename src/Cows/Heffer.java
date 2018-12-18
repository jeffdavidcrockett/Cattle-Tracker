package Cows;

public class Heffer extends Cow
{
	private int amountOfBabies;
	
	public Heffer(int id, String breed, String birthdate, String datePurchased, String purchasedFrom, 
			boolean vaccines, int mother, int father, String notes)
	{
		super(id, breed, birthdate, datePurchased, purchasedFrom, vaccines, mother, father, notes);
		this.amountOfBabies = 0;
	}
	
	public void setAmountOfBabies(int numOfBabies)
	{
		amountOfBabies = numOfBabies;
	}
	
	public int getAmountOfBabies()
	{
		return amountOfBabies;
	}
}
