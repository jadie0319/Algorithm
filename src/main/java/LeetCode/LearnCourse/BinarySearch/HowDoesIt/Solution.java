package LeetCode.LearnCourse.BinarySearch.HowDoesIt;

/**
 * @author choijaeyong on 15/03/2019.
 * @project Algorithm
 * @description
 */
public class Solution {
  public static void main(String[] args) {

    int[] nums = {-1,0,3,5,9,12};
    int target = 9;

    System.out.println(search(nums,target));


  }

  public static int search(int[] nums, int target) {

    int start = 0;
    int end = nums.length -1;
    int mid;

    while(start <= end) {
      mid = (start + end)/2;
      if(nums[mid] == target) {
        return mid;
      } else if(target > nums[mid]) {
        start = mid+1;
      } else {
        end = mid-1;
      }

    }

    return -1;
  }

}
