package etc.Study3;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author choijaeyong on 23/02/2019.
 * @project Algorithm
 * @description
 *
 */
public class Solution2 {
  public static void main(String[] args) {

    int[] people = {2,3};
    int[] tshirts = {1,2,3};

    System.out.println(solution(people, tshirts));
  }

  public static int solution(int[] people, int[] tshirts) {
    int answer = 0;

    Arrays.sort(people);
    Arrays.sort(tshirts);

    int peoples = people.length;
    int tshirtsSizes = tshirts.length;

    boolean[] tshirtsFlag = new boolean[tshirtsSizes];

    people:for(int i=0; i < peoples ; i++) {
      for(int j=0; j < tshirtsSizes ; j++) {
        if(people[i] <= tshirts[j] && tshirtsFlag[j] == false) {
          answer++;
          tshirtsFlag[j] = true;
          continue people;
        }
      }
    }

    return answer;
  }

}
