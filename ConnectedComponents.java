import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.*;

public class ConnectedComponents {
    private static void dfs(int node, List<List<Integer>> adjList, boolean[] vis) {
        vis[node] = true;

        for (int neigh : adjList.get(node)) {
            if (!vis[neigh]) {
                dfs(neigh, adjList, vis);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = br.readLine().trim();
        int n = Integer.parseInt(firstLine);

        int m = Integer.parseInt(br.readLine().trim());

        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] edge = br.readLine().trim().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        int cnt = 0;

        for(int i=0;i<n;i++) {
            if (!visited[i]) {
                cnt++;
                dfs(i, adjList, visited);
            }
        }

        System.out.println(cnt);
    }
}