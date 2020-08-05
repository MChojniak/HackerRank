package twoDimensionalArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TwoDimensionalArray {
    // Complete the hourglassSum function below.

    static int hourglassSum(int[][] arr) {

        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 2) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (j < arr[i].length - 2) {
                        int sumCount = 0;

                        //top
                        sumCount = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                        //mid
                        sumCount += arr[i + 1][j + 1];
                        //bot
                        sumCount += arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];

                        resultList.add(sumCount);
                    }
                }
            }
        }
        Collections.sort(resultList, Collections.reverseOrder());
        return resultList.get(0);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int ik = 6;
        int jk = 6;
        int[][] arr = new int[ik][jk];

        for (int i = 0; i < ik; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < jk; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        System.out.println(result);
        scanner.close();
    }
}
