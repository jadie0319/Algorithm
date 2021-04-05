package codility.lesson16;

/**
 * @author choijaeyong on 2020/12/16.
 * @project Algorithm
 * @description
 */
public class Main {

  public static void main(String[] args) {
    int[] A = {1,3,7,9,9};
    int[] B = {5,6,8,9,10};

    int solution = solution(A, B);
    System.out.println(solution);

  }

  public static int solution(int[] A, int[] B) {
    int number = A.length;
    int maxCount = 0;

    for(int i=0; i < number ; i++) {
      int length = B[i] - A[i];
      int end = A[i] + length;
      int count = 0;
      for (int j=1; j < number ; j++ ) {
        if (A[j] > end ) {
          count++;
        }
      }
      maxCount = Math.max(maxCount,count);
    }


    return maxCount;
  }

}
