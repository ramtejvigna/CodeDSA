package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimizingCoins {
    private static int solve(int[] coins, int x, int sum) {
        if (sum == x) return sum;

        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().trim().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int x = Integer.parseInt(firstLine[1]);

        String[] secondLine = br.readLine().trim().split(" ");
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(secondLine[i]);
        }

        System.out.println(solve(coins, x, 0));

    }
}
