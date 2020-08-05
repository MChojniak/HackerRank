package sockMerchantTask;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SockMerchant {

    // SOLUTION (provided function template set argument n)
    static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> resultMap = new HashMap();

        Arrays.stream(ar).forEach(key -> {
            resultMap.put(key, resultMap.getOrDefault(key, 0) + 1);
        });

        int result = 0;

        for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
            result += entry.getValue() / 2;
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);
        System.out.println(result);
        scanner.close();
    }
}
