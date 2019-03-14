package LeetCode.LearnCourse.Recursion.Complexity;

/**
 * @author choijaeyong on 14/03/2019.
 * @project Algorithm
 * @description
 */
public class ImplPow {
  public static void main(String[] args) {
    ImplPow implPow = new ImplPow();

    System.out.println(implPow.myPow(2.0,-2));
    System.out.println(Math.pow(2.0, -2147483648));
    System.out.println(Integer.MIN_VALUE);

  }

  public double myPow(double x, int n) {
    if(n == Integer.MIN_VALUE) {
      if(x == 1.0 || x == -1.0) {
        return 1.0;
      }
      return 0.0;
    }


    double answer = 1;
    int iterative = Math.abs(n);

    for(int i=0; i < iterative ; i++) {
      answer = answer * x;
    }
    if(n < 0) {
      answer = 1 / answer;
    }

    return answer;
  }

}
