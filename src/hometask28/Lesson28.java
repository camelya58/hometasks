package hometask28;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.time.*;
import java.time.format.*;

public class Lesson28 {
    static DateTimeFormatter df1 = DateTimeFormatter.ofPattern("yyyy, MMMM-dd !! hh:mm");
    static DateTimeFormatter df2 = DateTimeFormatter.ofPattern("hh:mm, dd/MMM/yy");

    public static void change(LocalDateTime ldt1, LocalDateTime ldt2, Period p, Duration d){
        while(ldt1.isBefore(ldt2)){
            System.out.print("Work from: " + ldt1.format(df1));
            ldt1 = ldt1.plus(p);
            System.out.println(" To: " + ldt1.format(df1));
            System.out.print("Rest from: " + ldt1.format(df2));
            ldt1 = ldt1.plus(d);
            System.out.println(" Till: " + ldt1.format(df2));
            System.out.println("______________________________");
        }
    }
    public static void main(String[] args) {

        LocalDateTime lt = LocalDateTime.of(2020, 1, 1, 9, 0, 0);
        LocalDateTime lt2 = LocalDateTime.of(2020, 10, 31, 18, 0, 0);
        Period p = Period.ofDays(5);
        Duration d = Duration.ofHours(48);
        change(lt, lt2, p, d);
    }
}
