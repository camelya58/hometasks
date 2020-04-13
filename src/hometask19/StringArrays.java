package hometask19;

public class StringArrays {
//    static String[] abc(String... array){
//        String[] array2 = new String[array.length];
//        for (int i = 0; i < array.length; i++){
//            array2[i] = array[i];
//        }
//        return array2;
//    }
    static String[] abc(String[]... array){
        int length = 0;
        for (String[] array3 : array){
            length += array3.length;
        }
        int count = 0;
        String[] array2 = new String[length];
        for (String[] array3 : array){
            for (String arr: array3) {
                array2[count] = arr;
                count++;
            }
        }
        return array2;
    }

    public static void main(String[] args) {
        String[] array = abc(new String[][]{{"hello", "bye"}, {"ok", "no", "yes"}});
        for (int i = 0; i < array.length; i++){
            for (String arg: args) {
                if (arg.equals(array[i])){
                    array[i] = null;
                }
            }
        }
        for (String string: array){
            System.out.print(string + " ");
        }
    }
}
