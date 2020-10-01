package PS3;

import java.util.Scanner;

public class SoftPass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pass = sc.next();
        String user = sc.next();

        if (pass.equals(user) || isPrepend(pass, user) || isAppend(pass, user)||isFlippedCase(pass, user)){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean isPrepend(String a, String b) {
        return Character.isDigit(a.charAt(0)) && a.substring(1).equals(b);
    }

    public static boolean isAppend(String a, String b) {
        return Character.isDigit(a.charAt(a.length()-1)) && a.substring(0, a.length()-1).equals(b);
    }

    public static boolean isFlippedCase(String a, String b) {
        String flipped = "";
        for (char c: a.toCharArray()) {
            if (Character.isUpperCase(c)){
                flipped += (""+c).toLowerCase();
            } else {
                flipped += (""+c).toUpperCase();
            }
        }
        return flipped.equals(b);
    }
}
