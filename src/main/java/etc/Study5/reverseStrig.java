package etc.Study5;

/**
 * @author choijaeyong on 21/03/2019.
 * @project Algorithm
 * @description
 */
public class reverseStrig {
  public static void main(String[] args) {
    String str = "hello";

    System.out.println(reverse(str));
  }

  public static String reverse(String str) {
    StringBuilder sb = new StringBuilder();
    int length = str.length()-1;

    for(int i=length ; i >= 0 ; i--) {
      sb.append(str.charAt(i));
    }

    return sb.toString();
  }

}
