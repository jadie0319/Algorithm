package etc.Question2;

import java.util.Arrays;

/**
 * @author choijaeyong on 20/02/2019.
 * @project Algorithm
 * @description
 */
public class QuickSample {
  public static void main(String[] args) {
    int[] arr = {5,7,3,2,1,5,8,6,11,9,3,4,10,5};

    quicksort(arr,0,arr.length-1);

    System.out.println(Arrays.toString(arr));

  }
  public static void quicksort(int[] arr,int start, int end) {

    if(start >= end ) {
      return;
    }

    int left = start;
    int right = end;
    int pivot = arr[(left+right)/2];

    do{

      while(arr[left] < pivot) left++;
      while(arr[right] > pivot) right--;

      if(left <= right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++;
        right--;
      }

    }while(left <= right);

    if(start < right) quicksort(arr,start,right);
    if(left < end) quicksort(arr,left,end);




  }

}
