package LeetCode.LearnCourse.Recursion.RecurrenceRelation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author choijaeyong on 07/03/2019.
 * @project Algorithm
 * @description
 */
public class Solution2 {
  public static void main(String[] args) {
    List<Integer> result = getRow(3);
    System.out.println(result);


  }
  public static List<Integer> getRow(int rowIndex) {
    List<List<Integer>> triangle = new ArrayList<>();

    triangle.add(new ArrayList<>());
    triangle.get(0).add(1);

    if(rowIndex == 0) {
      return triangle.get(0);
    }

    for(int i=1; i <= rowIndex ; i++) {
      List<Integer> row = new ArrayList<>();
      List<Integer> prev = triangle.get(i-1);
      row.add(1);

      for(int j=1 ; j < i ; j++) {
        row.add(prev.get(j) + prev.get(j-1));
      }

      row.add(1);
      triangle.add(row);

      if(i == rowIndex) {
        return row;
      }
    }



    return null;
  }

}
