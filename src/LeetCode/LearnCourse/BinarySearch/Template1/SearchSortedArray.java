package LeetCode.LearnCourse.BinarySearch.Template1;

import java.util.Arrays;

/**
 * @author choijaeyong on 17/03/2019.
 * @project Algorithm
 * @description
 * https://leetcode.com/explore/learn/card/binary-search/125/template-i/952/
 *
 */
public class SearchSortedArray {
  public static void main(String[] args) {
    int[] nums = {4,5,6,7,0,1,2};
    int target = 0;

    System.out.println(search(nums, target));

  }

  public static int search(int[] nums, int target) {
//    int[] newArray = Arrays.copyOf(nums,nums.length);
//    Arrays.sort(newArray);
    System.out.println(Arrays.toString(nums));

    int subtract = 0;
    int numsLength = nums.length-1;
    for(int i=0; i < numsLength ; i++) {
      if(nums[i] > nums[i+1]) {
        subtract = i+1;
        break;
      }
    }
    System.out.println("subtract : " + subtract); // 4
    int[] newArray = Arrays.copyOf(nums,nums.length + subtract);
    System.out.println(Arrays.toString(newArray));


    int newArrayLength = newArray.length-1;
    for(int i=0; i < subtract ; i++) {
      newArray[i+numsLength+1] = newArray[i];
      newArray[i]=0;
    }
    System.out.println(Arrays.toString(newArray));


    int left = subtract;
    int right = newArrayLength;
    int mid=0;
    int index=0;

    System.out.println("left : " + left + "   right = " + right + "   mid : " + mid);

    while(left <= right) {
      mid = (left+right)/2; // 7
      if(newArray[mid] == target) {
        System.out.println("left : " + left + "   right = " + right + "   mid : " + mid);
        if(mid > numsLength) {
          return mid - numsLength-1;
        }
        return mid;
      } else if(target < newArray[mid]) {
        right = mid-1;
      } else if(target > newArray[mid]) {
        left = mid+1;
      }
    }



    return -1;
  }

}
