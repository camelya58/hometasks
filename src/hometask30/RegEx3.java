package hometask30;

public class RegEx3 {
    public static void main(String[] args) {
        // \\d - цифровой символ
        // \\D - нецифровой символ
        // \\s - символ пробела
        // \\S - непробельный символ

        // если нужно получить из текста цифры
        String string = "12 var3 34 2%^i 90";
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = string.split(" ");
        for (String str: strings){
            if (str.matches("\\d+")) { // отбираем только те цифры, которые полностью состоят из цифр
               stringBuilder.append(str+ " ");
            }
        }
        System.out.println(stringBuilder.toString());
        System.out.println("________________________");

        StringBuilder sb = new StringBuilder();
        for (String str: strings){
            if (!str.matches("\\D")) { // отбираем все цифры
                for (Character c : str.toCharArray()) {
                    if (Character.isDigit(c)) {
                        sb.append(c);
                    }
                }
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
