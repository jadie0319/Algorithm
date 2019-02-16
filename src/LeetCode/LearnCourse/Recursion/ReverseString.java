package LeetCode.LearnCourse.Recursion;

/**
 * @author choijaeyong on 16/02/2019.
 * @project Algorithm
 * @description
 */
public class ReverseString {
  public static void main(String[] args) {

    char[] input = {'h','e','l','l','o'};
    reverseString(input);

  }

  public static void reverseString(char[] s) {
    StringBuilder sb = new StringBuilder();

    printReverseString(s,0,sb);

    String rev = sb.toString();
    for(int i=0 ; i < s.length ; i++) {
      s[i] = rev.charAt(i);
    }


//    //System.out.println(result);
//    for(int i=0; i < result.length ; i++) {
//      if(i==0) {
//        System.out.print("[\"" + result[i] + "\",");
//      } else if(i==result.length-1) {
//        System.out.print("\""+result[i]+"\"]");
//      } else {
//        System.out.print("\"" + result[i] + "\",");
//      }
//    }
  }

  public static void printReverseString(char[] s, int index,StringBuilder sb) {
    if(index == s.length) {
      return;
    }
    printReverseString(s,index+1,sb);
    //System.out.print(s[index]);
    sb.append(s[index]);
  }

}
