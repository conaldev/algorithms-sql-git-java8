import java.util.Scanner;


public class SpecialNumber_Septeni {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double i = (double) n;
        double powCharHalf = 1;
        while (true) {
            i -= Math.pow(3, powCharHalf);
            if (i < 0) {
                i += Math.pow(3, powCharHalf);
                break;
            }
            powCharHalf++;
        }
        System.out.println("powCharHalf = " + powCharHalf);
        System.out.println("i after = " + i);
        StringBuilder ans = new StringBuilder();
        int lengthHalf = (int) powCharHalf;
        int mu = (int) powCharHalf - 1;
        int minus;
        while (ans.length() < lengthHalf) {
            int num1 = (int) Math.pow(3, mu);
            int num2 = 2 * (int) Math.pow(3, mu);
            int num3 = 3 * (int) Math.pow(3, mu);
            if (i / num1 <= 1) {
                minus = 0;
                ans.append("2");
            } else if (i / num2 <= 1) {
                minus = num1;
                ans.append("3");
            } else {
                minus = num2;
                ans.append("4");
            }
            i -= minus;
            mu--;
        }
        StringBuilder temp = new StringBuilder(ans);
        ans.append(temp.reverse());
        System.out.println("ans = " +ans.toString());
    }
}
