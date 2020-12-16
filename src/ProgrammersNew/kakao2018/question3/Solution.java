package ProgrammersNew.kakao2018.question3;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author choijaeyong on 2020/08/30.
 * @project Algorithm
 * @description
 * 캐시
 */
public class Solution {

  public static void main(String[] args) {
    String[] str1 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
    String[] str2 = {"Jeju", "Pangyo", "NewYork", "newyork"};
    String[] str3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
    String[] str4 = {"aa","aa","aa","aa"};
    String[] str5 = {"aa","bb","aa","aa"};

    //int solution = solution(0, str3);
    int solution = solution(2, str5);
    System.out.println("solution : " + solution);

  }

  public static int solution(int cacheSize, String[] cities) {
    int answer = 0;

    Queue<String> queue = new ArrayDeque<String>();
    for (String str : cities) {
      String s = str.toLowerCase();
      if (cacheSize == 0) {
        return cities.length * 5;
      }
      if (queue.contains(s)) {
        answer = answer + 1;
        queue.remove(s);
        queue.add(s);
      } else {
        if (queue.size() >= cacheSize) {
          queue.poll();
          queue.add(s);
          answer = answer + 5;
        } else {
          queue.add(s);
          answer = answer + 5;
        }

      }
    }

    return answer;
  }




}
