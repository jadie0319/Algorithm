package etc.Practice;

import java.time.LocalDateTime;
import java.time.Period;

/**
 * @author choijaeyong on 02/04/2019.
 * @project Algorithm
 * @description
 */
public class LocalDateTimeTest {
  public static void main(String[] args) {
    LocalDateTime ldt1 = LocalDateTime.of(2019,4,2,15,30);
    LocalDateTime ldt2 = LocalDateTime.of(2019,4,2,15,40);

    //Period period = Period.between(ldt1,ldt2);
    System.out.println(ldt1.getDayOfMonth());
    System.out.println(ldt1.getDayOfWeek());
    System.out.println(ldt1.getDayOfYear());
    System.out.println(ldt1.getYear());
    System.out.println(ldt1.getHour());
    System.out.println(ldt1.getMinute());
  }

}
