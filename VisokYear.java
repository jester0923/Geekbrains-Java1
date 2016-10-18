/*
* Created by Dmtriy Kirpichnikov 05.10.2016
*/

public class VisokYear 
{
	public static void main (String[] args) 
		{
			int year;
			year = 2005;
			System.out.println("Hello World!");
			System.out.println (Visokyear(year) + "Good JOB!");
		}
	    
		static Visokyear (int year)
		{
			if ((year % 4 == 0) && year % 100 != 0)
			{
            System.out.println("this is visokosniy year.");
			}
        
		else 
			
		if ((year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0))
			{
            System.out.println ("this is visokosniy year.");
			}
        
		else
			{
            System.out.println ("this is not a visokosniy year.");
			}
		return year;
        }
}