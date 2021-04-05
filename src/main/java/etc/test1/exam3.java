package etc.test1;

import java.util.Stack;

/**
 * @author choijaeyong on 18/02/2019.
 * @project Algorithm
 * @description
 */
public class exam3 {

  final static Double MAX = Math.pow(2,20) - 1;

  public static void main(String[] args) {

    String s = "13 DUP 4 POP 5 DUP + DUP + -";
    String s1 = "5 6 + -";
    String s2 = "3 DUP 5 - -";
    System.out.println(solution(s1));

  }

  public static int solution(String S) {

    String[] inputs = S.split(" ");
    Stack<Integer> stack = new Stack<>();

    for(String str : inputs) {
      switch(str) {

        case "DUP":
          // DUP 일때
          int temp = 0;
          if(!stack.empty()) {
            temp = stack.peek();
          }else {
            // if stack is empty, then return -1. The end
            return -1;
          }
          stack.push(temp);
          break;

        case "POP":
          // POP 일때
          if(stack.empty()) {
            // stack is empty, so stack isn't pop data.
            return -1;
          }else {
            stack.pop();
          }
          break;

        case "+":
          // + 일때
          if(stack.size() < 2) {
            // + operation needs two element.
            return -1;
          } else {
            int first = stack.pop();
            int second = stack.pop();
            int result = second + first;

            if(result > MAX.intValue()) {
              // overflow
              return -1;
            }

            stack.push(result);
          }
          break;

        case "-":
          // - 일때

          if(stack.size() < 2) {
            // - operation needs two element.
            return -1;
          } else {
            int first = stack.pop();
            int second = stack.pop();
            int result = first - second;

            if(result < 0) {
              // underflow
              return -1;
            }

            stack.push(result);
          }
          break;

        default:
          // remainder is number except POP,DUP,+,-.
          stack.push(Integer.parseInt(str));

      }
    }
    return stack.peek();
  }

}
