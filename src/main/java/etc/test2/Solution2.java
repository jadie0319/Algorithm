package etc.test2;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author choijaeyong on 15/04/2019.
 * @project Algorithm
 * @description
 */
public class Solution2 {
  public static void main(String[] args) {

    String[] values = {"(){}[]","{[}])"};
    String[] answer = braces(values);
    System.out.println(Arrays.toString(answer));
  }
  public static String[] braces(String[] values) {

    String[] answer = new String[values.length];
    int index=0;

    for(String value : values) {

      Stack<Character> stack = new Stack<>();

      for(int i=0; i < value.length() ; i++) {
        if(stack.empty()) {
          stack.push(value.charAt(i));
        } else if(stack.peek() == '(' && value.charAt(i) == ')') {
          stack.pop();
        } else if(stack.peek() == '{' && value.charAt(i) == '}') {
          stack.pop();
        } else if(stack.peek() == '[' && value.charAt(i) == ']') {
          stack.pop();
        } else {
          stack.push(value.charAt(i));
        }
      }

      if(stack.empty()) {
        answer[index] = "YES";
      }else {
        answer[index] = "NO";
      }
      index++;
    }

    return answer;
  }

}
