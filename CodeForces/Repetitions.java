package CodeForces;

import java.util.Scanner;

class Repetitions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        sb.append(sc.nextLine());

        int maxCount = 1;
        int currentCount = 1;
        for (int i=1;i<sb.length();i++) {
            if(sb.charAt(i) == sb.charAt(i - 1)) {
                currentCount++;
            } else {
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 1;
            }
        }
        maxCount = Math.max(maxCount, currentCount);
        System.out.println(maxCount);

        sc.close();
    }
}
