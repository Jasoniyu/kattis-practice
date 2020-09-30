package PS2;

import java.util.Arrays;
import java.util.Scanner;

public class BioTrip {
    static int n, minA, maxA;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int d = sc.nextInt();
        minA = sc.nextInt();
        maxA = sc.nextInt();

        Object[] adjList = new Object[n + 1];
        for (int i = 1; i <= n; i++) {
            int m = sc.nextInt();
            Road[] lst = new Road[m];
            for (int j = 0; j < m; j++) {
                lst[j] = new Road(sc.nextInt(), sc.nextInt(), sc.nextInt());
            }
            adjList[i] = lst;
        }

        // depth first search
        int pray = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[n + 1][n + 1];
        for (Road r : (Road[]) adjList[1]) {
            visited[1][r.destination] = true;
            pray = Math.min(pray, dfs(r.destination, r.time, getAng(1, r.destination, adjList), d, adjList, visited));
            visited[1][r.destination] = false;
        }

        if (pray == Integer.MAX_VALUE) {
            System.out.println("impossible");
        } else {
            System.out.println(pray);
        }


    }

    public static int dfs(int loc, int time, int angle, int d, Object[] adjList, boolean[][] visited) {
        if (loc == d) {
            // go back to start
//            return time;
            boolean[][] visited2 = new boolean[n + 1][n + 1];
            return dfs2(d, time, angle, adjList, visited2);
        } else {
            int minTime = Integer.MAX_VALUE;
            for (Road r : (Road[]) adjList[loc]) {
                int angDiff = Math.abs(angle - r.angle);
                boolean goodAng = r.angle > angle ? angDiff <= minA : angDiff <= maxA;
                if (!visited[loc][r.destination] && goodAng) {
                    visited[loc][r.destination] = true;
                    minTime = Math.min(minTime, dfs(r.destination, time + r.time, getAng(loc, r.destination, adjList), d, adjList, visited));
                    visited[loc][r.destination] = false;
                }
            }
            return minTime;
        }
    }

    public static int dfs2(int loc, int time, int angle, Object[] adjList, boolean[][] visited) {
        if (loc == 1) {
            // finished
            return time;
        } else {
            int minTime = Integer.MAX_VALUE;
            for (Road r : (Road[]) adjList[loc]) {
                int angDiff = Math.abs(angle - r.angle);
                boolean goodAng = r.angle > angle ? angDiff <= minA : angDiff <= maxA;
                if (!visited[loc][r.destination] && goodAng) {
                    visited[loc][r.destination] = true;
                    minTime = Math.min(minTime, dfs2(r.destination, time + r.time, r.angle, adjList, visited));
                    visited[loc][r.destination] = false;
                }
            }
            return minTime;
        }
    }

    public static int getAng(int start, int dest, Object[] adjList) {
        for(Road r : (Road[])adjList[dest]){
            if (r.destination == start) {
                return (r.angle+180)%360;
            }
        }
        return -1;
    }
}

class Road {
    int destination;
    int time;
    int angle;

    public Road(int d, int t, int a) {
        destination = d;
        time = t;
        angle = a;
    }

    @Override
    public String toString() {
        return "Road{" +
                "destination=" + destination +
                ", time=" + time +
                ", angle=" + angle +
                '}';
    }
}
