import java.util.*;

public class WhichBase {

    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        for (int i = 0; i < x; i++) {
            int ID = scan.nextInt();
            String line = scan.next();
            runCode(line, ID);
        }
        scan.close();
    }

    public static void runCode(String line, int ID) {
        System.out.print(ID + " ");
        try {
            long val = Long.parseLong(line,8);
            System.out.print(val + " ");
        } catch (Exception E) {
            System.out.print("0 ");
        }
        System.out.print(Long.parseLong(line) + " ");
        System.out.println(Long.parseLong(line,16));
    }
}