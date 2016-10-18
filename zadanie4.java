/*
* Created by Dmtriy Kirpichnikov 05.10.2016
*/

public class zadanie4 
{
	public static void main (String[] args) 
		{
			int a,b,c;
			boolean flag;
			a=5;
			b=2;
			c=0;
			flag = true;
			
			flag = oper (a,b,c,flag);
			
			System.out.println ("Flag = " + flag);
		}
	    
		static boolean oper (int a, int b, int c, boolean flag) 
		{
			c = a + b;
			
            if (c < 10) 
			{
				System.out.println ("Summa < 10");
				flag = false;
				return flag;
			}
			if (c > 20) 
			{
				System.out.println ("Summa > 20");
				flag = false;
				return flag;
			} else
				{
				System.out.println ("10 <= Summa <= 20");
				return flag;
				}
			 
        }
		
	    
}