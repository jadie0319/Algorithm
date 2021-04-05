package etc.Question2;

/**
 * @author choijaeyong on 20/02/2019.
 * @project Algorithm
 * @description
 */
public class Binary {
  public static void main(String[] args) {
    int[] arr = {1,2,5,7,9,10,11,16,18,20,22,26,29,33,43};

    binarySearch(arr,11);
  }

  public static void binarySearch(int[] arr, int k) {

    int mid = 0;
    int left = 0;
    int right = arr.length-1;

    while(left <= right) {
      mid = (left + right) / 2;
      if(arr[mid] == k) {
        System.out.println((mid+1) + "번째에 있다.");
        break;
      }
      if(k <= arr[mid]) {
        right = mid -1;
      }else {
        left = mid+1;
      }
    }


  }

}
