package CSES;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Apartments {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().trim().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        int k = Integer.parseInt(firstLine[2]);

        String[] apartmentStrs = br.readLine().trim().split(" ");
        String[] applicantStrs = br.readLine().trim().split(" ");

        int[] apartments = new int[n];
        int[] applicants = new int[m];
        for (int i = 0; i < n; i++) {
            apartments[i] = Integer.parseInt(apartmentStrs[i]);
        }
        for (int i = 0; i < m; i++) {
            applicants[i] = Integer.parseInt(applicantStrs[i]);
        }

        java.util.Arrays.sort(apartments);
        java.util.Arrays.sort(applicants);

        int i = 0, j = 0;
        int matches = 0;

        while(i < n && j < m) {
            if (Math.abs(apartments[i] - applicants[j]) <= k) {
                matches++;
                i++;
                j++;
            } else if (apartments[i] < applicants[j]) i++;
            else j++;
        }

        System.out.println(matches);
    }
}
