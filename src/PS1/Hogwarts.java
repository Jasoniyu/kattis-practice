package PS1;

import java.util.*;

public class Hogwarts {
    static int numRooms;
    static int[][] oldRooms, newRooms;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        numRooms = sc.nextInt();
        oldRooms = new int[numRooms][numRooms];
        newRooms = new int[numRooms][numRooms];

        for (int r = 0; r < numRooms; r++) {
            for (int c = 0; c < numRooms; c++) {
                oldRooms[r][c] = sc.nextInt();
            }
        }

        for (int r = 0; r < numRooms; r++) {
            for (int c = 0; c < numRooms; c++) {
                newRooms[r][c] = sc.nextInt();
            }
        }

        Queue<Integer> bfs = new LinkedList<>();
        Queue<ArrayList<Integer>> paths = new LinkedList<>();
        ArrayList<ArrayList<Integer>> oldPaths = new ArrayList<>();
        bfs.add(1);
        paths.add(new ArrayList<>());

        while (!bfs.isEmpty()) {
            int rm = bfs.remove();
            ArrayList<Integer> path = paths.remove();
            for (int nextRm : oldRooms[rm - 1]) {
                if (nextRm != 0 && nextRm != rm && !path.contains(nextRm)) {
                    ArrayList<Integer> newPath = new ArrayList<>(path);
                    newPath.add(nextRm);
                    if (nextRm == numRooms) {
                        oldPaths.add(newPath);
                        continue;
                    }
                    bfs.add(nextRm);
                    paths.add(newPath);
                }
            }
        }

        if (oldPaths.isEmpty()) {
            System.out.println("Impossible");
        } else {
            for (ArrayList<Integer> path : oldPaths) {
                if (!checkPath(path)) {
                    System.out.println("No");
                    return;
                }
            }
            System.out.println("Yes");
        }


    }

    public static boolean contains(int[] array, int v) {
        for (int i : array) {
            if (i == v) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPath(ArrayList<Integer> path) {
        int curRm = 1;
        for (int i : path) {
            if (!contains(newRooms[curRm - 1], i)) {
                return false;
            } else {
                if (i == numRooms) {
                    return true;
                }
                curRm = i;
            }

        }
        return false;
    }
}
