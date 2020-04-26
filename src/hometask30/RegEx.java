package hometask30;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
    public static void main(String[] args){
        // если мы хотим задать шаблон написания e-mail
        // \\b - граница слова. \\ba - в начале, a\\b - в конце
        // [A-Za-z] - отбор букв латинского алфавита без учета регистра
        // [0-9] - отбор цифр, [^0-9] - все, кроме цифр
        // {n} - встречается n раз, {n,} - встречается n раз и более
        // {n,m} - встречается не менее n раз, но не более m раз
        // ^ - начало текста ^a
        // $ - конец текста a$

        //String email = "myName+89%@myDomen63-like.com";
        String email = "2323@456356%%^-890.ghjgjg";
        boolean result = email.matches("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b");
        System.out.println(result);
        System.out.println("_____________________________");

        // если мы хотим в тексте заменить один символ на другой
        String text = "Ночь. Улица. Фонарь. Аптека.\n" +
                "Бесмысленный и тусклый свет.\n" +
                "Живи ещё хоть четверть века —\n" +
                "Всё будет так. Исхода нет.\n";

        System.out.println(text.replaceAll("\\.", "!"));// если заменить на "."
        System.out.println("_____________________________");

    }
}
