package PS3;

import java.util.Scanner;

public class Basketball {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 0;
        String game = sc.next();
        for (int i = 0; i < game.length(); i += 2) {
            int score = Integer.parseInt("" + game.charAt(i + 1));
            if (game.charAt(i) == 'A'){
                a+= score;
            } else {
                b+= score;
            }
        }
        if(a>b){
            System.out.println("A");
        } else {
            System.out.println("B");
        }
    }
}
