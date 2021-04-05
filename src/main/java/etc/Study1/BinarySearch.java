package etc.Study1;

import java.util.Arrays;

/**
 * @author choijaeyong on 06/02/2019.
 * @project Algorithm
 * @description
 *
 * 이진탐색 예제. 이진탐색은 정렬이 되어 있어야 한다.
 */
public class BinarySearch {

  public static void main(String[] args) {

    int[] array = {1,4,2,5,6,8,2,5,9,10,11,19,10,15,13};
    int test = 3;

    binarySort(array,10);

    for(int k : array) {
      System.out.print(k + " ");
    }




  }

  public static void binarySort(int[] array, int target) {
    Arrays.sort(array);

    int mid = 0;
    int left = 0;
    int right = array.length-1;

    while(left <= right){
      mid = (right + left) /2;
      if(array[mid] == target) {
        System.out.println(target + "이 있다.");
        break;
      }

      if(target < array[mid]) {
        right = mid -1;
      } else {
        left = mid + 1;
      }
    }


  }

}
