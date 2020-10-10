import java.util.*;

public class FBIUniversalControlNumbers {

    static TreeMap<Character,Integer> decode;
    static int[] coefficients;
    public static void main(String[] args) {
        decode = new TreeMap<>();
        decode.put('0',0);
        decode.put('1',1);
        decode.put('2',2);
        decode.put('3',3);
        decode.put('4',4);
        decode.put('5',5);
        decode.put('6',6);
        decode.put('7',7);
        decode.put('8',8);
        decode.put('9',9);
        decode.put('A',10);
        decode.put('C',11);
        decode.put('D',12);
        decode.put('E',13);
        decode.put('F',14);
        decode.put('H',15);
        decode.put('J',16);
        decode.put('K',17);
        decode.put('L',18);
        decode.put('M',19);
        decode.put('N',20);
        decode.put('P',21);
        decode.put('R',22);
        decode.put('T',23);
        decode.put('V',24);
        decode.put('W',25);
        decode.put('X',26);
        decode.put('B',8);
        decode.put('G',11);
        decode.put('I',1);
        decode.put('O',0);
        decode.put('Q',0);
        decode.put('S',5);
        decode.put('U',24);
        decode.put('Y',24);
        decode.put('Z',2);

        coefficients = new int[]{2,4,5,7,8,10,11,13};
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        String line;
        for (int i = 0; i < x; i++) {
            int ID = scan.nextInt();
            line = scan.next();
            runCode(line, ID);
        }
        scan.close();
    }

    public static void runCode(String inputCode, int ID) {
        long decimal = 0;
        long value = 0;
        for (int i = 0; i < 8; i++) {
            int val = decode.get(inputCode.charAt(i));
            decimal += val*coefficients[i];
            value *= 27;
            value += val;
        }
        long modded = decimal % 27;
        int check = decode.get(inputCode.charAt(8));
        System.out.print(ID + " ");
        if (check == modded) {
            System.out.println(value);
        } else {
            System.out.println("Invalid");
        }
    }
}