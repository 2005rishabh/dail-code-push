import java.util.*;

public class ToWordsAfterRotationSame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int result = trs(s1, s2);
        System.out.println(result); 
    }

    public static int trs(String s1, String s2) {
        String str = s1 + s1;
        if (str.contains(s2)) {
            return 1;
        }
        return -1;
    }
}