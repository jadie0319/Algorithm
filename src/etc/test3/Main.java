package etc.test3;

import java.util.Arrays;
import java.util.List;

/**
 * @author choijaeyong on 19/04/2019.
 * @project Algorithm
 * @description
 */
public class Main {

  public static void main(String[] args) {
    Subject subject1 = new Subject("컴퓨터구조",2);
    List<Time> times = Arrays.asList(new Time("월",1) , new Time("월",2));
    subject1.setTime(times);

    Subject subject2 = new Subject("자료구조",3);
    times = Arrays.asList(new Time("월",5) , new Time("월",6)
            , new Time("수",5), new Time("수",6));
    subject2.setTime(times);

    System.out.println(subject1.getTime());
    System.out.println(subject2.getTime());


  }

}
