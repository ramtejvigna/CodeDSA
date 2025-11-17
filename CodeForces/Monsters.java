package CodeForces;

import java.io.*;
import java.util.*;

public class Monsters {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static final char[] mv = {'U', 'D', 'L', 'R'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");

        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        char[][] grid = new char[n][m];
        int[][] monsterTime = new int[n][m];
        int[][] playerTime = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            grid[i] = line.toCharArray();
            Arrays.fill(monsterTime[i], Integer.MAX_VALUE);
            Arrays.fill(playerTime[i], Integer.MAX_VALUE);
        }

        ArrayDeque<int[]> mq = new ArrayDeque<>();
        int sx = -1, sy = -1;

        // Collect monster positions
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'M') {
                    mq.add(new int[]{i, j});
                    monsterTime[i][j] = 0;
                }
                if (grid[i][j] == 'A') {
                    sx = i;
                    sy = j;
                }
            }
        }

        // BFS for monsters — multi-source
        while (!mq.isEmpty()) {
            int[] cur = mq.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
                    grid[nx][ny] != '#' &&
                    monsterTime[nx][ny] > monsterTime[x][y] + 1) {

                    monsterTime[nx][ny] = monsterTime[x][y] + 1;
                    mq.add(new int[]{nx, ny});
                }
            }
        }

        // BFS for player
        ArrayDeque<int[]> pq = new ArrayDeque<>();
        pq.add(new int[]{sx, sy});
        playerTime[sx][sy] = 0;

        char[][] parent = new char[n][m];
        int[][] px = new int[n][m];
        int[][] py = new int[n][m];

        boolean escaped = false;
        int ex = -1, ey = -1;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1];

            // If A reaches a boundary → escape
            if (x == 0 || x == n - 1 || y == 0 || y == m - 1) {
                escaped = true;
                ex = x; ey = y;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
                    grid[nx][ny] != '#' &&
                    playerTime[nx][ny] == Integer.MAX_VALUE) {

                    int nextTime = playerTime[x][y] + 1;

                    // Player cannot move into a cell if monster reaches earlier or same time
                    if (nextTime < monsterTime[nx][ny]) {
                        playerTime[nx][ny] = nextTime;
                        parent[nx][ny] = mv[d];
                        px[nx][ny] = x;
                        py[nx][ny] = y;
                        pq.add(new int[]{nx, ny});
                    }
                }
            }
        }

        if (!escaped) {
            System.out.println("NO");
            return;
        }

        // reconstruct path
        StringBuilder path = new StringBuilder();
        int cx = ex, cy = ey;

        while (cx != sx || cy != sy) {
            path.append(parent[cx][cy]);
            int tempX = px[cx][cy];
            int tempY = py[cx][cy];
            cx = tempX;
            cy = tempY;
        }

        path.reverse();
        System.out.println("YES");
        System.out.println(path.length());
        System.out.println(path.toString());
    }
}
