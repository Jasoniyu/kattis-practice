package PS1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PieceOfCake {

	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = sc.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int h = Integer.parseInt(inputs[1]);
        int v = Integer.parseInt(inputs[2]);
        System.out.println(4 * (Math.max(h, n-h)) * (Math.max(v, n-v)));
	}

}
