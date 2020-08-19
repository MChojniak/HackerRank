package bontrousle;

import java.io.IOException;
import java.util.*;

public class Bonetrousle {

    static long[] bonetrousleFun(long n, long k, int b) {
        List<Long> stickCounterList = new ArrayList<>();

        // boxes to buy with global minimal value -> if b = 3
        // (1,1) (2,2) (3,3)
        stickCounterList.add((long) 0);
        for (long i = 1; i <= b; i++) {
            stickCounterList.add(i);
        }
        // min and max values for b boxes
        long min = (b * (b + 1L)) / 2;
        long max = (b * (2L * k - b + 1)) / 2;

        // n should between them
        if (!(n >= min && n <= max)) {
            return new long[]{-1};
        }
        // we split rest of values to add to each box
        long valToAdd = (n - min) / b;
        // if we haven't split it equally we need
        // to see how much add to last box
        long rest = (n - min) % b;

        for (int i = b; i > 0; i--) {
            stickCounterList.set(i, i + valToAdd);
        }
        stickCounterList.set(stickCounterList.size() - 1, stickCounterList.size() - 1 + valToAdd + rest);

        long[] result = transferListToLongArray(stickCounterList);
        return result;
    }

    private static long[] transferListToLongArray(List<Long> counterMap) {
        Long[] result = counterMap.toArray(new Long[0]);
        return Arrays.stream(result)
                .filter(Objects::nonNull)
                .filter(l -> l > 0)
                .mapToLong(Long::longValue)
                .toArray();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nkb = scanner.nextLine().split(" ");

            long n = Long.parseLong(nkb[0].trim());

            long k = Long.parseLong(nkb[1].trim());

            int b = Integer.parseInt(nkb[2].trim());

            long[] result = bonetrousleFun(n, k, b);

            for (int resultItr = 0; resultItr < result.length; resultItr++) {
                System.out.println(String.valueOf(result[resultItr]));

                if (resultItr != result.length - 1) {
                    System.out.println(" ");
                }
            }

        }

    }
}
