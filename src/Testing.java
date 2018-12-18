import java.util.Date;
import java.util.Scanner;

import Cows.Cow;
import Data.DBConnect;


public class Testing 
{
	public static void main(String[] args)
	{
		DBConnect db = new DBConnect();
		
		Cow cow1 = new Cow(202, "dairy", "11-04-1988", "12-22-2018", "Bob", true, 205, 203, null);
		
		cow1.writeCowToDb(db);
	}
}
