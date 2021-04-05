package etc.Study4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author choijaeyong on 04/03/2019.
 * @project Algorithm
 * @description
 */
public class Main3 {

  final static double MAX = Math.pow(2,20) - 1;

  public static void main(String[] args) {
    String s = "13 DUP 4 POP 5 DUP + DUP + -";
    String s1 = "5 6 + -";
    String s2 = "3 DUP 5 - -";


    System.out.println(solution(s1));





  }

  public static int solution(String S) {

    String[] inputs = S.split(" ");
    ArrayDeque<Integer> stack = new ArrayDeque<>();

    for(String str : inputs) {
      switch(str) {
        case "DUP":
          int temp=0;
          if(!stack.isEmpty()) {
            temp = stack.peek();
          }else {
            return -1;
          }
          stack.push(temp);
          break;

        case "POP":
          if(stack.isEmpty()) {
            return -1;
          }else {
            stack.pop();
          }
          break;

        case "+":
          if(stack.size() < 2) {
            return -1;
          }else {
            int first = stack.pop();
            int second = stack.pop();
            int result = first + second;
            if(result > MAX) {
              return -1;
            }
            stack.push(result);
          }
          break;

        case "-":
          if(stack.size() < 2) {
            return -1;
          }else {
            int first = stack.pop();
            int second = stack.pop();
            int result = first - second;
            if(result < 0) {
              return -1;
            }
            stack.push(result);

          }
          break;

        default:
          stack.push(Integer.parseInt(str));
      }
    }

    // stack이 비었다면 여기서 peek 가 아니라. -1을 ? 해줘야했나.

    return stack.peek();
  }

}