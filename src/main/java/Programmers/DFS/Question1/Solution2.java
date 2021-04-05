package Programmers.DFS.Question1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {

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
    String[] answers;
    List<String> answerList = new ArrayList<>();


    List<String[]> list = new ArrayList<>();
    int length = tickets.length;
    for(int i=0; i < length ; i++) {
      list.add(tickets[i]);
    }




    return null;
  }

  public static int initICN(String[][] tickets, Stack<String> stack) {
    int length = tickets.length;


    return 0;
  }



}
