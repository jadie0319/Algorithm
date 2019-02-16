package LeetCode.LearnCourse.Recursion;

/**
 * @author choijaeyong on 16/02/2019.
 * @project Algorithm
 * @description
 * 사이트에 나온 코드
 */
public class ReverseString2 {
  public static void main(String[] args) {

    char[] input = {'h','e','l','l','o'};
    reverseString(input);
    System.out.println(input);

  }

  public static void reverseString(char[] s) {

    printReverseString(s, 0,s.length-1);

  }

  public static void printReverseString(char[] s, int start, int end) {
    if(start >= end) {
      return;
    }
    char temp = s[start];
    s[start] = s[end];
    s[end] = temp;

    printReverseString(s,start+1,end-1);
  }

}
