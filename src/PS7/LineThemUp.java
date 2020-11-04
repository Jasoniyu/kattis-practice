import java.util.Scanner;

public class LineThemUp {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.next();
		}
		if (isDecreasing(arr)) {
			System.out.println("DECREASING");
		} else if (isIncreasing(arr)) {
			System.out.println("INCREASING");
		} else {
			System.out.println("NEITHER");
		}
	}
	
	public static boolean isDecreasing(String[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i].compareTo(arr[i-1]) > 0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isIncreasing(String[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i].compareTo(arr[i-1]) < 0) {
				return false;
			}
		}
		return true;
	}

}
