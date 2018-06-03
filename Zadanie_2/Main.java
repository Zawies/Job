
public class Main {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(Numbers.getNumberOfReversable(1000000000));
	    	long end = System.currentTimeMillis();
	    	System.out.println((end - start) + " ms");
	}
}
