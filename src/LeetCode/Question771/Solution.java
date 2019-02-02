package LeetCode.Question771;

/**
 * @author choijaeyong on 11/03/2019.
 * @project Algorithm
 * @description
 */
public class Solution {
  public static void main(String[] args) {

    String J = "aA";
    String S = "aAAbbbb";

    System.out.println(numJewelsInStones(J,S));
  }

  public static int numJewelsInStones(String J, String S) {

    int count = 0;
    char[] jewels = J.toCharArray();

    int size = S.length();
    int size2 = jewels.length;

    for(int i=0; i < size ; i++) {
      for(int j=0; j < size2 ; j++) {
        if(S.charAt(i) == jewels[j]) {
          count++;
        }
      }
    }


    return count;
  }

}
