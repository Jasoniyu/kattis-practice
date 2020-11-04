import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class RationalSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int p = sc.nextInt();
		for (int i = 0; i < p; i++) {
			int ID = sc.nextInt();
			String fraction = sc.next();
			String[] arr = fraction.split("/");
			int numerator = Integer.parseInt(arr[0]);
			int denominator = Integer.parseInt(arr[1]);
			runCode(ID, numerator, denominator);
		}
	}
	
	public static void runCode(int ID, int num, int denom) {
		
		if (num < denom) {
			// left child
			denom -= num;
			num += denom;
			System.out.println(ID + " " + num + "/" + denom);
		} else {
			// right child
			if (denom == 1) {
				System.out.println(ID + " 1/" + (num+1));
			} else {
				int count = num/denom;
				int parentNum = num%denom;
				int parentDenom = denom-parentNum;
				parentNum += parentDenom; // go right once
				parentDenom += parentNum*count; // go left "count" times
				System.out.println(ID + " " + parentNum + "/" + parentDenom);
			}
		}
	}

}
