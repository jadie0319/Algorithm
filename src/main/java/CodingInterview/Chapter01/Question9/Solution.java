package CodingInterview.Chapter01.Question9;

/**
 * @author choijaeyong on 15/02/2019.
 * @project Algorithm
 * @description
 *
 * 1-9 문자열 회전
 *
 */
public class Solution {
  public static void main(String[] args) {
    String s1 = "waterbottle";
    String s2 = "erbottlewat";

  }

  public static boolean isRotate(String s1, String s2) {

    int length = s1.length();

    if(s2.length() == length) {
      String s1s1 = s1+ s1;
      // return isSubstring(s1s1,s2);
    }
    return false;
  }

}
