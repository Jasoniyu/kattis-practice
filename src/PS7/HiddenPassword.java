import java.util.Scanner;

public class HiddenPassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Go through the code and compare with the first character of message
		Scanner sc = new Scanner(System.in);
		String password = sc.next();
		String message = sc.next();
		
		for (int i = 0; i < message.length(); i++) {
			String letter = message.substring(i, i+1);
			int index = password.indexOf(letter);
			if (index == 0) {
				password = password.substring(1);
			} else if (index > 0) {
				System.out.println("FAIL");
				return;
			}
		}
		if (password.equals("")) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
	}

}
