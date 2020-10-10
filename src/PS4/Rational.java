import java.util.*;

public class Rational {

    static Stack<Integer> path;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        for (int i = 0; i < x; i++) {
            path = new Stack<>();
            int ID = scan.nextInt();
            int input = scan.nextInt();
            while (input != 1) {
                path.push(input % 2);
                input /= 2;
            }
            int num = 1;
            int denom = 1;
            while (!path.isEmpty()) {
                int val = path.pop();
                if (val == 1) {
                    num = num + denom;
                } else {
                    denom = num + denom;
                }
            }
            System.out.println(ID + " " + num + "/" + denom);
        }
        scan.close();
    }
}