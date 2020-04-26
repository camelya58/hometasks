package hometask31;

import java.io.*;

public class SetIn {
    public static void main(String[] args) throws IOException{
        InputStream fis = new FileInputStream("SomeFile"); //считывает побайтово
        OutputStream fos = new FileOutputStream("AnotherFile");
        while (fis.available()>0){ // пока количество несчитанных байтов больше 0
            int data = fis.read(); // приводим byte к int
            fos.write(data);
        }
        fis.close();
        fos.close();

        StringBuilder sb = new StringBuilder();
        Reader reader = new FileReader("SomeFile"); //считывает посимвольно
        Writer writer = new FileWriter("OtherFile");
        while (reader.ready()){ //пока Ридер готов к чтению
            int data2 = reader.read(); // приводим char к int
            writer.write(data2);
            sb.append((char)data2);
        }
        reader.close();
        writer.close();

        String text = sb.toString();
        System.out.println(text);
        System.out.println("______________________________");

        InputStream usual = System.in;

        InputStream is = new ByteArrayInputStream(text.getBytes());
        System.setIn(is);
        // можно поменять на обычное чтение с консоли -usual
        //System.setIn(usual);
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in)); //чтобы считывать построчно

        while (true) {
            String line = reader2.readLine();
            if (line == null) break;
            System.out.println(line);
        }
        reader2.close();
        is.close();


    }
}

