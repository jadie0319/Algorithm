package Programmers.DFS.Question1;


/*
DFS 문제.
https://programmers.co.kr/learn/courses/30/lessons/43164?language=java
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution {
  public static void main(String[] args) {
    String tickets[][] = {{"ICN","JKF"},{"HND","IAD"},{"JKF","HND"}};
    System.out.println(tickets.length);
    for(int i=0; i<tickets.length ; i++) {
      System.out.println(tickets[i][0]);
    }

    String a = "a";
    String b = "b";
    int ab = tickets[0][1].compareTo(tickets[1][1]);
    System.out.println(ab);
  }

  public static String[] solution(String[][] tickets) {

    // 배열의 개수는 tickets.length +1;
    int length = tickets.length+1;
    String[] answer = new String[length];

    Queue queue = new LinkedList();
    Stack stack = new Stack();

    List<String> paths = new ArrayList<>();
    paths(tickets,paths);

    int i=0;
    while(true) {
      if(tickets[i][0].equals("ICN")) {
        stack.push(tickets[i][0]);
        stack.push(tickets[i][1]);
        continue;
      }

      if(tickets[i][0].equals(stack.peek())) {

      }
      i++;
      if(i==tickets.length+1) {
        break;
      }
    }


    return null;
  }




  public static int compareTickets(String[][] tickets, int prev, int next) {

    if(tickets[prev][0].equals(tickets[next][0])) {
      int comp = tickets[prev][1].compareTo(tickets[next][1]);  // 앞에 문자가 더 앞에 있으면 -1을 반환.
      if(comp == -1) {
        return prev;
      }
    }
    return next;
  }

  public static List<String> paths(String[][] tickets , List<String> paths) {
    if(paths.size() == tickets.length + 1) {
      return paths;
    }
    return null;
  }


}
