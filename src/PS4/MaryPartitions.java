import java.util.*;

public class MaryPartitions {

    static int[] dp;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        for (int i = 0; i < x; i++) {
            int ID = scan.nextInt();
            int m = scan.nextInt();
            int input = scan.nextInt();
            dp = new int[input + 1];
            System.out.println(ID + " " + (solve(input,m) + 1));
        }
        scan.close();
    }

    public static int solve(int n, int m) {
        if (dp[n] != 0) {
            return dp[n];
        }
        int divide  = n/m;
        for (int i = m; i <= n/m; i++) {
            divide += solve(i,m);
        }
        dp[n] = divide;
        return divide;
    }
}