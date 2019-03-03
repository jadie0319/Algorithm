package etc.Study4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author choijaeyong on 03/03/2019.
 * @project Algorithm
 * @description
 */
public class Main1 {
  public static void main(String[] args) {
    int[] A = {3,4,5,4};

    System.out.println(solution(A));

  }

  public static int solution(int[] A) {

    Integer[] temp = null;
    int length = A.length;

    int result = 0;

    for(int i=0; i < length ; i++) {
      System.out.println("A : " + Arrays.toString(A));
      // 새 배열을 만든다. i 번째 나무가 빠진.
      temp = newArray(A,i);
      System.out.println("temp : " + Arrays.toString(temp) );

      // i 번째 나무가 빠진 새 배열이 크기순으로 잘 정렬 되었는지 비교해본다.
      if(isOrdered(temp)) {
        // 정렬이 잘 되어있으면 결과값에 ++
        result++;
      }

    }

    return result;
  }

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
    System.out.println();

    return temp;
  }

  public static boolean isOrdered(Integer[] A) {
    int length = A.length;

    for(int i=0; i < length-1 ; i++) {
      if(A[i] > A[i+1]) {
        return false;
      }
    }
    return true;
  }

}
