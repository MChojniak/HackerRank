package repeatedString;


import java.io.IOException;
import java.util.Scanner;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        char[] ofStringArr = s.toCharArray();
        long aCounter = 0;
        for (char singleChar : ofStringArr) {
            if (singleChar == 'a') {
                aCounter++;
            }
        }
        aCounter *= n / s.length();
        long rest = n % s.length();
        if (rest == 0) {
            return aCounter;
        } else {
            for (int i = 0; i < rest; i++) {
                if (ofStringArr[i] == 'a') {
                    aCounter++;
                }
            }
        }
        return aCounter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        System.out.println(result);

        scanner.close();
    }
}
