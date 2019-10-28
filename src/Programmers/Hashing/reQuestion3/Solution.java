package Programmers.Hashing.reQuestion3;

import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

/**
 * @author choijaeyong on 2019/10/27.
 * @project Algorithm
 * @description
 */
public class Solution {

  public static void main(String[] args) {
    String[][] clothes = { {"yellow_hat","headgear"},
        {"blue_sunglasses","eyewear"},{"green_turban","headgear"} };

    String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

    solution(clothes);
  }

  public static int solution(String[][] clothes) {
    int answer = 0;

    Hashtable<String,Integer> table = new Hashtable<String,Integer>();

    for(int i=0; i < clothes.length ; i++) {
      if(table.containsKey(clothes[i][1])) {
        table.replace(clothes[i][1], table.get(clothes[i][1]) + 1);
      } else {
        table.put(clothes[i][1], 1);
      }
    }
    answer=1;
    Collection<Integer> values = table.values();
    for (Integer value : values) {
      answer = answer * (value+1);
    }
    // 아무것도 안입은경우
    answer = answer -1;

    return answer;
  }

}
