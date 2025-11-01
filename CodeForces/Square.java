package CodeForces;

import java.util.Scanner;

public class Square {
    private static boolean checkPossible(int s1, int s2, int s3, int s4) {
        return s1 == s2 && s2 == s3 && s3 == s4;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0) {
            int s1 = sc.nextInt();
            int s2 = sc.nextInt();
            int s3 = sc.nextInt();
            int s4 = sc.nextInt();

            System.out.println(checkPossible(s1,s2,s3,s4) ? "YES" : "NO");
        }
    }
}
