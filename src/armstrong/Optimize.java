package armstrong;

import java.util.*;

/**
 * Class Optimize
 *
 * @author Kamila Meshcheryakova
 * created by 28.10.2020
 */
public class Optimize {

    public static long[][] initialArray = new long[10][20];

    static {
        for (int i = 0; i < initialArray.length; i++) {
            for (int j = 0; j < initialArray[i].length; j++) {
                initialArray[i][j] = pow(i, j);
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

    public static long[] getNumbers(long N) {
        if (N <= 0) return new long[0];
        int numberLength = getNumberLength(N);
        int[] numbersArray = getNumbersArray(numberLength);
        Set<Long> set = new TreeSet<>(getUniqueNumbersList(numbersArray, N));
        List<Long> armstrongList = new ArrayList<>(set);
        long[] armstrongArray = new long[armstrongList.size()];
        for (int i = 0; i < armstrongList.size(); i++) {
            armstrongArray[i] = armstrongList.get(i);
        }
        return armstrongArray;
    }

    public static int[] getNumbersArray(int numberLength) {
        int[] array = new int[numberLength];
        Arrays.fill(array, 9);
        return array;
    }

    public static boolean isArmstrongNumber(long n) {
        if (n == 0) {
            return false;
        }
        return sum(n) == n;
    }

    public static long sum(long n) {
        int degree = getNumberLength(n);
        long sum = 0;
        int number = (int) (n % 10);
        while (n >= 1) {
            sum += initialArray[number][degree];
            n /= 10;
            number = (int) (n % 10);
        }
        return sum;
    }

    private static int getNumberLength(long n) {
        int count = 0;
        while (n > 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    private static List<Long> getUniqueNumbersList(int[] array, long N) {
        List<Long> list = new ArrayList<>(50);
        int index = 0;
        while (array[array.length - 1] > 0) {
            if (array[0] > 0 || array[1] == 0) {
                iterateNewArray(array, list, N);
            }
            if (array[0] == 0) {
                index++;
                if (index > array.length - 1 && array[array.length - 1] == 0) {
                    break;
                }
                if (index > array.length - 1) {
                    index--;
                }
                for (int i = 1; i < array.length; i++) {
                    if (array[i] > 0) {
                        index = i;
                        break;
                    }
                }

                --array[index];
                for (int i = 0; i < array.length; i++) {
                    if (i == index) break;
                    array[i] = array[index];
                }
            }
        }
        return list;
    }

    private static void iterateNewArray(int[] array, List<Long> list, long N) {
        while (array[0] >= 0) {
            recurseSumOfDegrees(array, list, N);
            if (array[0] == 0) {
                break;
            }
            --array[0];
        }
    }

    private static void recurseSumOfDegrees(int[] array, List<Long> list, long N) {
        long sum = 0;
        for (int element : array) {
            sum += initialArray[element][array.length];
        }
        if (sum > 0 && isArmstrongNumber(sum) && sum < N) {
            list.add(sum);
        }
        for (int element : array) {
            if (element == 0) {
                int[] extraArray = new int[array.length - 1];
                System.arraycopy(array, 1, extraArray, 0, extraArray.length);
                recurseSumOfDegrees(extraArray, list, N);
                return;
            }
        }
    }

    public static void main(String[] args) {

        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(100_000_000_000L)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}