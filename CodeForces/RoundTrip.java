package CodeForces;

import java.io.*;
import java.util.*;

public class RoundTrip {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");

        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        List<List<Integer>> adj = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);

        for (int start = 1; start <= n; start++) {
            if (visited[start]) continue;

            Deque<int[]> stack = new ArrayDeque<>();
            stack.push(new int[]{start, -1}); // node, parent

            while (!stack.isEmpty()) {
                int[] top = stack.pop();
                int node = top[0];
                int par = top[1];

                if (!visited[node]) {
                    visited[node] = true;
                    parent[node] = par;
                }

                for (int neigh : adj.get(node)) {
                    if (neigh == par) continue;

                    if (!visited[neigh]) {
                        stack.push(new int[]{neigh, node});
                    } else {
                        // Found a back-edge -> cycle exists
                        List<Integer> cycle = new ArrayList<>();

                        int cur = node;
                        cycle.add(neigh);
                        while (cur != neigh) {
                            cycle.add(cur);
                            cur = parent[cur];
                        }
                        cycle.add(neigh);

                        Collections.reverse(cycle);

                        System.out.println(cycle.size());
                        for (int x : cycle) System.out.print(x + " ");
                        System.out.println();
                        return;
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
