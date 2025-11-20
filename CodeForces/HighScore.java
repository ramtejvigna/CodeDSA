package CodeForces;

import java.util.*;
import java.io.*;

public class HighScore {
    static class Edge {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = br.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        Edge[] edges = new Edge[m];

        for (int i = 0; i < m; i++) {
            String[] arr = br.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            int w = Integer.parseInt(arr[2]);
            edges[i] = new Edge(a, b, -w); // negate weights to maximize
        }

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        // Standard Bellman-Ford
        for (int i = 1; i < n; i++) {
            for (Edge e : edges) {
                if (dist[e.u] != Long.MAX_VALUE && dist[e.u] + e.w < dist[e.v]) {
                    dist[e.v] = dist[e.u] + e.w;
                }
            }
        }

        // Detect nodes affected by negative cycles
        boolean[] affected = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            Edge e = edges[i];
            if (dist[e.u] != Long.MAX_VALUE && dist[e.u] + e.w < dist[e.v]) {
                affected[e.v] = true;
            }
        }

        // Propagate cycle reachability
        for (int i = 0; i < n; i++) {
            for (Edge e : edges) {
                if (affected[e.u]) affected[e.v] = true;
            }
        }

        // If node n is reachable from any negative cycle → infinite score
        if (affected[n]) {
            System.out.println(-1);
            return;
        }

        // Otherwise output max score
        System.out.println(-dist[n]);
    }
}
