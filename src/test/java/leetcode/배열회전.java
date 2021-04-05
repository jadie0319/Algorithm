package leetcode;

import org.junit.jupiter.api.Test;

/*
  LeetCode 48번
 */

public class 배열회전 {

  @Test
  void test() {
    int[][] matrix = {
        {1,2,3},{4,5,6},{7,8,9}
    };
    rotate(matrix);
  }

  @Test
  void test2() {
    int[][] matrix = {
        {5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}
    };
    rotate(matrix);
  }

  public static void rotate(int[][] matrix) {
    /*
    0,0 -> 0,3    0,3 -> 3,3    3,3 -> 3,0    3,0 -> 0,0
    0,1 -> 1,3    1,3 -> 3,2    3,2 -> 2,0    2,0 -> 0,1
    0,2 -> 2,3    2,3 -> 3,1    3,1 -> 1,0    1,0 -> 0,2
    0,3 -> 3,3    3,3 -> 3,0    3,0 -> 0,0    0,0 -> 0,3
     */

    for (int y=0 ; y <  (matrix.length + 1)/2 ; y++) {  // 회전 대상의 수
      for (int x=0 ; x < matrix[y].length ; x++) {  // 회전 내부 인덱스

      }
    }
  }

}
