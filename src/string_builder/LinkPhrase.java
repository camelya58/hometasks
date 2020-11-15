package string_builder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class LinkPhrase {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             FileReader fileReader = new FileReader(bufferedReader.readLine());
             BufferedReader reader = new BufferedReader(fileReader)) {
            StringBuilder sb = new StringBuilder();
            while (reader.ready()) {
                sb.append(reader.readLine()).append(" ");
            }
            String[] strings = sb.toString().split(" ");
            StringBuilder result = getLine(strings);
            System.out.println(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        if (words.length == 0) return sb;
        while (true) {
            for (int i = 0; i < words.length - 1; i++) {
                for (int j = i; j < words.length; j++) {
                    int wrongIndex = inWrongOrder(words);
                    if (wrongIndex == 0) {
                        Arrays.stream(words).forEach(word -> sb.append(word).append(" "));
                        return sb.deleteCharAt(sb.length() - 1);
                    }
                    i = wrongIndex - 1;
                    if (j <= i) continue;
                    String next = words[j];
                    String startNext = "" + next.charAt(0);
                    String endNext = "" + next.charAt(next.length() - 1);
                    String startFirst = "" + words[0].charAt(0);
                    if (endNext.equalsIgnoreCase(startFirst)) {
                        String[] temp = new String[j];
                        System.arraycopy(words, 0, temp, 0, j);
                        words[0] = words[j];
                        System.arraycopy(temp, 0, words, 1, j);
                        break;
                    }
                    for (int k = i; k < j; k++) {
                        String previous = words[k];
                        String startPrevious = "" + previous.charAt(0);
                        String endPrevious = "" + previous.charAt(previous.length() - 1);
                        if (endPrevious.equalsIgnoreCase(startNext)) {


                            if (!("" +words[k + 1].charAt(0)).equalsIgnoreCase(endPrevious) ||
                                    (("" +words[k + 1].charAt(0)).equalsIgnoreCase(endPrevious) &&
                                            ("" +words[k + 1].charAt(0)).equalsIgnoreCase(endNext))) {
                                String[] temp = new String[j - k - 1];
                                System.arraycopy(words, k + 1, temp, 0, temp.length);
                                words[k + 1] = words[j];
                                System.arraycopy(temp, 0, words, k + 2, temp.length);
                                break;
                            }
                        }
                        if (endNext.equalsIgnoreCase(startPrevious)) {
                            if (k > 0) {
                                if (!(""+words[k - 1].charAt(words[k - 1].length() - 1)).equalsIgnoreCase(startPrevious) ||
                                        ((""+words[k - 1].charAt(words[k - 1].length() - 1)).equalsIgnoreCase(startPrevious) &&
                                                (""+words[k - 1].charAt(words[k - 1].length() - 1)).equalsIgnoreCase(startNext))) {
                                    String[] temp = new String[j - k];
                                    System.arraycopy(words, k, temp, 0, temp.length);
                                    words[k] = words[j];
                                    System.arraycopy(temp, 0, words, k + 1, temp.length);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static StringBuilder getLined(String... words) { //lineD
        StringBuilder sb = new StringBuilder();
        if (words.length == 0) return sb;
        while (true) {
            for (int i = 0; i < words.length - 1; i++) {
                String first = words[i];
                for (int j = 0; j < words.length; j++) {
                    if (i == j) continue;
                    String next = words[j];
                    String endPrevious = "" + first.charAt(first.length() - 1);
                    String startNext = "" + next.charAt(0);
                    if (endPrevious.equalsIgnoreCase(startNext)) {
                        String temp = words[i + 1];
                        words[i + 1] = words[j];
                        words[j] = temp;
                        break;
                    }
                }
                if (right(words)) {
                    Arrays.stream(words).forEach(word -> sb.append(word).append(" "));
                    return sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }

    static int inWrongOrder(String[] words) {
        for (int i = 0; i < words.length - 1; i++) {
            String previous = words[i];
            String next = words[i + 1];
            String endPrevious = "" + previous.charAt(previous.length() - 1);
            String startNext = "" + next.charAt(0);
            if (!endPrevious.equalsIgnoreCase(startNext)) return i + 1;
        }
        return 0;
    }

    static boolean right(String[] words) {
        for (int i = 0; i < words.length - 1; i++) {
            String endPrevious = "" + words[i].charAt(words[i].length() - 1);
            String startNext = "" + words[i + 1].charAt(0);
            if (!endPrevious.equalsIgnoreCase(startNext)) return false;
        }
        return true;
    }

    //    public static StringBuilder getLine(String... words) {
//        StringBuilder sb = new StringBuilder();
//        if (words.length == 0) return sb;
//        ArrayList<String> list = new ArrayList<>(Arrays.asList(words));
//        while (true) {
//            for (int i = 0; i < list.size() - 1; i++) {
//                String first = list.get(i);
//                for (int j = 0; j < list.size(); j++) {
//                    if (i == j) continue;
//                    String next = list.get(j);
//                    String endPrevious = "" + first.charAt(first.length() - 1);
//                    String startNext = "" + next.charAt(0);
//                    if (endPrevious.equalsIgnoreCase(startNext)) {
//                        list.remove(next);
//                        list.add(i + 1, next);
//                        break;
//                    }
//                }
//            }
//            if (rightOrder(list)) {
//                list.forEach(word -> sb.append(word).append(" "));
//                return sb.deleteCharAt(sb.length() - 1);
//            }
//        }
//    }
    static boolean rightOrder(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            String endPrevious = "" + list.get(i).charAt(list.get(i).length() - 1);
            String startNext = "" + list.get(i + 1).charAt(0);
            if (!endPrevious.equalsIgnoreCase(startNext)) return false;
        }
        return true;
    }
}

