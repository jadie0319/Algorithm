package LeetCode.Question557;

/**
 * @author choijaeyong on 10/02/2019.
 * @project Algorithm
 * @description
 * 557. Reverse Words in a String III
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 *
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */
public class Solution {


  public static void main(String[] args) {

    String S = "Let's take LeetCode contest";

    System.out.println(reverseWords(S));

  }

  public static String reverseWords(String s) {

    String[] words = s.split(" ");

    int length = words.length;
    StringBuilder sb = new StringBuilder();


    for(int i=0; i < length ; i++) {
      int wordLength = words[i].length();

      for(int j=wordLength-1; j >= 0 ; j--) {
        sb.append(words[i].charAt(j));
      }
      sb.append(" ");
    }

    sb.setLength(sb.length()-1);

    return sb.toString();
  }
}
