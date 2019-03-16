package etc.Study5;

/**
 * @author choijaeyong on 16/03/2019.
 * @project Algorithm
 * @description
 */
public class Solution2 {
  public static void main(String[] args) {
    int[][] lands = {{10,0,30,5},{0,30,20,50},{30,30,40,40}};
    int[][] wells = {{15,15,25,25}, {40,10,50,20}};
    int[] point = {10,10,30,30};

  }

  public boolean solution(int[][] lands, int[][] wells, int[] point) {
    boolean answer = false;

    for(int[] land : lands) {
      // point 가 land 안에 있는지.
      boolean overlap = overlap(land,point);
      if(overlap) {
        return false;
      }
    }

    for(int[] well : wells) {
      // well이 point 안에 있는지
      boolean overlap = overlap(point,well);
      if(overlap) {
        return true;
      }
    }

    return answer;
  }

  public boolean overlap(int[] target, int[] compare) {
    if(overlap(target[0], target[2], compare[0] ) || overlap(target[0],target[2],compare[2])) {
      return overlap(target[1],target[3],compare[1]) || overlap(target[1],target[3],compare[3]);
    } else {
      return false;
    }
  }

  public boolean overlap(int from, int to, int point) {
    return from < point && to > point;
  }

}
