package CodeForces;

import java.util.*;

public class YourName {
    private static boolean getMatch(String cubes, String t, int n) {
        if (cubes.length() != n || t.length() != n) return false;

        Map<Character, Integer> mpp = new HashMap<>();
        for (char c : cubes.toCharArray())
            mpp.put(c, mpp.getOrDefault(c, 0) + 1);

        for (char c : t.toCharArray()) {
            if (mpp.getOrDefault(c, 0) == 0) return false;
            mpp.put(c, mpp.get(c) - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            String cubes = sc.next();
            String t = sc.next();

            System.out.println(getMatch(cubes, t, n) ? "YES" : "NO");
        }
        sc.close();
    }
}