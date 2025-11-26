package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiceCombinations {
    private static int solve(int n) {
        int MOD = 1_000_000_007;
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i=1;i<=n;i++) {
            for (int j=1;j<=6;j++) {
                if (i - j >= 0) {
                    dp[i] = (dp[i] + dp[i-j]) % MOD;
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        System.out.println(solve(n));
    }
}