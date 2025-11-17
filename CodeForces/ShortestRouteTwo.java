package CodeForces;

import java.util.*;
import java.io.*;

public class ShortestRouteTwo {
    static class Pair {
        int node;
        int weight;

        Pair(int n, int w) {
            node = n;
            weight = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = br.readLine().split(" ");

        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int q = Integer.parseInt(parts[2]);

        long[][] dist = new long[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            parts = br.readLine().split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            int w = Integer.parseInt(parts[2]);

            dist[u][v] = Math.min(dist[u][v], w);
            dist[v][u] = Math.min(dist[v][u], w);
        }

        for (int k=1;k<=n;k++) {
            for (int i=1;i<=n;i++) {
                long dik = dist[i][k];
                if (dik == Long.MAX_VALUE) continue;

                for(int j=1;j<=n;j++) {
                    if (dist[k][j] == Long.MAX_VALUE) continue;

                    if (dist[i][j] > dik + dist[k][j]) {
                        dist[i][j] = dik + dist[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            parts = br.readLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);

            long ans = dist[a][b];
            sb.append(ans == Long.MAX_VALUE ? -1 : ans).append("\n");
        }

        System.out.print(sb.toString());
    }
}
