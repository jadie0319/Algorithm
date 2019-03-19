package LeetCode.LearnCourse.BinarySearch.Template2;

import java.util.Arrays;

/**
 * @author choijaeyong on 19/03/2019.
 * @project Algorithm
 * @description
 *
 * advanced form of BinarySearch
 */
public class template2 {
  public static void main(String[] args) {
    int[] nums = {0, 1, 2, 4, 5, 6, 7};
    int target = 2;

    System.out.println(Arrays.toString(nums));
    System.out.println(binarySearch(nums,target));
  }

  public static int binarySearch(int[] nums, int target) {

    if(nums.length == 0 || nums == null) {
      return -1;
    }

    int left = 0;
    int right = nums.length;

    while(left < right) {
      int mid = left + (right - left)/2;
      if(nums[mid] == target) {
        return mid;
      }else if(nums[mid] < target) {
        left = mid+1;
      }else {
        right = mid;
      }
    }

    if(left != nums.length && nums[left] == target) {
      return left;
    }
    return -1;
  }

}