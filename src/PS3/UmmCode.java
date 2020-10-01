package PS3;

import java.util.Arrays;
import java.util.Scanner;

public class UmmCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] speech = sc.nextLine().split(" ");
        System.out.println(decode(umsOnly(speech)));
    }

    public static String umsOnly(String[] speech) {
        StringBuilder res = new StringBuilder();
        for (String s : speech) {
            res.append(isCode(s));
        }
        return res.toString();
    }

    public static String isCode(String s) {
        StringBuilder toRet = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                return "";
            } else if (Character.isLetter(c)) {
                if (c != 'u' && c != 'm') {
                    return "";
                } else {
                    toRet.append(c);
                }
            }
        }
        return toRet.toString();
    }

    public static String decode(String encoded) {
        StringBuilder toRet = new StringBuilder();
        for (int i = 0; i < encoded.length(); i += 7) {
            toRet.append(umToBinary(encoded.substring(i, i+7)));
        }
        return toRet.toString();
    }

    public static char umToBinary(String s) {
        int val = 0;
        for(int i = 0; i<7; i++){
            val = val<<1;
            if (s.charAt(i)=='u') {
                val = val|1;
            }
        }
        return (char)(val);
    }
}
