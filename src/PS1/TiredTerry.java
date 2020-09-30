package PS1;

import java.util.Scanner;

public class TiredTerry {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int p = Integer.parseInt(sc.next());
		int d = Integer.parseInt(sc.next());
		String str = sc.next();
		str = str + str.substring(0, p-1);
		int startIndex = 0;
		int endIndex = p - 1;
		int numZs = 0;
		int numTired = 0;
		for (int i = 0; i < p; i++) {
			if (str.charAt(i) == 'Z') {
				numZs++;
			}
		}
		while (endIndex < str.length()) {
			if (numZs < d) {
				numTired++;
			}
			if (str.charAt(startIndex) == 'Z') {
				numZs--;
			}
			startIndex++;
			endIndex++;
			if (endIndex < str.length()) {
				if (str.charAt(endIndex) == 'Z') {
					numZs++;
				}
			}
		}
		System.out.println(numTired);
	}

}
