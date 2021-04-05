package LeetCode.Question240;

import java.util.Arrays;

/**
 * @author choijaeyong on 30/01/2019.
 * @project Algorithm
 * @description
 * 240. Search a 2D Matrix II
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
public class Solution {
  public static void main(String[] args) {

    int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};

    System.out.println( searchMatrix(matrix,20));

  }

//  public static boolean searchMatrix(int[][] matrix, int target) {
//
//    int mid;
//    int left = 0;
//    int originalLength = matrix.length;
//    int right = originalLength - 1;
//
//    int[][] leftMatrix = new int[mid][mid];
//    int[][] rightMatrix = new int[originalLength-mid][originalLength-mid];
//
//    while(right >= left) {
//      mid = (originalLength) / 2;
//
//
//
//    }
//    for(int i=0; i < leftMatrix.length ; i++) {
//      leftMatrix[i] = Arrays.copyOf(matrix[i],originalLength);
//    }
//    for(int i=0; i < rightMatrix.length ; i++) {
//      rightMatrix[i] = Arrays.copyOf(matrix[i+mid],originalLength);
//    }
//
//    printArray(leftMatrix);
//    System.out.println();
//    printArray(rightMatrix);
//
//
//
//
//    return false;
//  }


  public static boolean searchMatrix(int[][] matrix, int target) {

    if(matrix.length == 1) {
      Arrays.binarySearch(matrix,target);
    }

    int originalLength = matrix.length;
    int mid = (originalLength) / 2;

    int[][] leftMatrix = new int[mid][mid];
    int[][] rightMatrix = new int[originalLength-mid][originalLength-mid];

//    System.out.println(leftMatrix.length);
//    System.out.println(rightMatrix.length);

    for(int i=0; i < leftMatrix.length ; i++) {
      leftMatrix[i] = Arrays.copyOf(matrix[i],originalLength);
    }
    for(int i=0; i < rightMatrix.length ; i++) {
      rightMatrix[i] = Arrays.copyOf(matrix[i+mid],originalLength);
    }

    printArray(leftMatrix);
    System.out.println();
    printArray(rightMatrix);

    return false;
  }







  public static void printArray(int[][] matrix) {
    for(int[] k : matrix){
      System.out.print(k[0] + " " + k[1] + " " + k[2] + " " + k[3] + " " + k[4]);
      System.out.println();
    }
  }
}
