package etc.test1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author choijaeyong on 18/02/2019.
 * @project Algorithm
 * @description
 */
public class exam1 {
  public static void main(String[] args) {
    int[] inputs = {3,4,5,4};
    int[] inputs1 = {4,5,2,3,4};
    int[] inputs2 = {1,2,3,3,5,6,7};

    System.out.println(solution(inputs2));

  }

  public static int solution(int[] A) {

    Integer[] temp = null;
    int length = A.length;

    int result =0;

    for(int i=0; i < length ; i++) {

      temp = newArray(A,i);

      if(isOrdered(temp)) {
        result++;
      }

    }
    return result;
  }

  // new array except cut tree
  public static Integer[] newArray(int[] A, int k) {
    Integer[] temp = null;
    List<Integer> list = new ArrayList<>();
    int length = A.length;

    for(int i=0; i < length ; i++) {
      if(i == k) {
        continue;
      }
      list.add(A[i]);
    }

    temp = list.toArray(new Integer[list.size()]);

    return temp;
  }

  public static boolean isOrdered(Integer[] A) {

    int length = A.length;

    for(int i=0; i < length - 1 ; i++) {
      if(A[i] > A[i+1]) {
        // if A[i] tree is bigger than A[i+1] tree, return false
        return false;
      }
    }
    return true;
  }

}
