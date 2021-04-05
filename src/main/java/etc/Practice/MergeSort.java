package etc.Practice;

import java.util.Arrays;

/**
 * @author choijaeyong on 01/04/2019.
 * @project Algorithm
 * @description
 */
public class MergeSort {
  public static void main(String[] args) {
    int[] array = {1,4,2,5,6,8,2,5};
    mergeSort(array,0,array.length-1);

  }

  public static void mergeSort(int[] array, int left, int right) {
    if(left < right) {
      int mid = (left + right)/2;
      mergeSort(array,left,mid);
      mergeSort(array,mid+1,right);
      merge(array, left, mid, right);

    }

  }

  public static void merge(int[] array, int left, int mid, int right) {

    int l = left;
    int m = mid +1;
    int t = left;
    int[] temp = new int[array.length];

    while(l <= mid && m <= right) {
      if(array[l] <= array[m]) {
        temp[t] = array[l];
        t++;
        l++;
      } else {
        temp[t] = array[m];
        t++;
        m++;
      }
    }

    while(l <= mid) {
      temp[t] = array[l];
      t++;
      l++;
    }

    while(m <= right) {
      temp[t] = array[m];
      t++;
      m++;
    }

    System.out.println("temp");
    System.out.println(Arrays.toString(temp));
    System.out.println();

    System.out.println("l : " + l + "  t : " + t);
    for(int i=left ; i < t ; i++) {
      array[i] = temp[i];
    }

    System.out.println("arr");
    System.out.println(Arrays.toString(array));
    System.out.println();
    System.out.println();


  }

}
