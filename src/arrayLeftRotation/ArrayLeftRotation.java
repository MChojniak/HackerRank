package arrayLeftRotation;

import java.io.IOException;
import java.util.Scanner;

public class ArrayLeftRotation {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int[] returnableArray = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            d = d % a.length;
            if (i - d < 0) {
                returnableArray[a.length + (i - d)] = a[i];
            } else {
                returnableArray[i - d] = a[i];
            }
        }
        return returnableArray;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);

            if (i != result.length - 1) {
                System.out.println(" ");
            }
        }

        scanner.close();
    }
}
