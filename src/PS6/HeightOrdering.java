import java.util.Scanner;

public class HeightOrdering {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); 
				
			int n = sc.nextInt();
				
			for (int i = 0; i < n; i++) {
				int ID = sc.nextInt();
				int[] heights = new int[20];
				for (int j = 0; j < 20; j++) {
					heights[j] = sc.nextInt();
				}
				runCode(ID, heights);
			}
		}
	
	public static void runCode(int ID, int[] heights) {
		int count = 0;
		for (int i = 1; i < 20; i++) {
			for (int j = 0; j < i; j++) {
				if (heights[j] > heights[i]) {
					count++;
				}
			}
		}
		System.out.println(ID + " " + count);
	}

}
