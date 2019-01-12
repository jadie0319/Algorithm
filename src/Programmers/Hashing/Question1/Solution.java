package Programmers.Hashing.Question1;

import java.util.Arrays;
import java.util.Hashtable;

/**
 * @author choijaeyong on 11/01/2019.
 * @project Algorithm
 * @description
 *
 *  https://programmers.co.kr/learn/courses/30/lessons/42576?language=java
 *  완주하지 못한 선수.
 *
 *
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 *
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * completion의 길이는 participant의 길이보다 1 작습니다.
 * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 * 참가자 중에는 동명이인이 있을 수 있습니다.
 *
 */
public class Solution {

  public static void main(String[] args) {
    //String[] participant = {"leo","kiki","eden"};
    String[] participant = {"mislav", "stanko", "mislav", "ana"};
    //String[] completion = {"eden","kiki"};
    String[] completion = {"stanko", "ana", "mislav"};

    //Arrays.sort(participant);

//    for(String user : participant) {
//      System.out.println(user);
//    }

    // compareTo : 0 이 1보다 배열의 앞에 위치했기에 음수가 나온다.
    System.out.println(participant[0].compareTo(participant[1]));

    String answer = solution(participant,completion);
    System.out.println(answer);




  }


  public static String solution(String[] participants, String[] completions) {
    String answer = "";

    Hashtable<String,Integer> table = new Hashtable();

    for(String participant : participants) {
      if(table.containsKey(participant)) {
        table.put(participant, (table.get(participant)+1));
      }else{
        table.put(participant,1);
      }

    }


    for(String completion : completions) {
      table.put(completion, (table.get(completion)-1));
    }

    for(String participant : participants) {
      if(table.get(participant) == 1) {
        answer = participant;
        break;
      }
    }

    return answer;
  }


}
