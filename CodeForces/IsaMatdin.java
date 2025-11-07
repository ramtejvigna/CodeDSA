package CodeForces;

import java.util.Arrays;
import java.util.Scanner;

public class IsaMatdin {
    private static void printArray(int[] arr) {
        for (int idx = 0; idx < arr.length; idx++) {
            System.out.print(arr[idx] + " ");
        }
    }
    private static int[] checkSort(int[] arr, int n) {
        boolean hasEven = false, hasOdd = false;

        for(int val : arr) {
            if((val & 1) == 0) hasEven = true;
            else hasOdd = true;

            if(hasEven && hasOdd) {
                Arrays.sort(arr);
                return arr;
            }
        }
        return arr;
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

            printArray(checkSort(arr, n));
            System.out.println();
        }

        sc.close();
    }
}
