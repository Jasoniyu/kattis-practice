package PS4;

import java.util.Arrays;
import java.util.Scanner;

public class DASort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        for (int i = 0; i < p; i++) {
            int id = sc.nextInt();
            int size = sc.nextInt();
            int[] prob = new int[size];
            for (int j = 0; j < size; j++) {
                prob[j] = sc.nextInt();
            }
            solve(id, prob);
        }
    }

    public static void solve(int id, int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        int count = 0;
        int index = 0;
        for (int i : arr) {
            if (i == sorted[index]) {
                index++;
            } else {
                count++;
            }
        }
        System.out.println(id + " " + count);
    }
}
