package etc.Study1;

import java.util.Arrays;

/**
 * @author choijaeyong on 07/02/2019.
 * @project Algorithm
 * @description
 */
public class QuickSort {

  public static void main(String[] args) {
    int[] array = {1,4,2,5,6,8,2,5};

//    for(int k : array) {
//      System.out.print(k + " ");
//    }
    System.out.println("정렬 전");
    System.out.println(Arrays.toString(array));

    System.out.println();
    quickSort(array,0,array.length-1);

    System.out.println();
    System.out.println("정렬 후");
    System.out.println(Arrays.toString(array));


  }

  public static void quickSort(int[] array, int start, int end) {

    if(start >= end) {
      return;
    }

    int left = start; // left pointer
    int right = end; // right pointer
    int pivot = array[(left+right)/2];

    do {

      while(array[left] < pivot) left++;
      while(array[right] > pivot) right--;

      if(left <= right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
        System.out.println(Arrays.toString(array));
        left++;
        right--;
      }

    }while(left <= right);

    if(start < right) quickSort(array,start,right);
    if(left < end) quickSort(array,left,end);

  }

}
