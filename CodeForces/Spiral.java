package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Spiral {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long y = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());

            long layer = Math.max(x, y);
            long ans;

            if (layer % 2 == 0) {
                if (y == layer) {
                    ans = layer * layer - x + 1;
                } else {
                    ans = (layer - 1) * (layer - 1) + y;
                }
            } else {
                if (x == layer) {
                    ans = layer * layer - y + 1;
                } else {
                    ans = (layer - 1) * (layer - 1) + x;
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb.toString());
    }
}
