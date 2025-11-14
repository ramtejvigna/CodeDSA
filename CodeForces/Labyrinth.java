import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

class Labyrinth {

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static final char[] moveChar = {'U', 'D', 'L', 'R'};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = br.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++)
            grid[i] = br.readLine().toCharArray();

        int sx = -1, sy = -1, ex = -1, ey = -1;

        // Find A and B
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'A') {
                    sx = i; sy = j;
                }
                if (grid[i][j] == 'B') {
                    ex = i; ey = j;
                }
            }
        }

        // BFS
        boolean[][] vis = new boolean[n][m];
        char[][] parentMove = new char[n][m];
        int[][] px = new int[n][m];
        int[][] py = new int[n][m];

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy});
        vis[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            if (x == ex && y == ey) break;  // reached B

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
                        !vis[nx][ny] && grid[nx][ny] != '#') {

                    vis[nx][ny] = true;
                    px[nx][ny] = x;
                    py[nx][ny] = y;
                    parentMove[nx][ny] = moveChar[d];

                    q.add(new int[]{nx, ny});
                }
            }
        }

        // If cannot reach B
        if (!vis[ex][ey]) {
            System.out.println("NO");
            return;
        }

        // Reconstruct path
        StringBuilder path = new StringBuilder();
        int cx = ex, cy = ey;

        while (cx != sx || cy != sy) {
            path.append(parentMove[cx][cy]);
            int tx = px[cx][cy];
            int ty = py[cx][cy];
            cx = tx;
            cy = ty;
        }

        System.out.println("YES");
        System.out.println(path.length());
        System.out.println(path.reverse().toString());
    }
}
