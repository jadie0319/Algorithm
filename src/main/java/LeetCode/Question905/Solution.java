package LeetCode.Question905;

import java.util.Arrays;

/**
 * @author choijaeyong on 05/02/2019.
 * @project Algorithm
 * @description
 * 905. Sort Array By Parity
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *
 * https://leetcode.com/problems/sort-array-by-parity/
 */
public class Solution {
  public static void main(String[] args) {

    int[] A = {3,1,2,4};


    System.out.println(Arrays.toString(sortArrayByParity(A)));

  }

  public static int[] sortArrayByParity(int[] A) {

    int length = A.length;
    int[] result = new int[length];

    int frontPointer = 0;
    int rearPointer = length-1;

    for(int i=0; i < length ; i++) {
      if(A[i] % 2 == 0) {
        result[frontPointer++] = A[i];
      } else {
        result[rearPointer--] = A[i];
      }
    }

    return result;
  }

}
