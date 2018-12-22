package Cows;

import Data.DBConnect;

public class Bull extends Cow 
{
	private String castrated;
	
	public Bull(int id, String breed, String gender, String birthdate, String datePurchased, String purchasedFrom, 
			String price, String vaccines, int mother, int father, String fixed, String notes)
	{
		super(id, breed, gender, birthdate, datePurchased, purchasedFrom, price, vaccines, mother, father, notes);
		this.castrated = fixed;
	}
	
	public void writeBullToCurrentDb(DBConnect dbObj)
	{
		dbObj.insertBullIntoCurrent(id, breed, gender, birthdate, datePurchased, purchasedFrom,
				price, vaccines, mother, father, castrated, notes);
	}
	
	public void writeBullToPastDb(DBConnect dbObj, String priceSoldFor, String soldTo)
	{
		dbObj.insertBullIntoPast(id, breed, gender, birthdate, datePurchased, purchasedFrom,
				price, vaccines, mother, father, castrated, notes, priceSoldFor, soldTo);
	}
	
	public void setFixed(String state)
	{
		castrated = state;
	}
	
	public String getFixedState()
	{
		return castrated;
	}
}
