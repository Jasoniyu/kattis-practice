import java.math.BigInteger;
import java.util.Scanner;

public class SumAndProduct {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] pages = new long[n];
		
		for (int i = 0; i < n; i++) {
			pages[i] = sc.nextLong();
		}
		
		BigInteger product = new BigInteger("0", 10);
		BigInteger sum = new BigInteger("0", 10);
		long count = 0;
		for (int i = 0; i < n-1; i++) {
			product = new BigInteger(Long.toString(pages[i]), 10);
			sum = new BigInteger(Long.toString(pages[i]), 10);
			
			for (int j = i+1; j < n; j++) {
				product = product.multiply(new BigInteger(Long.toString(pages[j]), 10));
				sum = sum.add(new BigInteger(Long.toString(pages[j]), 10));
				BigInteger difference = product.subtract(sum);
				if (difference.compareTo(new BigInteger(Integer.toString(n - j + 1))) == 1) {
					break;
				}
				if (difference == BigInteger.ZERO) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
