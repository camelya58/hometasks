package hometask30;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class RegEx4 allows to generate random password consisting of 8 symbols (numbers and letters)
 * with at least one number, one lowercase letter and one uppercase letter.
 *
 * @author Kamila Meshcheryakova
 * created by 01.09.2020
 */
public class RegEx4 {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());

        String st = "@12# var3 34% 2(&%i 90!";
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(st);
        while (matcher.find()){
            System.out.println(matcher.group());
        }

        System.out.println("-----------------");

        Pattern pattern1 = Pattern.compile("\\b[0-9]+[^%]\\b");
        Matcher matcher1 = pattern1.matcher(st);
        while (matcher1.find()){
            System.out.println(matcher1.group());
        }
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int min = 48;
        int max = 122;
        int diff = max - min;
        String str;
        StringBuilder sb = new StringBuilder();
        byte[] bytes = new byte[8];
        Random random = new Random();
        while (true) {
            char symbol = (char) (random.nextInt(diff + 1) + min);
            str = String.valueOf(symbol);
            if (str.matches("[A-Za-z0-9]")) {
                sb.append(str);
            }
            if (sb.toString().matches("^(?=.+[A-Z])(?=.+[a-z])(?=.+\\d)[A-Za-z\\d]{8}$")) {
                bytes = sb.toString().getBytes();
                break;
            } else if (!sb.toString().matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{8}$")) {
                sb = new StringBuilder(sb.toString().replaceAll(".{8}", ""));
            }
        }
        try {
            baos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baos;
    }
}
