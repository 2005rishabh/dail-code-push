package codeforces;
import java.util.*;

class A_Bit{
    public static void main(String[] args) {
        int ans = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            arr.add(sc.next());
        }

        for(int i = 0; i < n; i++) {
            String s = arr.get(i);
            if(s.contains("++")) {
                ans++;
            } else if(s.contains("--")) {
                ans--;
            }
        }
        System.out.println(ans);
    }
}