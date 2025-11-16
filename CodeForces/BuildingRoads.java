package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BuildingRoads {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = br.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            parts = br.readLine().split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n + 1];

        List<Integer> centers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                centers.add(i);
                Queue<Integer> queue = new LinkedList<>();
                vis[i] = true;
                queue.add(i);

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int neighbor : adj.get(node)) {
                        if (!vis[neighbor]) {
                            vis[neighbor] = true;
                            queue.add(neighbor);
                        }
                    }
                }
            }
        }

        System.out.println(centers.size() - 1);
        for (int i = 1; i < centers.size(); i++) {
            System.out.println(centers.get(i - 1) + " " + centers.get(i));
        }
    }
}
