import java.util.Arrays;
import java.util.Scanner;

public class PermutationDescentCounts {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		int[][] arr = getArray();
		for (int i = 0; i < p; i++) {
			int ID = sc.nextInt();
			int n = sc.nextInt();
			int v = sc.nextInt();
			runCode(arr, n, v, ID);
		}
	}
	
	public static void runCode(int[][] arr, int n, int v, int ID) {
		System.out.print(ID + " ");
		System.out.println(arr[n][v]);
	}
	
	public static int[][] getArray() {
		int[][] arr = new int[101][101];
		arr[1][0] = 1;
		arr[2][0] = 1;
		arr[2][1] = 1;
		for (int i = 3; i < 101; i++) {
			for (int j = 0; j < i; j++) {
				if (j == 0 || j == i-1) {
					arr[i][j] = 1;
				} else {
					arr[i][j] = (arr[i-1][j-1]*(i-j) + arr[i-1][j]*(j+1)) % 1001113;
				}
			}
		}
		return arr;
	}

}
