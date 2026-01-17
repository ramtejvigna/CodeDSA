import java.util.*;
import java.io.*;

class FlightDiscount {

    static class Edge {
        int to;
        long weight;

        Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class State {
        int node;
        int usedDiscount;
        long cost;

        State(int node, int usedDiscount, long cost) {
            this.node = node;
            this.usedDiscount = usedDiscount;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        @SuppressWarnings("unchecked")
        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] edgeLine = br.readLine().split(" ");
            int a = Integer.parseInt(edgeLine[0]) - 1; // convert to 0-based
            int b = Integer.parseInt(edgeLine[1]) - 1;
            long w = Long.parseLong(edgeLine[2]);

            graph[a].add(new Edge(b, w));
        }

        long[][] dist = new long[n][2];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], Long.MAX_VALUE);

        dist[0][0] = 0;

        PriorityQueue<State> pq =
                new PriorityQueue<>(Comparator.comparingLong(s -> s.cost));
        pq.add(new State(0, 0, 0));

        while (!pq.isEmpty()) {
            State curr = pq.poll();
            int node = curr.node;
            int usedDiscount = curr.usedDiscount;
            long cost = curr.cost;

            if (cost > dist[node][usedDiscount]) continue;

            for (Edge edge : graph[node]) {
                int nextNode = edge.to;

                // Without discount
                long normalCost = cost + edge.weight;
                if (normalCost < dist[nextNode][usedDiscount]) {
                    dist[nextNode][usedDiscount] = normalCost;
                    pq.add(new State(nextNode, usedDiscount, normalCost));
                }

                // With discount (only once)
                if (usedDiscount == 0) {
                    long discountedCost = cost + edge.weight / 2;
                    if (discountedCost < dist[nextNode][1]) {
                        dist[nextNode][1] = discountedCost;
                        pq.add(new State(nextNode, 1, discountedCost));
                    }
                }
            }
        }

        System.out.println(dist[n - 1][1]);
    }
}
