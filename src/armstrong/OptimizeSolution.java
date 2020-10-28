package armstrong;

import java.util.*;

/**
 * Class OptimizeSolution
 *
 * @author Kamila Meshcheryakova
 * created by 28.10.2020
 */
public class OptimizeSolution {

    public static long[][] initialArray = new long[10][19];

    static {
        for (int i = 0; i < initialArray.length; i++) {
            for (int j = 0; j < initialArray[i].length; j++) {
                initialArray[i][j] = pow(i, j);
            }
        }
    }

    public static long[] getNumbers(long N) {
        int[] numbersArray = getNumbersArray(getNumberLength(N));
        long[] uniqueNumbersArray = getUniqueNumbersArrayFromSumOfDegrees(numbersArray);
        return getArmstrongNumbersArray(uniqueNumbersArray, N);
    }

    public static int[] getNumbersArray(int numberLength) {
        int[] array = new int[numberLength];
        Arrays.fill(array, 9);
        return array;
    }

    public static long sumOfDegrees(int[] array) {
        long sum = 0;
        for (int element : array) {
            sum += initialArray[element][array.length];
        }
        return sum;
    }

    public static long[] getUniqueNumbersArrayFromSumOfDegrees(int[] array) {
        List<Long> list = new ArrayList<>();
        int[] extraArray = new int[array.length];
        while (extraArray[extraArray.length - 1] > 0) {
            list.add(sumOfDegrees(recurseMethod(extraArray)));
        }
        long[] uniqueNumbersArray = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            uniqueNumbersArray[i] = list.get(i);
        }
        return uniqueNumbersArray;
    }

    private static int[] recurseMethod(int[] extraArray) {
        while (extraArray[0] > 0) {

        }

        return new int[0];
    }

    public static long[] getArmstrongNumbersArray(long[] array, long N) {
        List<Long> list = new ArrayList<>();
        for (long l : array) {
            if (isArmstrongNumber(l)) {
                list.add(l);
            }
        }
        Collections.sort(list);
        long[] armstrongArray = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < N) {
                armstrongArray[i] = list.get(i);
            }
        }
        return armstrongArray;

    }

    public static boolean isArmstrongNumber(long n) {
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

    private static void method(int[] array) {
        List<Long> list = new ArrayList<>();
        int index = 0;
        while (array[array.length - 1] > 0) {
            if (array[0] > 0) {
                recurse(array, list);
            } else {
                index++;
                if (index > array.length - 1) {
                    break;
                }
                --array[index];
                for (int i = 0; i < array.length; i++) {
                    if (i == index) break;
                    array[i] = array[index];
                }
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println(list);
    }

    private static void recurse(int[] array, List<Long> list) {
        while (array[0] >= 0) {
            list.add(sumOfDegrees(array));
            System.out.println(Arrays.toString(array));
            if (array[0] == 0) {
               break;
            }
            --array[0];
        }
    }

    public static void main(String[] args) {

        method(getNumbersArray(3));

        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(408)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

//        a = System.currentTimeMillis();
//        System.out.println(Arrays.toString(getNumbers(Integer.MAX_VALUE)));
//        b = System.currentTimeMillis();
//        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
//        System.out.println("time = " + (b - a) / 1000);
    }
}
