package LeetCode.LearnCourse.Recursion.Memoization;

import java.util.HashMap;
import java.util.Map;

/**
 * @author choijaeyong on 12/03/2019.
 * @project Algorithm
 * @description
 * Fibonacci Number
 * https://leetcode.com/explore/learn/card/recursion-i/255/recursion-memoization/1661/
 */
public class Fibonacci {

  Map<Integer , Integer> map = new HashMap<>();

  public static void main(String[] args) { // 0 1 1 2 3 5
    Fibonacci solution = new Fibonacci();
    System.out.println(solution.fib(2));
    System.out.println(solution.fib(3));
    System.out.println(solution.fib(4));
    System.out.println(solution.fib(5));

  }
//  public static int fib(int N) {
//    if(N == 0) {
//      return 0;
//    }else if(N == 1) {
//      return 1;
//    }
//
//    return fib(N-1) + fib(N-2);
//  }

  public int fib(int N) {
    if(map.containsKey(N)) {
      return map.get(N);
    }
    int result;
    if(N == 0) {
      return 0;
    }else if(N == 1) {
      return 1;
    }
    result = fib(N-1) + fib(N-2);
    map.put(N, result);

    return result;
  }


}
