package Programmers.dp;

/**
 * @author choijaeyong on 2019/11/11.
 * @project Algorithm
 * @description
 */
public class Solution {

  public static void main(String[] args) {
    int m = 4;
    int n = 3;
    int[][] puddles = {{2,2}};
    int result = solution(m,n,puddles);
    System.out.println("result : " + result);
  }
  public static int solution(int m, int n, int[][] puddles) {
    int answer = 0;

    int[][] grid = new int[n][m];

    for (int i=0 ; i < puddles.length ; i++) {
      int y=puddles[i][0];
      int x=puddles[i][1];
      grid[y-1][x-1] = -1;
    }

    for (int i=0; i < n ; i++) {
      for(int j=0; j < m ; j++) {
        System.out.print(grid[i][j] + " ");
      }
      System.out.println();
    }
    int max = 0;
    for (int i=0; i < n ; i++) {
      for (int j=0 ; j < m ; j++) {
        if (grid[i][j] == -1) {

        }


      }
    }


    return answer;
  }

}
