package ProgrammersNew.test;

/**
 * @author choijaeyong on 2020/09/12.
 * @project Algorithm
 * @description
 */
public class Solution {

  public static void main(String[] args) {
    String str1 = "...!@BaT#*..y.abcdefghijklm";
    String str2 = "z-+.^."	;
    String str3 = "=.=";
    String str4 = "...!@BaT#*..y.abcdefghijklm";

    System.out.println(solution(str3));
  }

  public static String solution(String new_id) {
    String answer = "";

    String lowId = new_id.toLowerCase();
    StringBuilder sb = new StringBuilder();
    for (char c : lowId.toCharArray()) {
      if ( (Character.isLetter(c) || Character.isDigit(c) || c == '-' || c == '_' || c == '.')  ) {
        sb.append(c);
      }
    }
    new_id = sb.toString();
    new_id = new_id.replaceAll("[.]{1,}+", ".");

    if (new_id.charAt(0) == '.') {
      new_id = new_id.substring(1);
    }

    if (new_id.length() == 0) {
      new_id = "a";
    }

    if (new_id.charAt(new_id.length() -1 ) == '.') {
      new_id = new_id.substring(0,new_id.length()-1);
    }

    if (new_id.length() >= 16) {
      new_id = new_id.substring(0,15);
      if (new_id.charAt(new_id.length() -1 ) == '.') {
        new_id = new_id.substring(0,new_id.length()-1);
      }
    }

    if (new_id.length() <= 2) {
      char plusChar = new_id.charAt(new_id.length()-1);
      sb = new StringBuilder(new_id);
      while(sb.length() <= 2) {
        sb.append(plusChar);
      }
      answer = sb.toString();
    } else {
      answer = new_id;
    }
    return answer;
  }

}
