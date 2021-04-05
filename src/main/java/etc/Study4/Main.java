package etc.Study4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author choijaeyong on 02/03/2019.
 * @project Algorithm
 * @description
 */
public class Main {
  public static void main(String[] args) {
    Map<String,Integer> map = new HashMap<>();
    map.put("a",1);
    map.put("b",2);
    map.put("c",3);
    map.put("d",4);

    Set<String> set = map.keySet();
    Iterator<String> itr = set.iterator();

    while(itr.hasNext()) {
      String temp = itr.next();
      if(temp.equals("c")) {
        itr.remove();
      }
      System.out.println(temp);
    }

    System.out.println(map);
    System.out.println(set);


  }

}
