import java.util.Scanner;

public class ACMContestScoring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 26-length array
		// for each line, if it's right, then add total time to a running total
		// if it's wrong, then add 20 minutes
		Scanner sc = new Scanner(System.in);
		int totalTime = 0;
		int numQuestionsSolved = 0;
		int[] arr = new int[26];
		while (sc.hasNext()) {
			int time = sc.nextInt();
			if (time == -1) {
				break;
			}
			int question = (int) sc.next().charAt(0)-65;
			String status = sc.next();
			if (status.equals("right")) {
				numQuestionsSolved++;
				totalTime += (time + arr[question]);
			} else {
				arr[question] += 20;
			}
		}
		System.out.println(numQuestionsSolved + " " + totalTime);
	}

}
