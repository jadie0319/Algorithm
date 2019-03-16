package etc.Study5;

import LeetCode.LearnCourse.Recursion.Complexity.Solution;
import java.util.Arrays;

/**
 * @author choijaeyong on 16/03/2019.
 * @project Algorithm
 * @description
 *
 */
public class Solution1 {
  public static void main(String[] args) {

    Solution1 solution1 = new Solution1();
    System.out.println(Arrays.toString(solution1.solution(15000)));
  }

  public int[] solution(int money) {
    int[] answer = {};
    answer = new int[9]; // 오만, 만, 오천, 천, 오백, 백, 오십, 십, 일

    money = calculate(money,50000,answer,0);
    money = calculate(money,10000,answer,1);
    money = calculate(money,5000,answer,2);
    money = calculate(money,1000,answer,3);
    money = calculate(money,500,answer,4);
    money = calculate(money,100,answer,5);
    money = calculate(money,50,answer,6);
    money = calculate(money,10,answer,7);
    money = calculate(money,1,answer,8);


    return answer;
  }

  public int calculate(int money, int unit, int[] answer, int index) {
    if(money / unit >= 1) {
      int temp = money / unit;
      answer[index] = temp;
      money = money - temp * unit;
    }
    return money;
  }

}
