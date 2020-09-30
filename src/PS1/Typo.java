package PS1;

import java.util.HashSet;
import java.util.Scanner;

public class Typo {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		String[] words = new String[n];
		HashSet<String> hs = new HashSet<String>();
		for (int i = 0; i < n; i++) {
			words[i] = sc.next();
			hs.add(words[i]);
		}
		int numTypos = 0;
		for (String w : words) {
			for (int i = 0; i < w.length(); i++) {
				if (hs.contains(w.substring(0, i) + w.substring(i+1, w.length()))) {
					System.out.println(w);
					numTypos = 1;
					break;
				}
			}
		}
		if (numTypos == 0) {
			System.out.println("NO TYPOS");
		}
	}

}
