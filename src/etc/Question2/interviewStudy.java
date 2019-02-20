package etc.Question2;

import java.util.Arrays;

/**
 * @author choijaeyong on 20/02/2019.
 * @project Algorithm
 * @description
 *
 */
public class interviewStudy {
  public static void main(String[] args) {

    int[] memo = new int[6];
    System.out.println(fibo(5,memo));
  }

  public static int fibo(int n,int[] memo) {
    if(n==1) {
      return 1;
    }else if(n==2) {
      return 1;
    }
    if(memo[n]==0) {
      memo[n] = fibo(n-1,memo) + fibo(n-2,memo);
    }

    System.out.println(Arrays.toString(memo) + " n : " + n);
    System.out.println();


    return memo[n];
  }

}
