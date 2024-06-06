import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class App {
    public static void main(String[] args) throws ParseException {
                
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                
                Date d = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
                
                System.out.println(sdf.format(d));
                
                Calendar cal = Calendar.getInstance();
                cal.setTime(d);
                
                int minutes = cal.get(Calendar.MINUTE);
                
                int month = 1 + cal.get(Calendar.MONTH);
                
                cal.add(Calendar.HOUR_OF_DAY, 4);
                d = cal.getTime();
                
                
                System.out.println("*********** new date ***********");
                System.out.println(d);
                System.out.print(String.format("minutes: %d \n month: %d", minutes, month));
    }
}
