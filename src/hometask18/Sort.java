package hometask18;

import java.util.Arrays;

public class Sort {
    public int [] sortedArray(int[] array) {
        Arrays.sort(array);
        return array;
    }
    public int [] sortsArray(int[] array) {
        for (int i = 0; i < array.length-1; i++){
            for (int j = i +1; j < array.length-1; j++){
                int tmp = array[i];
                if (array[i] > array[j]){
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;
    }
    public static void showArray(String[][] array){
        StringBuilder sb = new StringBuilder("{ {");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sb.append(array[i][j] + ",");
                if (j == array[i].length-1){
                    sb.deleteCharAt(sb.length()-1);
                }
            }
            if (i != array.length-1) {
            sb.append("},{");}
            else sb.append("} }");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        int [] array = {9, 7, 45, -245, 56, 1, 58};
       // sort.sortedArray(array);
        sort.sortsArray(array);
        for (int number: array) {
            System.out.print(number + " ");
         }
        System.out.println();
        String[][] array2 = {{"cat","dog"}, {"fish", "humster", "rat"}};
        showArray(array2);
        String[][] array3 = {{"abc","def"}, {"ghj", "klm"},{"nop", "qrt"}};
        showArray(array3);
    }
}
