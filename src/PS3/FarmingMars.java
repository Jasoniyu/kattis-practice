import java.util.HashMap;
import java.util.Scanner;

public class FarmingMars {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		double[] farmland = new double[n];
		for (int i = 0; i < n; i++) {
			farmland[i] = sc.nextDouble();
		}
		
		boolean majorityFound = false;
		for (int i = 0; i < m; i++) {
			majorityFound = false;
			int l = sc.nextInt();
			int r = sc.nextInt();
			if (l == r) {
				System.out.println("usable");
				majorityFound = true;
				continue;
			}
			HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
			int maj = (r - l + 1)/2 + 1;
			for (int j = l-1; j < r; j++) {
				if (hm.containsKey(farmland[j])) {
					int count = hm.get(farmland[j]) + 1;
					if (count >= maj) {
						System.out.println("usable");
						majorityFound = true;
					} else {
						hm.put(farmland[j], count);
					}
				} else {
					hm.put(farmland[j], 1);
				}
			}
			if (!majorityFound) {
				System.out.println("unusable");
			}
		}
	}

}


