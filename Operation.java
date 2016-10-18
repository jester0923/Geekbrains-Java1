/*
* Created by Dmtriy Kirpichnikov 05.10.2016
*/

public class Operation 
{
	public static void main (String[] args) 
		{
			int a,b,c,d;
			a=10;
			b=2;
			c=6;
			d=3;
			System.out.println ("Hello World!");
			System.out.println ("Oper= " + oper(a,b,c,d));
		}
	    
		static int oper (int a, int b, int c, int d) 
		{
             return a * (b + (c / d));
        }
		
	    
}