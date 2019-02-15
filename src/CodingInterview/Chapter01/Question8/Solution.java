package CodingInterview.Chapter01.Question8;

import java.util.Arrays;

/**
 * @author choijaeyong on 15/02/2019.
 * @project Algorithm
 * @description
 * 1-8. 0 행렬 : M * N 행렬의 한 원소가 0인 경우, 해당 원소가 속한 행과 열의 모든 원소를 0으로 설정하는
 * 알고리즘을 작성하라.
 */
public class Solution {
  public static void main(String[] args) {
    int[][] matrix = {{1,2,3,4,5},{6,7,8,9,1},{2,3,0,5,6},{1,2,3,4,5}};

    print(matrix);
    System.out.println();
    solution(matrix);

    print(matrix);
  }

  public static void solution(int[][] matrix) {

    int fixRow = 0;
    int fixCol = 0;

    for(int i=0; i < matrix.length ; i++) {
      for(int j=0; j < matrix[i].length ; j++) {
        if(matrix[i][j] == 0) {
          fixRow = i;
          fixCol = j;
        }
      }
    }

    // change
    for(int i=0; i < matrix.length ; i++) {
      for(int j=0; j < matrix[i].length ; j++) {
        if(j == fixCol || i == fixRow) {
          matrix[i][j] = 0;
        }
      }
    }


  }

  public static void print(int[][] matrix) {
    for(int i=0; i < matrix.length ; i++) {
      for(int j=0; j < matrix[i].length ; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }



}
