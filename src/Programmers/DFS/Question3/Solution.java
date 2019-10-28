package Programmers.DFS.Question3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author choijaeyong on 2019/10/28.
 * @project Algorithm
 * @description
 */
public class Solution {

  public static void main(String[] args) {
    String begin = "hit";
    String target = "cog";
    String[] words = {"hot","dot","dog","lot","log","cog"};
    String[] words1 = {"hot","dot","dog","lot","log"};

    List<String> strings = changeableList(begin, words);
    //System.out.println(strings);

    int answer = solution(begin,target,words);
    System.out.println(answer);

  }
  public static int solution(String begin, String target, String[] words) {
    int answer = 0;

    Map<String, List<String>> maps = new HashMap<>();
    maps.put(begin,changeableList(begin, words));

    // 이웃을 정의한다.
    for(String word : words) {
      maps.put(word,changeableList(word,words));
    }
    //System.out.println(maps);

    Queue<String> queue = new LinkedList<String>();
    queue.add(begin);
    queue.add("jump");

    List<String> checkedNeighbor = new ArrayList<>();

    while(!queue.isEmpty()) {
      String word = queue.poll();
      //System.out.println("word : " + word + "   answer : " + answer);
      if (word.equals("jump")) {
        answer++;
        continue;
      }

      if (checkedNeighbor.contains(word)) {
        continue;
      }
//      answer++;
//      checkedNeighbor.add(word);

      if (word.equals(target)) {
        return answer;
      } else {
        List<String> wordNeighbors = maps.get(word);
        if (wordNeighbors.contains(target)) {
          answer++;
          return answer;
        }
        for (String neighbor : wordNeighbors) {
          queue.add(neighbor);
        }
        queue.add("jump");
        checkedNeighbor.add(word);
      }
    }

    answer = 0;

    return answer;
  }

  public static List<String> changeableList(String word, String[] targets) {
    List<String> list = new ArrayList<>();
    for (String target : targets) {
      if(isChangeable(word, target)) {
        list.add(target);
      }
    }
    return list;
  }


  public static boolean isChangeable(String word1 , String word2) {
    int checkDiff = 0;
    for(int i=0 ; i < word1.length() ; i++) {
      if(word1.charAt(i) != word2.charAt(i)) {
        checkDiff++;
      }
    }

    if(checkDiff == 1) {
      return true;
    }
    return false;
  }

}
