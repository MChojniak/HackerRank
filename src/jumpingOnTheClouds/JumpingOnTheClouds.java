package jumpingOnTheClouds;

import java.io.IOException;
import java.util.Scanner;

public class JumpingOnTheClouds {

    static int jumpingOnClouds(int[] c) {
        int jumpCounter = 0;
        for (int i = 0; i < c.length; i++) {
            if (i < c.length - 2) {
                if (c[i + 2] == 0) {
                    jumpCounter++;
                    ++i;
                } else if (c[i + 2] == 1) {
                    jumpCounter++;
                }
            } else if (i == c.length - 2) {
                jumpCounter++;
                break;
            }
        }

        return jumpCounter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        System.out.println(result);
        scanner.close();
    }
}
