package hometask30;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx2 {
    public static void main(String[] args) {
        // если мы хотим сделать из строчки массив строк, поделив по определенному условию
        // \\W - все символы, кроме букв, цифр и знака подчеркивания
        // \\w - все символы, состоящие из букв, цифр и знака подчеркивания
        // + если встречаются один и более раз
        // * если встречаются ноль и более раз
        // ? если встречаются один раз или отсутствует
        String text = "cat, catch; world! concatenate: snow) cats/ dark @ white[ scattered% concat";
        String[] strings = text.split("\\W+");
        System.out.println(Arrays.toString(strings));
        System.out.println("_____________________________");

        // если мы хотим убрать из строки все знаки пунктуации
        // \\p{Punct} - любой знак пунктуации
        // \\p{Letter} - любые буквы любого языка
        // \\p{Number} - любые виды цифр любого языка
        // \\p{Symbol} - математические символы, символы валют
        String text2 = text.replaceAll("\\p{Punct}", "");
        System.out.println(text2);

        // \\b - граница слова. \\ba - в начале, a\\b - в конце
        Pattern pattern = Pattern.compile("\\bcat\\b"); // cat\\b  \\bcat
        Matcher match = pattern.matcher(text2);
        int matchCounter = 0;
        while (match.find()) {
            matchCounter++;}
        System.out.println(matchCounter);
        System.out.println("_____________________________");

        // \\B - не граница слова
        Pattern pattern2 = Pattern.compile("\\Bcat\\B");
        Matcher match2 = pattern2.matcher(text2);
        int matchCounter2 = 0;
        while (match2.find()) {
            matchCounter2++;}
        System.out.println(matchCounter2);
        System.out.println("_____________________________");

    }
}
