import java.util.Arrays;
import java.util.Scanner;

public class Mancala {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); 
		
		int[][] boards = getBoards();
		
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int ID = sc.nextInt();
			int count = sc.nextInt();
			System.out.print(ID + " ");
			int bins = 0;
			
			int[] arr = boards[count-1];
			for (int j = 80; j >= 0; j--) {
				if (arr[j] != 0) {
					bins = arr[j];
					break;
				}
			}
			System.out.println(bins);
			for (int j = 0; j < bins; j++) {
				System.out.print(arr[j] + " ");
				if ((j+1) % 10 == 0 && (j+1) != bins) {
					System.out.println();
				}
			}
			System.out.println();
		}
	}
	
	
	public static int[][] getBoards() {
		int[][] arr = new int[2000][81];
		arr[0][0] = 1;
		for (int r = 1; r < 2000; r++) {
			boolean found = false;
			for (int c = 0; c < 81; c++) {
				if (!found) {
					if (arr[r-1][c] != 0) {
						arr[r][c] = arr[r-1][c]-1;
					} else {
						arr[r][c] = c+1;
						found = true;
					}
				} else {
					arr[r][c] = arr[r-1][c];
				}
			}
		}
		return arr;
	}
	

}
