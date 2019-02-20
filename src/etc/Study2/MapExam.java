package etc.Study2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author choijaeyong on 13/02/2019.
 * @project Algorithm
 * @description
 * Map 예제
 */
public class MapExam {

  public static void main(String[] args) {
    int A[] = {5,4,0,3,1,6,2};
    System.out.println(solution(A));
  }

  public static int solution(int[] A) {
    // write your code in Java SE 8
    int length = A.length;

    if(length == 0) {
      return 0;
    }

    Map<Integer,Integer> map = new HashMap<>();

    int max=0;
    for(int i=0; i < length ; i++) {
      map.put(i,A[i]);
    }

    System.out.println(map);

    boolean[] flags = new boolean[length];

    for(int i=0; i < length ; i++) {
      if(flags[i] == false) {
        int num = map.get(i);
        int cnt = 0;

        if(num == i) {
          flags[i] = true;
          cnt = 1;
        }

        while(flags[num] == false) {
          flags[num] = true;
          num = map.get(num);
          cnt++;
        }
        max = max > cnt ? max : cnt;

      }
    }

    return max;
  }

}
