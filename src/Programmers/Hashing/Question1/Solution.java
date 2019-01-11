package Programmers.Hashing.Question1;

import java.util.Arrays;

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
    String[] participant = {"leo","kiki","eden"};
    String[] completion = {"eden","kiki"};

    Arrays.sort(participant);

    for(String user : participant) {
      System.out.println(user);
    }

    // compareTo : 0 이 1보다 배열의 앞에 위치했기에 음수가 나온다.
    System.out.println(participant[0].compareTo(participant[1]));




  }


  public static String solution(String[] participant, String[] completion) {
    String answer = "";
    int completionNums = completion.length;




    


    return answer;
  }

//  public static boolean completeMarathon(String[] participant, String completion) {
//    int size = participant.length;
//    int left = 0;
//    int right = size - 1;
//    int mid;
//    while(right >= left) {
//      mid = (right + left) / 2;
//      if(participant[mid].equals(completion)) {
//        System.out.println(completion + "완주했다!");
//        return true;
//      }
//      // completion 이 mid 의 앞에 있으면?
//      if(participant[mid].compareTo(completion) > 0) {
//        right = mid -1;
//      } else {
//        left = mid + 1;
//      }
//    }
//    return false;
//  }

}
