import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();  // use string (important for large input)

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';

            if (i == 0 && digit == 9) {
                result.append(9);
            } else {
                result.append(Math.min(digit, 9 - digit));
            }
        }

        System.out.println(result);
    }
}