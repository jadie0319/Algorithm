package etc.Study1;

import java.io.*;
import java.util.Stack;

class StackExam {

  public static void main(String[] args) throws java.lang.Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Integer input = Integer.parseInt(br.readLine());
    String[] lines = new String[input];

    for(int i=0 ; i < input ; i++) {
      lines[i] = br.readLine();
    }

    Stack<String> stack = new Stack<String>();

    for(int i=0 ; i < input ; i++) {

      String[] words = lines[i].split(" ");

      for(String word : words) {
        stack.push(word);
      }

      int size = words.length;

      for(int j=0 ; j < size ; j++) {

        if(j != size-1) {
          System.out.print(stack.pop() + " ");
        } else {
          System.out.print(stack.pop());
        }

      }

      if(i != input -1) {
        System.out.println();
      }

    }


  }

}
