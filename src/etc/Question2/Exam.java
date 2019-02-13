package etc.Question2;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author choijaeyong on 13/02/2019.
 * @project Algorithm
 * @description
 */
public class Exam {

  public static void main(String[] args) {

    int[] A = {1,3,6,4,1,2};
    Exam e = new Exam();

    System.out.println(e.solution(A));

  }

  public int solution(int[] A) {

    Arrays.sort(A);
    int max = A[A.length-1];
    if(max <= 0) {
      return 1;
    }
    int count=1;
    for(int i=0; i < A.length ; i++) {
      if(A[i] <= count) {
        continue;
      } else if(A[i] == count+1) {
        count++;
        System.out.println("A[i] == count+1 : " + count);
      } else if(A[i] > count + 1) {
        System.out.println("A[i] > count+1 : " + count);
        return count+1;
      }
    }



    return count;
  }

}
