package CodeForces;

import java.io.*;
import java.util.*;

public class ShortestRouteOne {
    static class Pair {
        int node;
        long dist;
        Pair(int n, long d) { node = n; dist = d; }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int m = fs.nextInt();

        List<List<Pair>> g = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            long w = fs.nextLong();
            g.get(u).add(new Pair(v, w));
        }

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.dist));
        pq.add(new Pair(1, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            long d = curr.dist;

            if (d != dist[u]) continue;

            for (Pair p : g.get(u)) {
                int v = p.node;
                long w = p.dist;

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        for (int i=1;i<=n;i++) {
            System.out.print(dist[i] + " ");
        }
    }

    // FastScanner for high input load
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = is; }
        private int read() throws IOException {
            if (ptr >= len) {
                ptr = 0;
                len = in.read(buffer);
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        long nextLong() throws IOException {
            long x = 0; int c;
            while ((c = read()) <= ' ') ;
            boolean neg = c == '-';
            if (neg) c = read();
            for (; c > ' '; c = read()) x = x * 10 + c - '0';
            return neg ? -x : x;
        }
        int nextInt() throws IOException { return (int) nextLong(); }
    }
}
