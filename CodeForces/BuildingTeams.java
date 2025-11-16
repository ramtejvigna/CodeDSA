package CodeForces;

import java.io.*;
import java.util.*;

public class BuildingTeams {
    public static void main(String[] args) throws Exception {
        Scanner fs = new Scanner(System.in);

        int n = fs.nextInt();
        int m = fs.nextInt();

        List<List<Integer>> adj = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] color = new int[n + 1];
        Arrays.fill(color, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                color[i] = 0;
                q.add(i);

                while (!q.isEmpty()) {
                    int node = q.poll();

                    for (int neigh : adj.get(node)) {
                        if (color[neigh] == -1) {
                            color[neigh] = 1 - color[node];
                            q.add(neigh);
                        } else if (color[neigh] == color[node]) {
                            System.out.println("IMPOSSIBLE");
                            return;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++)
            sb.append(color[i] + 1).append(' ');
        System.out.println(sb.toString());
    }
}
