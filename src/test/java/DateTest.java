import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    @Test
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        String format = sdf.format(date);
        c.setTime(date);
        c.add(Calendar.MONTH,3);
        System.out.println(sdf.format(c.getTime()));
//        calc.setTime(sdf.parse(maxDateStr));
//        calc.add(calc.DATE, -30);
//        Date minDate = calc.getTime();
//        minDateStr = sdf.format(minDate);
//        System.out.println("minDateStr:"+minDateStr);

    }
}
