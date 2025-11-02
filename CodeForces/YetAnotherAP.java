package CodeForces;

import java.util.Scanner;

public class YetAnotherAP {
    private static int gcd(int a, int b) {
        if(b == 0) return a;

        return gcd(b, a % b);
    }
    private static int getMin(int[] arr) {
        int min = Integer.MAX_VALUE;

        for(int i=0;i<arr.length;i++) {
            if(min > arr[i]) min = arr[i];
        }

        return min;
    }
    private static int getSmallGCD(int[] arr, int n) {
        int smallest = getMin(arr);

        for(int i=0;i<arr.length;i++) {
            for(int j=2;j<Integer.MAX_VALUE;j++) {
                if(gcd(arr[i], j) == 1) return j;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0) {
            int n = sc.nextInt();

            int[] arr = new int[n];

            for (int idx = 0; idx < arr.length; idx++) {
                arr[idx] = sc.nextInt();
            }

            System.out.println(getSmallGCD(arr, n));
        }
    }
}
