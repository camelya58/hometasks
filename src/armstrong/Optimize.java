package armstrong;

import java.util.*;

/**
 * Class Optimize
 *
 * @author Kamila Meshcheryakova
 * created by 28.10.2020
 */
public class Optimize {

    public static long[][] initialArray = new long[10][19];

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
        int[] numbersArray = getNumbersArray(getNumberLength(N));
        List<Long> list = getUniqueNumbersList(numbersArray);
        return getArmstrongNumbersArray(list, N);
    }

    public static int[] getNumbersArray(int numberLength) {
        int[] array = new int[numberLength];
        Arrays.fill(array, 9);
        System.out.println("init array" + Arrays.toString(array));
        return array;
    }

    public static long[] getArmstrongNumbersArray(List<Long> list, long N) {
        List<Long> armstrongList = new ArrayList<>();
        for (Long l : list) {
            if (l >= N) break;
            if (isArmstrongNumber(l)) {
                armstrongList.add(l);
            }
        }
        System.out.println("armstrongList = " + armstrongList);
        long[] armstrongArray = new long[armstrongList.size()];
        for (int i = 0; i < armstrongList.size(); i++) {
            if (armstrongList.get(i) < N) {
                armstrongArray[i] = armstrongList.get(i);
            }
        }
        return armstrongArray;
    }

    public static boolean isArmstrongNumber(long n) {
        if (n == 0) return false;
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

    private static List<Long> getUniqueNumbersList(int[] array) {
        List<Long> list = new ArrayList<>();
        int index = 0;
        while (array[array.length - 1] > 0) {
            if (array[0] >  0) {
                recurse(array, list);
            } if (array[0] == 0) {
                index++;
                if (index > array.length - 1 && array[array.length -1] == 0) {
                    break;
                }
                if (index > array.length - 1) {
                    index--;
                }
                if (index != 0 && array[index-1] > 0) {
                    index--;
                }
                --array[index];
                for (int i = 0; i < array.length; i++) {
                    if (i == index) break;
                    array[i] = array[index];
                }
            }
        }
        Collections.sort(list);
        System.out.println(list);
        return list;
    }

    private static void recurse(int[] array, List<Long> list) {
       while (array[0] >= 0) {
            list.add(sumOfDegrees(array));
            if (array[0] == 0) {
                break;
            }
            --array[0];
        }
        System.out.println("recurse" + list);
    }

    private static long sumOfDegrees(int[] array) {
        long sum = 0;
        for (int element : array) {
            sum += initialArray[element][array.length];
        }
        return sum;
    }

    public static void main(String[] args) {

        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(15)));
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