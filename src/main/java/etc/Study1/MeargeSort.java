package etc.Study1;

/**
 * @author choijaeyong on 06/02/2019.
 * @project Algorithm
 * @description
 */
public class MeargeSort {

  //public static int[] result = new int[30];

  public static void main(String[] args) {

    //int[] array = {1,4,2,5,6,8,2,5,9,10,11,19,10,15,13};
    int[] array = {1,4,2,5,6,8,2,5};
    //int[] array = {4,1,2,5};
    mergeSort(array,0,array.length-1);

    for(int k: array) {
      System.out.print(k + " ");
    }


  }

  public static void mergeSort(int[] arr, int left, int right) {
    if(left < right) {
      int mid = (left+right)/2;
      mergeSort(arr,left,mid);
      mergeSort(arr,mid+1,right);
      merge(arr,left,mid,right);
    }

  }

  public static void merge(int[] arr, int left, int middle, int right) {

    // 두개의 덩어리? 배열이 존재한다고 생각.
    // left ~ mid 까지. mid+1 ~ right 까지.

    int l = left;  // 앞 덩어리의 첫번째 .
    int m = middle + 1; // 뒤 덩어리의 첫번째.
    int r = left; // 임시배열의 인덱스...?
    int[] temp = new int[arr.length];

    while(l <= middle && m <= right) {
      if(arr[l] <= arr[m]) {
        temp[r++] = arr[l++];
        //result[r++] = arr[l++];
      } else {
        temp[r++] = arr[m++];
        //result[r++] = arr[m++];
      }
    }

    // l 이나 m 이 마지막 인덱스까지 비교를 끝냈을때
    // 어느 한쪽은 마지막 인덱스에 도달하지 못했을 것이다. 그때 마지막 인덱스까지의 값을 배열에 넣어줘야한다.
    while(l <= middle) {
      temp[r++] = arr[l++];
      //result[r++] = arr[l++];
    }

    while(m <= right) {
      temp[r++] = arr[m++];
      //result[r++] = arr[m++];
    }

    System.out.println("temp");
    for(int k : temp) {
      System.out.print(k + " ");
    }
    System.out.println();


    // 임시배열에 정렬된 값을 원래 배열에 반영해준다.
    System.out.println("l : " + l + "   r : " + r);
    for(int i=left ; i < r ; i++) {
      //System.out.println("arr[i] : " + arr[i] + "     temp[i] : " + temp[i]);
      arr[i] = temp[i];
    }

    System.out.println("arr");
    for(int k : arr) {
      System.out.print(k + " ");
    }
    System.out.println();
    System.out.println();

  }
}
