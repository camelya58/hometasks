package string_builder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Class LinkPhrase demonstrates the work of StringBuilder: to link the words after each other by equals end and start of thw words.
 * If the file consists: "Kiev New-York Amsterdam Vienna Melbourne".
 * Output: "New-York Kiev Vienna Amsterdam Melbourne".
 *
 * @author Kamila Meshcheryakova
 * created by 16.11.2020
 */
public class LinkPhrase {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine()))) {
            String[] strings = reader.readLine().trim().split("\\s");
            StringBuilder result = getLine(strings);
            System.out.println(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        if (words.length == 0) return sb;
        int countRound = 0;
        Map<Integer, List<String>> map = new HashMap<>();
        while (true) {

            for (int i = 0; i < words.length - 1; i++) {
                for (int j = i; j < words.length; j++) {
                    int wrongIndex = inWrongOrder(words);
                    if (wrongIndex == 0) {
                        Arrays.stream(words).forEach(word -> sb.append(word).append(" "));
                        return sb.deleteCharAt(sb.length() - 1);
                    }

                    if (wrongIndex > words.length / 2 && countRound > words.length * 2) {
                        map.put(wrongIndex, Arrays.asList(words));
                        ArrayList<String> list = new ArrayList<>(Arrays.asList(words));
                        Collections.shuffle(list);
                        System.arraycopy(list.toArray(words), 0, words, 0, words.length);
                    }

                    if (countRound > words.length * 4) {
                        if (map.isEmpty()) {
                            Arrays.stream(words).forEach(word -> sb.append(word).append(" "));
                        } else {
                            int max = Collections.max(map.keySet());
                            map.get(max).forEach(word -> sb.append(word).append(" "));
                        }
                        return sb.deleteCharAt(sb.length() - 1);

                    }

                    i = wrongIndex - 1;
                    if (j <= i) continue;
                    String next = words[j];
                    String startNext = next.substring(0,1);
                    String endNext = next.substring(next.length() - 1);
                    String startFirst = words[0].substring(0,1);
                    if (endNext.equalsIgnoreCase(startFirst)) {
                        String[] temp = new String[j];
                        System.arraycopy(words, 0, temp, 0, j);
                        words[0] = words[j];
                        System.arraycopy(temp, 0, words, 1, j);
                        break;
                    }
                    for (int k = i; k < j; k++) {
                        String previous = words[k];
                        String startPrevious = previous.substring(0,1);
                        String endPrevious = previous.substring(previous.length() - 1);
                        if (endPrevious.equalsIgnoreCase(startNext)) {


                            if (!(words[k + 1].substring(0,1)).equalsIgnoreCase(endPrevious) ||
                                    ((words[k + 1].substring(0,1)).equalsIgnoreCase(endPrevious) &&
                                            (words[k + 1].substring(0,1)).equalsIgnoreCase(endNext))) {
                                String[] temp = new String[j - k - 1];
                                System.arraycopy(words, k + 1, temp, 0, temp.length);
                                words[k + 1] = words[j];
                                System.arraycopy(temp, 0, words, k + 2, temp.length);
                                break;
                            }
                        }
                        if (endNext.equalsIgnoreCase(startPrevious)) {
                            if (k > 0) {
                                if (!(words[k - 1].substring(words[k - 1].length() - 1)).equalsIgnoreCase(startPrevious) ||
                                        ((words[k - 1].substring(words[k - 1].length() - 1)).equalsIgnoreCase(startPrevious) &&
                                                (words[k - 1].substring(words[k - 1].length() - 1)).equalsIgnoreCase(startNext))) {
                                    String[] temp = new String[j - k];
                                    System.arraycopy(words, k, temp, 0, temp.length);
                                    words[k] = words[j];
                                    System.arraycopy(temp, 0, words, k + 1, temp.length);
                                    break;
                                }
                            }
                        }
                    }
                    if (j == words.length - 1) {
                        countRound++;
                    }
                }
            }
        }
    }

    static int inWrongOrder(String[] words) {
        for (int i = 0; i < words.length - 1; i++) {
            String previous = words[i];
            String next = words[i + 1];
            String endPrevious = previous.substring(previous.length() - 1);
            String startNext = next.substring(0,1);
            if (!endPrevious.equalsIgnoreCase(startNext)) return i + 1;
        }
        return 0;
    }
}


