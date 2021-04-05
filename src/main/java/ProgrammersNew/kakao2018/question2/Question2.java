package ProgrammersNew.kakao2018.question2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author choijaeyong on 2020/08/27.
 * @project Algorithm
 * @description
 * 다트게임
 */
public class Question2 {

  public static void main(String[] args) {
    String dartResult = "1S2D*3T";
    int solution = solution(dartResult);
  }

  public static int solution(String dartResult) {
    int answer = 0;

    int[] sum = new int[3];

    String reg = "([0-9]{1,2}[S|T|D][*|#]{0,1})";
    Pattern p = Pattern.compile(reg+reg+reg);
    Matcher m = p.matcher(dartResult);
    m.find();

    for (int i = 1 ; i <= m.groupCount() ; i++) {
      Pattern p1 = Pattern.compile("([0-9]{1,2})([S|T|D])([*|#]{0,1})");
      Matcher m1 = p1.matcher(m.group(i));
      m1.find();


      sum[i-1] = (int)Math.pow( Integer.parseInt(m1.group(1)) , getPow(m1.group(2)));
      calculate(sum,i,m1.group(3));
    }

    return sum[0] + sum[1] + sum[2];
  }

  private static void calculate(int[] sum, int i, String option) {
    if (option.equals("*")) {
      sum[i-1] *= 2;
      if (i > 1) {
        sum[i-2] *= 2;
      }
    } else if (option.equals("#")) {
      sum[i-1] *= -1;
    }
  }

  private static Integer getPow(String group) {
    if (group.equals("S")) {
      return 1;
    } else if (group.equals("D")) {
      return 2;
    } else {
      return 3;
    }
  }

}
