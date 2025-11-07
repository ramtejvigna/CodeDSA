package CodeForces;

import java.util.Scanner;

class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long totalSum = (long) n * (n + 1) / 2;

        long arrSum = 0;
        for (int i = 0; i < n - 1; i++) {
            arrSum += sc.nextLong();
        }

        System.out.print(totalSum - arrSum);
        sc.close();
    }
}
