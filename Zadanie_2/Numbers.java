
public class Numbers {
	
	public static long reverseNumber(long number)
	{
		long reversed = 0;
		while(number>=1)
		{
			//Adding one zero to reversed number
			reversed *= 10;
			//Adding last digit of number to reversed number
			reversed += number%10;
			//Removing last digit from number
			number /= 10;
		}
		
		
		return reversed;
	}
	
	public static boolean isOdd(long number)
	{
		
		for(long i = number; i > 0; i /= 10)
		{
			int tmp = (int)i%10;
			if(tmp == 0)
				return false;
			if(tmp%2 == 0)
				return false;
		}
		
		
		return true;
	}
	
	public static long getNumberOfReversable(long bound)
	{
		long counter = 0;
		for (long i = 0; i<bound; i++)
		{
			//Rejecting numbers with leading zeros
			if(i%10 != 0)
				if(isOdd(i + reverseNumber(i))) counter++;
		}
		return counter;
	}
}
