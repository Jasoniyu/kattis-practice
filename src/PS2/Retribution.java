import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Retribution {

	public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        final int t = sc.nextInt();
        final int f = sc.nextInt();

        final HashSet<Integer[]> judgesLocations1 = new HashSet<>();
        final HashSet<Integer[]> judgesLocations2 = new HashSet<>();
        final HashSet<Integer[]> tarLocations = new HashSet<>();
        final HashSet<Integer[]> featherLocations = new HashSet<>();

        for (int i = 0; i < n; i++) {
            final Integer[] location = new Integer[3];
            location[0] = sc.nextInt();
            location[1] = sc.nextInt();
            location[2] = i;
            judgesLocations1.add(location);
            judgesLocations2.add(location);
        }
        
        for (int i = 0; i < t; i++) {
            final Integer[] location = new Integer[3];
            location[0] = sc.nextInt();
            location[1] = sc.nextInt();
            location[2] = i;
            tarLocations.add(location);
        }

        for (int i = 0; i < f; i++) {
            final Integer[] location = new Integer[3];
            location[0] = sc.nextInt();
            location[1] = sc.nextInt();
            location[2] = i;
            featherLocations.add(location);
        }

        double totalDistance = 0;

        while (!judgesLocations1.isEmpty()) {
            double minDistance = Double.MAX_VALUE;
            Integer[] judgeRemoved = { 0, 0, 0 };
            Integer[] tarRemoved = { 0, 0, 0 };

            for (final Integer[] tarLocation : tarLocations) {
                for (final Integer[] judgeLocation : judgesLocations1) {
                    final double distance = getDistance(tarLocation, judgeLocation);
                    if (distance < minDistance) {
                        judgeRemoved = judgeLocation;
                        tarRemoved = tarLocation;
                        minDistance = distance;
                    } else if (Double.compare(distance, minDistance) == 0) {
                        if (judgeRemoved[2] > judgeLocation[2]) {
                            judgeRemoved = judgeLocation;
                            tarRemoved = tarLocation;
                        } else if (judgeRemoved[2] == judgeLocation[2] && tarRemoved[2] > tarLocation[2]) {
                            tarRemoved = tarLocation;
                        }
                    }
                    
                }
            }

            totalDistance += minDistance;
            judgesLocations1.remove(judgeRemoved);
            tarLocations.remove(tarRemoved);
        }

        while (!judgesLocations2.isEmpty()) {
            double minDistance = Double.MAX_VALUE;
            Integer[] judgeRemoved = { 0, 0, 0 };
            Integer[] featherRemoved = { 0, 0, 0 };

            for (final Integer[] featherLocation : featherLocations) {
                for (final Integer[] judgeLocation : judgesLocations2) {
                    final double distance = getDistance(featherLocation, judgeLocation);
                    if (distance < minDistance) {
                        judgeRemoved = judgeLocation;
                        featherRemoved = featherLocation;
                        minDistance = distance;
                    } else if (Double.compare(distance, minDistance) == 0) {
                        if (judgeRemoved[2] > judgeLocation[2]) {
                            judgeRemoved = judgeLocation;
                            featherRemoved = featherLocation;
                        } else if (judgeRemoved[2] == judgeLocation[2] && featherRemoved[2] > featherLocation[2]) {
                            featherRemoved = featherLocation;
                        }
                    }
                }
            }

            totalDistance += minDistance;
            judgesLocations2.remove(judgeRemoved);
            featherLocations.remove(featherRemoved);
        }

        System.out.println(totalDistance);
        sc.close();
    }

    public static double getDistance(final Integer[] a, final Integer[] b) {
        return Math.sqrt(Math.pow((double) a[0] - b[0], 2) + Math.pow((double) a[1] - b[1], 2));
	}

}