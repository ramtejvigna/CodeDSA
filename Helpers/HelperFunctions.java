package Helpers;

import java.util.Scanner;

public class HelperFunctions {
    public void takeArrayInput(int[] arr, int n, Scanner sc) {
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public boolean isPrime(int num) {
        if(num == 2 || num == 3) return true;

        for(int i=2;i*i<=num;i++) {
            if(num % i == 0) return false;
        }

        return true;
    }

    public boolean isEven(int num) {
        return num % 2 == 0;
    }

    public boolean isOdd(int num) {
        return !isEven(num);
    }

    public int[] reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;

        while(left < right) {
            swap(arr, left++, right--);
        }

        return arr;
    }
}
