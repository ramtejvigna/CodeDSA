
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class FerrisWheel {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().trim().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int x = Integer.parseInt(firstLine[1]);

        String[] weightStrs = br.readLine().trim().split(" ");
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(weightStrs[i]);
        }

        java.util.Arrays.sort(weights);
        int i = 0, j = n - 1;
        int rides = 0;

        while(i <= j) {
            if (weights[i] + weights[j] <= x) {
                i++; j--;
            } else j--;
            rides++;
        }

        System.out.println(rides);
    }
}
