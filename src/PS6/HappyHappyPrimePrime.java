import java.util.HashSet;
import java.util.Scanner;

public class HappyHappyPrimePrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); 
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			int ID = sc.nextInt();
			int num = sc.nextInt();
			runCode(ID, num);
		}

	}
	
	public static void runCode(int ID, int num) {
		if (isPrime(num) && isHappy(num)) System.out.println(ID + " " + num + " YES");
		else System.out.println(ID + " " + num + " NO");
	}
	
	public static boolean isPrime(int num) {
		if (num == 1 || num % 2 == 0) {
			if (num == 2) return true;
			return false;
		}
		for (int i = 3; i <= Math.sqrt(num); i += 2) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isHappy(int num) {
		HashSet<Integer> set = new HashSet<Integer>();
		while (num != 1) {
			int squareSum = 0;
			while (num != 0) {
				squareSum += (num%10)*(num%10);
				num /= 10;
			}
			num = squareSum;
			if(!set.add(num)) {
				return false;
			}
		}
		return true;
	}

}
