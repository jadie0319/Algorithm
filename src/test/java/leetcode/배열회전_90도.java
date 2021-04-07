package leetcode;

import org.junit.jupiter.api.Test;

/*
  LeetCode 48번
 */

public class 배열회전_90도 {

  @Test
  void test() {
    int[][] matrix = {
        {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
    };
    rotate(matrix);
  }

  @Test
  void test2() {
    int[][] matrix = {
        {5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}
    };
    rotate(matrix);
  }

  public static void print(int[][] matrix) {
    for (int y = 0; y < matrix.length ; y++) {  // 회전 대상의 수
      for (int x = 0; x < matrix[y].length; x++) {  // 회전 내부 인덱스
        System.out.print(matrix[y][x] + " ");
      }
      System.out.println();
    }
  }

  public static void rotate(int[][] matrix) {
    /*
    0,0 -> 0,3    0,3 -> 3,3    3,3 -> 3,0    3,0 -> 0,0
    0,1 -> 1,3    1,3 -> 3,2    3,2 -> 2,0    2,0 -> 0,1
    0,2 -> 2,3    2,3 -> 3,1    3,1 -> 1,0    1,0 -> 0,2
    0,3 -> 3,3    3,3 -> 3,0    3,0 -> 0,0    0,0 -> 0,3
    규칙: 열 과 행이 같다
     */

    int length = matrix.length;
    for (int y = 0; y < (matrix.length + 1) / 2; y++) {  // 회전 대상의 수
      for (int x = 0; x < (matrix[y].length / 2); x++) {  // 회전 내부 인덱스
        int temp = matrix[y][x];
        matrix[y][x] = matrix[length - 1 - x][y];
        matrix[length - 1 - x][y] = matrix[length - 1 - y][length - 1 - x];
        matrix[length - 1 - y][length - 1 - x] =  matrix[x][length-1-y];
        matrix[x][length-1-y] = temp;
        print(matrix);
        System.out.println();
      }
    }
  }

  /*
  4 * 4
    0,0 -> 0,3    0,3 -> 3,3    3,3 -> 3,0    3,0 -> 0,0
    0,1 -> 1,3    1,3 -> 3,2    3,2 -> 2,0    2,0 -> 0,1
    0,2 -> 2,3    2,3 -> 3,1    3,1 -> 1,0    1,0 -> 0,2
    0,3 -> 3,3    3,3 -> 3,0    3,0 -> 0,0    0,0 -> 0,3
    규칙: 열 과 행이 같다
     */

  public static void r(int[][] matrix) {
    // y=0, x=0
    int temp = matrix[0][0];
    matrix[0][0] = matrix[3][0];
    matrix[3][0] = matrix[3][3];
    matrix[3][3] = matrix[0][3];
    matrix[0][3] = temp;

    // y=0, x=1
    int temp2 = matrix[0][1];
    matrix[0][1] = matrix[2][0];
    matrix[2][0] = matrix[3][2];
    matrix[3][2] = matrix[1][3];
    matrix[1][3] = temp2;

    // y=0, x=2
    int temp3 = matrix[0][2];
    matrix[0][2] = matrix[1][0];
    matrix[1][0] = matrix[3][1];
    matrix[3][1] = matrix[2][3];
    matrix[2][3] = temp3;
  }

}
