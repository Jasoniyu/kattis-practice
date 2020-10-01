package PS2;

import java.util.HashSet;
import java.util.Scanner;

public class Pass {
    static HashSet<String> passes = new HashSet<>();
    static int[][] map;
    static int rows, cols, n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        rows = sc.nextInt();
        cols = sc.nextInt();
        n = sc.nextInt();
        map = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        findPasses();
        int res = findPaths();
        if (res == Integer.MAX_VALUE) {
            System.out.println("impossible");
        } else {
            System.out.println(res);
        }

    }

    public static void findPasses() {
        for (int r = 1; r < rows - 1; r++) {
            for (int c = 1; c < cols; c++) {
                if (map[r - 1][c] > map[r][c] && map[r + 1][c] > map[r][c]) {
                    if (map[r][c - 1] < map[r][c] && map[r][c + 1] < map[r][c]) {
                        passes.add("" + r + "," + c);
                    }
                }
            }
        }
    }

    public static boolean isPass(String cords) {
        return passes.contains(cords);
    }

    public static int findPaths() {
        int min = Integer.MAX_VALUE;
        for (int r = 0; r < rows; r++) {
            if (map[r][0] != -1) {
                min = Math.min(min, pathHelper(r, 0, 0, 0));
            }
        }
        return min;
    }

    public static int pathHelper(int r, int c, int ps, int cost) {
        if (c == cols - 1) {
            // on the east edge
            if (ps == n && map[r][c] != -1) {
                return cost + map[r][c];
            } else {
                return Integer.MAX_VALUE;
            }
        } else {
            int min = Integer.MAX_VALUE;
            //Northeast
            try {
                if (map[r - 1][c + 1] != -1) {
                    int nPs = isPass("" + (r - 1) + "," + (c + 1)) ? ps + 1 : ps;
                    min = Math.min(min, pathHelper(r - 1, c + 1, nPs, cost + map[r][c]));
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }
            //East
            try {
                if (map[r][c + 1] != -1) {
                    int nPs = isPass("" + (r) + "," + (c + 1)) ? ps + 1 : ps;
                    min = Math.min(min, pathHelper(r, c + 1, nPs, cost + map[r][c]));
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }
            //Southeast
            try {
                if (map[r + 1][c + 1] != -1) {
                    int nPs = isPass("" + (r + 1) + "," + (c + 1)) ? ps + 1 : ps;
                    min = Math.min(min, pathHelper(r + 1, c + 1, nPs, cost + map[r][c]));
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }
            return min;
        }
    }
}
