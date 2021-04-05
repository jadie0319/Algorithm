package etc.Question2;

import java.util.Arrays;

/**
 * @author choijaeyong on 20/02/2019.
 * @project Algorithm
 * @description
 */
public class MergeSample {

  public static void main(String[] args) {
    int[] arr = {5,7,3,2,1,5,8,6,11,9,3,4,10,5};

    merge(arr,0,arr.length-1);
    System.out.println(Arrays.toString(arr));


  }

  public static void merge(int[] arr, int start, int end) {
    if(start < end) {
      int mid = (start+end)/2;
      merge(arr,start,mid);
      merge(arr,mid+1,end);
      mergesort(arr,start,mid,end);
    }

  }
  public static void mergesort(int[] arr, int left, int middle, int right) {

    int leftptr = left;
    int rightptr = middle+1;
    int idx = left;

    int[] result = new int[arr.length];

    while(leftptr <= middle && rightptr <= right) {
      if(arr[leftptr] < arr[rightptr]) {
        result[idx] = arr[leftptr];
        idx++;
        leftptr++;
      } else {
        result[idx] = arr[rightptr];
        idx++;
        rightptr++;
      }
    }

    while(leftptr <= middle) {
      result[idx] = arr[leftptr];
      idx++;
      leftptr++;
    }

    while(rightptr <= right) {
      result[idx] = arr[rightptr];
      idx++;
      rightptr++;
    }

    for(int i=left ; i <= right ; i++) {
      arr[i] = result[i];
    }



  }

}
