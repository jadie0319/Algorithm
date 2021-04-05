package etc.Practice;

import java.util.Arrays;

/**
 * @author choijaeyong on 01/04/2019.
 * @project Algorithm
 * @description
 */
public class QuickSort {

  public static void main(String[] args) {
    int[] array = {1,4,2,5,6,8,2,5};
    quickSort(array,0,array.length-1);

    System.out.println(Arrays.toString(array));


  }

  public static void quickSort(int[] arr, int start, int end) {

    if(start >= end) {
      return;
    }

    int left = start;
    int right = end;
    int pivot = arr[(left+right)/2];

    do {
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

    if(start < right) quickSort(arr,start,right);
    if(left < end) quickSort(arr,left,end);

  }
}
