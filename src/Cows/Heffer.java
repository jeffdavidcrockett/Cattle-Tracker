package Cows;

public class Heffer extends Cow
{
	private int amountOfBabies;
	
	public Heffer(int id, String breed, String gender, String birthdate, String datePurchased, String purchasedFrom, 
			String price, String vaccines, int mother, int father, String notes)
	{
		super(id, breed, gender, birthdate, datePurchased, purchasedFrom, price, vaccines, mother, father, notes);
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
