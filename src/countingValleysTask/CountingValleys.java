package countingValleysTask;

import java.util.Scanner;

public class CountingValleys {

    // SOLUTION (provided function template set argument n)
    static int countingValleys(int n, String s) {
        char[] pathAsChars = s.toCharArray();

        int level = 0;
        int amplitude = 0;

        for (int i = 0; i <= pathAsChars.length - 1; i++) {
            if (pathAsChars[i] == 'D') {
                --level;
            } else {
                ++level;
            }

            if (level == 0 && pathAsChars[i] == 'U') {
                amplitude += 1;
            }
        }

        return amplitude;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        System.out.println(result);
        scanner.close();
    }
}
