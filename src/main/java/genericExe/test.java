package genericExe;

import java.text.SimpleDateFormat;
import org.joda.time.DateTime;
import java.util.Date;

public class test {
    public static void main(String[] args) {

        String EXPECTED_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'+'02:00";

        String data1 = new SimpleDateFormat(EXPECTED_DATE_FORMAT).format(new Date());
        String data2 = new SimpleDateFormat(EXPECTED_DATE_FORMAT).format(new DateTime(new Date()).plusMinutes(-10).toDate());

        System.out.println(data1);
        System.out.println("======");
        System.out.println(data2);

    }
}
