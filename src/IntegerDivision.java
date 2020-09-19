import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class IntegerDivision {

	public static void main(String[] args) throws Exception {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String line1 = sc.readLine();
        String line2 = sc.readLine();
        String[] line1elements = line1.split(" ");
        String[] line2elements = line2.split(" ");
        int n = Integer.parseInt(line1elements[0]);
        int d = Integer.parseInt(line1elements[1]);
        HashMap<Integer, Long> hm = new HashMap<Integer, Long>();
        for (int i = 0; i < n; i++) {
        	int a = Integer.parseInt(line2elements[i]);
        	int q = a/d;
        	if (hm.containsKey(q)) {
        		hm.replace(q, hm.get(q)+1);
        	} else {
        		hm.put(q, (long)1);
        	}
        }
        long sum = 0;
        for (Entry<Integer, Long> entry: hm.entrySet()) {
        	long value = ((long)entry.getValue());
        	sum += ((value)*(value-1))/2;
        }
        System.out.println(sum);
	}

}
