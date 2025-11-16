package CodeForces;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class MessageRoute {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = br.readLine().split(" ");

        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<=n;i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        
        queue.add(1);
        visited[1] = true;

        int[] parent = new int[n+1];
        parent[1] = -1;
        boolean found = false;
        while(!queue.isEmpty()) {
            int node = queue.poll();

            if (node == n) {
                found = true;
                break;
            }

            for(int neigh : adj.get(node)) {
                if (!visited[neigh]) {
                    visited[neigh] = true;
                    parent[neigh] = node;
                    queue.add(neigh);
                }
            }
        }

        if (!found) {
            System.out.println("IMPOSSIBLE");
        } else {
            List<Integer> path = new ArrayList<>();
            int curr = n;
            while (curr != -1) {
                path.add(curr);
                curr = parent[curr];
            }
            Collections.reverse(path);

            System.out.println(path.size());
            for (int node : path) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}
