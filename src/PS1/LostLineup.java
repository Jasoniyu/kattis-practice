package PS1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LostLineup {
	
	public static void main(String args[]) throws Exception {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String line1 = sc.readLine();
        String line2 = sc.readLine();
        int n = Integer.parseInt(line1);
        String[] line2elements = line2.split(" ");
        int[] arr = new int[n-1];
        for (int i = 2; i < n+1; i++) {
        	int elem = Integer.parseInt(line2elements[i-2]);
        	arr[elem] = i;
        }
        System.out.print("1 ");
        for (int i : arr) {
        	System.out.print(i + " ");
        }
        System.out.println();
	}
}
