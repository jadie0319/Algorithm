package LeetCode.Question64;

/**
 * @author choijaeyong on 23/01/2019.
 * @project Algorithm
 * @description
 *
 * 64. Minimum Path Sum
 * https://leetcode.com/problems/minimum-path-sum/
 *
 *
 */
public class Main {

  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) {
    //int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
    //int[][] grid = {{1,2},{5,6},{1,1}};
    int[][] grid = {{1}};

    minPathSum(grid);
  }



  public static int minPathSum(int[][] grid) {

    int result = calcPathSum(grid,0,0,0);
    System.out.println(min);

    return min;
  }

  public static int calcPathSum(int[][] grid, int y, int x, int result) {

    if(y > grid.length  ||  x > grid[0].length) {
      System.out.println("y > length or x > length");
      return 0;
    }

    // 끝지점(오른쪽 맨 아래) 이면.
    if(y == grid.length -1 && x == grid[0].length - 1) {
      result += grid[y][x];
      min = result < min ? result : min;
      System.out.println("grid[y][x] : "+ grid[y][x] +"  y : " + y + " x : " + x +"  min : " + min + "    result : " + result);
      //return grid[y][x];
      return grid[y][x];
    }

    if(y == grid.length-1) {
      // 맨 아래
      result += grid[y][x];
      System.out.println("옆으로만 이동 가능 , result : " + result + " grid[y][x] : " + grid[y][x]);
      return calcPathSum(grid,y,x+1,result);

    } else if(x == grid[0].length-1){
      // 맨 오른쪽
      result += grid[y][x];
      System.out.println("아래로만 이동 가능 , result : " + result + " grid[y][x] : " + grid[y][x]);
      return calcPathSum(grid,y+1,x,result);

    } else{
      // 일반?적인 경우?
      result += grid[y][x];
      System.out.println("y : " + y + " x : " + x + " result :" + result + " grid[y][x] : " + grid[y][x]);
      return calcPathSum(grid,y+1,x,result) + calcPathSum(grid,y,x+1,result);
    }







//    return grid[y+1][x] + grid[y][x+1];
  }

}



//public class Quiz64 {
//  public static int minPathSum(int[][] grid) {
//    int size = grid.length;
//    int size2 = grid[0].length;
//    int[][] sum = new int[size][size2];
//
//    for (int i = 0; i < size; i++) {
//      for (int j = 0; j < size2; j++) {
//        if (i == 0 && j == 0) {
//          sum[i][j] = grid[i][j];
//          continue;
//        } else if (i == 0) {
//          sum[i][j] = grid[i][j] + sum[i][j - 1];
//          continue;
//        } else if (j == 0) {
//          sum[i][j] = grid[i][j] + sum[i - 1][j];
//          continue;
//        }
//        sum[i][j] = grid[i][j] + Math.min(sum[i - 1][j], sum[i][j - 1]);
//      }
//    }
//    return sum[size - 1][size2 - 1];
//  }
//
//  public static void main(String[] args) {
////        int[][] grid = {{1,2,5}, {3,2,1}};
//    int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
//    System.out.println(minPathSum(grid));
//  }
//}