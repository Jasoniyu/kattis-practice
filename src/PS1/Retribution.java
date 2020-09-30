package PS1;

import java.util.HashSet;
import java.util.Scanner;

public class Retribution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt();
		int f = sc.nextInt();
		
		HashSet<Integer[]> judgesLocations1 = new HashSet<Integer[]>();
		HashSet<Integer[]> judgesLocations2 = new HashSet<Integer[]>();
		HashSet<Integer[]> tarLocations = new HashSet<Integer[]>();
		HashSet<Integer[]> featherLocations = new HashSet<Integer[]>();
		
		for (int i = 0; i < n; i++) {
			Integer[] location = new Integer[3];
			location[0] = sc.nextInt();
			location[1] = sc.nextInt();
			location[2] = i;
			judgesLocations1.add(location);
			judgesLocations2.add(location);
		}
		
		for (int i = 0; i < t; i++) {
			Integer[] location = new Integer[3];
			location[0] = sc.nextInt();
			location[1] = sc.nextInt();
			location[2] = i;
			tarLocations.add(location);
		}
		
		for (int i = 0; i < f; i++) {
			Integer[] location = new Integer[3];
			location[0] = sc.nextInt();
			location[1] = sc.nextInt();
			location[2] = i;
			featherLocations.add(location);
		}
		
		double totalDistance = 0;
		
		while (!judgesLocations1.isEmpty()) {
			double minDistance = Double.MAX_VALUE;
			Integer[] judgeRemoved = {0, 0, 0};
			Integer[] tarRemoved = {0, 0, 0};
			
			for (Integer[] tarLocation : tarLocations) {
				for (Integer[] judgeLocation : judgesLocations1) {
					double distance = getDistance(tarLocation, judgeLocation);
					if (distance < minDistance) {
						judgeRemoved = judgeLocation;
						tarRemoved = tarLocation;
						minDistance = distance;
					} else if (Double.compare(distance, minDistance) == 0) {
						if (judgeRemoved[2] > judgeLocation[2]) {
							judgeRemoved = judgeLocation;
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
			Integer[] judgeRemoved = {0, 0, 0};
			Integer[] featherRemoved = {0, 0, 0};
			
			for (Integer[] featherLocation : featherLocations) {
				for (Integer[] judgeLocation : judgesLocations2) {
					double distance = getDistance(featherLocation, judgeLocation);
					if (distance < minDistance) {
						judgeRemoved = judgeLocation;
						featherRemoved = featherLocation;
						minDistance = distance;
					} else if (Double.compare(distance, minDistance) == 0) {
						if (judgeRemoved[2] > judgeLocation[2]) {
							judgeRemoved = judgeLocation;
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
		// while the judges set is not empty
			// Iterate through the tarLocations set
				// Iterate through the judgesLocations1 set
					// For each location, compare the distance to the minDistance
					// if we find a new minDistance, then we store the judge and location of the repository
			
			// get the minDistance and remove the elements from both judgesLocation1 and tarLocations
			// add the minDistance to some global counter variable
		
		// while the judges set is not empty
					// Iterate through the tarLocations set
						// Iterate through the judgesLocations1 set
							// For each location, compare the distance to the minDistance
							// if we find a new minDistance, then we store the judge and location of the repository
					
					// get the minDistance and remove the elements from both judgesLocation1 and tarLocations
					// add the minDistance to some global counter variable
		

		
	}
	
	public static double getDistance(Integer[] a, Integer[] b) {
		return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
	}

}
