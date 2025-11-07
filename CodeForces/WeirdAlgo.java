package CodeForces;

import java.util.Scanner;

class WeirdAlgo {
    private static void weirdAlgo(long n) {
        StringBuilder sb = new StringBuilder();
        while(n != 1) {
            sb.append(n).append(" ");
            if((n & 1) == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
        }
        System.out.print(sb.toString() + 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        weirdAlgo(n);

        sc.close();
    }
}
