import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Chips {
	static final private Map<String, BigInteger> memo = new HashMap<>();
	
	//Getting number of partitions with max integer equal to maxNumber
	public static BigInteger getNumberOfChipsPartitions(long numberOfChips, long maxNumber)
	{
		if(numberOfChips<=1)
		{
			return BigInteger.ONE;
		}
		if(maxNumber>numberOfChips)
		{
			return getNumberOfChipsPartitions(numberOfChips, numberOfChips);
		}
		String key = numberOfChips + "," + maxNumber;
		//Getting number of partitions from memory
		BigInteger counter = memo.get(key);
		if(counter != null)
		{
			return counter;
		}
		counter = BigInteger.ZERO;
		for (long i = 1; i <= maxNumber; i++)
		{
			counter = counter.add(getNumberOfChipsPartitions(numberOfChips - i, i));
		}
		//Saving number of partitions to memory
		memo.put(key, counter);
		return counter;
	}
	
	public static BigInteger getNumberOfChipsPartitions(long numberOfChips)
	{
		return getNumberOfChipsPartitions(numberOfChips, numberOfChips);
	}
	
	public static long getNumberDivisibleBy(BigInteger divider)
	{
		long i = 1;
		while(true)
		{
			if(getNumberOfChipsPartitions(i).mod(divider).equals(BigInteger.ZERO)) break;	
			i++;
		}
		return i;
	}
}
