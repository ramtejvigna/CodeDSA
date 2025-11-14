package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

class CountingRooms {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    private static int countRooms(char[][] grid, int n, int m) {
        boolean[][] vis = new boolean[n][m];
        int cnt = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == '.' && !vis[i][j]) {
                    cnt++;
                    
                    vis[i][j] = true;
                    queue.add(new int[]{i, j});

                    while(!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int x = cell[0];
                        int y = cell[1];

                        for (int dir=0;dir<4;dir++) {
                            int newX = x + dx[dir];
                            int newY = y + dy[dir];

                            if (newX >= 0 && newX < n && newY >= 0 && newY < m &&
                                grid[newX][newY] == '.' && !vis[newX][newY]) {
                                    vis[newX][newY] = true;
                                    queue.add(new int[]{newX, newY});
                                }
                        }
                    }
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = br.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        System.out.print(countRooms(grid, n, m));
    }
}
