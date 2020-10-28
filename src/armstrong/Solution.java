package armstrong;

import java.util.*;

/**
 * Class Solution
 *
 * @author Kamila Meshcheryakova
 * created by 28.10.2020
 */
public class Solution {

    public static long[] getNumbers(long N) {

        Set<Long> set = new HashSet<>();
        for (long i = 1; i <= getRightNumber(N - 1); i++) {
            if (isUniqueNumber(i)) {
                long sumOfNUms = sum(i);
                if (isArmstrongNumber(sumOfNUms)) {
                    set.add(sumOfNUms);
                }
            }
        }

        List<Long> list = new ArrayList<>();
        for (Long l : set) {
            if (l < N) {
                list.add(l);
            }
        }
        Collections.sort(list);
        long[] result = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < N) {
                result[i] = list.get(i);
            }
        }
        return result;
    }

    public static boolean isUniqueNumber(long n) {
        long lastDigit = 0;
        long currentDigit;
        while (n > 0) {
            currentDigit = n % 10;
            if (lastDigit > currentDigit) {
                return false;
            }
            lastDigit = currentDigit;
            n /= 10;
        }
        return true;
    }

    private static long getRightNumber(long N) {
        int length = getNumberLength(N);
        StringBuilder sb = new StringBuilder();
        int count = length;
        while (count > 0) {
            sb.append("9");
            count--;
        }
        return Long.parseLong(sb.toString());
    }

    public static boolean isArmstrongNumber(long n) {
        return sum(n) == n;
    }

    public static long sum(long n) {
        int degree = getNumberLength(n);
        long sum = 0;
        int number = (int) (n % 10);
        while (n >= 1) {
            sum += array[number][degree];
            n /= 10;
            number = (int) (n % 10);
        }
        return sum;
    }

    public static long[][] array = new long[10][19];

    static {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = pow(i, j);
            }
        }
    }

    private static long pow(int base, int exponent) {
        long result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    private static int getNumberLength(long n) {
        int count = 0;
        while (n > 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(372)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(100_000_000))); // 7 sec
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}

