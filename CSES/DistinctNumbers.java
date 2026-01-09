package CSES;

import java.util.*;
import java.io.*;

public class DistinctNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        String[] numbers = br.readLine().trim().split(" ");

        Set<Integer> distinctNumbers = new HashSet<>();
        for (String numStr : numbers) {
            distinctNumbers.add(Integer.parseInt(numStr));
        }

        System.out.println(distinctNumbers.size());
    }
}
