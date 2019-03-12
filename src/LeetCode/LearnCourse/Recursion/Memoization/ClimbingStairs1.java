package LeetCode.LearnCourse.Recursion.Memoization;

/**
 * @author choijaeyong on 12/03/2019.
 * @project Algorithm
 * @description
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 * https://leetcode.com/explore/learn/card/recursion-i/255/recursion-memoization/1662/
 */
public class ClimbingStairs1 {

  public static void main(String[] args) {
    ClimbingStairs1 climbingStairs1 = new ClimbingStairs1();
    System.out.println(climbingStairs1.climbStairs2(3));
  }


  public int climbStairs(int n) {

    if(n == 1) {
      return 1;
    } else if(n == 2) {
      return 2;
    }


    return climbStairs(n-1) + climbStairs(n-2);
  }



  public int climbStairs2(int n) {
    int[] memo = new int[n+1];
    return climb_stairs(0,n,memo);
  }

  public int climb_stairs(int i, int n, int[] memo) {
    if(i > n) {
      return 0;
    }

    if(i == n) {
      return 1;
    }

    if(memo[i] > 0) {
      return memo[i];
    }
    memo[i] = climb_stairs(i+1,n,memo) + climb_stairs(i+2 , n, memo);
    return memo[i];
  }

}
